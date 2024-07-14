package com.flyaway.helper;

public class FlyawayConstants {
	public static final String EMAILID = "test@test.com";
	public static final String INVALID_EMAIL="Invalidemail@test";
	public static final String PASSWORD = "Test";
	public static final String CONFIRM_PASSWORD = "Test";
	public static final String CONFIRM_PASSWORD_NOT_MATCH = "Test12";
	public static final String INVALID_PASSWORD = "Pass12";
	public static final String NAME = "Shraddha";
	public static final String ADDRESS = "Westdrayton";
	public static final String CITY = "London";
	public static final String EMPTY_STR = "";
	
	public static final String LINK_TEXT_LOGIN_SIGNUP_BUTTON = "//a[@href=\"login\"]";
	public static final String SIGN_UP_LINK="//a[@href=\"signup\"]";
	public static final String XPATH_HOME_LINK = "//a[@href=\"home\"]";
	public static final String XPATH_LOGIN_LINK = "//a[@href=\"login\"]";
	public static final String XPATH_EDIT_PROFILE_LINK = "//a[@href=\"editprofile\"]";
	public static final String XPATH_BOOK_FLIGHT_LINK = "//*[contains(@href,'bookflight')]";
	public static final String XPATH_SUBMIT_BUTTON_LINK = "//button[text()='Submit']";
	
	public static final String MESSAGE_INVALID_EMAIL="Email id is required.";
	public static final String MESSAGE_EMAIL_EXITS="This email id already exists.";
	public static final String MESSAGE_INVALID_PASSWORD="Error , Incomplete passwords submitted.";
	public static final String MESSAGE_PASSWORD_NOT_MATCH="Error , Passwords do not match.";
	public static final String MESSAGE_NAME_REQUIRED="Name is required.";
	public static final String MESSAGE_LOGIN_FAILD="Login failed";
	public static final String MESSAGE_ERROR_BOOKING_WITHOUT_LOGIN="Error, You need to login before booking a flight.";
	
	public static final String MESSAGE_CONFIRM_BOOKING="Your Flight  by %s , from %s to %s";
	
	public static final String BANGLORE = "Bangalore";
	public static final String HYDERABAD = "Hyderabad";
	public static final String CHENNAI="Chennai";
	
	public static final String SOURCE = "source";
	public static final String DESTINATION = "destination";

	private FlyawayConstants(){}
}
