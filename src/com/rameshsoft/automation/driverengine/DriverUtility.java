package com.rameshsoft.automation.driverengine;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.excelant.ExcelAntTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.rameshsoft.automation.supporters.ScreenShotUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverUtility 
{
	private static WebDriver webdriver;
    private static  ExtentReports er;
    private static ExtentTest et;
    private static Logger log;
    
	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser)
	{
		 er=new ExtentReports("D:\\reports.html");
		 PropertyConfigurator.configure("C:\\mounika\\Framework\\log4j.properties");
		 if(browser.equalsIgnoreCase("firefox"))
		 {
			 System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			 webdriver=new FirefoxDriver();
			 webdriver.manage().window().maximize();
			 webdriver.manage().deleteAllCookies();
			 webdriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 }
		 else if(browser.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver_win32\\chromedriver.exe");
			 webdriver=new ChromeDriver();
			 webdriver.manage().window().maximize();
			 webdriver.manage().deleteAllCookies();
			 webdriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 }
		 else if(browser.equalsIgnoreCase("ie"))
		 {
			 System.setProperty("webdriver.internetexplorer.driver","C:\\Program Files (x86)\\IEDriverServer_x64_3.7.0.zip\\IEDriverServer.exe");
			 webdriver=new InternetExplorerDriver();
			 webdriver.manage().window().maximize();
			 webdriver.manage().deleteAllCookies();
			 webdriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 }
		 else
		 {
			 System.out.println("browser is not found");
		 }
    }
	
	public static WebDriver getWebDriver()
	{
		return webdriver;
	}
	
	@BeforeMethod
	public void beforeMethod(Method m)
	{
	      et =er.startTest(m.getName());
	      log=Logger.getLogger(m.getClass());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		er.endTest(et);
		er.flush( );
		if(ITestResult.FAILURE==result.getStatus())
		{
				ScreenShotUtilities.getScreenShot(webdriver,result.getName( ));       	
		}	
	}
	
	//use this methods @Test level to get reports
	public static ExtentTest getExtentTest( )
	{
		return et;
	}
	
	public static Logger getLogger()
	{
		return log;
		
	}
	
	@AfterSuite
	public void closeBrowser( )
	{
		if(webdriver!=null)
			webdriver.close();
		else
		    System.out.println("webdriver value is null");
	}
}
