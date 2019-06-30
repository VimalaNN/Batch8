package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTCP_006;
import com.training.pom.RTTCP_007;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_006 {
	
	
	Logger log = Logger.getLogger(RTTCP_006.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private  RTTCP_006 RTTC06;
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
		RTTC06 = new RTTCP_006(driver);
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
	public void ChangePwdPass() throws InterruptedException {
		RTTC06.LoginLink();
		 Thread.sleep(20000);
		 RTTC06.RegisterLink();
		 Thread.sleep(20000);
		 RTTC06.sendUserName("chandu@gmail.com");
		 RTTC06.sendPassword("mehadi");
		Thread.sleep(20000);
		RTTC06.clickLoginBtn(); 
		Thread.sleep(20000);
		Thread.sleep(20000);
		screenShot.captureScreenShot("LoginButton");
		log.info("user has clicked on the Login link");
		RTTC06.clickChangePassword();
		Thread.sleep(20000);
		screenShot.captureScreenShot("ChangePasswordLink");
		log.info("user has clicked on the change password link");
		RTTC06.firstPasswordfield("mehadi");
		RTTC06.confirmPasswdfield("mehadi");
		Thread.sleep(20000);
		screenShot.captureScreenShot("Re Set Password");
		Thread.sleep(20000);
		RTTC06.clikcontinue();
		Thread.sleep(20000);
		RTTC06.SuccesMessage();
		screenShot.captureScreenShot("ResetSuccess");
		log.info("User successfully re set the password");
		
	
		
	}
		
	}

