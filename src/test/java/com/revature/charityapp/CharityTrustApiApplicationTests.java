package com.revature.charityapp;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.charityapp.model.Users;
import com.revature.charityapp.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharityTrustApiApplicationTests {
@Autowired
UserRepository userRepository;
	@Test
	public void loginTest()
	{
	Users users=userRepository.findByEmailIdAndPassword("chandrababubollineni416@gmail.com", "Babu@123");    
	assertNotNull(users);
	}
	
}
