package com.zee5.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zee5.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	private static WebElement password = null;

	//Page Factory- OR:-
	@FindBy(xpath="//span[text()='Login with ADFS']")
	WebElement Login;

	@FindBy(xpath="//input[@name='UserName']")
	WebElement UserName;

	@FindBy(xpath="//input[@name='Password']")
	WebElement Passwword;

	@FindBy(xpath="//input[@id='SubmitButton']")
	WebElement signin;
	


	//Initializing the page objects;
	public LoginPage(){
	PageFactory.initElements(driver, this);
	}

	//Actions:
	
	public void signin() {
		Login.click();
	}
	public void login(String un, String pwd){
		UserName.sendKeys(un);
	password.sendKeys(pwd);
	signin.click();
	}
}
