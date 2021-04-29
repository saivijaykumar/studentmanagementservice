package com.project.StudentManagementService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.project.StudentManagementService.domain.Course;
import com.project.StudentManagementService.domain.SearchCourseCriteria;
import com.project.StudentManagementService.repository.CourseRepository;

@Service
public class CourseManagementService {

	@Autowired
	public CourseRepository courseRepository;
	
	public void saveCourse(Course course){
		courseRepository.save(course);
	}
	
	public List<Course> fetchCourses(SearchCourseCriteria searchCourseCriteria){
		return courseRepository.searchCourses(searchCourseCriteria.getName(), searchCourseCriteria.getDescription());
	}
	
	public List<String> validateCourse(Course course){
		List<String> errors = new ArrayList<String>();
		if(StringUtils.isEmpty(course.getName())){
			errors.add("name");
		}
		if(StringUtils.isEmpty(course.getDescription())){
			errors.add("description");
		}
		return errors;
	}
}
