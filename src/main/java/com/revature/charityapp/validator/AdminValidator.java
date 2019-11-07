package com.revature.charityapp.validator;

import org.springframework.stereotype.Component;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ValidationException;

@Component
	public class AdminValidator {
	public  void validateLogin(String adminName, String adminPassword) throws ValidationException {
	        
	        if (adminName == null ) {
	            throw new ValidationException(Message.INVALID_NAME);
	        }
	        if (adminPassword == null) {
	            throw new ValidationException(Message.INVALID_PASSWORD);
	        }
	}
	}


