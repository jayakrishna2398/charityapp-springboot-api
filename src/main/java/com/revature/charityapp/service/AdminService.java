package com.revature.charityapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.Admin;
import com.revature.charityapp.repository.AdminRepository;
import com.revature.charityapp.validator.AdminValidator;

@Service
	public class AdminService {
	    @Autowired
	    private AdminRepository adminRepository;

	    public Admin adminLogin(String adminName,String adminPassword) throws ServiceException {
	        Admin adminObj=null;
	        AdminValidator validator = new AdminValidator();
	        try {
	            validator.validateLogin(adminName,adminPassword);
	            adminObj= adminRepository.findByNameAndPassword(adminName,adminPassword);
	        } catch (ValidationException e) {
	            e.printStackTrace();
	            throw new ServiceException("Access Denied");
	        }
	        return adminObj;
	    }
	    
	}

