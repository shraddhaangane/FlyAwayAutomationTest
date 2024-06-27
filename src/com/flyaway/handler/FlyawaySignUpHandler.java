package com.flyaway.handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlyawaySignUpHandler {
public void setMemberDetails(WebDriver driver, String emailid, String password, String confirmPassword, String name, String address, String city) {
		
		driver.findElement(By.name("email_id")).sendKeys(emailid);
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.name("pwd2")).sendKeys(confirmPassword);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("address")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td/button")).click();
	    }
public void clickLoginSignUpLink(WebDriver driver, String linkText) {
	driver.findElement(By.xpath(linkText)).click();
}
public void clickSignUpLink(WebDriver driver, String linklabel) {
	driver.findElement(By.xpath(linklabel)).click();
}
}