package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.ProjectDashboard;

public class GlassPosition extends BrowserSettings {
  @Test(enabled=true)
  //verify redirection to Cost and Price Dashboard
  public void verifyRedirectionToCostAndPriceDashboard() throws Exception {
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		SoftAssert softAssertion= new SoftAssert();
		hp.searchProject("other");
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		Thread.sleep(10000);
		String projectnamePD=gd.readprojectname();
		Thread.sleep(10000);
		System.out.println(projectnamePD);
		if(projectnamePD.contains("Edit Price")) {
			//Assert.assertTrue(true);
			softAssertion.assertTrue(true);
			BrowserSettings.childTest.pass("PASS:Redirected to Price Dashboard Successfully");
		}
		else {
			
			//Assert.assertTrue(false);
			softAssertion.assertTrue(false);
			System.out.println("Fail:Not Redirected to Price Dashboard Successfully");
			BrowserSettings.childTest.fail("FAIL:Unable to Redirect to Price Dashboard Successfully");
			
		}
		
		driver.navigate().back();
		Thread.sleep(10000);
		gd.openCostandExtendedMarginDashboard();
		Thread.sleep(1000);
		String projectnameCD=gd.readprojectname();
		System.out.println(projectnameCD);
		if(projectnameCD.contains("Costs & Extended Margin")) {
			//Assert.assertTrue(true);
			softAssertion.assertTrue(true);
			BrowserSettings.childTest.pass("PASS:Redirected to the Costs & Extended Margin Dashboard Successfully");
		}
		else {
			
			//Assert.assertTrue(false);
			softAssertion.assertTrue(false);
			BrowserSettings.childTest.fail("FAIL: Unable to Redirect to the Costs & Extended Margin Dashboard Successfully");
			
		}
		
		
	  
  }
  @Test()
  //If scenario is submitted for internal validation then Add version button should be disabled
  public void verifyAddVersionbtn() throws Exception {
	  ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		
		hp.searchProject("other");
		pd.selectscenario();
		pd.verifyInternalValidationStatus();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.stateAddVersion();
		if(ProjectDashboard.internalVal.equals("Internal Validation : No") && (GlassPositionDashboard.state=true) )
		{
			BrowserSettings.childTest.pass("PASS");
			Assert.assertTrue(true);
		}
		else if(!(ProjectDashboard.internalVal.equals("Internal Validation : No")&&(GlassPositionDashboard.state=false))) 
		{
			BrowserSettings.childTest.pass("PASS");
			Assert.assertTrue(true);
		}
		
		else {
			BrowserSettings.childTest.pass("FAIL");
			Assert.assertTrue(false);
		}
	  
  }
  @Test
  public void ActionButtonMenuVersionDashboard() throws Exception 
  //Verify for the options in the action button in the version dashboard
  {
	  ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		
		hp.searchProject("other");
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.clickActionbutton();
		gd.btnActionMenu();
		
		if(GlassPositionDashboard.ActionNames.contains("Rename") && GlassPositionDashboard.ActionNames.contains("Delete") && GlassPositionDashboard.ActionNames.contains("Edit Price") && GlassPositionDashboard.ActionNames.contains("Edit Costs & EM") ) {
			System.out.println("Pass");	
			Assert.assertTrue(true);
			BrowserSettings.childTest.pass("PASS:All Action Button Menu VersionDashboard values are available ");
			
			}
			else
			{
				Assert.assertTrue(false);
				BrowserSettings.childTest.pass("FAIL:All Action Button Menu VersionDashboard values are not available ");
			}
  }
}
