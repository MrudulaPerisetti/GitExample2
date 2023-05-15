package com.SeleniumPractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenKartExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w= new WebDriverWait(driver,5);
		String items[]= {"Brocolli","Cucumber","Beans","Brinjal"};
		addItems(driver,items);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='promoBtn']")));
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		//System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//div[@style='width: 360px; margin: 10px auto;']/select")).click();
		driver.findElement(By.xpath("//option[@value='India']")).click();
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//div[@class='wrapperTwo']/button")).click();

	}
	public static void addItems(WebDriver driver, String[] items) {
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++) {
			String name[]=products.get(i).getText().split("-");
			String Formattedname=name[0].trim();
			List ListitemNeeded=Arrays.asList(items);
			if(ListitemNeeded.contains(Formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			    if(j==products.size()) {
					break;
					
				}
			}
		}
	}
}
		
