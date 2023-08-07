package Com.SPB.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;

public class VeirfyLogin extends BrowserSettings {
	ActionDriver ad;

	@Test
	// This test is to verify whether user has logged-in into the X-Calc or not
	public void VerifyLogin() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		Log.info("capture the X-calc logo on the homepage");
		String logoone = hm.GetXcalclogo();
		System.out.println(logoone);
		Log.info("Check whether logo is correct or not ");
		ad.verificationByAssert(logoone, "X-Calc");

		Log.info("successfully checked for the logo and user has logged in successfully");
		Log.endTestCase("loginVerification");
	

	}

}
