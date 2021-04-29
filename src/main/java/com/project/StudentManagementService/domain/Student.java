package com.project.StudentManagementService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="STUDENT")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	public int id;
	
	@NotNull(message = "FirstName can not be null!!")
    @NotEmpty(message = "FirstName can not be empty!!")
	@Column(name="FIRST_NAME")
	public String firstName;
	
	@NotNull(message = "LastName can not be null!!")
    @NotEmpty(message = "LastName can not be empty!!")
	@Column(name="LAST_NAME")
	public String lastName;
	
	@NotNull(message = "Email can not be null!!")
    @NotEmpty(message = "Email can not be empty!!")
	@Column(name="EMAIL")
	public String email;
	
}
