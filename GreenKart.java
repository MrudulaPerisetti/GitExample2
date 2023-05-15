package com.SeleniumPractice;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GreenKart {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String itemsNeeded[]= {"Brocolli","Cucumber","Beans","Brinjal"};
		Thread.sleep(3000);
		List<WebElement> product=driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0;i<product.size();i++) {
			String name[]=product.get(i).getText().split("-");
			String Formattedname=name[0].trim();
			List ListitemNeeded=Arrays.asList(itemsNeeded);
			if(ListitemNeeded.contains(Formattedname)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			    if(j==product.size()) {
					break;
					
				}
			}
		}

	}

}
