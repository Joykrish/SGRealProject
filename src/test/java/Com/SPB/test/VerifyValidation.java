package Com.SPB.test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyRFQ;
import Com.SPB.PageObjects.ProjectDashboard;
import Com.SPB.PageObjects.validation;

public class VerifyValidation extends BrowserSettings {
	 @Test(enabled=true)
	public void verifyOpenButtonMyPending() throws Exception {
		Log.startTestCase("verifyOpenButtonMyPending");
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		lg.loginintoapplication();
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.OpenValidation();
		validation vl = PageFactory.initElements(driver, validation.class);
		Thread.sleep(10000);
		vl.searchProjectGlobal();
		Thread.sleep(1000);
		vl.clickOpenButton();
		Thread.sleep(10000);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		System.out.println(pd.GetSelectedProjectName());
		if (pd.GetSelectedProjectName().contains(validation.vaDevcode)) {
			Assert.assertTrue(true);
			System.out.println("Open button working properly");
			 BrowserSettings.parentTest.pass("Open button working properly");

		} else {
			Assert.assertTrue(false);
			System.out.println("Open button not working properly");
			 BrowserSettings.parentTest.fail("Open button not working properly");

		}
	}

	@Test(enabled = true)
	public void verifyOpenButtonAllProject() throws Exception {
		Log.startTestCase("verifyOpenButtonMyPending");
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		lg.loginintoapplication();
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.OpenValidation();
		Thread.sleep(10000);

		validation vl = PageFactory.initElements(driver, validation.class);
		vl.openMyProjects();
		Thread.sleep(10000);
		vl.searchProjectGlobal();
		Thread.sleep(10000);
		vl.clickOpenButton();
		Thread.sleep(10000);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		System.out.println(pd.GetSelectedProjectName());
		if (pd.GetSelectedProjectName().contains(validation.vaDevcode)) {
			Assert.assertTrue(true);
			System.out.println("Open button working properly");
			BrowserSettings.parentTest.pass("Open button working properly");
		} else {
			Assert.assertTrue(false);
			System.out.println("Open button not working properly");
			 BrowserSettings.parentTest.fail("Open button not working properly");
		}
	}

}
