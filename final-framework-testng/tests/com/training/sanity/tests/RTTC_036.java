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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_036 {
	

	Logger log = Logger.getLogger(RTTCP_036.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private RTTCP_036 RTTC36;
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
		RTTC36 = new RTTCP_036(driver);
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
		 RTTC36.sendUserName("admin");
		 RTTC36.sendPassword("admin@123");
		Thread.sleep(2000);
		RTTC36.clickLoginBtn(); 
		Thread.sleep(2000);
		RTTC36.myORdersC();
		screenShot.captureScreenShot("Image");
		log.info("Orders details Image clicked");
		Thread.sleep(2000);
		RTTC36.viewIconclick();
		screenShot.captureScreenShot("ViewIcon");
		log.info("Clicked on the View Icon corresponding newly created Order");
		Thread.sleep(2000);
		RTTC36.reutnLink();
		Thread.sleep(2000);
		screenShot.captureScreenShot("ReturnLink");
		log.info("User has clicked on the Reurn Link");
		
	}
	

}
