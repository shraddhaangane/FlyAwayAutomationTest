package com.flyaway.memberlogin;

import static com.flyaway.helper.FlyawayConstants.*;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawayMemberLoginHandler;

public class FlyAwayMemberLoginTest {
	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawayMemberLoginHandler loginHandler = new FlyawayMemberLoginHandler();

	// Verify member login page with valid user details
	@Test(description = "Verify login page with valid user details")
	public void verifyLoginPageWithValidUserDetails() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.close();
	}

	// Verify member login page with Invalid email id
	@Test(description = "Verify login page with Invalid email id")
	public void verifyLoginPageWithInvalidEmailId() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, INVALID_EMAIL, PASSWORD);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);
		driver.close();
	}

	// Verify member login page with valid emaild id and invalid password
	@Test(description = "Verify login page with valid emaild id and invalid password")
	public void verifyLoginPageWithvalidEmailIdandInvalidPassword() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, CONFIRM_PASSWORD_NOT_MATCH);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);
		driver.close();
	}
	@Test(description = "Verify login page with Invalid emaild id and invalid password")
	public void verifyLoginPageWithInvalidEmailIdandInvalidPassword() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, INVALID_EMAIL, CONFIRM_PASSWORD_NOT_MATCH);
		validateErrorMessage(driver, MESSAGE_LOGIN_FAILD);
		driver.close();
	} 
	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		System.out.println("expectedErrorMessage==> " + expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}
}
