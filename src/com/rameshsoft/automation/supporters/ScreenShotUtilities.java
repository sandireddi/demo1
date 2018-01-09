package com.rameshsoft.automation.supporters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public interface ScreenShotUtilities 
{
    public static String getScreenShot(WebDriver driver,String imgName) throws IOException
    {
    	   TakesScreenshot t = (TakesScreenshot)driver;
		    File file=t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,new File("D:\\"+imgName+".jpeg"));	
			return imgName;
	}
 }

