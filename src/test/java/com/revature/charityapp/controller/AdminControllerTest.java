package com.revature.charityapp.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Admin;
import com.revature.charityapp.service.AdminService;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest

public class AdminControllerTest{

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService adminServiceMock;

	@InjectMocks
	AdminController adminController;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() throws Exception {
		Admin admin = new Admin();
		admin.setAdminName("jayakrishna");
		admin.setAdminPassword("Krish@12");
		when(adminServiceMock.adminLogin(anyString(),anyString())).thenReturn(admin);


		String userJson = new ObjectMapper().writeValueAsString(admin);
		mockMvc.perform(post("/login?name=jayakrishna&password=Krish@12").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.adminName").value("jayakrishna"));

	}
	@Test
	public void testInvalidLogin() throws Exception {
		Admin admin = new Admin();
		admin.setAdminName("naresh");
		admin.setAdminPassword("pass123");

		when(adminServiceMock.adminLogin(anyString(),anyString()))
				.thenThrow(new ServiceException("Access denied"));

		String userJson = new ObjectMapper().writeValueAsString(admin);

		mockMvc.perform(post("/login?name=naresh&password=pass123").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errorMessage").value("Access denied"));

	}


	}

