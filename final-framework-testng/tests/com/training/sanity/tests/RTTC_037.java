package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.Catelog;
import com.training.pom.Categories;
import com.training.pom.Login;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_037 {
	
	
	Logger log = Logger.getLogger(RTTC_037.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private Login log1;
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
		log1 = new Login(driver); 
	
		
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
	
  @Test(dataProvider = "dp")
  
  public void VerifyInvalidLogin(String userName, String password) throws Exception {
	  
	  logger = extent.createTest("Verifying the Login");
		logger.log(com.aventstack.extentreports.Status.PASS, "Login");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");

	  log1.sendUserName(userName);
	  log1.sendPassword(password);
		log1.CheckWebDriverWaitL();
		log1.clickLoginBtn();
		log1.ErrorLogin();
		screenShot.captureScreenShot("Logins");
		logger.log(com.aventstack.extentreports.Status.PASS, "Login ");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
	  	
  }

  
  
  @DataProvider(name="dp")
  public Object[][] getDataProvider() {
    return new Object[][]
    		{ 
    	{"admin","123456"},
    	{"admin","admin"},
    	{"manzoor","admin@123"},
    	{"admin@123","admin@123"}
    	};
  }
}
