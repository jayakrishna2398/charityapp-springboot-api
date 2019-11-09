package com.revature.charityapp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapp.dao.TransactionList;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.Admin;
import com.revature.charityapp.model.FundRequest;
import com.revature.charityapp.repository.FundReqRepository;
import com.revature.charityapp.validator.RequestValidator;
@Service
public class FundRequestService {
	
	    @Autowired
	    private FundReqRepository requestRepository;
	    @Autowired
	    private TransactionList trans;
	    @Autowired
	   private JavaMailSender emailSender;
	    @Transactional
	    public FundRequest registerUser(FundRequest request,Admin admin) throws ServiceException {
	        FundRequest requestObj=null;
	        try {
	            RequestValidator validator = new RequestValidator();
	                validator.ValidatorInsert(request);
	                requestObj=requestRepository.save(request);
	               // sendReqMail(request,admin);
	            }catch (ValidationException e) {
	                throw new ServiceException(e.getMessage(), e);
	            }
	            return requestObj;
	        }
	    @Transactional
	    public List<FundRequest> list() throws ServiceException{
	        List<FundRequest> requestObj= null;
	        requestObj=requestRepository.findAll();
	        return requestObj;
	    }
	    @Transactional
	    public List<FundRequest> donorFundRequest() throws ServiceException {
	        
	            List<FundRequest> list = null;
	            try {
	                list = trans.donorFundRequest();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                throw new ServiceException(e.getMessage(), e);
	            }
	        return list;
	    }
	    @Transactional
	    public FundRequest update(FundRequest request) throws ServiceException {
	        FundRequest requestObj=null;
	        int res = 0;
	        try {
	            
	            RequestValidator validator = new RequestValidator();
	                validator.ValidatorInsert(request);
	                String reqType=request.getReqType();
	                Integer amount=request.getAmount();
	               res = requestRepository.update(reqType,amount);
	                System.out.println("res:" + requestObj);
	                if(res == 0) {
	                	throw new ServiceException("Request cannot be updated");
	                }
	            }catch (Exception e) {
	            	e.printStackTrace();
	                throw new ServiceException(e.getMessage(), e);
	            }
	            return requestObj;
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

//	    @Transactional
//	    public void sendReqMail(FundRequest req,Admin admin) throws ServiceException{
//	    	try {
//	    		SimpleMailMessage message = new SimpleMailMessage();
//	    		message.setTo(admin.getAdminEmailId());
//	    		message.setSubject("Your request has been added !!!");
//    			StringBuilder content = new StringBuilder();
//    			content.append("Welcome "+ admin.getAdminName() + ", \n");
//    			content.append("You have been added the following fund request details." ).append("\n");
//    			content.append("\n");
//    			content.append("Your added Fund request type service is, \n");
//    			content.append("REQUEST TYPE : " + req.getReqType() + "\n");
//    			content.append("Your added fund amount is, \n");
//    			content.append("AMOUNT: " + req.getAmount() + "\n");
//    			content.append("\n");
//    			content.append("Regards,").append("\n");
//    			content.append(" Charity trust foundations team.").append("\n");   
//                message.setText(content.toString());
//                emailSender.send(message);
//        	}catch(MailException e) {
//        		throw new ServiceException("email not sent");
//        	}
//	    }
		}


