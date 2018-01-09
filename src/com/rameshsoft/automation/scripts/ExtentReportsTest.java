package com.rameshsoft.automation.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsTest 
{
  public static void main(String[] args) 
  {
	ExtentReports er=new ExtentReports("D:\\reports\\gmail.html");
	ExtentTest et=er.startTest("main");
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.gmail.com");
	driver.findElement(By.id("identifierId")).sendKeys("mounika6799@gmail.com");
	et.log(LogStatus.INFO,"id is successfull");
	driver.findElement(By.id("identifierNext")).click();
	et.log(LogStatus.INFO,"next button is clicked");
	er.endTest(et);
	er.flush();
  }
}
