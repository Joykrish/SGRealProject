package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.ProjectDashboard;

public class ProjectIndicator extends BrowserSettings {
	@Test
	
	//Verify the project indicators are displaying same/correct in the cost dashboard or not 
	//Test data Row=2,22,26
	public void VerifyProjectIndicator() throws Exception {
		// SoftAssert softAssertion=new SoftAssert();
		Log.startTestCase("VerifyProjectIndicator");

		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		hp.searchProject("other");
		Thread.sleep(10000);
		pd.selectscenario();

		Thread.sleep(10000);
		pd.readPNVY1();
		pd.readMVCY1();
		pd.readRBCY1();
		pd.readEM();
		pd.readPBR();

		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readPNVAverageProjectCostDashboard();
		cd.readMVCAverageProjectCostDashboard();
		cd.readRBCAverageProjectCostDashboard();
		cd.readEMAverageProjectCostDashboard();
		cd.readPBRAverageProjectCostDashboard();

		boolean res1 = ProjectDashboard.PNVY1num.equals(CostDashboard.pnvOnCost);
		if (res1 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:PNV value on Project Dashboard and Cost Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:PNV value on Project Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:PNV value on Project Dashboard and Cost Dashboard is not equal");
			BrowserSettings.parentTest.pass("FAIL:PNV value on Project Dashboard and Cost Dashboard is not equal");
			// softAssertion.assertTrue(false);

		}
		boolean res2 = ProjectDashboard.MVC1.equals(CostDashboard.mvcOnCost);
		if (res2 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:MVC value on Project Dashboard and Cost Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:MVC value on Project Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:MVC value on Project Dashboard and Cost Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:MVC value on Project Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		boolean res3 = ProjectDashboard.RBCY1.equals(CostDashboard.rbcOnCost);
		if (res3 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:RBC value on Project Dashboard and Cost Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:RBC value on Project Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:RBC value on Project Dashboard and Cost Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:RBC value on Project Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		boolean res4 = ProjectDashboard.em.equals(CostDashboard.emOnCost);
		if (res4 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:EM value on Project Dashboard and Cost Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:EM value on Project Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:EM value on Project Dashboard and Cost Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:EM value on Project Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		boolean res5 = ProjectDashboard.pbr.equals(CostDashboard.pbrOnCost);
		if (res5 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:PBR value on Project Dashboard and Cost Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:PBR value on Project Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:PBR value on Project Dashboard and Cost Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:PBR value on Project Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		Log.endTestCase("VerifyProjectIndicator");
	}
}
