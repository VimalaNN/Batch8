package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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


public class RTTC_038 {
	
	private static final String SuccMsg = null;
	Logger log = Logger.getLogger(Catelog.class.getName());
	private WebDriver driver;
	private static String baseUrl;
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
				reporter = new ExtentHtmlReporter("C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\ExtentReport\\RTTC038_Extentreport.html");
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
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
		}
		
	@Test
	public void Categories() throws InterruptedException {
		
		logger = extent.createTest("Verifying the Login");
		//logger.log(Status, "User is in the Login Page");
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
		ExtentTest logger2 = extent.createTest("OrderTtest");
		log.info("User successfully logged in to the application ");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		screenShot.captureScreenShot("Login");
		logger.log(com.aventstack.extentreports.Status.PASS, "User is in Order Details Page");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		 
		 ExtentTest logger3 = extent.createTest("CatgoryMenu");
		categories.CarlogMenuclick();
		screenShot.captureScreenShot("Category");
		logger.log(com.aventstack.extentreports.Status.PASS, "Category Menu link clicked");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		 ExtentTest logger4 = extent.createTest("SubCategory");
		categories.SubMenuCategoriesClic();
		screenShot.captureScreenShot("SubCategory");
		logger.log(com.aventstack.extentreports.Status.PASS, "Clicked on Category Submenu");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		categories.getCategoryname();
		 ExtentTest logger5 = extent.createTest("OrderTtest");
		screenShot.captureScreenShot("GetCategoryname");
		logger.log(com.aventstack.extentreports.Status.PASS, "Get all ready created Category name");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		categories.GetUserCategoryname();
		 ExtentTest logger6= extent.createTest("OrderTtest");
		screenShot.captureScreenShot("GetCategory");
		logger.log(com.aventstack.extentreports.Status.PASS, "Get user created category name");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 extent.flush();
		categories.ClickAddNew();
		screenShot.captureScreenShot("AddNew");
		logger.log(com.aventstack.extentreports.Status.PASS, "Clicked on Add New Button");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		 log1.CheckWebDriverWaitL();
		categories.InputCategoryName("ORNAMENTSV");
		screenShot.captureScreenShot("InputCaegory");
		logger.log(com.aventstack.extentreports.Status.PASS, "Enter");
		 logger.log(com.aventstack.extentreports.Status.INFO, "Test pass");
		categories.clearValueMegaTitle();
		log1.CheckWebDriverWaitL();
		screenShot.captureScreenShot("RemoveTitle");
		categories.Megatitl("ORNAMENTS");
		log1.CheckWebDriverWaitL();
		categories.MegaDescrp("ornaments for ladies");
		categories.Savebutton();
		
		String actual = categories.SuccMsg.getText();
		String expected1 = "Success: You have modified categories!";
		Assert.assertEquals(actual, expected1);
		
		extent.flush();
		
	}
	

}
