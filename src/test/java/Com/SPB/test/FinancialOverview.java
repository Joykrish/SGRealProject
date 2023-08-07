package Com.SPB.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.FinancialDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.PriceDashboard;
import Com.SPB.PageObjects.ProjectDashboard;
import Com.SPB.PageObjects.ProjectSimulation;

public class FinancialOverview extends BrowserSettings {
	ActionDriver ad;
	// Test Data :2,22,26

	@Test(enabled = true)

	public void verifyPricePce() throws Exception {
		ad = new ActionDriver();
		Log.startTestCase("verifyPricePce");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.readPricepce();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		Thread.sleep(10000);
		Prd.readQuatedPricePce();
		
			if (FinancialDashboard.PricePce.equals(PriceDashboard.quotedPricePCE)) {

				Assert.assertTrue(true);
				System.out.println("PASS:QuotedPrice(pce) on  Financial Dashboard and Price Dashboard is equal");
				BrowserSettings.parentTest
						.pass("PASS:QuotedPrice(pce) Financial Dashboard and Price Dashboard is equal");
			}
			else {
				Assert.assertTrue(false);
			BrowserSettings.parentTest
					.fail("FAIL:QuotedPrice(pce) Financial Dashboard and Price Dashboard is not equal");
		
			
			// TODO: handle exception
		}

		Log.endTestCase("verifyPricePce");
	}

	@Test(enabled = true)

	public void verifyVolume() throws Exception {
		Log.startTestCase("verifyVolume");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.readQuantity();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		Thread.sleep(10000);
		Prd.readValume();

		if (FinancialDashboard.Quantity1.equals(PriceDashboard.Valume)) {
			Assert.assertTrue(true);
			System.out.println("PASS:Quantity Financial Dashboard and Price Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:Quantity Financial Dashboard and Price Dashboard is equal");

		} else {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("FAIL:Quantity Financial Dashboard and Price Dashboard is not equal");

		}
		Log.endTestCase("verifyVolume");
	}

	@Test(enabled = true)
	public void verifyAddedValue() throws Exception {
		Log.startTestCase("verifyAddedValue");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.AddedValue();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		Thread.sleep(10000);
		Prd.readAddedValue1();

		if (FinancialDashboard.AddedValue.equals(PriceDashboard.AddedValue)) {

			Assert.assertTrue(true);
			System.out.println("PASS:Added Value Financial Dashboard and Price Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:Added Value Financial Dashboard and Price Dashboard is equal");
		} else {
			BrowserSettings.parentTest.fail("FAIL:Added Value  Financial Dashboard and Price Dashboard is not equal");
			System.out.println("FAIL:Added Value  Financial Dashboard and Price Dashboard is not equal");
		}

		Log.endTestCase("verifyAddedValue");
	}

	@Test(enabled = true)
	public void verifyY1() throws Exception {
		Log.startTestCase("verifyY1");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.Y1();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(30000);
		cd.readPNVY1K();

		if (FinancialDashboard.y1.equals(CostDashboard.PNVY1K)) {

			Assert.assertTrue(true);
			System.out.println("PASS:Y1 Value Financial Dashboard and Price Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:Y1 Value Financial Dashboard and Price Dashboard is equal");
		} else {
			System.out.println("FAIL:Y1 Value  Financial Dashboard and Price Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:Y1 Value Financial Dashboard and Price Dashboard is equal");
		}
		Log.endTestCase("verifyY1");
	}

	@Test(enabled = true)
	public void VerifyProjectMVC() throws Exception {
		Log.startTestCase("VerifyProjectMVC");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.ProjectMVC();
		driver.navigate().back();
		pd.readMVCY1();

		if (FinancialDashboard.ProjectMVCper.equals(ProjectDashboard.MVC1)) {

			Assert.assertTrue(true);
			System.out.println("PASS:MVC Project Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:MVC Project Value Financial Dashboard and Project Dashboard is equal");
		} else {
			System.out.println("FAIL:MVC Project Value Financial Dashboard and Project Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:MVC Project Value Financial Dashboard and Project Dashboard is not equal");
		}

		Log.endTestCase("VerifyProjectMVC");
	}

	@Test(enabled = true)
	public void verifyMVCGPNonPercentage() throws Exception {
		Log.startTestCase("verifyMVCGPNonPercentage");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.MVCGP();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readMarginVarCost();

		if (FinancialDashboard.GPMVCnoper.equals(CostDashboard.MarginVarcost)) {

			Assert.assertTrue(true);
			System.out.println("PASS:MVC GP non percentage Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:MVC GP non percentage Value Financial Dashboard and Project Dashboard is equal");
		} else {
			Assert.assertTrue(false);
			System.out
					.println("FAIL:MVC GP non percentage Value Financial Dashboard and Project Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:MVC GP non percentage Value Financial Dashboard and Project Dashboard is not equal");
		}
		Log.endTestCase("verifyMVCGPNonPercentage");
	}

