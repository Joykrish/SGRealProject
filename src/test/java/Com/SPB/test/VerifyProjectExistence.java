package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.NewRFQ;

public class VerifyProjectExistence extends BrowserSettings {
	ActionDriver ad;
  @Test(priority=1,enabled=true)
  
  //Verify in case Project is not available in the MPT project
  //Test Data Row 6
  public void SearchProjectForimportnotexists() throws Exception {
	  ad=new ActionDriver();
	  NewRFQ nr=PageFactory.initElements(driver, NewRFQ.class);
	  LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
	  lg.loginintoapplication();
	  nr.importproject();
	  nr.selectCustomerTwo();
	  nr.selectBrandTwo();
	  nr.selectDevCodeTwo();
	  nr.selectBodyTwo();
	  nr.selectRegionTwo();
	  nr.ClickSearch();
	  nr.messagecaptureone();
	  ad.verificationByAssert(NewRFQ.projectsearchmessageone, "Project not found on MPT");
	 // Assert.assertEquals("Project not found on MPT", NewRFQ.projectsearchmessageone);
	  
  }

@Test(priority=2,enabled=false)
  
  //Verify in case Project is  available in the MPT project
  public void SearchProjectForimporttexists() throws Exception {
	ad=new ActionDriver();
	  NewRFQ nr=new NewRFQ();
	  nr.importproject();
	 nr.selectCustomer();
	  nr.selectBrand();
	  nr.selectDevCode();
	  nr.selectBody();
	  nr.selectRegion();
	  nr.ClickSearch();
	  nr.messagecapturetwo();
	 // Assert.assertEquals("Project already exists", NewRFQ.projectsearchmessagetwo);
	  ad.verificationByAssert(NewRFQ.projectsearchmessagetwo,"Project already exists");
	  
	  
  }

}
