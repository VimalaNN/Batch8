
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

public class RTTCP_008 {
	
	private WebDriver driver;
	
	public RTTCP_008(WebDriver driver) {
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

		@FindBy(xpath="//li[@id='menu_all_categories_Menu_VIfWm2LT_VLHXC']/a/span[1]")
		private WebElement MainMenu;

		@FindBy(xpath="//li[@id='menu_all_categories_Menu_VIfWm2LT_VLHXC']/ul/li/a/span[1]") 
		
		private WebElement SubMenu;
		
		
		
		@FindBy(xpath="//div[@class='sort']/select")
		private WebElement listSelection;
		
		@FindBy(xpath="//div[@class='sort']/select")
		private WebElement listSelection1;
		
		
		
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
		
		public void ClickShopmenu() throws InterruptedException {
	 
		Actions actions = new Actions(driver);
		actions.moveToElement(this.MainMenu).build().perform();
		actions.moveToElement(SubMenu).click().build().perform();
		Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sort']/select")));
		element1.click();
		 			 
		}
				
		
		
		public void DropdownSelect() throws InterruptedException {
			
				
			Select list = new Select(this.listSelection);
			
			int size = list.getOptions().size();
			Thread.sleep(2000);
			int i;
			for(i=0;i<size;i++) {
				
				 list.selectByIndex(i);
				Thread.sleep(1000);

				String listitems = list.getFirstSelectedOption().getText();
				System.out.println("Elements in the drop list are : " + listitems);
				WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sort']/select")));
						
				
			
				
			}
		
			
		}
			public void selectDropDown() throws InterruptedException {
				
				driver.navigate().refresh();
				String expected = "Name (A - Z)";
				
				Select listc = new Select(this.listSelection1);
				listc.selectByIndex(1);
				String listitems = listc.getFirstSelectedOption().getText();
				WebDriverWait wait = new WebDriverWait(driver, 90);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sort']/select")));
				Assert.assertEquals(listitems, expected);
			
			}
			}

				
			
			


		