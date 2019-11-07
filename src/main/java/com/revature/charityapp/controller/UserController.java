package com.revature.charityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Users;
import com.revature.charityapp.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	Users user = new Users();
	@PostMapping("userLogin")
	  @ApiOperation(value = "DonorLogin API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Users.class),
	           @ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	
	public ResponseEntity<Object> login(@RequestParam("email") String donorEmailId,@RequestParam("password") String donorPassword) {
		
		String errorMessage = null;
		Users users = null;
		try {
			
			
			users=service.userLogin(donorEmailId, donorPassword);
			
			if (users == null) {
				throw new ServiceException("Invalid Email or Password");
			}

		} catch (Exception e) {
			errorMessage = e.getMessage();
		}

		if (users != null) {
		    return new ResponseEntity<>(users, HttpStatus.OK );

		} else {
			  Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}

	}
	@PostMapping("register")
	  @ApiOperation(value = "Register API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Registered", response = Users.class),
	           @ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<Object> register(@RequestParam("donorName") String donorName,@RequestParam("donorEmailId") String donorEmailId,@RequestParam("donorPassword") String donorPassword,@RequestParam("gender") String gender) {
		String errorMessage = null;
		Users users=null;
		try {
			users = new Users();
//		users.setDonorId(donorId);
		users.setDonorName(donorName);
		users.setDonorEmailId(donorEmailId);
		users.setDonorPassword(donorPassword);
		users.setGender(gender);
			service.register(users);
			return new ResponseEntity<>(users, HttpStatus.OK );
			
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			Message message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}
		
	}
	@GetMapping("listUsers")
	  @ApiOperation(value = "listDonor API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Donors listed", response = Users.class),
	           @ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<Object> listDonor(Users user) {
		List<Users> list = null;
		String errorMessage = null;
		try {
		list=service.list();
		return new ResponseEntity<>(list, HttpStatus.OK );
		}catch(ServiceException e) {
			errorMessage = e.getMessage();
			  Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}

	}

}
