package com.SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		//login cross
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//one way
		driver.findElement(By.xpath("//span[@class='sc-jtXEFf ezccfJ']")).click();
		//From
		driver.findElement(By.xpath("//p[@class='sc-eLwHnm hHxEGr fswWidgetPlaceholder']")).click();
		driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("Bengaluru (BLR)");
		//To
		driver.findElement(By.xpath("//p/span[@class='autoCompleteSubTitle']")).click();
		driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("Hyderabad (HYD)");
		driver.findElement(By.xpath("//div/p[@class='sc-fHeRUh bDhnUc']")).click();
		//calender
		String action="";
		String month="August 2023";
		while(true) {
			WebElement Smonth=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
			//Getting current month from the calender
			String CurrentMonth=Smonth.getText();
			//System.out.println(CurrentMonth);
			if(CurrentMonth.equals(month)) {
				break;
			}
			if(!CurrentMonth.equals(month)) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		String day="10";
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		int count = dates.size();
		//Selecting date from the calender
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.xpath("//div[@class='DayPicker-Day']")).get(i).getText();
			if(text.equalsIgnoreCase(day))
			{
				driver.findElements(By.xpath("//div[@class='DayPicker-Day']")).get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//div/span[@class='fswTrvl__done']")).click();
		int adult=4;
		for(int i=0;i<adult;i++) {
			driver.findElement(By.xpath("//span[@class='sc-eFegNN csJIKZ'][2]")).click();
		}
		//Travel class- Business
		driver.findElement(By.xpath("//li[@class='sc-jHkVzv fMjuWe'][2]")).click();
		//Done after Travel class selection
		driver.findElement(By.xpath("//div/a[@class='sc-fmciRz duyTj']")).click();
		//popup cross
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		//radio button
		driver.findElement(By.xpath("//li[@class='sc-dPiLbb btATnz'][2]")).click();
		//Done after radio button
		driver.findElement(By.xpath("//div/a[@class='sc-fmciRz duyTj']")).click();
		//search button
		driver.findElement(By.xpath("//div/span[@class='sc-cvZCdy iEJrkB']")).click();
		/*
		//==================Final Page Calender====================
		//Declare year to select in the calender
		String year="August 2023";
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"search-widget-checkin-input\"]")));
		
		//Click action on cal
		driver.findElement(By.xpath("//*[@id=\"search-widget-checkin-input\"]")).click();
		while(true) {
			WebElement Syear=driver.findElement(By.xpath("//p[@class='dcalendarstyles__MonthNamePara-sc-r2jz2t-3 eTlOyJ']"));
			String CurrentMonth=Syear.getText();
			//System.out.println(CurrentMonth);
			if(CurrentMonth.equals(year)) {
				break;
			}
			if(!CurrentMonth.equals(year)) {
				driver.findElement(By.xpath("//div/sgv[@class='ArrowRightIcon-sc-t9vcrx-0 gNpIAs']")).click();
			}
		}
		String day1="5";
		List<WebElement> dates1 = driver.findElements(By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 jockDS']"));
		int count1 = dates1.size();
		//Selecting date from the calender
		for(int i=0;i<count1;i++)
		{
			String text=driver.findElements(By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 jockDS']")).get(i).getText();
			if(text.equalsIgnoreCase(day1))
			{
				driver.findElements(By.xpath("//ul[@class='dcalendarstyles__DateWrapDiv-sc-r2jz2t-7 jockDS']")).get(i).click();
				break;
			}
		}*/
		//=================================================================================
		//Explicit wait untill page load
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[@class='srp-card-uistyles__BookButton-sc-3flq99-21 ivgkjF dF justifyCenter alignItemsCenter txtUpper']")));
		//Clicking cheapest flight
		driver.findElement(By.xpath("//div/button[@class='srp-card-uistyles__BookButton-sc-3flq99-21 ivgkjF dF justifyCenter alignItemsCenter txtUpper']")).click();


	}
}
