package com.project.StudentManagementService.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.StudentManagementService.StudentManagementServiceApplicationTests;
import com.project.StudentManagementService.domain.SearchCriteria;
import com.project.StudentManagementService.domain.Student;
import com.project.StudentManagementService.repository.StudentRepository;

public class StudentManagementServiceTests extends StudentManagementServiceApplicationTests {

	@MockBean
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	@Before
    public void setUp() {
        studentService.studentRepository = studentRepository;
    }
	
	@Test
	public void testSaveStudent(){
		Student student = new Student();
		student.setEmail("s@g.com");
		student.setFirstName("vijay");
		student.setLastName("devireddy");
		studentService.saveStudent(student);
	}
	
	@Test
	public void testSearchStudent(){
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setFirstName("sai");
		searchCriteria.setLastName("vijay");
		studentService.fetchStudents(new SearchCriteria());
	}
	
	@Test
	public void testValidateStudent(){
		Student student = new Student();
		student.setEmail("");
		student.setFirstName("");
		student.setLastName("");
		studentService.validateStudent(student);
	}
}
