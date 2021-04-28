package com.project.StudentManagementService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.StudentManagementService.domain.Course;
import com.project.StudentManagementService.domain.SearchCourseCriteria;
import com.project.StudentManagementService.repository.CourseRepository;

@Service
public class CourseManagementService {

	@Autowired
	CourseRepository courseRepository;
	
	public void saveCourse(Course course){
		courseRepository.save(course);
	}
	
	public List<Course> fetchCourses(SearchCourseCriteria searchCourseCriteria){
		return courseRepository.searchCourses(searchCourseCriteria.getName(), searchCourseCriteria.getDescription());
	}
}
