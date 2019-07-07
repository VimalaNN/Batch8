package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.training.generics.ScreenShot;
import com.training.pom.Catelog;
import com.training.pom.Login;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_039 {
	

	Logger log = Logger.getLogger(Catelog.class.getName());
	private WebDriver driver;
	private String baseUrl;
	private Login log1;
	private Catelog categories;
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
				reporter = new ExtentHtmlReporter("C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\ExtentReport\\RTTC039_Extentreport.html");
				extent = new ExtentReports();
				extent.attachReporter(reporter);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		log1 = new Login(driver); 
		categories = new Catelog(driver);
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
	public void Categories() throws InterruptedException {
		logger = extent.createTest("Verifying the Login");
		logger.log(com.aventstack.extentreports.Status.PASS, "MarkupHelper");
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
		categories.CarlogMenuclick();
		screenShot.captureScreenShot("Category");
		logger.log(com.aventstack.extentreports.Status.PASS, "Category Menu link clicked");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();

		 ExtentTest logger3 = extent.createTest("SubCategory");
			categories.SubMenuCategoriesClic();
			screenShot.captureScreenShot("ViewIcon");
			logger.log(com.aventstack.extentreports.Status.PASS, "Clicked on Sub Category");
			 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
			 extent.flush();
	
			 categories.clickonEditCategory();
			 ExtentTest logger5 = extent.createTest("CategpryTtest");
			screenShot.captureScreenShot("GetCategoryname");
			logger.log(com.aventstack.extentreports.Status.PASS, "Click on edit category");
			 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
			 extent.flush();
			 	categories. clearValueMegaTitle();
			 	ExtentTest logger6= extent.createTest("CategpruTtest");
				screenShot.captureScreenShot("ClearMEgaTitle");
				logger.log(com.aventstack.extentreports.Status.PASS, "Remove Value from the Megatitle");
				 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
				 extent.flush();
				 
		categories.InputCategoryName("ORNAMENTS");
		ExtentTest logger7= extent.createTest("CategpruTtest");
		screenShot.captureScreenShot("InputCategry");
		logger.log(com.aventstack.extentreports.Status.PASS, "Enter the cateogry re enter");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		 
		 categories.Megatitl("ORNAMENTS");
		 ExtentTest logger10= extent.createTest("CategpruTtest");
			screenShot.captureScreenShot("InputCategry");
			logger.log(com.aventstack.extentreports.Status.PASS, "Enter the data in to the cateogry MegaTitle");
			 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
			 extent.flush();
		 
		 
		categories.InputMetaKeyword("ornaments for ladie");
		
		ExtentTest logger8= extent.createTest("CategpruTtest");
		screenShot.captureScreenShot("SelectCheckCategory");
		logger.log(com.aventstack.extentreports.Status.PASS, "Re enter the meta Keyword");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		categories.Savebutton();
		
		ExtentTest logger9= extent.createTest("CategpruTtest");
		screenShot.captureScreenShot("SelectCheckCategory");
		logger.log(com.aventstack.extentreports.Status.PASS, "User saved the edit category");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
			
			String actual = categories.SuccMsg.getText();
			String expected1 = "Success: You have modified categories!  ";
			Assert.assertEquals(actual, expected1);
			
			extent.flush();
		
}
}
