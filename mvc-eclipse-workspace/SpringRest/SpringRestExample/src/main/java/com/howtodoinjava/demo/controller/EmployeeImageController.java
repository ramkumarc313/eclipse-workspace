package com.howtodoinjava.demo.controller;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/employee-management/employees/{id}/photo")
@PropertySource("classpath:application.properties")
public class EmployeeImageController {

	@Autowired
	private EmployeeRepository repository;

	private File uploadDirRoot;

	@Autowired
	EmployeeImageController(@Value("${image.upload.dir}") String uploadDir, EmployeeRepository repository) {
		this.uploadDirRoot = new File(uploadDir);
		this.repository = repository;
	}

	@GetMapping
	ResponseEntity<Resource> read(@PathVariable Long id) {
		return this.repository.findById(id).map(employee -> {
			File file = fileFor(employee);
			Resource fileSystemResource = new FileSystemResource(file);
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileSystemResource);
		}).orElseThrow(() -> new RecordNotFoundException("Image for available"));
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT }, consumes = { "multipart/form-data" })
	Callable<ResponseEntity<?>> write(@PathVariable Long id, @RequestParam("file") MultipartFile file)
			throws Exception {
		return () -> this.repository.findById(id).map(employee -> {
			File fileForEmployee = fileFor(employee);

			try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(fileForEmployee)) {
				FileCopyUtils.copy(in, out);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}

			URI location = fromCurrentRequest().buildAndExpand(id).toUri();

			return ResponseEntity.created(location).build();
		}).orElseThrow(() -> new RecordNotFoundException("Employee id is not present in database"));
	}

	@PostMapping(value = "/multiple", consumes = { "multipart/form-data" })
	Callable<ResponseEntity<?>> writeMultiple(@PathVariable Long id, @RequestParam("files") MultipartFile[] files)
			throws Exception {
		return () -> this.repository.findById(id).map(employee -> {

			Arrays.asList(files).stream().forEach(file -> {
				File fileForEmployee;
				try {
					fileForEmployee = uploadPath(employee, file);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}

				try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(fileForEmployee)) {
					FileCopyUtils.copy(in, out);
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
			});

			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RecordNotFoundException("Employee id is not present in database"));
	}

	private File fileFor(Employee e) {
		return new File(this.uploadDirRoot, Long.toString(e.getId()));
	}

	private File uploadPath(Employee e, MultipartFile file) throws IOException {
		File uploadPath = Paths.get(this.uploadDirRoot.getPath(), e.getId().toString()).toFile();
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		return new File(uploadPath.getAbsolutePath(), file.getOriginalFilename());
	}
}