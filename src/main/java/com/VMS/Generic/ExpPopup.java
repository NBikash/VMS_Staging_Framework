package com.VMS.Generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;


public class ExpPopup extends Baseclass{
	Generic g=new Generic();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	/**
	 * This is the Generic method for "Still You Did Not Approved TADA Advance Tour Plan !"
	 * It will  verify the popup and click on cancel button 
	 * @Placement After click on signin button, This popup should appear on homepage 
	 */
	public void TADAadvtourplannotApproved() {
		 try {
			    g.waitForPresenceOfElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']"), 10);
		        WebElement cancel = driver.findElement(By.xpath("//button[@class='cancel']"));
		        cancel.click();
		        Reporter.log("TADAadvtourplannotApproved Popupfound and handled .",true);
		    } catch (NoSuchElementException | TimeoutException e) {
		        Reporter.log(" Issue with TADAadvtourplannotApproved Popup, either popup not found or issue with locators. Continuing with the next steps...",true);
		    }
	}
	
	/**
	 * This is the Generic method for "Task Created Successfully"
	 * It will  verify the popup and click on cancel button
	 * @throws Exception 
	 * @placement After creating a task or clicking on save button after entering all details in taskcreation page 
	 */
	public void TaskcreatedSuccessfullPopup() throws Exception {
		try {
			g.waitForPresenceOfElement(By.xpath("//h2[text()='Record saved successfully']/.."), 10);	
		    WebElement cancel = driver.findElement(By.xpath("//button[text()='OK']"));
		    g.CustomWait(500, cancel);
		    cancel.click();
		    Reporter.log("TaskcreatedSuccessfullPopup found and handled",true);
		}catch (NoSuchElementException | TimeoutException e)   {
			Reporter.log("Issue with TaskcreatedSuccessfullPopup ,either popup not found or issue with locators . Continuing with the next steps...",true);
			throw new Exception("Issue with TaskcreatedSuccessfullPopup either popup not fiund or issue with locators. Continuing with the next steps...", e);
	    }
		
	    } 
	
	
	
	/**
	 * This is the Generic method for popup "Failed to save, please contact administrator"
	 * It will  verify the popup and if popup found , it will throw RuntimeException and it fail the test case in  test class
	 * @throws Exception 
	 * @placement After creating a task or clicking on save button after entering all details in taskcreation page 
	 */
	public void failtosaveContactAdmin()  {
		try {
		 WebElement popup = driver.findElement(By.xpath("//h2[text()='Failed to save, please contact administrator']/.."));
		 if (popup != null) {
		        throw new RuntimeException( "----> Failed to save popup found. Test case failed.");
		    }
		}
		catch(NoSuchElementException e) {
			Reporter.log("failtosaveContactAdmin popup not found ,Continuing with the next steps... ",true);
			
		}
		}

}
