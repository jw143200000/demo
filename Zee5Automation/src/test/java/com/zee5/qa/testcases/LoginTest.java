package com.zee5.qa.testcases;


//import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zee5.qa.base.TestBase;
import com.zee5.qa.pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginPage;
	

public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		
	}

	
	@Test
	public void loginTest() {
	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}



