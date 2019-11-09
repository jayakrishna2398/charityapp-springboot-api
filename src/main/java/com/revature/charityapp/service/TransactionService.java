package com.revature.charityapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.UsersTransaction;
import com.revature.charityapp.repository.TransactionRepository;
@Service
public class TransactionService {
	@Autowired
	TransactionRepository transRepository;
	  @Transactional
	    public List<UsersTransaction> list() throws ServiceException{
	        List<UsersTransaction> requestObj= null;
	        requestObj = transRepository.findAll();
	        return requestObj;
	    }
	   @Transactional
       public void transaction(UsersTransaction donor) throws ServiceException{
           try { 
        	   		System.out.println(donor);
                   transRepository.save(donor);
               }catch (Exception e) {
                   throw new ServiceException(e.getMessage());
               }
           }
}
