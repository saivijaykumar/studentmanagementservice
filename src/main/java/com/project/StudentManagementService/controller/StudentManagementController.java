package com.project.StudentManagementService.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.StudentManagementService.domain.Student;
import com.project.StudentManagementService.domain.PageView;
import com.project.StudentManagementService.domain.SearchCriteria;
import com.project.StudentManagementService.service.StudentService;

@Controller
public class StudentManagementController {

	@Autowired
	StudentService StudentService;
	
	@Autowired
	PageView pageView;
	
	@GetMapping("/")
    String index(Model model) {
		pageView.setCount(pageView.getCount() + 1);
        return "index";
    }
	
	@ResponseBody
	@GetMapping("/pageviewcount")
    int fetchPageViewCount(Model model) {
        return pageView.getCount();
    }
	
	@GetMapping("/addstudent")
    String addUser(Model model) {
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("student", new Student());
        return "addstudent";
    }
	
	@GetMapping("/students")
    String fetchUsers(Model model) {
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("searchCriteria", new SearchCriteria());
		SearchCriteria searchCriteria = new SearchCriteria();
		searchCriteria.setFirstName("");
		searchCriteria.setLastName("");
		model.addAttribute("students", StudentService.fetchStudents(searchCriteria));
        return "students";
    }
	
	@RequestMapping(value = "/savestudent", method=RequestMethod.POST)
	public String saveStudent(@Valid Student student, BindingResult result, Model model){
		if (result.hasErrors()) {
		    return "addstudent";
		 }
		pageView.setCount(pageView.getCount() + 1);
		 StudentService.saveStudent(student);
		return "index";
	}
	
	@GetMapping(value="/searchStudent")
	public String searchStudent(@Valid SearchCriteria searchCriteria, Model model){
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("students", StudentService.fetchStudents(searchCriteria));
        return "students";	
	}
	
}
