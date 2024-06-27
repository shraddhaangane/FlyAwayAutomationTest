package com.flyaway.flightbooking;

import static com.flyaway.helper.FlyawayConstants.*;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.flyaway.handler.FlyawayCommonHandler;
import com.flyaway.handler.FlyawayMemberLoginHandler;

public class FlightBookingTest {

	FlyawayCommonHandler commonHandler = new FlyawayCommonHandler();
	FlyawayMemberLoginHandler loginHandler = new FlyawayMemberLoginHandler();

	// Verify member should able select flight from drop down
	@Test(description = "Verify member should able select flight from drop down")
	public void verifyMemberSelectFlightFromDropdown() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(CHENNAI);
		driver.findElement(By.xpath("//button[text()='Submit']"));
		driver.close();
	}

	// Verify member should able to book flight from result
	@Test(description = "Verify member should able to book flight from result")
	public void verifyMemberSelectBookflight() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(CHENNAI);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//*[contains(@href,'bookflight')]")).click();
		driver.close();
	}

	// Verify member should able to view result of flight choosing only source from
	// drop down
	@Test(description = "Verify member should able to view result of flight choosing only source from drop down")
	public void verifyMemberSelectOnlySource() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.close();
	}

	// Verify member should able to view result of flight choosing only destination
	// from drop down
	@Test(description = "Verify member should able to view result of flight choosing only destination from drop down")
	public void verifyMemberSelectOnlyDestination() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(CHENNAI);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//*[contains(@href,'bookflight')]")).click();
		driver.close();
	}

	// Verify member should not able to book flight without valid login
	@Test(description = "Verify member should not able to book flight without valid login")
	public void verifyMemberUnableToBookflighWithoutLogin() {
		WebDriver driver = commonHandler.homePage();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(CHENNAI);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//*[contains(@href,'bookflight')]")).click();
		validateErrorMessage(driver, MESSAGE_ERROR_BOOKING_WITHOUT_LOGIN);
		driver.close();
	}

	// Verify member should able to book flight and complete payment process(Pending)
	@Test(description = "Verify member should able to book flight and complete payment process")
	public void verifyMemberBookFlightAndCompletePayment() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(HYDERABAD);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
        String airlineName= driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[3]")).getText();
		driver.findElement(By.xpath("//*[contains(@href,'bookflight')]")).click();
		driver.findElement(By.xpath("//a[@href=\"completepurchase\"]")).click();
		
		validateErrorMessage(driver, String.format(MESSAGE_CONFIRM_BOOKING, airlineName, BANGLORE,HYDERABAD));
		driver.close();
	}

	// Verify member should able to view booking details in "Your Bookings"
	@Test(description = "Verify member should able to view booking details in Your Bookings")
	public void verifyMemberViewConfirmBookDetails() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText(BANGLORE);
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText(HYDERABAD);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//*[contains(@href,'bookflight')]")).click();
		driver.findElement(By.xpath("//a[@href=\"completepurchase\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'See Your Bookings')]")).click();
		driver.close();
	}

	// Verify No search result for flight booking
	@Test(description = "Verify No search result for flight booking")
	public void verifyNoSearchResltForFlightBooking() {
		WebDriver driver = commonHandler.homePage();

		driver.findElement(By.xpath("//a[@href=\"login\"]")).click();
		loginHandler.setMemberloginPage(driver, EMAILID, PASSWORD);
		driver.findElement(By.xpath("//a[@href=\"home\"]")).click();
		Select selectsource = new Select(driver.findElement(By.name("source")));
		selectsource.selectByVisibleText("Ahmedabad");
		Select selectdestination = new Select(driver.findElement(By.name("destination")));
		selectdestination.selectByVisibleText("Ahmedabad");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.close();
	}

	private void validateErrorMessage(WebDriver driver, String expectedErrorMessage) {
		System.out.println("expectedErrorMessage==> " + expectedErrorMessage);
		assertTrue(driver.findElement(By.tagName("body")).getAttribute("innerHTML").contains(expectedErrorMessage));
	}
}
