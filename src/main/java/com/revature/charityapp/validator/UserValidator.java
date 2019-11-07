package com.revature.charityapp.validator;

import org.springframework.stereotype.Component;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.Users;
@Component
public class UserValidator {
	public  void validateLogin(String donorEmailId, String donorPassword) throws ValidationException {
        
        if (donorEmailId == null ) {
            throw new ValidationException(Message.INVALID_EMAIL);
        }
        if (donorPassword == null) {
            throw new ValidationException(Message.INVALID_PASSWORD);
        }
}
public void ValidatorRegister(Users donor) throws ValidationException  {
        
        if (donor.getDonorName() == null) {
            throw new ValidationException(Message.INVALID_NAME);
        }
        if (donor.getDonorEmailId() == null) {
            throw new ValidationException(Message.INVALID_EMAIL);
        }
        if (donor.getDonorPassword() == null) {
            throw new ValidationException(Message.INVALID_PASSWORD);
        }
       
        
        if(donor.getGender()== null) {
            throw new ValidationException(Message.INVALID_GENDER);
            
        }
    }
}
