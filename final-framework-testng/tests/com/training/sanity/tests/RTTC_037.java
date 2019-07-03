package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RTTCP_036;
import com.training.pom.RTTCP_037;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_037 {
	
	Logger log = Logger.getLogger(RTTCP_037.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private RTTCP_037 RTTC37;
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
		RTTC37 = new RTTCP_037(driver);
		baseUrl = properties.getProperty("baseURL");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}
		*/
	
	
	@Test
	public void DeletePRoductCart() throws InterruptedException {
		 
		Thread.sleep(2000);
		RTTC37.inCorrectpwd("admin","123456");
		 Thread.sleep(2000);
		 RTTC37. inCorrectpwd2("admin","admin");
		 Thread.sleep(2000); 
		 RTTC37.inCorrectUsername("manzoor","admin@123");
		 Thread.sleep(2000);
		 RTTC37.inCorrectUsername1("admin@123","admin@123");
		 
		Thread.sleep(2000);
	
}
}
