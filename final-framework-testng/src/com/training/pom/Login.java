package com.training.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	private WebDriver driver;
	public Login(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath="//*[@id='input-username']")
	private WebElement userName; 
	
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']/i")
	private WebElement Errormsg;
	
	// Function for User name field 

	public void sendUserName(String userName) throws InterruptedException {
			this.userName.clear();
			this.userName.sendKeys(userName);
			Thread.sleep(2000);
	}
	
	// Function for Password filed 
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		
	}
	
	// Function for WebDriver to Wait 
	
	public void CheckWebDriverWaitL() {
		
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		
	}
	// Function to click on the Login button 
	
	public void clickLoginBtn() {
	this.LoginBtn.click(); 
		}
	
	public void ErrorLogin() {
	
		this.Errormsg.getText();
	}
}
	
	
	
