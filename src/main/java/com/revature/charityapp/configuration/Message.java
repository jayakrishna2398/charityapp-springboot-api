package com.revature.charityapp.configuration;

			public class Message {
			   
				private String infoMessage;
			       private String errorMessage;
			       public String getInfoMessage() {
			           return infoMessage;
			       }
			       public void setInfoMessage(String infoMessage) {
			           this.infoMessage = infoMessage;
			       }
			       public void setErrorMessage(String error) {
			           this.errorMessage= error;
			       }
			       public String getErrorMessage() {
			           return errorMessage;
			       }
			       public Message(String error) {
			           super();
			           this.errorMessage = error;
			           
			       }
			
			       public static final String INVALID_NAME = "Invalid name";
			               public static final String EMAIL_ALREADY_EXIST = "Email is already exist";
			               public static final String INVALID_PASSWORD = "Invalid Password";
			               public static final String INVALID_EMAIL="Invalid email";
			   
			               final public static String INVALID_GENDER= "Invalid gender";
			               public static final String INVALID_ID="Invalid id";
			               public static final String UNABLE_TO_LOGIN = "Unable to login";
			               public static final String UNABLE_TO_LIST_DONOR="Unable to list donors";
			               public static final String UNABLE_TO_INSERT="Unable to insert request";
			               public static final String UNABLE_TO_REGISTER = "Unable to register! try again";
			               public static final String UNABLE_TO_FUND_AMOUNT="Unable to fund amount";
			               public static final String UNABLE_TO_REQUEST = "Unable to fund request";
			               public static final String UNABLE_TO_LIST_REQUEST = "Unable to list fund request";
			               public static final String UNABLE_TO_TRANSACTION = "Unable to transaction";
			               public static final String INVALID_FUND_TYPE = "Invalid fund type";
			               public static final String UNABLE_TO_UPDATE="unable to update request";
			               public static final String INVALID_NAME_AND_PASSWORD = "Invalid email or password";
			           }



