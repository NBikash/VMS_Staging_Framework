package com.VMS.POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is the object repository for LoginPage which store all the webelement present in loginpage 
 */
public class LoginPage {
	@FindBy(id="form2")
	private WebElement untbx;
	@FindBy(id="form4")
	private WebElement pwdtbx;
	@FindBy(xpath="//button[@ng-if='!twofactor']")
	private WebElement signinbtn;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setlogin(String un,String pwd)
	{
		untbx.sendKeys(un);
		pwdtbx.sendKeys(pwd);
		signinbtn.click();;
	}

}
