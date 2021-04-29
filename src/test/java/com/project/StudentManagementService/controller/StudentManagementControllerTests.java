package com.project.StudentManagementService.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.project.StudentManagementService.StudentManagementServiceApplicationTests;


public class StudentManagementControllerTests extends StudentManagementServiceApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testIndexApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPageViewApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/pageviewcount")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddStudentApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/addstudent")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStudentsApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/students")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearchStudentApi(){
		try {
			ResultActions resp = mockMvc.perform(get("/searchStudent")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
