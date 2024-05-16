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
		    } catch (NoSuchElementException e) {
		        Reporter.log(" TADAadvtourplannotApproved Popup not found 1. Continuing with the next steps...",true);
		    }catch (TimeoutException e) {
		    	Reporter.log("TADAadvtourplannotApproved Popup not found 2. Continuing with the next steps... ",true);
		    } 
	}
	
	/**
	 * This is the Generic method for "Task Created Successfully"
	 * It will  verify the popup and click on cancel button
	 * @placement After creating a task or clicking on save button after entering all details in taskcreation page 
	 */
	public void TaskcreatedSuccessfullPopup() throws NoSuchElementException,TimeoutException {
		try {
			g.waitForPresenceOfElement(By.xpath("//h2[text()='Record saved successfully']/.."), 10);	
		    WebElement cancel = driver.findElement(By.xpath("//button[@class='confirm']"));
		    cancel.click();
		   
		}catch (NoSuchElementException e)   {
			Reporter.log("TaskcreatedSuccessfullPopup Popup not found 1. Continuing with the next steps...",true);
			
	    }catch (TimeoutException e) {
	    	Reporter.log("TaskcreatedSuccessfullPopup Popup not found 2. Continuing with the next steps... ",true);  
	    	
	    } 
	
	}
	
	/**
	 * This is the Generic method for popup "Failed to save, please contact administrator"
	 * It will  verify the popup and if popup found , it will throw RuntimeException and it fail the test case in  test class
	 * @placement After creating a task or clicking on save button after entering all details in taskcreation page 
	 */
	public void failtosaveContactAdmin() {
		 WebElement popup = driver.findElement(By.xpath("//h2[text()='Failed to save, please contact administrator']/.."));
		 if (popup != null) {
		        throw new RuntimeException( "----> Failed to save popup found. Test case failed.");
		    }
		}

}
