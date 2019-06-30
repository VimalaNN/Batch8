package com.training.pom;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RTTCP_007 {
	
	private WebDriver driver;
		public RTTCP_007(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
		@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]")
		private WebElement LoginLink;
		
		@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[1]/a/span")
		public WebElement RegisterLin;
				
		@FindBy(id="input-email")
		private WebElement userName; 
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(xpath="//input[@class='btn btn-primary' and @type='submit']")
		private WebElement LoginBtn;
		
		@FindBy(xpath="//a[contains(text(),'Change your password')]")
		private WebElement ChangePasswordLink;
	
		@FindBy(id="input-confirm")
		private WebElement confirmpass;
		
		@FindBy(id="input-password")
		private WebElement resetp;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement continueBtn;
		
		@FindBy(xpath="//div[@class='text-danger']")
		private WebElement FaileText;
		
			
		
		
		
		
		
		public void LoginLinkClick() {
				this.LoginLink.click();
			}
				
		public void RegisterLink() {
			this.RegisterLin.click();
			
		}
		
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
					
			public void LoginLink() {
				Actions actions = new Actions(driver);
				actions.moveToElement(this.LoginLink).build().perform();
				
				
			}
			
			public void clickChangePassword() {
				//WebDriverWait wait=new WebDriverWait(driver,60);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Change your password']")));
				this.ChangePasswordLink.click();
				
				
				
				
			}
			
					
			public void firstPasswordfield(String resetPwd) {
			
				this.resetp.clear();
				this.resetp.sendKeys(resetPwd);

				
			}
			
			public void confirmPasswdfield(String confirmpwd) {
				
				this.confirmpass.sendKeys(confirmpwd);
			}
			
			public void clikcontinue() {
				
				this.continueBtn.click();
				
				
			}
			
			public void FailureMessage() {
				
				String Expected = "Password confirmation does not match password!";
				String actual = this.FaileText.getText();
				Assert.assertEquals(actual, Expected);
						
			}
			
			
		}
		
		
				
			
					
			
			


