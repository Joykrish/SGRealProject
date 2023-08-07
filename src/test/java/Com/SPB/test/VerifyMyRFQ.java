package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyRFQ;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyMyRFQ extends BrowserSettings{
  @Test
  public void VerifyOpenbuttonInMyRFQ() throws Exception {
	  //Verify for the open button functionality 
	  //after clicking on the OPEN button, user should be redirected to the Project Dashboard of the particular project
	  Log.startTestCase("VerifyOpen");
	  LoginWithSSO lg=PageFactory.initElements(driver, LoginWithSSO.class);
	  lg.loginintoapplication();
	  HomePage hm=PageFactory.initElements(driver, HomePage.class);
	  hm.OpenMyRFQ();
	  MyRFQ mr=PageFactory.initElements(driver, MyRFQ.class);
	  mr.GlobalSearch("");
	  mr.Openbutton();
	  Thread.sleep(10000);
	  ProjectDashboard pd=PageFactory.initElements(driver,ProjectDashboard.class);
	 System.out.println(pd.GetSelectedProjectName());
	  if( pd.GetSelectedProjectName().contains(MyRFQ.devcode)) {
		  Assert.assertTrue(true);
		System.out.println("Open button working properly");  
		BrowserSettings.parentTest.pass("Open button working properly");
	  }else
	  {
		  Assert.assertTrue(false);
		  System.out.println("Open button not working properly");
		  BrowserSettings.parentTest.fail("Open button not working properly");
	  }
	  
	  
	  Log.endTestCase("VerifyOpen");
	  
	  
  }
}
