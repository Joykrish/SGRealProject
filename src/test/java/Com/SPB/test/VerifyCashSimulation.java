package Com.SPB.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CashSimulation;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.FinancialDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyRFQ;
import Com.SPB.PageObjects.ProjectDashboard;
import Com.SPB.PageObjects.ProjectSimulation;

public class VerifyCashSimulation extends BrowserSettings {
@Test(enabled = true)
	public void verifyCashSimulationRedirection() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		
		Thread.sleep(10000);
		cs.OpenCashsimulation();

		Thread.sleep(10000);
		String ULR = ad.getcurrenturl();
		System.out.println(ULR);
		if (ULR.contains("https://dev-xcalc.sekurit.saint-gobain.com/cash-flow/")) {
			BrowserSettings.parentTest.pass("PASS:Redirected to Cash flow Dashboard Successfully");
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
			BrowserSettings.parentTest.fail("FAIL:Unable to Redirect to Cash flow Dashboard Successfully");
		}

	}

	@Test(enabled = true)
	public void verifyFinancialfollowupRedirection() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.ClickFinancialOverview();
		Thread.sleep(10000);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		String menu = fd.readMenu();
		System.out.println(menu);

		if (menu.contains("Financial Overview")) {
			System.out.println("Test is passed ");
			BrowserSettings.parentTest.pass("PASS:Redirected to Financial Dashboard Successfully");

		} else {
			System.out.println("FAIL:Redirected to Financial Dashboard Successfully");
		}

	}

	@Test(enabled = true)
	public void verifyPandLCarproduction() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		//hp.searchProject("Cashflow");
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		CashSimulation cs1 = PageFactory.initElements(driver, CashSimulation.class);
		String var = cs1.readCarProductionProfitandloss();
		System.out.println("Car production value on cost dashboard is " + var);
		BrowserSettings.parentTest.info("Car production value on cost dashboard is " + var);

		driver.navigate().back();

		ProjectDashboard PD = PageFactory.initElements(driver, ProjectDashboard.class);
		PD.readCarProduction();
		if (var.equals(PD.CP)) {
			BrowserSettings.parentTest
					.pass("PASS:Car Production Value on cash dashboard and project dashboard is same");
			System.out.println("PASS:Car Production Value on cash dashboard and project dashboard is same");

		} else {
			BrowserSettings.parentTest
					.fail("PASS:Car Production Value on cash dashboard and project dashboard is not same");
			System.out.println("FAIL:Car Production Value on cash dashboard and project dashboard is not same");
		}

	}

	@Test(enabled = true)
	public void verifyQuantityPandL() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		//hp.searchProject("Cashflow");
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readQuantityPandL();
		//driver.navigate().back();
		Thread.sleep(10000);
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		fd.readQuantityforcashflow();
		System.out.println(cs.QuantityPandLone + "and" + fd.Quantity1);

		if (!cs.GPone.equals("NA")) {
			if (cs.QuantityPandLone.equals(fd.Quantity1)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuantityPandL for Glass position 1 on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuantityPandL for Glass position 1 on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuantityPandL for Glass position 1 on Cashflow Dashboard and Financial Dashboard is not equal");
				BrowserSettings.parentTest.fail(
						"FAIL:QuantityPandL for Glass position 1 on Cashflow Dashboard and Financial Dashboard is not  equal");
			}
		}

		if (!cs.GPtwo.equals("NA")) {
			if (cs.QuantityPandLtwo.equals(fd.Quantity2)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is not equal");
				BrowserSettings.parentTest.fail(
						"FAIL:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is not  equal");
			}
		}

		if (!cs.GPtwo.equals("NA")) {
			if (cs.QuantityPandLthree.equals(fd.Quantity3)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuantityPandL for Glass position 3 on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuantityPandL for Glass position 3 on Cashflow Dashboard and Financial Dashboard is not equal");
				BrowserSettings.parentTest.fail(
						"FAIL:QuantityPandL for Glass position 2 on Cashflow Dashboard and Financial Dashboard is not  equal");
			}
		}

	}

	@Test(enabled = true)
	public void verifytakerate() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readtakerate();
		driver.navigate().back();
		pd.selectGlassPosition("verifytakerate-cashflow");
		Thread.sleep(10000);
		String takerate = gd.readtakerate();
		System.out.println("take rate for glass position is " + takerate);
		BrowserSettings.parentTest.info("take rate for glass position is " + takerate);
		if (takerate.contains(cs.takerateone)) {
			System.out.println("PASS:Take rate on Cashflow Dashboard and Glass Position is equal");
			BrowserSettings.parentTest.pass("PASS:Take rate on Cashflow Dashboard and Glass Position is equal");
		} else {
			System.out.println("FAIL:Take rate on Cashflow Dashboard and Glass Position is equal");
			BrowserSettings.parentTest.pass("FAIL:Take rate on Cashflow Dashboard and Glass Position is not equal");
		}

	}

