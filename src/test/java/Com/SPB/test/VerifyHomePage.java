package Com.SPB.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;

public class VerifyHomePage extends BrowserSettings {
	ActionDriver ad;
	HomePage hp;

	@Test(enabled=true)
	public void VerifyNewRFQImage() throws Exception {
		ad=new ActionDriver();
		Log.startTestCase("VerifyNewRFQImage");
		LoginWithSSO lg = new LoginWithSSO();
		lg.loginintoapplication();
		hp = new HomePage();
		hp.OpenNewRFQ();
		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.verificationByAssert(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/project");
		
		Log.endTestCase("VerifyNewRFQImage");
	}
	
	@Test(enabled=true)
	public void VerifyMyRFQImage() throws Exception {
		Log.startTestCase("VerifyMyRFQImage");
		LoginWithSSO lg = new LoginWithSSO();
		lg.loginintoapplication();
		hp = new HomePage();
		hp.OpenMyRFQ();
		ad = new ActionDriver();
		ad.getcurrenturl();
		Thread.sleep(10000);
		ad.verificationByAssert(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/my-project/list-rfqs");

		//Assert.assertEquals(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/my-project/list-rfqs");
		Log.endTestCase("VerifyMyRFQImage");
	}
	@Test(enabled=true)
	public void VerifyValidationImage() throws Exception {
		Log.startTestCase("VerifyValidationImage");
		LoginWithSSO lg = new LoginWithSSO();
		lg.loginintoapplication();
		hp = new HomePage();
		hp.OpenValidation();
		ad = new ActionDriver();
		ad.getcurrenturl();
		Thread.sleep(10000);
		ad.verificationByAssert(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/validation/my-pending");

		//Assert.assertEquals(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/validation/my-pending");
		Log.endTestCase("VerifyValidationImage");
	}
	@Test(enabled=true)
	public void VerifyBenchMarkPriceImage() throws Exception {
		Log.startTestCase("VerifyBenchMarkPriceImage");
		LoginWithSSO lg = new LoginWithSSO();
		lg.loginintoapplication();
		hp = new HomePage();
		hp.OpenBenchMarkPRice();
		ad = new ActionDriver();
		ad.getcurrenturl();
		Thread.sleep(10000);
		//Assert.assertEquals(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/mstr");
		ad.verificationByAssert(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/mstr");
		Log.endTestCase("VerifyBenchMarkPriceImage");
	}
	@Test(enabled=true)
	public void VerifyAdminImage() throws Exception {
		Log.startTestCase("VerifyAdminImage");
		LoginWithSSO lg = new LoginWithSSO();
		lg.loginintoapplication();
		hp = new HomePage();
		hp.OpenAdministration();
		ad = new ActionDriver();
		ad.getcurrenturl();
		Thread.sleep(10000);
		//Assert.assertEquals(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/administration");
		ad.verificationByAssert(ad.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/administration");
		Log.endTestCase("VerifyAdminImage");
	}
}
