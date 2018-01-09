package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPasswordPage {

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="passwordNext")
	WebElement signin;
	
	public void passaction(){
		password.clear();
		password.sendKeys("rameshsoft.selenium");
	}
	
	public void signinaction(){
		signin.click();
	}

	
}
