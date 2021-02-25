package com.zee5.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.zee5.qa.util.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);

	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\InstalledSoftwares\\Eclipse_2020_03\\Zee\\Zee5Automation\\Zee5Automation\\src\\main\\java\\com\\zee5\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}
//Code to call browser Type which is need to call for the automation testing.
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","D:\\InstalledSoftwares\\Eclipse_2020_03\\Selenium_Files\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Opening Chrome Browser");
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/Users/ravindra.pal/Downloads/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Opening Firefox Browser");

		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.internet.driver","C:/Users/ravindra.pal/Downloads/Iedriver.exe");
			driver = new InternetExplorerDriver();
			log.info("Opening IE Browser");

		}
		
		driver.manage().window().maximize();        //code to maximize the screen.
		driver.manage().deleteAllCookies();			// Code to delete all the cookies of the browser
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);       
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));   

	}
}

