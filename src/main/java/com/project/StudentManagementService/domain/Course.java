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
@Table(name="COURSE")
public class Course {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COURSE_ID")
	public int id;
	
	@NotEmpty
	@Column(name="COURSE_NAME")
	public String name;
	
	@NotEmpty
	@Column(name="DESCRIPTION")
	public String description;

}
