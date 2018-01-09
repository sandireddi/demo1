package com.rameshsoft.automation.driverengine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionEngine extends DriverUtility
{
	 private static Actions actions=new Actions(getWebDriver());
	 private static WebElement element;
	 
      public static void sendkeysAction(String locator,String locatorvalue,String textdata)
      {
    	  switch (locator) 
    	  {
		    case "id":
		    	    element=getWebDriver( ).findElement(By.id(locatorvalue));
		    	    if(element.isDisplayed() && element.isEnabled())
		    	    {
		    	    element.clear();
		    	    element.sendKeys(textdata);
		    	    }
		             break;
		     
		     case "name" :
		    	 element=getWebDriver( ).findElement(By.name(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;
		           
		     case "className" :
		    	  element=getWebDriver( ).findElement(By.className(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;
		           
		     case "xpath" :
		    	 element=getWebDriver( ).findElement(By.xpath(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;
		           
		     case "cssSelector" :   
		    	 element=getWebDriver( ).findElement(By.cssSelector(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;
		           
		     case "tagName":
		    	 element=getWebDriver( ).findElement(By.tagName(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;
		           
		     case "linkText" :
		    	 element=getWebDriver( ).findElement(By.linkText(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.clear();
		    	  element.sendKeys(textdata);
		    	  }
		           break;   
		    	 
		     case "partialLinkText" :
		     element=getWebDriver( ).findElement(By.partialLinkText(locatorvalue));
	    	  if(element.isDisplayed() && element.isEnabled())
	    	  {
	    	  element.clear();
	    	  element.sendKeys(textdata);
	    	  }
	           break;
    	  }
      }
    
      public static void clickAction(String locator,String locatorvalue)
      {
    	  switch (locator) 
    	  {
		    case "id":
		    	    element=getWebDriver( ).findElement(By.id(locatorvalue));
		    	    if(element.isDisplayed() && element.isEnabled())
		    	    {
		    	    element.click();
		    	    }
		             break;
		     
		     case "name" :
		    	 element=getWebDriver( ).findElement(By.name(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;
		           
		     case "className" :
		    	  element=getWebDriver( ).findElement(By.className(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;
		           
		     case "xpath" :
		    	 element=getWebDriver( ).findElement(By.xpath(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;
		           
		     case "cssSelector" :   
		    	 element=getWebDriver( ).findElement(By.cssSelector(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;
		           
		     case "tagName":
		    	 element=getWebDriver( ).findElement(By.tagName(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;
		           
		     case "linkText" :
		    	 element=getWebDriver( ).findElement(By.linkText(locatorvalue));
		    	  if(element.isDisplayed() && element.isEnabled())
		    	  {
		    	  element.click( );
		    	  }
		           break;   
		    	 
		     case "partialLinkText" :
		     element=getWebDriver( ).findElement(By.partialLinkText(locatorvalue));
	    	  if(element.isDisplayed() && element.isEnabled())
	    	  {
	    	  element.click( );
	    	  }
	           break;
      }
   } 
    
    public static void getWindowHandles(int index )
    {
    	Set<String> windows=getWebDriver().getWindowHandles();
    	List<String> l=new ArrayList<String>(windows);
    	String windowName=l.get(index);
    	getWebDriver().switchTo().window(windowName);  	
    }
    
    public static List<WebElement> getAllFrames()
    {
    	   List<WebElement> frames=getWebDriver().findElements(By.tagName("iframe"));
		   return frames;
    }
    
    public static void switchToFrame(String locator,String locatorvalue )
    {
    	  switch(locator)
    	  {
    	  case "idOrName" :
    		                getWebDriver().switchTo().frame(locator);
    		                break;
    		                
    	  case "index" :
    		  if(getAllFrames().size()>=Integer.parseInt(locator))
    		  {
    			  getWebDriver().switchTo().frame(locator);
    		  }
               break;	                
    		                
    	  case "webelement" :
              getWebDriver().switchTo().frame(locator);
              break;  
    	  }
    }
    public static void scrrenShot(String imgName) throws IOException
    {
    	TakesScreenshot t=(TakesScreenshot)getWebDriver();
    	File f=t.getScreenshotAs(OutputType.FILE);
    	FileUtils.copyDirectory(f,new File("d://"+imgName+".jpeg"));  
    }
    
    public static void dropdown(WebElement element, String dropdown_select,String dropdown_data)
    {
    	   String tagname=element.getTagName();
    	   if(tagname.equalsIgnoreCase("select"))
    	   {
    		   Select select=new Select(element);
    		    switch(dropdown_select)
    		   {
    		  case "value":
    			     select.selectByValue(dropdown_data);
    			     break;
    		  case "text":
    			     select.selectByVisibleText(dropdown_data);
    			     break;
    		  case "index":
    			     select.selectByIndex(Integer.parseInt(dropdown_data));
    			     break;	   
    		   }
    	   }    	   
    }
     
   public static void mouseHover(WebElement element) 	
   {
	  	   actions.moveToElement(element).build().perform();	   
   }
   
   public static void rightClick(WebElement element)
   {
	   actions.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
   }
    	
  public static boolean isdisplayed(WebElement element)  
  {
	  boolean flag=true;
	  if(element.isDisplayed() && element.isEnabled());
	  else
		  flag=false;
		  return flag;	  
	  }
  
  public static void enterUrl(String url)
  {
	  getWebDriver().get(url);
  }  	
}
