package com.project.StudentManagementService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.StudentManagementService.domain.Course;
import com.project.StudentManagementService.domain.PageView;
import com.project.StudentManagementService.domain.SearchCourseCriteria;
import com.project.StudentManagementService.domain.SearchCriteria;
import com.project.StudentManagementService.domain.Student;
import com.project.StudentManagementService.service.CourseManagementService;

@Controller
public class CourseManagementController {

	@Autowired
	CourseManagementService courseManagementService;
	
	@Autowired
	PageView pageView;
	
	@GetMapping("/addcourse")
    String addUser(Model model) {
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("course", new Course());
        return "addcourse";
    }
	
	@GetMapping("/courses")
    String fetchUsers(Model model) {
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("searchCourseCriteria", new SearchCourseCriteria());
		SearchCourseCriteria searchCourseCriteria = new SearchCourseCriteria();
		searchCourseCriteria.setName("");
		searchCourseCriteria.setDescription("");
		List<Course> courses = courseManagementService.fetchCourses(searchCourseCriteria);
		model.addAttribute("courses", courses);
        return "courses";
    }
	
	@RequestMapping(value = "/savecourse", method=RequestMethod.POST)
	public String saveStudent(@Valid Course course, BindingResult result, Model model){
		if (result.hasErrors()) {
		    return "addcourse";
		 }
		pageView.setCount(pageView.getCount() + 1);
		courseManagementService.saveCourse(course);
		return "index";
	}
	
	@GetMapping(value="/searchCourse")
	public String searchStudent(@Valid SearchCourseCriteria searchCourseCriteria, Model model){
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("searchCourseCriteria", new SearchCourseCriteria());
		model.addAttribute("courses", courseManagementService.fetchCourses(searchCourseCriteria));
        return "courses";	
	}
}