@Test(enabled = true )
	public void verifyQuotedPrice() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readQuotedPriceold();

		driver.navigate().back();
		pd.selectGlassPosition("verifyQuotedPrice");

		if (!cs.GPone.equals("NA")) {

			if (cs.quotedPriceone.equals(pd.QuotedPriceGP1)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuotedPrice for Glass position 1 on Cashflow Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuotedPrice for " + cs.GPone + " on Cashflow Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuotedPrice for Glass position 1 on Cashflow Dashboard and Cost Dashboard is not equal");
				BrowserSettings.parentTest
						.fail("QuotedPrice for Glass position 1 on Cashflow Dashboard and Cost Dashboard is not equal");
			}
		}

		if (!cs.GPtwo.equals("NA")) {
			if (cs.quotedPricetwo.equals(pd.QuotedPriceGP2)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuotedPrice for Glass position 2 on Cashflow Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuotedPrice for Glass position 2 on Cashflow Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuotedPrice for Glass position 2 on Cashflow Dashboard and Cost Dashboard is not equal");
				BrowserSettings.parentTest
						.fail("QuotedPrice for Glass position 2 on Cashflow Dashboard and Cost Dashboard is not equal");
			}
		}

		if (!cs.GPthree.equals("NA")) {
			if (cs.quotedPricethree.equals(pd.QuotedPriceGP3)) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QuotedPrice for Glass position 3 on Cashflow Dashboard and Cost Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:QuotedPrice for Glass position 3 on Cashflow Dashboard and Cost Dashboard is equal");
			} else {
				System.out.println(
						"FAIL:QuotedPrice for Glass position 3 on Cashflow Dashboard and Cost Dashboard is not equal");
				BrowserSettings.parentTest
						.fail("QuotedPrice for Glass position 3 on Cashflow Dashboard and Cost Dashboard is not equal");
			}
		}

	}

	@Test(enabled = true)
	public void verifyRBEPERCENT() throws Exception {

		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readRBEPercent();
		Thread.sleep(10000);
		//driver.navigate().back();
		Thread.sleep(10000);
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		if (!cs.GPone.equals("NA")) {
			double RBEOne = fd.readRBEPercentage(cs.GPone);
			System.out.println(RBEOne);
			BrowserSettings.parentTest.info("RBEPercentage for " + cs.GPone + " on financial dashboard is " + RBEOne);

			if (cs.RBEPercentGPONE1 == RBEOne) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:RBEPercent for " + cs.GPone + " on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:RBEPercent for " + cs.GPone + " on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println("FAIL:RBEPercent for " + cs.GPone
						+ " on Cashflow Dashboard and Financial Dashboard is not  equal");
				BrowserSettings.parentTest.fail(
						"RBEPercent for " + cs.GPone + " on Cashflow Dashboard and Financial Dashboard is not equal");
			}
		}
		if (!cs.GPtwo.equals("NA")) {
			double RBEtwo = fd.readRBEPercentage(cs.GPtwo);
			System.out.println(RBEtwo);
			BrowserSettings.parentTest.info("RBEPercentage for " + cs.GPtwo + " on financial dashboard is " + RBEtwo);

			if (cs.RBEPercentGPTWO2 == RBEtwo) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:RBEPercent for " + cs.GPtwo + " on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass(
						"PASS:RBEPercent for " + cs.GPtwo + " on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println("FAIL:RBEPercent for " + cs.GPtwo
						+ " on Cashflow Dashboard and Financial Dashboard is not  equal");
				BrowserSettings.parentTest.fail(
						"RBEPercent for " + cs.GPtwo + " on Cashflow Dashboard and Financial Dashboard is not equal");
			}
		}

		if (!cs.GPthree.equals("NA")) {
			double RBEthree = fd.readRBEPercentage(cs.GPthree);
			System.out.println(RBEthree);
			BrowserSettings.parentTest
					.info("RBEPercentage for " + cs.GPthree + " on financial dashboard is " + RBEthree);

			if (cs.RBEPercentGPTHree3 == RBEthree) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBEPercent for " + cs.GPthree
						+ " on Cashflow Dashboard and Financial Dashboard is equal");
				BrowserSettings.parentTest.pass("PASS:RBEPercent for " + cs.GPthree
						+ " on Cashflow Dashboard and Financial Dashboard is equal");
			} else {
				System.out.println("FAIL:RBEPercent for " + cs.GPthree
						+ " on Cashflow Dashboard and Financial Dashboard is not  equal");
				BrowserSettings.parentTest.fail(
						"RBEPercent for " + cs.GPthree + " on Cashflow Dashboard and Financial Dashboard is not equal");
			}
		}

	}

