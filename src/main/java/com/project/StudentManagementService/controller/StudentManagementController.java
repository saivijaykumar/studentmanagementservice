package com.project.StudentManagementService.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		model.addAttribute("errorsList", new ArrayList<String>());
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
	
	
	@GetMapping(value="/searchStudent")
	public String searchStudent(@Valid SearchCriteria searchCriteria, Model model){
		pageView.setCount(pageView.getCount() + 1);
		model.addAttribute("students", StudentService.fetchStudents(searchCriteria));
        return "students";	
	}
	
	@PostMapping("/savestudent")
    public String submitStudentDetails(@Valid Student student, Model model) {
		List<String> errors = StudentService.validateStudent(student);
		if (!errors.isEmpty()) {
			model.addAttribute("errorsList", errors);
		    return "addstudent";
		 } else {
        	pageView.setCount(pageView.getCount() + 1);
    		StudentService.saveStudent(student);
            return "index";
        }
    }
	
}
