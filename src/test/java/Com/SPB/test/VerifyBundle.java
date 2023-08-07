
package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.BundleOperations;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyBundle extends BrowserSettings {
	ActionDriver ad;

	// To open Bundle List page (its working)
	@Test(enabled = true) // ( its working)
	public void openbundlelistVerify() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("OPenBundlelist");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		Log.endTestCase("OPenBundlelist");
	}

	// Verify the bundle list page ( its working)
	@Test(enabled = true)
	public void BundlelistVerify() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		bl.verifyBundlelistpage();
		String BList = bl.GetmyBundlelistpage();
		System.out.println(BList);
		Log.info("Sucessfully captured  and printed the my bundle list text");

		String mybundlelist = bl.GetmyBundlelistpage();
		ad.verificationByAssert(BList, mybundlelist);
		/*
		 * if (BList.contains(bl.mybundlelist)) {
		 * System.out.println("PASS::Redirected to the Bundle list page Successfully");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully redirected to Selected Bundle List page"); } else {
		 * Assert.assertTrue(false); System.out.
		 * println(" FAIL::not Redirected to the Bundle list page Successfully");
		 * Log.info("File to  redirected to Selected  Bundle List page"); }
		 */
		Log.endTestCase("My Bundle list");
	}

	// Verify for the Bundle Creation (its working)
	@Test(enabled = true)
	public void BundleCreation() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		Thread.sleep(3000);
		bl.MyBundle();
		Thread.sleep(3000);
		bl.CreateBundle();
		String cb = bl.GetAddedBundleText();
		Log.info("Sucessfully captured Added Bundle text");
		System.out.println(cb);
		ad.verificationByAssert(cb, "Bundle added successfully");
		/*
		 * if (cb.contains("Bundle added successfully")) {
		 * System.out.println("PASS:: Added Bundle Successfully");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully redirected to added Bundle Confirmation screen"); }
		 * else { Assert.assertTrue(false);
		 * System.out.println(" FAIL::not added Bundle page Successfullyy");
		 * Log.info("File to  redirected to added Bundle Confirmation screen"); }
		 */
		Log.endTestCase("AddedBundle");

		Log.endTestCase("End of bundle creation");
	}

	// Verify open button functionality (its working)
	@Test(enabled = true) // ( its working)
	public void OpenBundle() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		Thread.sleep(10000);
		bl.openBuble();
		// bl.clickBundleoneAction();
		Thread.sleep(10000);
		String sb = bl.GetSelectedBundleName();
		Log.info("Sucessfully captured the  Selected Bundle");
		System.out.println(sb);
		//ad.verificationByAssert(sb, BundleOperations.BundleName);
		/*
		 * if (sb.contains(BundleOperations.BundleName)) //
		 * if(dl.equals("Confirm Deletion")) {
		 * System.out.println("PASS::Redirected to the Bundle page Successfully");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully redirected to Selected Bundle Dashboard"); } else {
		 * Assert.assertTrue(false); System.out.
		 * println(" FAIL::not Redirected to the Bundle Dashboard Successfully");
		 * Log.info("File to  redirected to Selected Bundle Dashboard"); }
		 */
		Log.endTestCase("Verify open bundle");
	}

	// Verify the Edit action button functionality (its working)

	@Test(enabled = true)
	public void BundleActionEdit() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		bl.BundlectionEdit();
		Thread.sleep(1000);

		String ub = bl.GetBundleUpdateText();
		Log.info("Sucessfully captured Edit page text");

		System.out.println(ub);
		ad.verificationByAssert(ub, "Bundle Updated successfully");

		/*
		 * if (ub.contains("Bundle Updated successfully")) {
		 * System.out.println("PASS::Redirected to the Edit Bundle page Successfully");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully redirected to Selected Bundle Dashboard"); } else {
		 * Assert.assertTrue(false); System.out.
		 * println(" FAIL::not Redirected to the Edit Bundle screen Successfully");
		 * Log.info("File to  redirected to Edit Bundle screens"); }
		 */
		Log.endTestCase("EditBundle");
		Thread.sleep(10000);
	}

	@Test(enabled = true)
	public void VerifyselectScenario() throws Exception {
		ad = new ActionDriver();

		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		Thread.sleep(10000);
		bl.openBuble();
		bl.selectScenarios();
	}

//Verify scenarios (its working)
	@Test(enabled = true)
	public void VerifyscenariosSelect() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		bl.openBuble();
		bl.verifyscenarios();
	}

	// Verify the Delete action button functionality (its working)
	@Test(enabled = true)
	public void BundleActionDelete() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("loginVerification");
		LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		HomePage hm = new HomePage();
		hm.OpenMyRFQ();
		Thread.sleep(3000);
		BundleOperations bl = PageFactory.initElements(driver, BundleOperations.class);
		bl.MyBundle();
		bl.BundlectionDelete();
		String db = bl.GetDeleteBundlePage();
		Log.info("Sucessfully captured delete page text");
		System.out.println(db);
		//ad.verificationByAssert(db, "Bundle Deleted");
		// if(db.contains("Confirm your deletion"))
		/*
		 * if (db.contains("Bundle Deleted")) {
		 * System.out.println("PASS:: Deleted Bundle page Successfully");
		 * Assert.assertTrue(true);
		 * Log.info("Sucessfully redirected to Delete Bundle Confirmation screen"); }
		 * else { Assert.assertTrue(false);
		 * System.out.println(" FAIL::not Deleted Bundle page Successfullyy");
		 * Log.info("File to  redirected to Delete Bundle Confirmation screen"); }
		 */
		Log.endTestCase("DeleteBundle");

	}

}
