package com.brillio.basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleTabsExample
{
public static void main(String[] args) throws InterruptedException, AWTException 
{ 
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//Navigating to amazon.com
	driver.get("https://www.amazon.in//");
	driver.manage().window().maximize();
	String currentHandle= driver.getWindowHandle();
	// Searching for Headphones
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones", Keys.ENTER);

	//Clicking on search button
	String UrlToClick=driver.findElement(By.xpath("//span[contains(text(),'Infinity (JBL) Glide 500 Wireless Headphones with ')]")).getAttribute("href");

	//span[contains(text(),'& Orders')]
	//Get all the handles currently available
	Set<String> handles=driver.getWindowHandles();
	for(String actual: handles) {
	if(!actual.equalsIgnoreCase(currentHandle)) {
	//Switch to the opened tab
	driver.switchTo().window(actual); 
	//opening the URL saved.
	driver.get("urlToClick");
	}}
}
}