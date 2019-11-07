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
import com.revature.charityapp.model.Users;
import com.revature.charityapp.service.UserService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest

public class UserControllerTest{

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userServiceMock;

	@InjectMocks
	UserController userController;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLogin() throws Exception {
		Users userObj = new Users();
		userObj.setDonorEmailId("chandrababu@gmail.com");
		userObj.setDonorPassword("Babu@123");
		when(userServiceMock.userLogin(anyString(),anyString())).thenReturn(userObj);


		String userJson = new ObjectMapper().writeValueAsString(userObj);
		mockMvc.perform(post("/userLogin?email=chandrababu@gmail.com&password=Babu@123").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk()).andExpect(jsonPath("$.donorEmailId").value("chandrababu@gmail.com"));

	}
	@Test
	public void testInvalidLogin() throws Exception {
		Users userObj = new Users();
		userObj.setDonorEmailId("nareshkumarh@live.com");
		userObj.setDonorPassword("pass123");

		when(userServiceMock.userLogin(anyString(),anyString()))
				.thenThrow(new ServiceException("Invalid Email or Password"));

		String userJson = new ObjectMapper().writeValueAsString(userObj);

		mockMvc.perform(post("/userLogin?email=nareshkumarh@live.com&password=pass123").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.errorMessage").value("Invalid Email or Password"));

	}


}


