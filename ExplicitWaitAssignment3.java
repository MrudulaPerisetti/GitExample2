package com.SeleniumPractice;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitAssignment3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Okay']")));
		driver.findElement(By.xpath("//button[text()='Okay']")).click();
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		driver.findElement(By.xpath("//option[@value='consult']")).click();
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		String mobiles[]= {"iphone","Samsung","Nokia","Blackberry"};
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']/h5")));
		int j=0;
		List<WebElement> products=driver.findElements(By.xpath("//div[@class='card-body']/h5"));
		for(int i=0;i<products.size();i++) {
			List<String> ListitemNeeded=Arrays.asList(mobiles);
			if(ListitemNeeded != null) {
				j++;
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-footer']/button")));
				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
				if(j==products.size()) {
					break;
				}
			}
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
	}
}