package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RTTCP_037 {
	
	private WebDriver driver;
	public RTTCP_037(WebDriver driver) {
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


public void inCorrectpwd(String userName,String password) {
	this.userName.sendKeys(userName);
	this.password.sendKeys(password);
	this.LoginBtn.click();
	String actual = this.Errore.getText();
	String expected = "Invalid token session. Please login again.";
	Assert.assertEquals(actual, expected);
	
}

public void inCorrectpwd2(String userName,String password) {
	this.userName.sendKeys(userName);
	this.password.sendKeys(password);
	this.LoginBtn.click();
	String actual = this.Errore.getText();
	String expected = "Invalid token session. Please login again.";
	Assert.assertEquals(actual, expected);
	
}
public void inCorrectUsername(String userName,String password) {
	this.userName.clear();
	this.password.clear();
	this.userName.sendKeys(userName);
	this.password.sendKeys(password);
	this.LoginBtn.click();
	String actual = this.Errore.getText();
	String expected = "Invalid token session. Please login again.";
	Assert.assertEquals(actual, expected);
	
	
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