package com.revature.charityapp.controller;



import java.util.List;


import javax.servlet.http.HttpServlet;
import io.swagger.annotations.ApiResponse;

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
import io.swagger.annotations.ApiResponses;



/**
 * Servlet implementation class FundRequestListController
 */
@RestController
public class FundRequestListController extends HttpServlet {
	@Autowired
	FundRequestService fundReqService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GetMapping("listRequest")
	@ApiOperation("List donor")
	@ApiResponses(
			value= {
					 @ApiResponse(code = 200, message = "List success!", response = FundRequest.class),
		              @ApiResponse(code = 400, message = "List not success!", response = FundRequest.class)
			}
			)
		public ResponseEntity<Object> listRequest() {
			List<FundRequest> list = null;
			String errorMessage = null;
			try {
			list=fundReqService.list();
			return new ResponseEntity<>(list, HttpStatus.OK );
			}catch(ServiceException e) {
				errorMessage = e.getMessage();
				 Message message = new Message(errorMessage);
		           return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST );
			}


		}
	}
