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
import com.training.pom.RTTCP_010;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_010 {
	
	
	
	Logger log = Logger.getLogger(RTTCP_010.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private RTTCP_010 RTTC10;
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
		RTTC10 = new RTTCP_010(driver);
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
	public void DeletePRoductCart() throws InterruptedException {
		RTTC10.LoginLink();
		 Thread.sleep(20000);
		 RTTC10.RegisterLink();
		 Thread.sleep(20000);
		 RTTC10.sendUserName("chandu@gmail.com");
		 RTTC10.sendPassword("mehadi");
		Thread.sleep(20000);
		RTTC10.clickLoginBtn(); 
		Thread.sleep(20000);
		RTTC10.ClickShopmenu();
		screenShot.captureScreenShot("Menu");
		log.info("Shop menu has been selected");
		Thread.sleep(20000);
		RTTC10.clickOnProduct();
		screenShot.captureScreenShot("ProductSelect");
		log.info("Product has been selected");
		Thread.sleep(20000);
		
		Thread.sleep(100000);
		RTTC10.windowSwitch();
		Thread.sleep(20000);
		screenShot.captureScreenShot("WindowSwitch");
		log.info("Browser is switched to the child window");
		RTTC10.clickonAddtoCart();
		screenShot.captureScreenShot("AddtoCart");
		log.info("Product has been Added to the cart");
		//RTTC10.getTextOnPop();
		//screenShot.captureScreenShot("TextonPopup");
		//log.info("Text on the pop is matching");
		RTTC10.MouseoveronCart();
		Thread.sleep(20000);
		screenShot.captureScreenShot("MouseOVerOnCart");
		log.info("User is able to view the added product in the cart");
		Thread.sleep(90000);
		RTTC10.removeProductCart();
		screenShot.captureScreenShot("RemovefromCart");
		log.info("User is able to Delete the product fromthe cart");
	}
	
		 

}
