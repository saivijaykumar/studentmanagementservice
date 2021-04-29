package com.project.StudentManagementService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.StudentManagementService.domain.SearchCriteria;
import com.project.StudentManagementService.domain.Student;
import com.project.StudentManagementService.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository studentRepository;
	
	public void saveStudent(Student student){
		studentRepository.save(student);
	}
	
	public List<Student> fetchStudents(SearchCriteria searchCriteria){
		return studentRepository.searchStudents(searchCriteria.getFirstName(), searchCriteria.getLastName());
	}
	
	public List<String> validateStudent(Student student){
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(student.getEmail())){
			errors.add("email");
		}
		
		if(StringUtils.isEmpty(student.getFirstName())){
			errors.add("firstName");
		}
		
		if(StringUtils.isEmpty(student.getLastName())){
			errors.add("lastName");
		}
		return errors;
	}
	
}
