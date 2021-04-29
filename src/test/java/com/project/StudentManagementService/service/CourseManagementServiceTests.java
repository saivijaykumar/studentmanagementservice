package com.project.StudentManagementService.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.StudentManagementService.StudentManagementServiceApplicationTests;
import com.project.StudentManagementService.domain.Course;
import com.project.StudentManagementService.domain.SearchCourseCriteria;
import com.project.StudentManagementService.repository.CourseRepository;

public class CourseManagementServiceTests extends StudentManagementServiceApplicationTests{

	@Autowired
	CourseManagementService courseManagementService;
	
	@MockBean
	CourseRepository courseRepository;
	
	@Before
    public void setUp() {
		courseManagementService.courseRepository = courseRepository;
    }
	
	@Test
	public void testSaveCourse(){
		Course course = new Course();
		course.setDescription("java");
		course.setName("java");
		courseManagementService.saveCourse(course);
	}
	
	public void testSearchCourse(){
		SearchCourseCriteria searchCourseCriteria = new SearchCourseCriteria();
		searchCourseCriteria.setDescription("java");
		searchCourseCriteria.setName("java");
		courseManagementService.fetchCourses(searchCourseCriteria);
	}
}
