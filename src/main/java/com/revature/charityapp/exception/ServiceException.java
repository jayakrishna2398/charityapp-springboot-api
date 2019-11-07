package com.revature.charityapp.exception;

public class ServiceException extends Exception{
	private static final long serialVersionUID = 3382751410713327364L;
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(String message, Throwable e) {
        super(message,e);
    }
}

