package com.revature.charityapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Admin;
@SpringBootTest
public class AdminServiceTest {
	@Autowired
	private AdminService adminService;

	@Test
	public void testAdminService() throws ServiceException {
		Admin admin = new Admin();
		admin.setAdminEmailId("jayakrishnakrish1998@gmail.com");
		admin.setAdminId(90);
		admin.setAdminName("jayakrishna");
		admin.setAdminPassword("Krish@12");
		assertNotNull(admin);
	}

}
