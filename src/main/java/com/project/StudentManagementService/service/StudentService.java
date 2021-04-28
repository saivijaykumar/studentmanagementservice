package com.project.StudentManagementService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.StudentManagementService.domain.SearchCriteria;
import com.project.StudentManagementService.domain.Student;
import com.project.StudentManagementService.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public void saveStudent(Student student){
		studentRepository.save(student);
	}
	
	public List<Student> fetchStudents(SearchCriteria searchCriteria){
		return studentRepository.searchStudents(searchCriteria.getFirstName(), searchCriteria.getLastName());
	}
	
}
