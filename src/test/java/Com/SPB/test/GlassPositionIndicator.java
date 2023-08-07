package Com.SPB.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.ProjectDashboard;

public class GlassPositionIndicator extends BrowserSettings {
	@Test
	
//Verify the GlassPosition indicators are displaying same/correct in the cost dashboard or not 
	//test data=Row=2,22,26
	public void verifyGlassPositionIndicators() throws Exception {
		Log.startTestCase("verifyGlassPositionIndicators");

		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		hp.searchProject("other");
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.readGlassPositionIndicators();
		Thread.sleep(10000);
		gd.openCostDashboard();
		String projectname=gd.readprojectname();
		
		
	//	gd.ifexistNoVesrion();
	//	gd.openCostDashboard();
	

		cd.readPNVAvergeGPCostDashboard();
		cd.readMVCAvergeGPCostDashboard();
		cd.readRBCAvergeGPCostDashboard();
		cd.readEMAvergeGPCostDashboard();
		cd.readPBRAvergeGPCostDashboard();
		
		
		boolean res1 = ProjectDashboard.PNVY1num.equals(CostDashboard.pnvOnCostGP);
		if (res1 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:PNV value on GP Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:PNV value on GP Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:PNV value on GP Dashboard and Cost Dashboard is not equal");
			BrowserSettings.childTest.fail("FAIL:PNV value on GP Dashboard and Cost Dashboard is equal");
			// softAssertion.assertTrue(false);

	}
		boolean res2 = ProjectDashboard.MVC1.equals(CostDashboard.mvcOnCostGP);
		if (res2 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:MVC value on GP Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:MVC value on GP Dashboard and Cost Dashboard is equal");
		} else {
			BrowserSettings.childTest.fail("FAIL:MVC value on GP Dashboard and Cost Dashboard is not equal");
			System.out.println("FAIL:MVC value on GP Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);
	}
		boolean res3 = ProjectDashboard.RBCY1.equals(CostDashboard.rbcOnCostGP);
		if (res3 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:RBC value on GP Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:RBC value on GP Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:RBC value on GP Dashboard and Cost Dashboard is not equal");
			BrowserSettings.childTest.fail("FAIL:RBC value on GP Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		boolean res4 = ProjectDashboard.em.equals(CostDashboard.emOnCostGP);
		if (res4 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:EM value on GP Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:EM value on GP Dashboard and Cost Dashboard is equal");
		} else {
			BrowserSettings.childTest.fail("FAIL:EM value on GP Dashboard and Cost Dashboard is not equal");
			System.out.println("FAIL:EM value on GP Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		boolean res5 = ProjectDashboard.pbr.equals(CostDashboard.pbrOnCostGP);
		if (res5 == true) {
			Assert.assertTrue(true);
			System.out.println("PASS:PBR value on GP Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:PBR value on GP Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:PBR value on GP Dashboard and Cost Dashboard is not equal");
			BrowserSettings.childTest.fail("FAIL:PBR value on GP Dashboard and Cost Dashboard is not equal");
			// Assert.assertTrue(false);

		}
		Log.endTestCase("verifyGlassPositionIndicators");
}
}