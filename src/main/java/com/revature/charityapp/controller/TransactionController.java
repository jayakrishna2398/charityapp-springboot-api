package com.revature.charityapp.controller;





import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityapp.configuration.Message;

import com.revature.charityapp.model.UsersTransaction;
import com.revature.charityapp.service.FundRequestService;
import com.revature.charityapp.service.TransactionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Servlet implementation class TransactionController
 */
@RestController
public class TransactionController extends HttpServlet {
	@Autowired
	TransactionService service;
	@Autowired
	FundRequestService reqService;
	private static final long serialVersionUID = 1L;
	  @ApiOperation(value = "Transaction API")
	   @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully transfered", response = UsersTransaction.class),
	           @ApiResponse(code = 400, message = "Transaction failed", response = UsersTransaction.class) })
       @PostMapping("transaction")
	public ResponseEntity<Object> register(@RequestParam("transactionId") int transactionId,@RequestParam("donorId") int donorId,@RequestParam("fundReqId") int fundRequestId,@RequestParam("amountFunded") double targetAmount) {
		String errorMessage = null;
		UsersTransaction trans = null;
		try {
		trans = new UsersTransaction();
		trans.setDonorId(donorId);
		trans.setTransactionId(transactionId);
		trans.setFundRequestId(fundRequestId);
		trans.setTargetAmount(targetAmount);
			service.transaction(trans);
			errorMessage = "Success";
			return new ResponseEntity<>(trans, HttpStatus.OK );
		} catch (Exception e) {
			errorMessage = e.getMessage();
			Message message = new Message(errorMessage);
	           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
		}

	}
		}
		
