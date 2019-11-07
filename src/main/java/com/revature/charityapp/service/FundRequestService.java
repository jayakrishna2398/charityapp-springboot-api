package com.revature.charityapp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapp.dao.TransactionList;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.FundRequest;
import com.revature.charityapp.repository.FundReqRepository;
import com.revature.charityapp.validator.RequestValidator;
@Service
public class FundRequestService {
	
	    @Autowired
	    FundReqRepository requestRepository;
	    @Autowired
	    TransactionList trans;
	    @Transactional
	    public FundRequest registerUser(FundRequest request) throws ServiceException {
	        FundRequest requestObj=null;
	        try {
	            RequestValidator validator = new RequestValidator();
	                validator.ValidatorInsert(request);
	                requestObj=requestRepository.save(request);
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

		}


