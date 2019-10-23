package com.example.filedemo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.filedemo.exception.FileStorageException;
import com.example.filedemo.model.DBFile;
import com.example.filedemo.model.FileRowMapper;
@Service
public class DBFileStorageService {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	

    public DBFile storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            String query="";
            jdbcTemplate.update(query,fileName, file.getContentType(), file.getBytes());
            return dbFile;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
		String sql = "select * from files where id = ?";
		DBFile dbFile = new DBFile();
    	RowMapper<DBFile> rowMapper = new FileRowMapper();
    	List<DBFile> al=jdbcTemplate.query(sql,rowMapper,fileId);
        return dbFile;
    }

}
