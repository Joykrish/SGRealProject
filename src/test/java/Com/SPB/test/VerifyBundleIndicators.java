package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyBundle;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyBundleIndicators extends BrowserSettings {
  @Test
  public void bundleIndicators () throws Exception {
	  
		
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  LoginWithSSO ls=PageFactory.initElements(driver, LoginWithSSO.class);
		ls.loginintoapplication();
		
		hp.OpenMyRFQ();
		MyBundle mb=PageFactory.initElements(driver, MyBundle.class);
		mb.clickMyBundle();
		mb.globalSearch();
		mb.openBundle();
		Thread.sleep(10000);
		mb.readBundleIndicators();
		mb.openBundleProjects();
		
		
		
  }
}
