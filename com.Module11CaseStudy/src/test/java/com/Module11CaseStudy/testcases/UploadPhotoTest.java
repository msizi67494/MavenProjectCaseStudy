package com.Module11CaseStudy.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Module11CaseStudy.baseclass.BaseClass;

public class UploadPhotoTest extends BaseClass {
	

	
	@BeforeTest
	public void setupBrowser() {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void uploadPhotoTest() throws InterruptedException {
		Actions action = new Actions(driver);
		
		//Login Page
		
		action.moveToElement(driver.findElement(By.linkText("Log In"))).click();
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.id("si_popup_email"))).click().sendKeys(prop.getProperty("username"));
		Thread.sleep(1000);
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.id("si_popup_passwd"))).click().sendKeys(prop.getProperty("password"));
	
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']"))).click();
		action.build().perform();
		
		String expectedTitle = "My Classroom | Edureka";
		String actualTitle = driver.getTitle();
		
		//Assert.assertEquals(actualTitle, expectedTitle,"Home Page Verified");
		
		//Home Page
		
		action.moveToElement(driver.findElement(By.xpath("//span[@class='user_name']"))).click();
		Thread.sleep(3000);
		action.build().perform();
		
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"))).click();
		Thread.sleep(1000);
		action.build().perform();
		
		Thread.sleep(3000);
		// My- Profile Page
		driver.findElement(By.xpath("//a[@id='personal_details']//i[@class='icon-pr-edit']")).click();
		
		Thread.sleep(3000);
		//Personal Details Page
		driver.findElement(By.xpath("//i[@class='icon-camera']")).click();
		
		Thread.sleep(3000);
		//Upload Photo Pop up
		driver.findElement(By.id("custom-input")).click();
		
		//upload photo
		driver.findElement(By.id("custom-input")).sendKeys("C:\\Users\\NdlelaM1\\Pictures\\Msizi Ndlela\\New folder\\Msizi Ndlela.JPG");
		
		//Submitt Button
		driver.findElement(By.xpath("//button[@class='submitbtn']")).click();
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
