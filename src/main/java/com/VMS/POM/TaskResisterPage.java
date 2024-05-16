package com.VMS.POM;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VMS.Generic.FileLibrary;
import com.VMS.Generic.Generic;

/**
 * This is the object repository for TaskResisterPage which store all the webelement present in TaskResisterPage 
 */
public class TaskResisterPage {
	Generic g=new Generic(); 
	FileLibrary l=new FileLibrary();
	
	@FindBy(xpath="//label[text()='Create Issues On:']/..//span[contains(text(),'Department')]/..")
	private WebElement dept;
	@FindBy(xpath="//span[text()='Select/Search Project']/..")
	private WebElement project;
	@FindBy(xpath="//span[text()='Select/Search Client']/..")
	private WebElement client;
	@FindBy(xpath="//span[text()='Select/Search Category']/..")
	private WebElement category;
	@FindBy(xpath="//div[text()='Software']")
	private WebElement softwareopsfordept;
	@FindBy(xpath="//div[text()='VAPS - GENERAL']")
	private WebElement generalopsforproject;
	@FindBy(xpath="//div[text()='General']")
	private WebElement generalopsforcategory;
	@FindBy(xpath="//div[text()='HO']")
	private WebElement hoforclent;
	@FindBy(name="taskname")
	private WebElement tasktitle;
	@FindBy(xpath="//label[contains(text(),'Description')]/..//textarea")
	private WebElement description;
	@FindBy(xpath="//span[text()='Select/Search Module']/..")
	private WebElement module;
	@FindBy (xpath="//div[text()='All']")
	private WebElement allopsformodule;
	@FindBy(xpath="//select[@name='priority']")
	private WebElement prioritydd;
	@FindBy(id="save-btn")
	private WebElement createbtn;
	public TaskResisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void getdept() {
		//g.waitForVisibility(dept, 10);
		//g.waitForInvisibility(By.id("preloader"), 10);
		g.CustomWait(500, dept);
		//dept.click();
	}
	public void getsoftwareopsfordept() {
		g.waitForVisibility(softwareopsfordept, 10);
		softwareopsfordept.click();
	}
	public void getproject() {
		g.waitForVisibility(project, 10);
		project.click();
	}
	public void getgeneralopsforproject() {
		g.waitForVisibility(generalopsforproject, 10);
		generalopsforproject.click();
	}
	public void getclient() {
		g.waitForVisibility(client, 10);
		client.click();
	}
	public void gethoforclent() {
		g.waitForVisibility(hoforclent, 10);
		hoforclent.click();
	}
	public void getcategory() {
		g.waitForVisibility(category, 10);
		category.click();
	}
	public void getgeneralopsforcategory() {
		g.waitForVisibility(generalopsforcategory, 10);
		generalopsforcategory.click();
	}
	public void gettasktitle() throws EncryptedDocumentException, IOException {
		g.waitForVisibility(tasktitle, 10);
		String res = l.readExcel("./src/test/resources/vms.xlsx","Sheet1", 1, 0);
		tasktitle.sendKeys(res);
	}
	public void getdescription() throws EncryptedDocumentException, IOException {
		g.waitForVisibility(description, 10);
		String res = l.readExcel("./src/test/resources/vms.xlsx","Sheet1", 1, 1);
		description.sendKeys(res);
	}
	public void getmodule() {
		g.waitForVisibility(module, 10);
		module.click();
	}
	public void getallopsformodule() {
		g.waitForVisibility(allopsformodule, 10);
		allopsformodule.click();
	}
	public void setprioritydd() {
		g.listboxbyvalue(prioritydd, "126");
	}
	public void setcreatebtn() {
		createbtn.click();
	}
	
	

}
