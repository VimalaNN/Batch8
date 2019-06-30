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
import com.training.pom.RTTCP_007;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class  RTTC_007 {
 
	Logger log = Logger.getLogger(RTTCP_007.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private  RTTCP_007 RTTC07;
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
		RTTC07 = new RTTCP_007(driver);
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
	public void ChangePwdFailure() throws InterruptedException {
		RTTC07.LoginLink();
		 Thread.sleep(20000);
		 RTTC07.RegisterLink();
		 Thread.sleep(20000);
		 RTTC07.sendUserName("chandu@gmail.com");
		 RTTC07.sendPassword("mehadi");
		Thread.sleep(20000);
		RTTC07.clickLoginBtn(); 
		Thread.sleep(20000);
		Thread.sleep(20000);
		screenShot.captureScreenShot("LoginButton");
		log.info("user has clicked on the Login link");
		RTTC07.clickChangePassword();
		Thread.sleep(20000);
		screenShot.captureScreenShot("ChangePasswordLink");
		log.info("user has clicked on the change password link");
		RTTC07.firstPasswordfield("mehadi");
		RTTC07.confirmPasswdfield("mehadi12");
		Thread.sleep(20000);
		screenShot.captureScreenShot("Re Set Password");
		Thread.sleep(20000);
		RTTC07.clikcontinue();
		Thread.sleep(20000);
		RTTC07.FailureMessage();
		screenShot.captureScreenShot("ResetFail");
		log.info("User is not able to re set the password");
		
	
		
	}
	
		 
	
}

