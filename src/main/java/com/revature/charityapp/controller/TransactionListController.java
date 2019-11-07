package com.revature.charityapp.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ServiceException;
import com.revature.charityapp.model.FundRequest;
import com.revature.charityapp.service.FundRequestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Servlet implementation class TransactionListController
 */
@RestController
public class TransactionListController {
	@Autowired
	FundRequestService reqService;
	private static final long serialVersionUID = 1L;
	FundRequest fundreq = null;

	@GetMapping("listTransaction")
	@ApiOperation(value = "TransactionList API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Transaction List viewed", response = FundRequest.class),
			@ApiResponse(code = 400, message = "List not viewed", response = FundRequest.class) })
	public ResponseEntity<Object> fundlist() {
		List<FundRequest> request = null;
		String error = null;
		try {
			request = reqService.donorFundRequest();
			return new ResponseEntity<>(request, HttpStatus.OK);

		} catch (ServiceException e) {
			e.printStackTrace();
			Message message = new Message(error);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
