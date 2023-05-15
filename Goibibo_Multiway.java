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

public class Goibibo_Multiway {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		//login cross
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//one way
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/ul/li[3]/span[1]")).click();
		
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
		//driver.findElement(By.xpath("//li[@class='sc-dPiLbb btATnz'][2]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[2]/div[2]/div/div/p")).click();
		driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("Bengaluru (BLR)");
		driver.findElement(By.xpath("//p[@class='sc-fHeRUh bDhnUc']")).click();
		String month2="October 2023";
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Caption']")));
		while(true) {
			WebElement Smonth=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']"));
			//Getting current month from the calender
			String CurrentMonth=Smonth.getText();
			//System.out.println(CurrentMonth);
			if(CurrentMonth.equals(month2)) {
				break;
			}
			if(!CurrentMonth.equals(month2)) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		String day1="4";
		WebDriverWait wait1=new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker-Day']")));
		List<WebElement> dates1 = driver.findElements(By.xpath("//div[@class='DayPicker-Day']"));
		int count1 = dates1.size();
		//Selecting date from the calender
		for(int i=0;i<count1;i++)
		{
			String text1=driver.findElements(By.xpath("//div[@class='DayPicker-Day']")).get(i).getText();
			if(text1.equalsIgnoreCase(day1))
			{
				driver.findElements(By.xpath("//div[@class='DayPicker-Day']")).get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//div/span[@class='fswTrvl__done']")).click();
		//Done after radio button
		//driver.findElement(By.xpath("//div/a[@class='sc-fmciRz duyTj']")).click();
		//search button
		driver.findElement(By.xpath("//div/span[@class='sc-cvZCdy iEJrkB']")).click();
		}
}