@Test(enabled = true)
	public void VerifyPNV2022() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(10000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readQuantityCash();
		cs.readQuotedPrice();
		cs.readPNV();

		if (!cs.GPone.equals("NA")) {
			if (cs.PNVone1 == (cs.quantityCashone1 * cs.quotedPriceone1)) {
				System.out.println(cs.quantityCashone1);
				System.out.println(cs.quotedPriceone1);

				Assert.assertTrue(true);
				System.out.println("PASS:PNV  for Glass position 1 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:PNV  for Glass position 1 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println("FAIL:PNV  for Glass position 1 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:PNV  for Glass position 1 on Cashflow Dashboard is not calculated correctly");
			}
		}
		if (!cs.GPtwo.equals("NA")) {

			if (cs.PNVtwo2 == (cs.quantityCashtwo2 * cs.quotedPricetwo2)) {

				Assert.assertTrue(true);
				System.out.println("PASS:PNV  for Glass position 2 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:PNV  for Glass position 2 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println("FAIL:PNV  for Glass position 2 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:PNV  for Glass position 2 on Cashflow Dashboard is not calculated correctly");
			}
		}
		if (!cs.GPthree.equals("NA")) {
			if (cs.PNVthree3 == (cs.quantityCashthree3 * cs.quotedPricethree3)) {

				Assert.assertTrue(true);
				System.out.println("PASS:PNV  for Glass position 3 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:PNV  for Glass position 1 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println("FAIL:PNV  for Glass position 3 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:PNV  for Glass position 1 on Cashflow Dashboard is not calculated correctly");
			}
		}
	}

@Test(enabled = true)
	public void verifyRBEvalue() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readPNV();
		cs.readRBEPercent();
		cs.readRBEValue();
		if (!cs.GPone.equals("NA")) {
			System.out.println(Math.round(cs.PNVone1 * (cs.RBEPercentGPONE1 / 100)));
			if (Math.round(cs.RBEValueone1) == (Math.round(cs.PNVone1 * (cs.RBEPercentGPONE1 / 100)))) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBEvalue for Glass position 1 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:RBEvalue for Glass position 1 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println(
						"FAIL:RBEvalue for Glass position 1 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:RBEvalue  for Glass position 1 on Cashflow Dashboard is not calculated correctly");
			}

		}

		if (!cs.GPtwo.equals("NA")) {

			if (Math.round(cs.RBEValuetwo2) == (Math.round(cs.PNVtwo2 * (cs.RBEPercentGPTWO2 / 100)))) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBEvalue for Glass position 2 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:RBEvalue  for Glass position 2 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println(
						"FAIL:RBEvalue for Glass position 2 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:RBEvalue  for Glass position 2 on Cashflow Dashboard is not calculated correctly");
			}

		}
		if (!cs.GPthree.equals("NA")) {
			System.out.println((Math.round(cs.PNVthree3 * (cs.RBEPercentGPTHree3 / 100))));

			if (Math.round(cs.RBEValuethree3) == (Math.round(cs.PNVthree3 * (cs.RBEPercentGPTHree3 / 100)))) {

				Assert.assertTrue(true);
				System.out.println("PASS:RBEvalue for Glass position 3 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest
						.pass("PASS:RBEvalue  for Glass position 3 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println(
						"FAIL:RBEvalue for Glass position 3 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest
						.fail("FAIL:RBEvalue  for Glass position 3 on Cashflow Dashboard is not calculated correctly");
			}

		}

	}

@Test(enabled = true)
	public void totalCashPRiceBeforeWCR() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.getRBEValueTotal();
		cs.readTotalCashflowBeforeWCR();
		if (cs.TotalCashflowBeforeWCR1 == cs.TotalCashflowBeforeWCR1) {
			BrowserSettings.parentTest.pass("PASS:TotalCashPRiceBeforeWCR is calculated successfully");
			System.out.println("PASS:TotalCashPRiceBeforeWCR is calculated successfully");
		} else {
			BrowserSettings.parentTest.fail("FAIL:TotalCashPRiceBeforeWCR is not calculated successfully");
			System.out.println("FAIL:TotalCashPRiceBeforeWCR is not calculated successfully");
		}

	}

@Test(enabled = true)
	public void verifyTotalCashflowafterWCR() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readTotalCashflowBeforeWCR();
		cs.readTotalFlowAfterWCR();
		cs.readWCR();
		System.out.println(cs.TotalCashflowBeforeWCR1);
		System.out.println(cs.WCR1);

		if (cs.TotalCashflowafterWCR1 == (cs.TotalCashflowBeforeWCR1) + (cs.WCR1)) {

			BrowserSettings.parentTest.pass("PASS:TotalCashPRiceAfterWCR is calculated correctly");
			System.out.println("PASS:TotalCashPRiceBeforeWCR is calculated correctly");
		} else {
			BrowserSettings.parentTest.fail("FAIL:TotalCashPRiceAfterWCR is not calculated successfully");
			System.out.println("FAIL:TotalCashPRiceAfterWCR is not calculated successfully");
		}

	}

