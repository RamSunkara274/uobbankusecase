package com.demo.bank.appconstants;

public class ApplicationConstants {

	private ApplicationConstants() {

	}

	public static final Integer TRANSACTION_SUCCESSFULL_CODE = 9001;
	public static final String TRANSACTION_SUCCESSFULL = "your transaction successfully completed";

	public static final Integer TRANSACTION_FAILURE_CODE = 9004;
	public static final String TRANSACTION_FAILURE = "your transaction is failed due to insufficent funds";

	public static final Integer USER_REGISTER_FAILURE_CODE = 9008;
	public static final String USER_REGISTER_FAILURE_MESSAGE = "While registering every field is manditory ! Please enter valid data";

}
