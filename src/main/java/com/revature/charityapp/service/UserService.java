package com.revature.charityapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.Users;
import com.revature.charityapp.repository.UserRepository;
import com.revature.charityapp.validator.AdminValidator;
import com.revature.charityapp.validator.UserValidator;


@Service
public class UserService {
	  @Autowired
	    private UserRepository userRepository;
	  @Autowired
	  private JavaMailSender emailSender;
	    @Transactional
	    public Users userLogin(String donorEmailId,String donorPassword) throws ServiceException {
	        Users user=null;
	        AdminValidator validator = new AdminValidator();
	        try {
	            validator.validateLogin(donorEmailId,donorPassword);
	            user= userRepository.findByEmailIdAndPassword(donorEmailId,donorPassword);
	        } catch (ValidationException e) {
	           throw new ServiceException("invalid email or password");
	        }
	        return user;
	    }
	    @Transactional
        public List<Users> list() throws ServiceException{
            List<Users> donorObj= null;
                try {
					donorObj=userRepository.findAll();
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServiceException("List cant be viewed");
				}    
            return donorObj;
        }
        @Transactional
        public void register(Users donor) throws ServiceException {
            try {
                	UserValidator validator = new UserValidator();
                    validator.ValidatorRegister(donor);
                    userRepository.save(donor);
                    sendMail(donor);
                }catch (ValidationException e) {
                    throw new ServiceException(e.getMessage());
                }
            }
    	public void sendSimpleMessage(String to, String subject, String text) throws ServiceException {
    		try {
    			SimpleMailMessage message = new SimpleMailMessage();
    			message.setTo(to);
    			message.setSubject(subject);
    			message.setText(text);

    			emailSender.send(message);
    			System.out.println("Mail Sent");
    		} catch (MailException exception) {
    			throw new ServiceException(exception.getMessage());
    		}
    	}

        @Transactional
        public void sendMail(Users user) throws ServiceException{
        	try {
    			SimpleMailMessage message = new SimpleMailMessage();
    			message.setTo(user.getDonorEmailId());
    			message.setSubject("Registration Mail -");
    			StringBuilder content = new StringBuilder();
    			content.append("Welcome "+ user.getDonorName() + ", \n");
    			content.append("Thank you for registering through charity trust foundations." ).append("\n");
    			content.append("\n");
    			content.append("\n");
    			content.append("Regards,").append("\n");
    			content.append(" jayakrishna.").append("\n");   
                message.setText(content.toString());
                emailSender.send(message);
        	}catch(MailException e) {
        		throw new ServiceException("email not sent");
        	}
        }
	    
}