@Test(enabled = true)
	public void VerifyWCR() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.getRBEValueTotal();
		cs.readTotalFlowAfterWCR();
		cs.readWCR();

		if (cs.WCR1 == cs.TotalCashflowafterWCR1 - cs.TotalRBEvalue) {
			BrowserSettings.parentTest.pass("PASS:WCR is calculated correctly");
			System.out.println("PASS:WCR is calculated correctly");

		} else {
			BrowserSettings.parentTest.fail("FAIL:WCR is not calculated successfully");
			System.out.println("FAIL:WCR is not calculated successfully");
		}

	}

	@Test(enabled = true)
	public void verifyBussinessLink() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readBusinessLink();
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		fd.readBusinessLink();

		if (cs.BL == fd.Businesslink11) {

			BrowserSettings.parentTest.pass("PASS:Business link in cashflow and financial dashboard  equal");
			System.out.println("PASS:Business link in cashflow and financial dashboard  equal");

		} else {
			BrowserSettings.parentTest.fail("PASS:Business link in cashflow and financial dashboard is not  equal");
			System.out.println("PASS:Business link in cashflow and financial dashboard is not equal");
		}

	}

	@Test(enabled = true)
	public void verifyCapex() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readCapex();
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		fd.readCapex();

		if (cs.Capex1 == fd.capex1) {

			BrowserSettings.parentTest.pass("PASS:Capex Value in cashflow and financial dashboard  equal");
			System.out.println("PASS:Capex Value in cashflow and financial dashboard  equal");

		} else {
			BrowserSettings.parentTest.fail("FAIL:Capex Value in cashflow and financial dashboard is not  equal");
			System.out.println("FAIL:Capex Value in cashflow and financial dashboard is not equal");
		}

	}

@Test(enabled = true)
	public void verifyDevCost() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readDevelopmentCost();
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		fd.readDevCost();

		if (cs.DevelopmentCost1 == fd.DevCost1) {

			BrowserSettings.parentTest.pass("PASS:DevCost Value in cashflow and financial dashboard  equal");
			System.out.println("PASS:DevCost Value in cashflow and financial dashboard  equal");

		} else {
			BrowserSettings.parentTest.fail("FAIL:DevCost Value in cashflow and financial dashboard is not  equal");
			System.out.println("FAIL:DevCost Value in cashflow and financial dashboard is not equal");
		}

	}

