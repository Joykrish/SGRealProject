package Com.SPB.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.PriceDashboard;
import Com.SPB.PageObjects.ProjectDashboard;
import Com.SPB.PageObjects.ProjectSimulation;

public class Simulation extends BrowserSettings {
	ActionDriver ad;
	@Test(enabled = true)
	public void verifyYearlyQuantity() throws Exception {
		ad=new ActionDriver();
		Log.startTestCase("verifyYearlyQuantity");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.yearlyQuatities();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readyearlyQuantities();
		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.yearlyQTV1F1 == CostDashboard.V1YearlyQTYF11) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Yearly quantity (pcs) for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Yearly quantity (pcs) for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Yearly quantity (pcs) for Version1 on Simulation Dashboard and Cost Dashboard is not  equal");
				BrowserSettings.parentTest.fail("FAIL:Yearly quantity (pcs) for Version1 on Simulation Dashboard and Cost Dashboard is not  equal");
			}
		}

		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.yearlyQTV2FF1 == CostDashboard.V2YearlyQTYF1111) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Yearly quantity (pcs) for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Yearly quantity (pcs) for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Yearly quantity (pcs) for Version2 on Simulation Dashboard and Cost Dashboard is not  equal");
				BrowserSettings.parentTest.fail("FAIL:Yearly quantity (pcs) for Version2 on Simulation Dashboard and Cost Dashboard is not  equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.yearlyQTV3FFF1 == CostDashboard.V3YearlyQTYF11112) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Yearly quantity (pcs) for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Yearly quantity (pcs) for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Yearly quantity (pcs) for Version3 on Simulation Dashboard and Cost Dashboard is not  equal");
				BrowserSettings.parentTest.fail("FAIL:Yearly quantity (pcs) for Version3 on Simulation Dashboard and Cost Dashboard is not  equal");
			}

		}
		Log.endTestCase("verifyYearlyQuantity");
	}

	@Test(enabled = true)
	public void verifyCommonSurface() throws Exception {
		Log.startTestCase("verifyCommonSurface");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(10000);
		sm.commonSurface();
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		PriceD.readCommonSurface();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.ComSurV1 == PriceDashboard.ComSurfaceV1PriceD) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Common Surface for Version1 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Common Surface for Version1 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Common Surface for Version1 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.parentTest.fail("FAIL:Common Surface for Version1 on Simulation Dashboard and Price Dashboard not equal");

			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.ComSurV2 == PriceDashboard.ComSurfaceV2PriceD) {
				

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Common Surface for Version2 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Common Surface for Version2 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Common Surface for Version2 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.parentTest.fail("FAIL:Common Surface for Version2 on Simulation Dashboard and Price Dashboard not equal");
			}
		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.ComSurV3 == PriceDashboard.ComSurfaceV3PriceD) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Common Surface for Version3 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:Common Surface for Version3 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Common Surface for Version3 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.parentTest.fail("FAIL:Common Surface for Version3 on Simulation Dashboard and Price Dashboard not equal");
			}
		}
		Log.endTestCase("verifyCommonSurface");
	}

	@Test(enabled = true)
	public void verifyPNV() throws Exception {
		Log.startTestCase("verifyPNV");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.pnv();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		cd.readPNVyear1();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.pnvVersion1 == CostDashboard.PNVY111V1111) {

				Assert.assertTrue(true);
				System.out.println("PASS:PNV for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:PNV for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:PNV for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:PNV for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.pnvVersion2 == CostDashboard.PNVY111V2222) {

				Assert.assertTrue(true);
				System.out.println("PASS:PNV for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:PNV for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				BrowserSettings.childTest.fail("FAIL:PNV for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				System.out.println("FAIL:PNV for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.pnvVersion3 == CostDashboard.PNVY111V3333) {

				Assert.assertTrue(true);
				System.out.println("PASS:PNV for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:PNV for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:PNV for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:PNV for Version3 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyPNV");
	}

	@Test(enabled = true)
	public void verifyQuotedPrice() throws Exception {
		Log.startTestCase("verifyQuotedPrice");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.QuotedPrice();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		cd.readQuatedPrice();
		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.QPV11 == CostDashboard.QuotedPriceV11) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Quoted PRice for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Quoted PRice for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out
						.println("FAIL:Quoted PRice for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Quoted PRice for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.QPV22 == CostDashboard.QuotedPriceV22) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Quoted PRice for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Quoted PRice for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out
						.println("FAIL:Quoted PRice for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.pass("FAIL:Quoted PRice for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.QPV33 == CostDashboard.QuotedPriceV33) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Quoted PRice for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Quoted PRice for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Quoted PRice for Version3s on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Quoted PRice for Version3s on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyQuotedPrice");
	}

	@Test(enabled =true)
	public void verifyAddedValue() throws Exception {
		Log.startTestCase("verifyAddedValue");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.addedValue();

		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openPriceDashboard();
		Thread.sleep(10000);
		PriceD.readAddedValue();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.AVV1.equals(PriceDashboard.AddedValueV1)) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Added Value for Version1 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Added Value for Version1 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out
						.println("FAIL:Added Value for Version1 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Added Value for Version1 on Simulation Dashboard and Price Dashboard not equal");
			}
		}

		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.AVV2.equals(PriceDashboard.AddedValueV2)) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Added Value for Version2 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Added Value for Version2 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out
						.println("FAIL:Added Value for Version2 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Added Value for Version2 on Simulation Dashboard and Price Dashboard not equal");
			}
		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.AVV3.equals(PriceDashboard.AddedValueV3)) {

				Assert.assertTrue(true);
				System.out
						.println("PASS:Added Value for Version3 on Simulation Dashboard and Price Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Added Value for Version3 on Simulation Dashboard and Price Dashboard is equal");
			} else {
				System.out
						.println("FAIL:Added Value for Version3 on Simulation Dashboard and Price Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Added Value for Version3 on Simulation Dashboard and Price Dashboard not equal");
			}
		}
		Log.endTestCase("verifyAddedValue");
	}

	@Test(enabled = true)
	public void verifyTotalCost() throws Exception {
		Log.startTestCase("verifyTotalCost");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);
		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.totalCost();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(10000);
		cd.readTotalCost();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.TCV1.equals(CostDashboard.TotalCostV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Total Cost for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Total Cost for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Total Cost for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Total Cost for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.TCV2.equals(CostDashboard.TotalCostV2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Total Cost for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Total Cost for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Total Cost for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Total Cost for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.TCV3.equals(CostDashboard.TotalCostV3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Total Cost for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Total Cost for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Total Cost for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Total Cost for Version3 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyTotalCost");
	}

	@Test(enabled = true)

	public void verifyExternalMarkup() throws Exception {
		Log.startTestCase("verifyExternalMarkup");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		sm.ExternalMark();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readExternalMarkup();
		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.EMCV1.equals(CostDashboard.ExtendedMarginV1)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Extended Margin for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Extended Margin for Version1 on Simulation Dashboard and Cost Dashboard is equal");

			} else {
				System.out.println(
						"FAIL:Extended Margin for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Extended Margin for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.EMCV2.equals(CostDashboard.ExtendedMarginV2)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Extended Margin for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Extended Margin for Version2 on Simulation Dashboard and Cost Dashboard is equal");

			} else {
				BrowserSettings.childTest.fail("FAIL:Extended Margin for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				System.out.println(
						"FAIL:Extended Margin for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.EMCV3.equals(CostDashboard.ExtendedMarginV3)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:Extended Margin for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Extended Margin for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:Extended Margin for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Extended Margin for Version3 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyExternalMarkup");
	}

	@Test(enabled = true)
	public void externalMarkupyears() throws Exception {
		Log.startTestCase("externalMarkupyears");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		PriceDashboard PriceD = PageFactory.initElements(driver, PriceDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		sm.ExternalMarkupYear();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readExternalMarkUpYears();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.EMYV1.equals(CostDashboard.exMarkUP)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:External MarkupYear for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:External MarkupYear for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:External MarkupYear on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:External MarkupYear on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("externalMarkupyears");
	}

	@Test(enabled = true)
	public void verifyMVCPercent() throws Exception {
		Log.startTestCase("verifyMVCPercent");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.MVCpercent();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readMVCPercent();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.MVCV1.equals(CostDashboard.MVCV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:MVC for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:MVC for Version1 on Simulation Dashboard and Cost Dashboard is equall");
			} else {
				System.out.println("FAIL:MVC for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:MVC for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.MVCV2.equals(CostDashboard.MVCV2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:MVC for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:MVC for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:MVC for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:MVC for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.MVCV3.equals(CostDashboard.MVCV3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:MVC for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:MVC for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:MVC for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:MVC for Version3 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyMVCPercent");
	}

	@Test(enabled = true)
	public void verifyRBCPercent() throws Exception {
		Log.startTestCase("verifyRBCPercent");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.RBCpercent();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readRBCPercent();
		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.RBCV1.equals(CostDashboard.RBCV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBC for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:RBC for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:RBC for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:RBC for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.RBCV2.equals(CostDashboard.RBCV2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBC for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:RBC for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:RBC for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:RBC for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.RBCV3.equals(CostDashboard.RBCV3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBC for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:RBC for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:RBC for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:RBC for Version3 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		Log.endTestCase("verifyRBCPercent");
	}

	@Test(enabled = true)
	public void EM5Years() throws Exception {
		Log.startTestCase("EM5Years");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(20000);
		sm.EM5years();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readEM5year();
		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.EM5V1.equals(CostDashboard.EMV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:EM for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:EM for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:EM for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:EM for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.EM5V2.equals(CostDashboard.EMV2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:EM for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:EM for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:EM for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:EM for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.EM5V3.equals(CostDashboard.EMV3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:EM for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:EM for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:EM for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:EM for Version3 on Simulation Dashboard and Cost Dashboard not equal");

			}
			Log.endTestCase("EM5Years");
		}

	}

	@Test(enabled = true)
	public void verifyDevCost() throws Exception {
		Log.startTestCase("verifyDevCost");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(10000);
		sm.devCost();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readDevCost();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.DevCostV11.equals(CostDashboard.DevCostV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Dev Cost for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Dev Cost for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Dev Cost for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Dev Cost for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			if (ProjectSimulation.DevCostV22.equals(CostDashboard.DevCostV2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Dev Cost for Version2 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Dev Cost for Version2 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Dev Cost for Version2 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Dev Cost for Version2 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			if (ProjectSimulation.DevCostV33.equals(CostDashboard.DevCostV3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Dev Cost for Version3 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Dev Cost for Version3 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Dev Cost for Version3 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Dev Cost for Version3 on Simulation Dashboard and Cost Dashboard not equal");

			}
		}
		Log.endTestCase("verifyDevCost");
	}

	@Test(enabled = true)
	public void verifyDevrev() throws Exception {
		Log.startTestCase("verifyDevrev");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(10000);
		sm.devRevenue();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readDevRevenue();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.DevRevenueV11.equals(CostDashboard.DevRevenueV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:Devrev for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:Devrev for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:Devrev for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:Devrev for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}

		Log.endTestCase("verifyDevrev");
	}

	@Test(enabled = true)
	public void VerifyPBR() throws Exception {
		Log.startTestCase("VerifyPBR");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);

		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		hm.searchProject("other");
		pd.selectscenario();

		Thread.sleep(10000);

		sm.openSimulationDashboard();
		Thread.sleep(10000);
		sm.PBR();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);
		pd.selectscenario();
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.openCostDashboard();
		Thread.sleep(20000);
		cd.readPBR();

		if (!ProjectSimulation.Version1.equals("NA")) {
			if (ProjectSimulation.PBRV11.equals(CostDashboard.PBRV1)) {

				Assert.assertTrue(true);
				System.out.println("PASS:PBR for Version1 on Simulation Dashboard and Cost Dashboard is equal");
				BrowserSettings.childTest.pass("PASS:PBR for Version1 on Simulation Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println("FAIL:PBR for Version1 on Simulation Dashboard and Cost Dashboard not equal");
				BrowserSettings.childTest.fail("FAIL:PBR for Version1 on Simulation Dashboard and Cost Dashboard not equal");
			}
		}

		Log.endTestCase("VerifyPBR");
	}

}