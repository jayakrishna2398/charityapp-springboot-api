package com.revature.charityapp.exception;

public class DBException extends Exception{
	private static final long serialVersionUID = 3382751410713327364L;
    public DBException(String message) {
        super(message);
    }
    public DBException(String message, Throwable e) {
        super(message,e);
    }
}

