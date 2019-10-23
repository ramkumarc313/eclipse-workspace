package net.javaguides.springboot.tutorial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

	@NotBlank(message="Name is mandatory")	
	@Column(name="name")
    private String name;
	
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private long phoneNo;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Email is mandatory") String email, long phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}



}
