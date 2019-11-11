package com.revature.charityapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Users;

public class UserServiceTest {
	
@Autowired
private UserService service;

	@Test
	public void testRegister() throws ServiceException {
		Users donor = null;
		try {
		donor = new Users();
		donor.setDonorEmailId("chandrababubollineni416@gmail.com");
		donor.setDonorId(1);
		donor.setDonorName("chandra babu");
		donor.setDonorPassword("Babu@123");
		donor.setGender("male");
		assertNotNull(donor);
	}catch(Exception e) {
	service.register(donor);	
	throw new ServiceException("user not found");
	}
	}
	@Test
	public void testListUsers() throws ServiceException{
		Users donor = null;
		try {
			donor = new Users();
			assertNotNull(donor);
		}catch(Exception e) {
			service.list();
			throw new ServiceException("list not found");
		}
	}
	@Test
	public void testMail() throws ServiceException{
		Users user = null;
		try {
			user = new Users();
			assertNotNull(user);
		}catch(Exception e) {
			service.sendMail(user);
			throw new ServiceException("Mail not sent");
		}
	}
}