	@Test(enabled = true)
	public void VerifyProjectRBC() throws Exception {
		Log.startTestCase("VerifyProjectRBC");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.ProjectRBC();
		driver.navigate().back();
		pd.readRBCY1();
		if (FinancialDashboard.RBCnoper.equals(ProjectDashboard.RBCY1)) {

			Assert.assertTrue(true);
			System.out.println("PASS:RBC Project Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:RBC Project Value Financial Dashboard and Project Dashboard is equal");
			
		} else {
			System.out.println("FAIL:RBC Project Value Financial Dashboard and Project Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:RBC Project Value Financial Dashboard and Project Dashboard is not equal");
		}
		Log.endTestCase("VerifyProjectRBC");
	}

	@Test(enabled = true)
	public void verifyRBCGPNonPercentage() throws Exception {
		Log.startTestCase("verifyRBCGPNonPercentage");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.RBCGP();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readRBCNonpercent();

		if (FinancialDashboard.GPEBCnoper.equals(CostDashboard.RBCNP)) {

			Assert.assertTrue(true);
			System.out.println("PASS:RBC GP non percent Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.parentTest.pass("PASS:RBC GP non percent Value Financial Dashboard and Project Dashboard is equal");
		} else {
			System.out.println("FAIL:RBC GP non percent Value Financial Dashboard and Project Dashboard is not equal");
			BrowserSettings.parentTest.fail("FAIL:RBC GP non percent Value Financial Dashboard and Project Dashboard is not equal");
		}

		Log.endTestCase("verifyRBCGPNonPercentage");
	}

	@Test(enabled = true)
	public void verifyRBEGPNonPercentage() throws Exception {
		Log.startTestCase("verifyRBEGPNonPercentage");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.RBEGP();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readRBENonpercent();

		if (FinancialDashboard.GPRBEnoper.equals(CostDashboard.RBENP)) {

			Assert.assertTrue(true);
			System.out.println("PASS:RBE GP non percent Value Financial Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:RBE GP non percent Value Financial Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:RBE GP non percent Value Financial Dashboard and Cost Dashboard is not equal");
			BrowserSettings.childTest.fail("FAIL:RBE GP non percent Value Financial Dashboard and Cost Dashboard is not equal");
		}

		
		Log.endTestCase("verifyRBEGPNonPercentage");
	}

	@Test(enabled = true)
	public void VerifyProjectEM() throws Exception {
		Log.startTestCase("VerifyProjectEM");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.ProjectEM();
		driver.navigate().back();
		pd.readEM();
		if (FinancialDashboard.ProjectEMper.equals(ProjectDashboard.em)) {

			Assert.assertTrue(true);
			System.out.println("PASS:EM  Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:EM  Value Financial Dashboard and Project Dashboard is equal");
		} else {
			System.out.println("FAIL:EM  Value Financial Dashboard and Project Dashboard is equal");
			BrowserSettings.childTest.fail("FAIL:EM  Value Financial Dashboard and Project Dashboard is equal");
		}
		Log.endTestCase("VerifyProjectEM");
	}

@Test(enabled = true)
	public void verifyEMGPNonPercentage() throws Exception {
		Log.startTestCase("verifyEMGPNonPercentage");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard Prd = PageFactory.initElements(driver, PriceDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();
		Thread.sleep(10000);
		fd.openFinancialDashboard("FinancialOverview");
		Thread.sleep(10000);
		fd.EMGP();
		driver.navigate().back();
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readEMNonpercent();

		if (FinancialDashboard.GPEMCnoper.equals(CostDashboard.EMNP)) {

			Assert.assertTrue(true);
			System.out.println("PASS:EM GP non percent Value Financial Dashboard and Cost Dashboard is equal");
			BrowserSettings.childTest.pass("PASS:EM GP non percent Value Financial Dashboard and Cost Dashboard is equal");
		} else {
			System.out.println("FAIL:EM GP non percent Value Financial Dashboard and Cost Dashboard is not equal");
			BrowserSettings.childTest.fail("FAIL:EM GP non percent Value Financial Dashboard and Cost Dashboard is not equal");
		}
		Log.endTestCase("verifyEMGPNonPercentage");
	}

}
