package com.SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamicpassword {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String p=Dpass(driver);
		String name="DenuSri";
		driver.get("https://www.rahulshettyacademy.com/locatorspractice");
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(p);
		// TODO Auto-generated method stub
		driver.findElement(By.className("submit")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
public static String Dpass(WebDriver driver) throws InterruptedException {
	driver.get("https://www.rahulshettyacademy.com/locatorspractice");
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("button[class='reset-pwd-btn']:nth-child(2)")).click();
	String pass=driver.findElement(By.xpath("//form/p")).getText();
	String pass1[]=pass.split("'");
	String pass2=pass1[1].split("'")[0];
	return pass2;
}
}
