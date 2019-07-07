package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Categories{
	
	private WebDriver driver;
	public Categories(WebDriver driver) {
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
	private WebElement Errore;


public String inCorrectpwdError() {
	String actual = this.Errore.getText();
	String expected = "No match for Username and/or Password.";
	Assert.assertEquals(actual, expected);
	return expected;
	
}

	

public void inCorrectUsername1(String userName,String password) {
	this.userName.clear();
	this.password.clear();
	this.userName.sendKeys(userName);
	this.password.sendKeys(password);
	this.LoginBtn.click();
	String actual = this.Errore.getText();
	String expected = "Invalid token session. Please login again.";
	Assert.assertEquals(actual, expected);
	
}
}