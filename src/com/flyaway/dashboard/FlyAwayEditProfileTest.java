package com.flyaway.dashboard;

import static com.flyaway.helper.FlyawayConstants.*;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.flyaway.handler.FlyAwayEditProfileHandler;
import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawayMemberLoginHandler;

public class FlyAwayEditProfileTest {
	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawayMemberLoginHandler loginHandler = new FlyawayMemberLoginHandler();
	FlyAwayEditProfileHandler editProfileHandler = new FlyAwayEditProfileHandler();

	// Verify member should able to view edit profile page
	@Test(description = "Verify member should able to view edit profile page")
	public void verifyMemberAbleToViewEditProfilePage() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"editprofile\"]")).click();
		driver.close();

	}

	// Verify member should not allow to update password with invalid password
	@Test(description = "Verify member should not allow to update password with invalid password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidPassword() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"editprofile\"]")).click();
		editProfileHandler.updateProfileDetails(driver, INVALID_PASSWORD, CONFIRM_PASSWORD, NAME);
		validateErrorMessage(driver, MESSAGE_PASSWORD_NOT_MATCH);
		driver.close();

	}

	// Verify member should not allow to update password with invalid confirm password
	@Test(description = "Verify member should not allow to update password with invalid confirm password")
	public void verifyMemberNotAllowToUpdatePasswordWithInvalidConfirmPassword() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"editprofile\"]")).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, INVALID_PASSWORD, NAME);
		validateErrorMessage(driver, MESSAGE_PASSWORD_NOT_MATCH);
		driver.close();

	}

	// Verify member should not allow to update empty name filed
	@Test(description = "Verify member should not allow to update empty name filed")
	public void verifyNotAllowtoUpdateEmptyName() {
		WebDriver driver = commonHandler.homePage();
		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"editprofile\"]")).click();
		editProfileHandler.updateProfileDetails(driver, PASSWORD, CONFIRM_PASSWORD, EMPTY_STR);
		validateErrorMessage(driver, MESSAGE_NAME_REQUIRED);
		driver.close();
	}

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		System.out.println("expectedErrorMessage==> " + expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}
}
