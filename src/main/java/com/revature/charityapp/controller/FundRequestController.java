package com.revature.charityapp.controller;



import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.Admin;
import com.revature.charityapp.model.FundRequest;
import com.revature.charityapp.service.FundRequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
/**
 * Servlet implementation class FundRequestController
 */
public class FundRequestController extends HttpServlet {
	@Autowired
	FundRequestService fundReqService;
	private static final long serialVersionUID = 1L;
	@PostMapping("request")
	  @ApiOperation(value = "FundRequest API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added request", response = FundRequest.class),
	           @ApiResponse(code = 400, message = "Invalid Credentials", response = FundRequest.class) })
	public ResponseEntity<Object> addRequest(@RequestParam("fundId") int fundId,@RequestParam("fundRequest") String reqType,@RequestParam("amountTarget") int amount) {
		String errorMessage = null;
		FundRequest request = null;
		Admin admin = null;
		try {
			request = new FundRequest();
			request.setReqType(reqType);
			request.setAmount(amount);
			request.setFundId(fundId);
			fundReqService.registerUser(request,admin);
			return new ResponseEntity<>(request, HttpStatus.OK );
		} catch (ServiceException e) {
			errorMessage = e.getMessage();
			  Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}
	}
	@PostMapping("updateRequest")
	@ApiOperation(value = "updateRequest API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Updated", response = FundRequest.class),
	           @ApiResponse(code = 400, message = "Request not updated !!!", response = Message.class) })
	public ResponseEntity<Object> updateRequest(@RequestParam("fundRequest") String reqType,@RequestParam("amountTarget") int amount) throws ServiceException{

		String errorMessage = null;
		FundRequest request =  null;

		try {
			request = new FundRequest();
			request.setReqType(reqType);
			request.setAmount(amount);
			fundReqService.update(request);
			return new ResponseEntity<>(request, HttpStatus.OK );
		}catch (ServiceException e) {
			errorMessage = e.getMessage();
			  Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}

		
	}


}
