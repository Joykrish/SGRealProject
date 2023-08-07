package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyBundle;

public class ScenarioTestTest extends BrowserSettings {
  @Test
  public void test() throws Exception {
	  HomePage hp = PageFactory.initElements(driver, HomePage.class);
	  LoginWithSSO ls=PageFactory.initElements(driver, LoginWithSSO.class);
		ls.loginintoapplication();
		
		hp.OpenMyRFQ();
		MyBundle mb=PageFactory.initElements(driver, MyBundle.class);
		mb.clickMyBundle();
		mb.globalSearch();
		mb.openBundle();
  }
}
