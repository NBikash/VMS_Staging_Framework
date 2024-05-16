package com.VMS.TestScripts;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.VMS.Generic.Baseclass;
import com.VMS.Generic.ExpPopup;
import com.VMS.Generic.Generic;
import com.VMS.POM.HomePage;
import com.VMS.POM.TaskResisterPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


@Listeners(com.VMS.Generic.ListenerImplimentation.class)
public class TaskCreation extends Baseclass {
	@Test(priority =0)
	public void taskRsister() throws InterruptedException {
		Generic g=new Generic(); 
		ExtentTest test=extent.createTest("Task Resister");
		test.assignAuthor("Bikash").assignCategory("Smoke Test").assignDevice("Chrome");
		
		try {
	HomePage hm=new HomePage(driver);
	ExpPopup e=new ExpPopup();
	TaskResisterPage t=new TaskResisterPage(driver);
	
	Reporter.log("task register",true);
	
	e.TADAadvtourplannotApproved();
	
	hm.setissuemanager();
	hm.settransaction();
	hm.gettaskregister();
	
	t.getdept();
	t.getsoftwareopsfordept();	
	t.getproject();
	t.getgeneralopsforproject();	
	t.getclient();
	t.gethoforclent();
	t.getcategory();
	t.getgeneralopsforcategory();
	t.gettasktitle();
	t.getdescription();
	t.getmodule();
	t.getallopsformodule();
	t.setprioritydd();	
	t.setcreatebtn();

	e.TaskcreatedSuccessfullPopup();
	e.failtosaveContactAdmin();
	
	
	
		}
		
		catch (WebDriverException e) {
          
            e.printStackTrace();
            test.fail("Test Failed"+e.getMessage()); 
           String p= g.failscreenshot();
            test.log(Status.WARNING,"Failed Test case Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(p).build());
           // driver.close();
           
        }
		catch(Exception e) {
			e.printStackTrace();			
			test.fail("Test failed"+e.getMessage());
			 String p= g.failscreenshot();
	            test.log(Status.WARNING,"Failed Test case Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(p).build());
	          //  driver.close();
		}
	
	
	
	
	
	
	}
	
	
	

}