@Test(enabled = true)
	public void verifyDevelopmentRevenueLumpSum() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		//hp.searchProject("Cashflow");
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readDevCostLumpSum();
		fd.openFinancialDashboard("");
		Thread.sleep(10000);
		fd.readDevCostLumpSum();

		if (cs.DevCostLumpSum1 == fd.DevCostlumpsum1) {

			BrowserSettings.parentTest.pass("PASS:DevCost Value in cashflow and financial dashboard  equal");
			System.out.println("PASS:DevCost Value in cashflow and financial dashboard  equal");

		} else {
			BrowserSettings.parentTest.fail("FAIL:DevCost Value in cashflow and financial dashboard is not  equal");
			System.out.println("FAIL:DevCost Value in cashflow and financial dashboard is not equal");
		}

	}
	@Test(enabled = true)
	public void VerifyQtyMarkupInternelandexternal() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readQuantityCashInternal();
		cs.readQuantityCash();

		if (!cs.GPone.equals("NA")) {

			if (cs.QuantityCashInternal11 == cs.quantityCashone1) {

				Assert.assertTrue(true);
				System.out.println(
						"QtyMarkupInternel for Glass position 1 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest.pass(
						"QtyMarkupInternel( for Glass position 1 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println("FAIL:QtyMarkupInternel for Glass position 1 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest.fail(
						"FAIL:QtyMarkupInternel  for Glass position 1 on Cashflow Dashboard is not calculated correctly");
			}

		}

		if (!cs.GPtwo.equals("NA")) {

			if (cs.QuantityCashInternal22 == cs.quantityCashtwo2) {

				Assert.assertTrue(true);
				System.out.println(
						"PASS:QtyMarkupInternel for Glass position 2 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest.pass(
						"PASSQtyMarkupInternel for Glass position 2 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println(
						"FAIL:QtyMarkupInternel for Glass position 2 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest.fail(
						"FAIL:QtyMarkupInternel  for Glass position 2 on Cashflow Dashboard is not calculated correctly");
			}

		}

		if (!cs.GPthree.equals("NA")) {

			if (cs.QuantityCashInternal33 == cs.quantityCashthree3) {

				Assert.assertTrue(true);
				System.out.println(
						"QuantityCashInternal for Glass position 3 on Cashflow Dashboard is calculated correctly");
				BrowserSettings.parentTest.pass(
						"PASS:QtyMarkupInternel for Glass position 3 on Cashflow Dashboard is calculated correctly");
			} else {
				System.out.println(
						"FAIL:QtyMarkupInternel for Glass position 3 on Cashflow Dashboard is not calculated correctly");
				BrowserSettings.parentTest.fail(
						"FAIL:QtyMarkupInternel  for Glass position 3 on Cashflow Dashboard is not calculated correctly");
			}

		}
	}
@Test(enabled = true)
	public void VerifycostCashforOEM() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.getTotalPNV();
		cs.readDevRevLS22();
		cs.readdevRevuneMarkup();
		cs.readNAVCustomerCostCashforOEM22();
		
		if(Math.round(cs.CostCashOEM22)==Math.round(cs.TotalPNV+cs.DevrevLumpSum22+cs.DevrevMarkup22)) {
			Assert.assertTrue(true);
			System.out.println(
					"PASS:CostCashforOEM on Cashsimulation is calculated correctly");
			BrowserSettings.parentTest.pass(
					"PASS:CostCashforOEM on Cashsimulation is calculated correctly");
			
		}
		else {
			System.out.println(
					"FAIL:CostCashforOEM on Cashsimulation is not calculated correctly");
			BrowserSettings.parentTest.fail(
					"FAIL:CostCashforOEM on Cashsimulation is not calculated correctly");
		}
	}
	@Test(enabled = true)
	public void verifyCashflowProjectBeforeActualization() throws Exception {
		
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		Thread.sleep(10000);
		cs.readCashflowProjectBeforeActualization22();
		cs.readBusinessLink();
		cs.readDevelopmentCost22();
		cs.readDevRevuneLumpSum22();
		cs.readdevRevuneMarkup();
		cs.getRBEValueTotal();
		cs.readWCR();
		
		
		if(cs.CFPBActualization22==cs.BL+cs.DevelopmentCost22+cs.DevCostLumpSum22+cs.DevrevMarkup22+cs.TotalRBEvalue+cs.WCR1) {
			Assert.assertTrue(true);
			System.out.println(
					"PASS:Cash Flow Before Actualization on Cashsimulation is calculated correctly");
			BrowserSettings.parentTest.pass(
					"PASS:Cash Flow Before Actualization on Cashsimulation is calculated correctly");
			
		}
		else {
			System.out.println(
					"FAIL:Cash Flow Before Actualization on Cashsimulation is not calculated correctly");
			BrowserSettings.parentTest.fail(
					"FAIL:Cash Flow Before Actualization on Cashsimulation is not calculated correctly");
		}
		
	}
