package com.flyaway.handler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlyawayMemberLoginHandler {
public void setMemberloginPage(WebDriver driver, String emailid, String password) {
		
		driver.findElement(By.name("email_id")).sendKeys(emailid);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td/button")).click();
	}


}
