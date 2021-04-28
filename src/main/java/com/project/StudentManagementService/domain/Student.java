package com.project.StudentManagementService.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="STUDENT")
public class Student {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	public int id;
	
	@NotEmpty
	@Column(name="FIRST_NAME")
	public String firstName;
	
	@NotEmpty
	@Column(name="LAST_NAME")
	public String lastName;
	
	@NotEmpty
	@Column(name="EMAIL")
	public String email;
	
}
