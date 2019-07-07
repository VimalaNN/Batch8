package com.training.pom;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

	public class Orders {
	
		private WebDriver driver;



		public Orders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	

	@FindBy(xpath="//*[@id='menu-sale']/a/i")
	private WebElement MyOrders;

	@FindBy(xpath="//*[@id='menu-sale']/ul/li[1]/a") 
	
	private WebElement Orderlink;
	
	@FindBy(xpath="//td[contains(text(),'10')]//following-sibling::td[6]//a[1]")
	private WebElement viewIcon;
	
	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement ReturnLink;
	
	
	// WebDriver wait
	
	public void CheckWebDriverWait() {
		
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		
	}
	
	
	
	//Function to Select Orders details	
	
	
	public void myORdersC() throws InterruptedException {
	

        Actions action = new Actions(driver);
        Thread.sleep(20000);
		action.moveToElement(this.MyOrders).build().perform();
		action.moveToElement(this.Orderlink).click().build().perform();
		
	}
	
	// Function to click on the view icon 	
	public void viewIconclick() throws InterruptedException {
		this.viewIcon.click();
	Thread.sleep(2000);
		}
	
	//Funtion to return to orders page 
	
	public void reutnLink() {
		
		this.ReturnLink.click();
	}


}
