package com.training.pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RTTCP_036 {
	
	private WebDriver driver;



	public RTTCP_036(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='input-username']")
	private WebElement userName; 
	
	@FindBy(xpath="//*[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement LoginBtn;

	@FindBy(xpath="//*[@id=\"menu-sale\"]/a/i")
	private WebElement MyOrders;

	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a") 
	
	private WebElement Orderlink;
	
	@FindBy(xpath="//td[contains(text(),'10')]//following-sibling::td[6]//a[1]")
	private WebElement viewIcon;
	
	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement ReturnLink;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	private WebElement AddtoCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']//parent::a")
	private WebElement mouseOver;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[1]")
	private WebElement viewcart;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[2]")
	private WebElement remove;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[2]")
	private WebElement checkout;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	private WebElement checkContinue;
	
	
	
		
	
	public void sendUserName(String userName) throws InterruptedException {
			this.userName.clear();
			this.userName.sendKeys(userName);
			Thread.sleep(2000);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
		
	}
	
			
	public void clickLoginBtn() {
		this.LoginBtn.click(); 
	}
	
	public void myORdersC() {
	

        Actions action = new Actions(driver);
		action.moveToElement(this.MyOrders).build().perform();
		action.moveToElement(this.Orderlink).click().build().perform();
		
	}
	
		
	public void viewIconclick() throws InterruptedException {
		this.viewIcon.click();
	Thread.sleep(2000);
		}
	

	public void reutnLink() {
		
		this.ReturnLink.click();
	}
	
	
	
	
	
	
	
	

}
