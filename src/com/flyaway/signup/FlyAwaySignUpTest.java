package com.flyaway.signup;

import static com.flyaway.helper.FlyawayConstants.*;
import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawaySignUpHandler;

public class FlyAwaySignUpTest {
	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawaySignUpHandler signUpHandler = new FlyawaySignUpHandler();

	// Verify signup page with valid user details
	@Test(description = "Verify signup page with valid member details")
	public void verifySignUpPageWithValidUserDetails() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, CONFIRM_PASSWORD, NAME, ADDRESS, CITY);
		driver.close();
	}

	// Verify sign up page with Empty User Details
	@Test(description = "Verify signup page with Empty User Details")
	public void verifySignUpPageWithEmptyUserDetails() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);

		signUpHandler.setMemberDetails(driver, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR, EMPTY_STR);
		driver.close();
	}

	// Verify signup page with First Name is blank
	@Test(description = "signup page with Email id is blank")
	public void verifyEmailIsBlank() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMPTY_STR, PASSWORD, CONFIRM_PASSWORD, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_INVALID_EMAIL);
		driver.close();
	}

	// Verify signup page with password is blank
	@Test(description = "signup page with password id is blank")
	public void verifyPasswordIsBlank() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, EMPTY_STR, CONFIRM_PASSWORD, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_INVALID_PASSWORD);
		driver.close();
	}

	// Verify signup page with Confirm Password is blank
	@Test(description = "signup page with Confirm password id is blank")
	public void verifyConfirmPasswordIsBlank() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, EMPTY_STR, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_INVALID_PASSWORD);
		driver.close();
	}

// Verify signup page with Confirm Password is Not Match
	@Test(description = "Verify signup page with Confirm Password is Not Match")
	public void verifyConfirmPasswordNotMatch() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, CONFIRM_PASSWORD_NOT_MATCH, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_PASSWORD_NOT_MATCH);
		driver.close();
	}

	// Verify signup page with name is blank
	@Test(description = "Verify signup page with name is blank")
	public void verifyNameIsBlank() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, CONFIRM_PASSWORD, EMPTY_STR, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_NAME_REQUIRED);
		driver.close();
	}

	// Verify signup page with email id is already taken
	@Test(description = "signup page with email id is already taken")
	public void verifyEmailIsAlreadyTaken() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, CONFIRM_PASSWORD, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_EMAIL_EXITS);
		driver.close();
	}

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		System.out.println("expectedErrorMessage==> " + expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}

	// verify already member login link
	@Test(description = "verify already member login link")
	public void verifyAlreadyMemeberlink() {
		WebDriver driver = commonHandler.homePage();
		signUpHandler.clickLoginSignUpLink(driver, LINK_TEXT_LOGIN_SIGNUP_BUTTON);
		signUpHandler.clickSignUpLink(driver, SIGN_UP_LINK);
		signUpHandler.setMemberDetails(driver, EMAILID, PASSWORD, CONFIRM_PASSWORD, NAME, ADDRESS, CITY);
		validateErrorMessage(driver, MESSAGE_EMAIL_EXITS);
		driver.findElement(By.linkText("Already a member? Login")).click();
		driver.close();
	}
}
