package com.rameshsoft.automation.supporters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rameshsoft.automation.customisedexceptions.FrameworkException;
import com.rameshsoft.automation.driverengine.DriverUtility;

public class ValidationUtilities extends DriverUtility
{
	private static boolean b;
    public static boolean validateMobNo(String mobNo)
    {
    	
		Pattern pattern=Pattern.compile("(0|[+]91)?[789][0-9]{9}");
		Matcher matcher=pattern.matcher(mobNo);
		if(matcher.find()&&matcher.group().equals(mobNo))
		    b=true;
		else
			b=false;
		return b; 	
    }
    public static boolean validateEmail(String email)
    {
    	Pattern pattern=Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]*[@][a-z][.][a-z]+");
    	Matcher matcher=pattern.matcher(email);
    	if(matcher.find() && matcher.group().equals(email))
    		b=true;
    	else
    		b=false;
		return b; 	
    }
    public static WebElement validateWebElement(String locatorName,String locatorValue) throws FrameworkException
    {
        WebElement element=null;
    	switch(locatorName)
    	{
    	    case "id":
    	    	   element=getWebDriver().findElement(By.id(locatorValue));
    	    	   if(element.isDisplayed() && element.isEnabled())
    	    	      System.out.println("webelement is displayed and enabled");
    	    	   else
    	    	      throw new FrameworkException("Unable to identify the element with id :" +locatorValue+" with type :" 
    	    	                                                            +locatorName);
    		         
    	}
		return element;
    }
}
