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
	
	
	public void Login(String uname,String pwd) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VimalaNarayanaswamy\\Documents\\Python Scripts\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://retailm1.upskills.in/admin");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys(uname);
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(pwd);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String Errortext = driver.findElement(By.xpath("//div[@class='alert alert-danger']/i")).getText();
       
		String expected = " No match for Username and/or Password.              ";
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Scroll obj = new Scroll();
		
		obj.Login("admin","admin@123");
		
        
	}
}