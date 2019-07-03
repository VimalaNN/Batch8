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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RTTCP_010 {
	
private WebDriver driver;
	
	public RTTCP_010(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[4]/div/div[3]/div/div/div[1]/h4/a")
	private WebElement ProductText;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	private WebElement AddtoCart;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']//parent::a")
	private WebElement mouseOver;
	
	@FindBy(xpath="//a[text()='View Cart']")
	private WebElement viewcart;
	
	@FindBy(xpath="//*[@id=\\\"cart_form\\\"]/div/table/tbody/tr/td[4]/div/span/button[2]/i")
	private WebElement remove;
	

	
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
	
	}
	
	public void clickOnProduct() {
		
		this.ProductText.click();
	}
	
	
	public void windowSwitch() {
		
		Set<String> widnowIDs = driver.getWindowHandles();
		Iterator<String> itr = widnowIDs.iterator();
		String mainWindow = itr.next();
		String childwindow = itr.next();
		
		driver.switchTo().window(childwindow);
		
	}
	
	public void clickonAddtoCart() throws InterruptedException {
		Thread.sleep(90000);
		this.AddtoCart.click();
	}
	
	public void getTextOnPop() {
		Alert alt = this.driver.switchTo().alert();
		
		String alertText = alt.getText();
		String Expected = "Shopping Cart updated!";
		Assert.assertEquals(alertText, Expected);
		
	}
	
	
	
	
	public void MouseoveronCart() throws InterruptedException {
		/*
		Actions actions = new Actions(driver);
	//	WebElement element = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li/h3/a"));
		actions.moveToElement(this.mouseOver).build().perform();
		Thread.sleep(4000);
		actions.moveToElement(viewcart).click().build().perform(); */
		
		
		Actions actions = new Actions(driver);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li/h3/a"));
		actions.moveToElement(element).build().perform();
		
		Thread.sleep(4000);
		System.out.println("element clicked on it ");
		actions.moveToElement(element).click().build().perform();
		
	}
	
	public void removeProductCart() {
		this.remove.click();
	}

}
