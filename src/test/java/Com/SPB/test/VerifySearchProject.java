package Com.SPB.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifySearchProject extends BrowserSettings {
  @Test
  //test data row number 2
  public void searchproject() throws Exception {
	  Log.startTestCase("SearchProject");
	 
	  HomePage hp=new HomePage();
	  Log.info("Calling SeachProject Method");
	  hp.searchProject("other");
	  Log.info("Seccessfully Calling SeachProject Method");
	  Thread.sleep(10000);
	  ProjectDashboard pd=new ProjectDashboard();
	  Log.info("Read the  SelectedProjectname");
	  String sp=pd.GetSelectedProjectName();
	  Log.info("Sucessfully captured the  Selected Projectname");
	  System.out.println(sp);
	  Log.info("Sucessfully captured  and printed the  Selected Projectname");
	  if(sp.contains(HomePage.devcodetobeseached)) {
		  System.out.println("PASS::Redirected to the Project Dashboard Successfully");
		  Assert.assertTrue(true);
		  Log.info("Sucessfully redirected to Selected Project Dashboard");
		  BrowserSettings.parentTest.pass("PASS::Redirected to the Project Dashboard Successfully");
	  }
	  else 
		  
	  {
		  Assert.assertTrue(false);
		  System.out.println("FAIL::not Redirected to the Project Dashboard Successfully");
		  Log.info("File to  redirected to Selected Project Dashboard");
		  BrowserSettings.parentTest.fail("FAIL::not Redirected to the Project Dashboard Successfully");
	  }
	Log.endTestCase("SearchProject");  
  }
  
}
