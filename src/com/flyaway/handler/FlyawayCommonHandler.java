package com.flyaway.handler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlyawayCommonHandler {
	public WebDriver homePage() {
		
		  WebDriver driver = new ChromeDriver();
		  driver.get("http://localhost:9090/FlyAway/home");
		  driver.manage().window().maximize();
		  
		  return driver;
}
}