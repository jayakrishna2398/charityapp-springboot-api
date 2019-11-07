package com.revature.charityapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Admin;
import com.revature.charityapp.service.AdminService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
public class AdminController {
	@Autowired
	AdminService service;
@PostMapping("login")
@ApiOperation(value = "AdminLogin API")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Logged In", response = Admin.class),
        @ApiResponse(code = 400, message = "Access denied", response = Message.class) })

	public ResponseEntity<Object> adminLogin(@RequestParam("name") String adminName,@RequestParam("password") String adminPassword) {
		
		String errorMessage = null;
		Admin admin = null;
		try {
			admin=service.adminLogin(adminName,adminPassword);
			if (admin == null) {
				throw new ServiceException("Access denied");
			}
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}
		if (admin != null) {
		    return new ResponseEntity<>(admin, HttpStatus.OK );

		} else {
			  Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}

}
}