@Test (enabled = true)
	public void verifyCashflowProjecCumulated() throws Exception {
		ActionDriver ad = new ActionDriver();
		Log.startTestCase("SearchProject");
		HomePage hp = new HomePage();
		CashSimulation cs = new CashSimulation();
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

		Log.info("Calling SeachProject Method");
		lg.loginintoapplication();
		//hp.searchProject("Cashflow");
		MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
		hp.OpenMyRFQ();
		Thread.sleep(10000);
		mr.GlobalSearch("cashsimulation");
		Thread.sleep(10000);
		mr.Openbutton();
		Thread.sleep(20000);
		cs.OpenCashsimulation();
		cs.readCashflowProjectCommunatedone();
		cs.readCashflowProjectBeforeActualization22();
		
		
		if(cs.CFPCommulated==cs.CFPBActualization22) {
			Assert.assertTrue(true);
			System.out.println(
					"PASS:CashFlow Project Commulated on Cashsimulation Dashboard is calculated correctly");
			BrowserSettings.parentTest.pass(
					"PASS:CashFlow Project Commulated on Cashsimulation is calculated correctly");
			
		}
		else {
			System.out.println(
					"FAIL:Cash Flow Before Actualization on Cashsimulation is not calculated correctly");
			BrowserSettings.parentTest.fail(
					"FAIL:Cash Flow Before Actualization on Cashsimulation is not calculated correctly");
		}
		
		
	}
@Test(enabled = true)
public void verifyPBRNetPresentvalueCONTRACTUAL() throws Exception{
	ActionDriver ad = new ActionDriver();
	Log.startTestCase("SearchProject");
	HomePage hp = new HomePage();
	CashSimulation cs = new CashSimulation();
	LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
	FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
	ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
	GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

	Log.info("Calling SeachProject Method");
	lg.loginintoapplication();
	//hp.searchProject("Cashflow");
	MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
	hp.OpenMyRFQ();
	Thread.sleep(10000);
	mr.GlobalSearch("cashsimulation");
	Thread.sleep(10000);
	mr.Openbutton();
	Thread.sleep(20000);
	cs.OpenCashsimulation();
	Thread.sleep(10000);
	cs.readPBRNetPresentvalueCONTRACTUAL21();
	cs.readCashINProjectafteractualization21();
	cs.readCashOutProjectafteractualization21();
		
	if(cs.PBRNetPresentvalueCONTRACTUAL21==cs.CashINProjectafteractualization21 + cs.CashOUTProjectafteractualization21) {
		Assert.assertTrue(true);
		System.out.println(
				"PASS:PBR Net Present value CONTRACTUAL for 21 on Cashsimulation Dashboard is calculated correctly");
		BrowserSettings.parentTest.pass(
				"PASS:PBR Net Present value CONTRACTUAL for 21 on Cashsimulation Dashboard is calculated correctly");
		
	}
	else {
		System.out.println(
				"FAIL:PBR Net Present value CONTRACTUAL for 21 on Cashsimulation Dashboard is not  calculated correctly");
		BrowserSettings.parentTest.fail(
				"FAIL:PBR Net Present value CONTRACTUAL for 21 on Cashsimulation Dashboard is not  calculated correctly");
	}
	
	}
@Test(enabled = true)
public void verifyPBRNetPresentvalueREAL() throws Exception{
	ActionDriver ad = new ActionDriver();
	Log.startTestCase("SearchProject");
	HomePage hp = new HomePage();
	CashSimulation cs = new CashSimulation();
	LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
	FinancialDashboard fd = PageFactory.initElements(driver, FinancialDashboard.class);
	ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
	GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);

	Log.info("Calling SeachProject Method");
	lg.loginintoapplication();
	//hp.searchProject("Cashflow");
	MyRFQ mr= PageFactory.initElements(driver, MyRFQ.class);
	hp.OpenMyRFQ();
	Thread.sleep(10000);
	mr.GlobalSearch("cashsimulation");
	Thread.sleep(10000);
	mr.Openbutton();
	Thread.sleep(20000);
	cs.OpenCashsimulation();
	Thread.sleep(10000);
	cs.readPBRNetPresentvalueREAL21();
	cs.readCashINProjectafteractualization21();
	cs.readCashOutProjectafteractualization21();
	if(cs.PBRNetPresentvalueREAL21==cs.CashINProjectafteractualization21 + cs.CashOUTProjectafteractualization21) {
		Assert.assertTrue(true);
		System.out.println(
				"PASS:PBR Net Present value REAL for 21 on Cashsimulation Dashboard is calculated correctly");
		BrowserSettings.parentTest.pass(
				"PASS:PBR Net Present value REAL for 21 on Cashsimulation Dashboard is calculated correctly");
		
	}
	else {
		System.out.println(
				"FAIL:PBR Net Present value REAL for 21 on Cashsimulation Dashboard is not calculated correctly");
		BrowserSettings.parentTest.fail(
				"FAIL:PBR Net Present value REAL for 21 on Cashsimulation Dashboard is not calculated correctly");
	}
	
	
}
}
