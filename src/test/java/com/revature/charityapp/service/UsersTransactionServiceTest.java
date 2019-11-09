package com.revature.charityapp.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.UsersTransaction;
@SpringBootTest
public class UsersTransactionServiceTest {
	@Test
	public void testTransaction() throws ServiceException {
		UsersTransaction donor =  new UsersTransaction();
		try {
		donor.setDonorId(1);
		donor.setFundRequestId(1);
		donor.setTargetAmount(20000);
		donor.setTransactionId(1);
		assertNotNull(donor);
		}catch(Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
