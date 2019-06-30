package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTCP_008;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_008 {
 
	Logger log = Logger.getLogger(RTTCP_008.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private RTTCP_008 RTTC08;
	private static Properties properties;
	private ScreenShot screenShot;
  
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOMN = new LoginPOMN(driver); 
		RTTC08 = new RTTCP_008(driver);
		baseUrl = properties.getProperty("baseURL");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void selectValuesDropdown() throws InterruptedException {
		RTTC08.LoginLink();
		 Thread.sleep(20000);
		 RTTC08.RegisterLink();
		 Thread.sleep(20000);
		 RTTC08.sendUserName("chandu@gmail.com");
		 RTTC08.sendPassword("chandu@123");
		Thread.sleep(20000);
		RTTC08.clickLoginBtn(); 
		Thread.sleep(20000);
		RTTC08.ClickShopmenu();
		screenShot.captureScreenShot("Menu");
		log.info("Shop menu has been selected");
		Thread.sleep(20000);
		RTTC08.DropdownSelect();
		screenShot.captureScreenShot("dropdown");
		log.info("All the Values in the list are printed");
		RTTC08.selectDropDown();
		screenShot.captureScreenShot("ValueSelect");
		log.info("Name (A-Z) has been selected in the drop down");
		
	}
	
		 
	
}

