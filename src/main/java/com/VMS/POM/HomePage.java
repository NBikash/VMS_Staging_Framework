package com.VMS.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.Generic.Generic;

/**
 * This is the object repository for HomePage which store all the webelement present in HomePage 
 */
public class HomePage {
	Generic g=new Generic(); 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement logoutoption;
	@FindBy(xpath="//button[text()='Log Out']")
	private WebElement logoutbtn;
	@FindBy(xpath="//span[text()='Issue Manager']/..")
    private WebElement issuemanager;
	@FindBy(xpath="//span[text()='Issue Manager']/../..//span[text()='Transaction']/..")
	private WebElement transactionbtn;
	@FindBy(xpath="//a[contains(@ui-sref,'app.ISM_TaskCreation')]")
	private WebElement taskregisterbtn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void getlogout() throws InterruptedException {
		Thread.sleep(3000);
		logoutoption.click();
		Thread.sleep(2000);
		logoutbtn.click();
	}
	public void setissuemanager()
	{
		g.CustomWait(500, issuemanager);
	}
	public void settransaction()
	{
		g.waitForVisibility(transactionbtn, 10);
		transactionbtn.click();
	}
	public void gettaskregister()
	{
		g.waitForVisibility(taskregisterbtn, 10);
		taskregisterbtn.click();
	}
	
	

}
