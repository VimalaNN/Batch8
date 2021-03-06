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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.Login;
import com.training.pom.Orders;
import com.training.pom.Orders;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_036 {
	

	Logger log = Logger.getLogger(Orders.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private Orders MyOrders;
	private Login log1;
	private static Properties properties;
	private ScreenShot screenShot;
	private static ExtentHtmlReporter reporter;
	private static ExtentReports extent;
	private ExtentTest logger;
  
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		//extent report code
				reporter = new ExtentHtmlReporter("C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\ExtentReport\\RTTC036_Extentreport.html");
				extent = new ExtentReports();
				extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		log1= new Login(driver); 
		MyOrders = new Orders(driver);
		baseUrl = properties.getProperty("baseURL");
		
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		} */
		
	
	
	@Test
	public void DeletePRoductCart() throws InterruptedException {
		logger = extent.createTest("Verifying the Login");
		logger.log(com.aventstack.extentreports.Status.PASS, "Login");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		log1.sendUserName("admin");
		log1.sendPassword("admin@123");
		log1.CheckWebDriverWaitL();
		log1.clickLoginBtn();
		
		logger.log(com.aventstack.extentreports.Status.PASS, "Login button option is clicked");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		extent.flush();
		screenShot.captureScreenShot("LoginC");

		 
		 ExtentTest logger2 = extent.createTest("CatgoryMenu");
		 MyOrders.myORdersC();
		screenShot.captureScreenShot("Category");
		logger.log(com.aventstack.extentreports.Status.PASS, "Order Menu link clicked");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();

		 ExtentTest logger3 = extent.createTest("SubCategory");
		MyOrders.viewIconclick();
		screenShot.captureScreenShot("ViewIcon");
		logger.log(com.aventstack.extentreports.Status.PASS, "Clicked on View Icon");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
	}
	
	

}
