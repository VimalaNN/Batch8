package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Catelog {
	
	
	private WebDriver driver;
	public Catelog(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/a/i")
	private WebElement catlog;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[1]/a")
	private WebElement catgorieLink;
	
	@FindBy(xpath="//*[@class='asc']")
	private WebElement CategoryName; 
	//*[@id="form-category"]/div/table/thead/tr/td[2]/a)
	
	
	@FindBy(xpath="//*[@id='form-category']/div/table/tbody/tr[1]/td[2]")
	private WebElement UserCategoryname;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement AddnewBtn;
	
	@FindBy(id="input-name1")
	private WebElement CategoryNameinput;
	
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement CategoryDescriptoin;
	
	
	@FindBy(id="input-meta-title1")
	private WebElement CategoryMegaTitle;
	
	@FindBy(xpath="//*[@id='input-meta-description1']")
	private WebElement 	MetaTagDesc;	
			
	@FindBy(id="input-meta-keyword1")
	private WebElement MetaKeywords;
	
	@FindBy(xpath="//button[@type='submit' ]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//*[contains(text(),' Success: You have modified categories!')]")
	public WebElement SuccMsg;
	
	@FindBy(xpath="//*[contains(text(),'Accessories')]//following-sibling::td[2]/a/i")
	private WebElement CatCreated;
	
	@FindBy(xpath="//*[@class='fa fa-reply']")
	private WebElement CancelEditCategory;
	@FindBy(xpath="//td[contains(text(),'ORNAMENTS1')]/following-sibling::td[2]")
	private WebElement Editcategory;
	
	@FindBy(xpath="//td[contains(text(),'ORNAMENTS1')]/preceding-sibling::td")
	private WebElement checkboxselect;
	
	@FindBy(xpath="//td[contains(text(),'ORNAMENTS1')]/following-sibling::td")
	private WebElement DeleteCategory;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement DeletBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']/i")
	public WebElement DeleteSuccessMsg;
	@FindBy(xpath="//i[@class='fa fa-reply']")
	private WebElement Clickcancel;
	
	
	
	
	
	// to click on the Main category image
	
	public void CarlogMenuclick() {
		
		this.catlog.click();
		
	}
	
	// to Click on the Categories link under category 
	
	public void SubMenuCategoriesClic() {
		
		this.catgorieLink.click();
	}
	
	// to Verify the Category name header is present 
	public void getCategoryname() {

		String catname = this.CategoryName.getText();
		String expected = "Category Name";
		
		Assert.assertEquals(catname, expected);
		
	}
	
	
	// Get user provided Category name
	public void GetUserCategoryname() {
		
		String UCatname= this.UserCategoryname.getText();
		String expected = "Accessories";

		Assert.assertEquals(UCatname, expected);
		
	} 
	
	//clik on the Cancel button 
	
	public void clickcancel() {
		
		this.Clickcancel.click();
	}
	
	// To click on ADD new button 
	
	public void ClickAddNew() {
	
	this.AddnewBtn.click();
	}
	
	// To enter Category name
	public void InputCategoryName(String catname) {
		this.CategoryNameinput.sendKeys(catname);
		
	}
	
	// To enter category Description 
	
	public void InputCateDescirption(String catDesc) {
		this.CategoryDescriptoin.sendKeys(catDesc);
	}
	
	public void InputMetaKeyword(String metakeywor) {
		this.MetaKeywords.sendKeys(metakeywor);
	}
	//Success message after click on the save button 
	
	/*public void SaveSuccess() {
		
	String actual = this.SuccMsg.getText();
	String expected = "Success: You have modified categories!";
	
	Assert.assertEquals(actual, expected);
	
	} */
	
	// enter data in to the mega title
	
	public void Megatitl(String megati) {
		this.CategoryMegaTitle.sendKeys(megati);
	}
	
	// Edit category
	public void clickonEditCategory() {
		
		this.CatCreated.click();
	}
	
	// Edit category Cancel button 
	public void clickonCancelEdit() {
		this.CancelEditCategory.click();
	}
	
	//select checbox in the categories page
	public void selectCheckbox() {
		this.checkboxselect.click();
		
	}
	// Delete Category 
	public void DeleteCategoryList() {
		this.DeleteCategory.click();
	}
	
	public void DeleteCategory() {
		this.DeletBtn.click();
	}
	// Handling pop up 
	
	public void PopAlert() throws InterruptedException{
		 Alert alert = driver.switchTo().alert();
		 String actual = alert.getText();
		alert.accept();
		
		String expected = "Are you sure?";
				
		Assert.assertEquals(actual, expected);
	}
	
	public void DeleteCategorySuccess() {
		String actual = this.DeleteSuccessMsg.getText();
		String expected = "Success: You have modified categories!";
	}
	
	//clear the value in the MegaTitle filed 
	public void clearValueMegaTitle() {
		this.CategoryMegaTitle.clear();
		
	}
	// save button 
	
	public void Savebutton() {
		this.SaveBtn.click();
	}
	// Meg description field 
	public void MegaDescrp(String megd) {
	this.MetaTagDesc.sendKeys(megd);
	}
}
