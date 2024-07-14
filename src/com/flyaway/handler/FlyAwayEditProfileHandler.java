package com.flyaway.handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlyAwayEditProfileHandler {
public void updateProfileDetails(WebDriver driver, String password, String confirmPassword, String name) {
		
		driver.findElement(By.name("pwd")).sendKeys(password);
		driver.findElement(By.name("pwd2")).sendKeys(confirmPassword);
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td/button")).click();
	    }
}
