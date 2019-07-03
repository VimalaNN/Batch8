package com.training.sanity.tests;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
    /*    
        driver.get("http://retailm1.upskills.in/admin");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("admin@123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
       
        Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/ul/li[1]/a"))).click().build().perform();
        driver.findElement(By.xpath("//td[contains(text(),'10')]//following-sibling::td[6]//a[1]")).click();
        driver.findElement(By.xpath("//i[@class='fa fa-reply']")).click(); 
     
   
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/a"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/ul/li[1]/a "))).click().build().perform();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/a[1]")).click();
        
        driver.findElement(By.xpath("//input[@id='input-name1']")).sendKeys("ORNAMENTS1");
        driver.findElement(By.xpath("//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]")).sendKeys("ORNAMENTS1");
      
        driver.findElement(By.xpath("//input[@id='input-meta-title1']")).sendKeys("ornaments for ladies");
        driver.findElement(By.xpath("//*[@id=\"input-meta-description1\"]")).sendKeys("ornaments for ladies");
        driver.findElement(By.xpath("//*[@id=\"input-meta-keyword1\"]")).sendKeys("ORNAMENTS1");
        driver.findElement(By.xpath("//*[@id=\"form-category\"]/ul/li[3]/a")).click();
        
        Select defaultdrop = new Select(driver.findElement(By.xpath("//*[@id=\"tab-design\"]/div/table/tbody/tr/td[2]/select")));
        
        defaultdrop.selectByVisibleText("Default");
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        String actualt = driver.findElement(By.xpath("//*[contains(text(),' Success: You have modified categories! ')]")).getText();
        
        
       String expected = "Success: You have modified categories!";
       
       
       Assert.assertEquals(actualt, expected);
       
       action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/a"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/ul/li[1]/a "))).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/tbody/tr[11]/td[4]/a")).click();
		driver.findElement(By.xpath("//input[@id='input-meta-title1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='input-meta-title1']")).sendKeys("ORNAMENTS");
        driver.findElement(By.xpath("//*[@id=\"input-meta-description1\"]")).sendKeys("ornaments for ladies");
        driver.findElement(By.xpath("//*[@id=\"input-meta-keyword1\"]")).sendKeys("ORNAMENTS1");
        driver.findElement(By.xpath("//*[@id=\"form-category\"]/ul/li[3]/a")).click();
        */
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        
        driver.get("http://retailm1.upskills.in/admin");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("admin@123");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
       
        Actions action = new Actions(driver);
      

        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/a"))).build().perform();
 		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-catalog\"]/ul/li[1]/a "))).click().build().perform();
 		driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/tbody/tr[11]/td[4]/a")).click();
        
        driver.findElement(By.xpath("//*[@id=\"form-category\"]/div/table/tbody/tr[2]/td[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/button")).click();
        
        
        
        
        
        
        
        
        
        
        
        
     /*   
        Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/a/i"))).build().perform();
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu-sale\"]/ul/li[1]/a"))).click().build().perform();
		String Ordername = driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr[1]/td[3]")).getText();
		System.out.println(Ordername);
		
		if (Ordername.contentEquals("manzoor mehadi")) {
			System.out.println("True");
		}
		
		else
			System.out.println("Fail");
		
		driver.findElement(By.xpath("//td[contains(text(),'10')]//following-sibling::td[6]//a[1]")).click();
		
		
		
		
	}  */
        
        

        
}    
}