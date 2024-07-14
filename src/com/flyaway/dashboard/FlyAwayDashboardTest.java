package com.flyaway.dashboard;

import static com.flyaway.helper.FlyawayConstants.EMAILID;
import static com.flyaway.helper.FlyawayConstants.PASSWORD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawayMemberLoginHandler;

public class FlyAwayDashboardTest {
	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawayMemberLoginHandler loginHandler = new FlyawayMemberLoginHandler();

	// Verify member should able to login and view flyaway dashboard
	@Test(description = "Verify member should able to login and view flyaway dashboard")
	public void verifyMemberLoginAndViewDashboard() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		String messageExpected = "FLYAWAY - DASHBOARD";
		WebElement dashboardtagname = driver.findElement(By.tagName("h3"));
		String messageActual = dashboardtagname.getText();

		driver.close();
		Assert.assertEquals(messageExpected, messageActual);
	}

	// Verify member should able view Home page
	@Test(description = "Verify member should able view Home page")
	public void verifyMemberToViewHomePage() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();

		driver.close();
	}
	
	
	

}
