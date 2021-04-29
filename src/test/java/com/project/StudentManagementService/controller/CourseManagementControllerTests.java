package com.project.StudentManagementService.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.StudentManagementService.StudentManagementServiceApplicationTests;
import com.project.StudentManagementService.domain.Student;


public class CourseManagementControllerTests extends StudentManagementServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testAddCourseApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/addcourse")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCoursesApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/courses")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchCourseApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/searchCourse")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
