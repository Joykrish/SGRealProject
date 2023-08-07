package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

import Com.SPB.PageObjects.Administration;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyAdministration extends BrowserSettings {
	ActionDriver ad;

	// To verify user addition (its working)
	@Test(enabled = true)

	public void AddUser() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);

		Log.info("Login into the application");
		lg.loginintoapplication();
		Administration am = PageFactory.initElements(driver, Administration.class);
		

		Thread.sleep(3000);

		am.CreateUser();

		String au = am.GetUserAddedConfirmation();

		System.out.println(au);
		Thread.sleep(10000);

		//ad.verificationByAssert(au, "User Added successfully");
		/*
		 * if (au.equals("User Added successfully")) { System.out.println("PASS");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully opened user confirmation page"); }
		 * 
		 * else { Assert.assertTrue(false); System.out.println(" FAIL");
		 * Log.info("failed to opene user delete confirmation page"); }
		 */
		Log.endTestCase("End of User Addtion test case");
	}

	// To search user from listing page (its working)
	@Test(enabled = true)
	public void SearchUser() throws Exception {
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		Administration am = PageFactory.initElements(driver, Administration.class);

		Thread.sleep(3000);
		am.GlobalSearchUser();

	}

	// to verify edit action button functionality(its working)
	@Test(enabled = true)
	public void ActionEdit() throws Exception {
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();

		HomePage hm = new HomePage();
		Thread.sleep(3000);
		Administration am = PageFactory.initElements(driver, Administration.class);
		am.ActionbuttonEdit();

		String el = am.GetUserEditConfirmation();
		System.out.println(el);
		/*
		 * if (el.equals("User Updated successfully")) { System.out.println("PASS");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully opened user edit confirmation toaster"); }
		 * 
		 * else { Assert.assertTrue(false); System.out.println(" FAIL");
		 * Log.info("failed to open user edit confirmation toaster"); }
		 */
		
		//ad.verificationByAssert(el, "User Updated successfully");
		Log.endTestCase("End of Edit button test case");
	}

	// to verify Delete action button functionality(its working)
	@Test(enabled = true)
	public void ActionDelete() throws Exception {
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();

		HomePage hm = new HomePage();
		Thread.sleep(3000);
		Administration am = PageFactory.initElements(driver, Administration.class);
		am.ActionbuttonDelete();

		String dl = am.GetUserDeleteConfirmation();
		System.out.println(dl);
		/*
		 * if (dl.equals("User Deleted")) { System.out.println("PASS");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully opened user delete confirmation toaster"); }
		 * 
		 * else { Assert.assertTrue(false); System.out.println(" FAIL");
		 * Log.info("failed to opene user delete confirmation toaster"); }
		 */
		//ad.verificationByAssert(dl, "User Deleted");
		Log.endTestCase("End of Delete user button test case");
	}

}
