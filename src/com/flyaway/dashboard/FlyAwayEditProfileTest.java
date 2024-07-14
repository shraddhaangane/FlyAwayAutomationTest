package com.flyaway.dashboard;

import static com.flyaway.helper.FlyawayConstants.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.flyaway.handler.FlyAwayEditProfileHandler;
import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawayMemberLoginHandler;

public class FlyAwayEditProfileTest {
	private static final Logger log = LoggerFactory.getLogger(FlyAwayEditProfileTest.class);
	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawayMemberLoginHandler loginHandler = new FlyawayMemberLoginHandler();
	FlyAwayEditProfileHandler editProfileHandler = new FlyAwayEditProfileHandler();

	// Verify member should able to view edit profile page
	@Test(description = "Verify member should able to view edit profile page")
	public void verifyMemberAbleToViewEditProfilePage() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath(XPATH_EDIT_PROFILE_LINK)).click();
		driver.close();

	}

	// Verify member should not allow to update password with invalid password
	@Test(description = "Verify member should not allow to update password with invalid password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidPassword() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath(XPATH_EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, INVALID_PASSWORD, CONFIRM_PASSWORD, NAME);
		validateErrorMessage(driver, MESSAGE_PASSWORD_NOT_MATCH);
		driver.close();

	}

	// Verify member should not allow to update password with invalid confirm password
	@Test(description = "Verify member should not allow to update password with invalid confirm password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidConfirmPassword() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath(XPATH_EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, INVALID_PASSWORD, NAME);
		validateErrorMessage(driver, MESSAGE_PASSWORD_NOT_MATCH);
		driver.close();

	}

	// Verify member should not allow to update empty name filed
	@Test(description = "Verify member should not allow to update empty name filed")
	public void verifyNotAllowtoUpdateEmptyName() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath(XPATH_EDIT_PROFILE_LINK)).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, CONFIRM_PASSWORD, EMPTY_STR);
		validateErrorMessage(driver, MESSAGE_NAME_REQUIRED);
		driver.close();
	}

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		log.info("expectedErrorMessage==> {}", expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}
}
