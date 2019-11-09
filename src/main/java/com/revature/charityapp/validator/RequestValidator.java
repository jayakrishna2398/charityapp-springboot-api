package com.revature.charityapp.validator;

	import org.springframework.stereotype.Component;

import com.revature.charityapp.configuration.Message;
import com.revature.charityapp.exception.ValidationException;
import com.revature.charityapp.model.FundRequest;
	@Component
	public class RequestValidator {
	    public void ValidatorInsert(FundRequest request) throws ValidationException {
	        if (request.getReqType() == null) {
	            throw new ValidationException(Message.INVALID_FUND_TYPE);
	        }
	        if(request.getAmount()<=0) {
	            throw new ValidationException(Message.UNABLE_TO_FUND_AMOUNT);
	        }
	        
	}}

