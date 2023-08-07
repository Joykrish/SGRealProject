package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import freemarker.core.ReturnInstruction.Return;

public class CashSimulation extends BrowserSettings {
	String fileName = "PriceBuilderData.xlsx";
	// String path =System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH");
	String path = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH") + "\\" + fileName;
	ExcelOpearations excel = new ExcelOpearations(path);
	public String GPone = excel.getCellData("CashSimulation", "Value", 2);
	public String GPtwo = excel.getCellData("CashSimulation", "Value", 3);
	public String GPthree = excel.getCellData("CashSimulation", "Value", 4);
	public String GPfour=excel.getCellData("CashSimulation", "Value", 5);
	ActionDriver ad;
	public HashMap<String, String> map;
	public String QuantityPandLone;
	public String QuantityPandLtwo;
	public String QuantityPandLthree;

	public String quotedPriceone;
	public String quotedPricetwo;
	public String quotedPricethree;

	public double PNVone1;
	public double PNVtwo2;
	public double PNVthree3;

	public double quantityCashone1;
	public double quantityCashtwo2;
	public double quantityCashthree3;
	
	public double quotedPriceone1;
	public double quotedPricetwo2;
	public double quotedPricethree3;
	
	public double RBEPercentGPONE1;
	public double RBEPercentGPTWO2;
	public double RBEPercentGPTHree3;
	
	public double RBEValueone1;
	public double RBEValuetwo2;
	
	public double RBEValuethree3;
	
	public double TotalCashflowBeforeWCR1;
	public double TotalCashflowafterWCR1;
	public double TotalRBEvalue;
	public double WCR1;
	public double BL;
	public double Capex1;
	
	public double DevelopmentCost1;
	public double DevCostLumpSum1;
	public double QuantityCashInternal11;
	public double QuantityCashInternal22;
	public double QuantityCashInternal33;
	
	public double TotalPNV;
	public double DevrevLumpSum22;
	public double DevrevMarkup22;
	public double CostCashOEM22;
	public double CFPBActualization22;
	public double DevelopmentCost22;
	public double DevCostLumpSum22;
	
	public double CFPCommulated;
	public double PBRNetPresentvalueCONTRACTUAL21;
	public double CashINProjectafteractualization21;
	public double CashOUTProjectafteractualization21;
	public double PBRNetPresentvalueREAL21;

	public String takerateone;

	@FindBy(xpath = "//p[text()='Cash Simulation']")
	private WebElement CashsimulationDashboard;

	@FindBy(xpath = "//span[text()='Financial Overview']")
	private WebElement btnFinancialOverview;

	@FindBy(xpath = "//td[text()='Car production P&L']//following-sibling::td[6]")
	private WebElement readCarProductionProfileLoss;

	@FindBy(xpath = "(//i[@class='pi pi-chevron-right'])[1]")
	private WebElement buttontakeratedispaly;
	
	@FindBy(xpath = "//span[text()='Financial Overview']")
	private WebElement buttonFinancialOverview;
	
	

	public CashSimulation() {
		PageFactory.initElements(driver, this);
	}

	public void OpenCashsimulation() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open CashSimulation");
		ad = new ActionDriver();
		ad.click(driver, CashsimulationDashboard, "Clicked on OpenCashsimulation");

	}

	public void ClickFinancialOverview() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Clicked on Financial Overview");
		ad = new ActionDriver();
		ad.click(driver, btnFinancialOverview, "Clicked on Financial Overview");

	}

	public String readCarProductionProfitandloss() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read CarProduction Profitandloss");
		ad = new ActionDriver();
		String readCarProductionPandL = ad.GetText(readCarProductionProfileLoss, "Value read ");
		readCarProductionPandL = readCarProductionPandL.replaceAll("[^\\d.]", "");
		return readCarProductionPandL;

	}

	public void readQuantityPandL() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Quantity Profitandloss");
		if (!GPone.equals("NA")) {
			QuantityPandLone = driver
					.findElement(By.xpath("//td[text()='Quantity P&L']//following-sibling::td[text()=' " + GPone
							+ "']//following-sibling::td[4]"))
					.getText();

			System.out.println("QualityProfit and lost value on CashSimulation is " + QuantityPandLone);
			BrowserSettings.parentTest.info("QualityProfit and lost value on CashSimulation for "+GPone+" is " + QuantityPandLone);

		}

		if (!GPtwo.equals("NA")) {
			QuantityPandLtwo = driver
					.findElement(By.xpath("(//td[text()=' " + GPtwo + "'])[1]//following-sibling::td[4]")).getText();
			System.out.println("QualityProfit and lost value on CashSimulation is " + QuantityPandLtwo);
			BrowserSettings.parentTest.info("QualityProfit and lost value on CashSimulation for "+GPtwo+" is " + QuantityPandLtwo);
		}

		if (!GPthree.equals("NA")) {
			QuantityPandLthree = driver
					.findElement(By.xpath("(//td[text()=' " + GPthree + "'])[1]//following-sibling::td[4]")).getText();
			System.out.println("QualityProfit and lost value on CashSimulation is " + QuantityPandLthree);
			BrowserSettings.parentTest.info("QualityProfit and lost value on CashSimulation for "+GPthree+" is " + QuantityPandLthree);

		}

	}

	public void readtakerate() throws IOException, InterruptedException {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read take rate");

		ad = new ActionDriver();
		ad.click(driver, buttontakeratedispaly, "clicked on button to display take rates");
		Thread.sleep(10000);

		if (!GPone.equals("NA")) {
			takerateone = driver.findElement(By.xpath("(//td[text()=' " + GPone + "'])[2]//following-sibling::td[4]"))
					.getText();

			System.out.println("take rate value for " + GPone + " value on CashSimulation is " + takerateone);
			BrowserSettings.parentTest.info("take rate value for " + GPone + " value on CashSimulation is " + takerateone);

		}
		if (!GPtwo.equals("NA")) {
			String takeratetwo = driver
					.findElement(By.xpath("(//td[text()=' " + GPtwo + "'])[2]//following-sibling::td[4]")).getText();

			System.out.println("take rate value for " + GPtwo + " value on CashSimulation is  " + takeratetwo);
			BrowserSettings.parentTest.info("take rate value for " + GPtwo + " value on CashSimulation is " + takeratetwo);

		}
		if (!GPthree.equals("NA")) {
			String takeratethree = driver
					.findElement(By.xpath("(//td[text()=' " + GPthree + "'])[2]//following-sibling::td[4]")).getText();

			System.out.println("take rate value for " + GPthree + " value on CashSimulation is  " + takeratethree);
			BrowserSettings.parentTest.info("take rate value for " + GPthree + " value on CashSimulation is " + takeratethree);

		}

	}

	public void readQuotedPriceold() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Quoted Price");

		if (!GPone.equals("NA")) {
			quotedPriceone = driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[1]//following-sibling::td[4]"))
					.getText();

			System.out.println("Quoted Price value for " + GPone + " value on CashSimulation is " + quotedPriceone);
			BrowserSettings.parentTest.info("Quoted Price value for " + GPone + " value on CashSimulation is " + quotedPriceone);

		}
		if (!GPtwo.equals("NA")) {
			quotedPricetwo = driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[1]//following-sibling::td[4]"))
					.getText();

			System.out.println("Quoted Price value for " + GPtwo + " value on CashSimulation is  " + quotedPricetwo);
			BrowserSettings.parentTest.info("Quoted Price value for " + GPtwo + " value on CashSimulation is  " + quotedPricetwo);

		}
		if (!GPthree.equals("NA")) {
			quotedPricethree = driver
					.findElement(By.xpath("(//td[text()='" + GPthree + "'])[1]//following-sibling::td[4]")).getText();

			System.out
					.println("Quoted Price value for " + GPthree + " value on CashSimulation is  " + quotedPricethree);
			BrowserSettings.parentTest.info("Quoted Price value for " + GPthree + " value on CashSimulation is  " + quotedPricethree);

		}

	}

	public void readQuotedPrice() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read QuotedPrice");
		ad = new ActionDriver();

		map = new HashMap<>();
		try {

			if (!GPone.equals("NA")) {
				map.put("quotedPriceone",
						driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[1]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("quotedPricetwo",
						driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[1]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("quotedPricethree",
						driver.findElement(By.xpath("(//td[text()='" + GPthree + "'])[1]//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("Quoted Price value for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Quoted Price value for all Versions successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

		String quotedPriceone = map.get("quotedPriceone");
		if (!(quotedPriceone == null)) {
			String qtr = null;
			quotedPriceone = ad.replacechartwo(quotedPriceone, qtr, ',', '.');
			quotedPriceone = quotedPriceone.replaceAll("[^\\d.]", "");
			double cashone = 0;
			 quotedPriceone1 = ad.Stringtodouble(quotedPriceone, cashone);
			System.out.println("Quoted Price for " + GPone + " in CashSimulationDashboard is " + quotedPriceone1);
			BrowserSettings.parentTest.info("Quoted Price for " + GPone + " in CashSimulationDashboard is " + quotedPriceone1);
		}
		String quotedPricetwo = map.get("quotedPricetwo");
		if (!(quotedPricetwo == null)) {
			String qtr = null;
			quotedPricetwo = ad.replacechartwo(quotedPricetwo, qtr, ',', '.');
			quotedPricetwo = quotedPricetwo.replaceAll("[^\\d.]", "");
			double cashone = 0;
			 quotedPricetwo2 = ad.Stringtodouble(quotedPricetwo, cashone);
			System.out.println("Quoted Price for " + GPtwo + " in CashSimulationDashboard is " + quotedPricetwo2);
			BrowserSettings.parentTest.info("Quoted Price for " + GPtwo + " in CashSimulationDashboard is " + quotedPricetwo2);
		}
		String quotedPricethree = map.get("quotedPricethree");
		if (!(quotedPricethree == null)) {
			String qtr = null;
			quotedPricethree = ad.replacechartwo(quotedPricethree, qtr, ',', '.');
			quotedPricethree = quotedPricethree.replaceAll("[^\\d.]", "");
			double cashone = 0;
			 quotedPricethree3 = ad.Stringtodouble(quotedPricethree, cashone);
			System.out.println("Quoted Price for " + GPthree + " in CashSimulationDashboard is " + quotedPricethree3);
			BrowserSettings.parentTest.info("Quoted Price for " + GPthree + " in CashSimulationDashboard is " + quotedPricethree3);
		}

	}

	public void readRBEPercent() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read RBE Percent");
		ad = new ActionDriver();

		map = new HashMap<>();

		try {

			if (!GPone.equals("NA")) {
				map.put("RBEPercentone",
						driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[3]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("RBEPercentwo",
						driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[3]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("RBEPercenthree",
						driver.findElement(By.xpath("(//td[text()='" + GPthree + "'])[3]//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("RBE Percent for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable capture RBE Percent for all Versions successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

		String RBEPercentGPONE = map.get("RBEPercentone");
		if (!(RBEPercentGPONE == null)) {
			
			String qtr = null;
			RBEPercentGPONE = ad.replacechartwo(RBEPercentGPONE, qtr, ',', '.');
			RBEPercentGPONE = RBEPercentGPONE.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEPercentGPONE1 = ad.Stringtodouble(RBEPercentGPONE, cashone);
			RBEPercentGPONE1=RBEPercentGPONE1 % 100;
			
			
			System.out.println("RBEPercent for " + GPone + " in  Cash SimulationDashboard is " + RBEPercentGPONE1);
			BrowserSettings.parentTest.info("RBEPercent for "+GPone+" in  Cash SimulationDashboard is " + RBEPercentGPONE1);
		}
		String RBEPercentGPtwo = map.get("RBEPercentwo");
		if (!(RBEPercentGPtwo == null)) {
			String qtr = null;
			RBEPercentGPtwo = ad.replacechartwo(RBEPercentGPtwo, qtr, ',', '.');
			RBEPercentGPtwo = RBEPercentGPtwo.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEPercentGPTWO2 = ad.Stringtodouble(RBEPercentGPtwo, cashone);
			RBEPercentGPTWO2=RBEPercentGPTWO2 % 100;
			
			System.out.println("RBEPercent for " + GPtwo + " in Cash SimulationDashboard is " + RBEPercentGPTWO2);
			BrowserSettings.parentTest.info("RBEPercent for "+GPtwo+" in  Cash SimulationDashboard is " + RBEPercentGPTWO2);
		}
		String RBEPercentGPthree = map.get("RBEPercenthree");
		if (!(RBEPercentGPthree == null)) {
			String qtr = null;
			RBEPercentGPthree = ad.replacechartwo(RBEPercentGPthree, qtr, ',', '.');
			RBEPercentGPthree = RBEPercentGPthree.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEPercentGPTHree3 = ad.Stringtodouble(RBEPercentGPthree, cashone);
			RBEPercentGPTHree3=RBEPercentGPTHree3 % 100;
			System.out.println("RBEPercent for " + GPthree + " Cash in SimulationDashboard is " + RBEPercentGPTHree3);
			BrowserSettings.parentTest.info("RBEPercent for "+GPthree+" in  Cash SimulationDashboard is " + RBEPercentGPTHree3);
		}
	}

	public void readQuantityCash() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read QuantityCash");
		ad = new ActionDriver();

		map = new HashMap<>();

		try {

			if (!GPone.equals("NA")) {
				map.put("quantityCashone",
						driver.findElement(By.xpath("(//td[text()=' " + GPone + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("quantityCashtwo",
						driver.findElement(By.xpath("(//td[text()=' " + GPtwo + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("quantityCashthree",
						driver.findElement(By.xpath("(//td[text()=' " + GPthree + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("QuantityCash values for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable capture QuantityCash values for all Versions successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

		String quantityCashone = map.get("quantityCashone");
		if (!(quantityCashone == null)) {
			String qtr = null;
			quantityCashone = ad.replacechartwo(quantityCashone, qtr, ',', '.');
			quantityCashone = quantityCashone.replaceAll("[^\\d.]", "");
			double cashone = 0;
			quantityCashone1 = ad.Stringtodouble(quantityCashone, cashone);

			System.out.println("QuantityCash for " + GPone + " in CashSimulationDashboard is " + quantityCashone1);
			BrowserSettings.parentTest.info("QuantityCash for " + GPone + " in CashSimulationDashboard is " + quantityCashone1);
		}
		String quantityCashtwo = map.get("quantityCashtwo");
		if (!(quantityCashtwo == null)) {
			String qtr = null;
			quantityCashtwo = ad.replacechartwo(quantityCashtwo, qtr, ',', '.');
			quantityCashtwo = quantityCashtwo.replaceAll("[^\\d.]", "");
			double cashone = 0;
			quantityCashtwo2 = ad.Stringtodouble(quantityCashtwo, cashone);

			System.out.println("QuantityCash for " + GPtwo + " in CashSimulationDashboard is " + quantityCashtwo2);
			BrowserSettings.parentTest.info("QuantityCash for " + GPtwo + " in CashSimulationDashboard is " + quantityCashtwo2);
		}
		String quantityCashthree = map.get("quantityCashthree");
		if (!(quantityCashthree == null)) {
			String qtr = null;
			quantityCashthree = ad.replacechartwo(quantityCashthree, qtr, ',', '.');
			quantityCashthree = quantityCashthree.replaceAll("[^\\d.]", "");
			double cashone = 0;
			quantityCashthree3 = ad.Stringtodouble(quantityCashthree, cashone);
			System.out.println("QuantityCash  for " + GPthree + " Cashin SimulationDashboard is " + quantityCashthree3);
			BrowserSettings.parentTest.info("QuantityCash for " + GPthree + " in CashSimulationDashboard is " + quantityCashthree3);
		}

	}

	public void readPNV() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read PNV");
		ad = new ActionDriver();

		map = new HashMap<>();

		try {

			if (!GPone.equals("NA")) {
				map.put("PNVone",
						driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("PNVtwo",
						driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("PNVthree",
						driver.findElement(By.xpath("(//td[text()='" + GPthree + "'])[2]//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("PNV values for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable capture PNV values for all Versions successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

		String PNVone = map.get("PNVone");
		if (!(PNVone == null)) {
			String qtr = null;
			PNVone = ad.replacechartwo(PNVone, qtr, ',', '.');
			PNVone = PNVone.replaceAll("[^\\d.]", "");
			double cashone = 0;
			PNVone1 = ad.Stringtodouble(PNVone, cashone);
			System.out.println("PNV for " + GPone + " in CashSimulationDashboard is " + PNVone1);
			BrowserSettings.parentTest.info("PNV for " + GPone + " in CashSimulationDashboard is " + PNVone1);
		}
		String PNVtwo = map.get("PNVtwo");
		if (!(PNVtwo == null)) {
			String qtr = null;
			PNVtwo = ad.replacechartwo(PNVtwo, qtr, ',', '.');
			PNVtwo = PNVtwo.replaceAll("[^\\d.]", "");
			double cashone = 0;
			PNVtwo2 = ad.Stringtodouble(PNVtwo, cashone);
			System.out.println("PNV for " + GPtwo + " in CashsimulationDashboard is " + PNVtwo2);
			BrowserSettings.parentTest.info("PNV for " + GPtwo + " in CashSimulationDashboard is " + PNVtwo2);
		}
		String PNVthree = map.get("PNVthree");
		if (!(PNVthree == null)) {
			String qtr = null;
			PNVthree = ad.replacechartwo(PNVthree, qtr, ',', '.');
			PNVthree = PNVthree.replaceAll("[^\\d.]", "");
			double cashone = 0;
			PNVthree3 = ad.Stringtodouble(PNVthree, cashone);
			System.out.println("PNV  for " + GPthree + " in CashSimulationDashboard is " + PNVthree3);
			BrowserSettings.parentTest.info("PNV for " + GPthree + " in CashSimulationDashboard is " + PNVthree3);
		}

	}
	
	public void readRBEValue() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read PNV");
		ad = new ActionDriver();

		map = new HashMap<>();
		
		
		try {

			if (!GPone.equals("NA")) {
				map.put("RBEValueone",
						driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[4]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("RBEValuetwo",
						driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[4]//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("RBEValuethree",
						driver.findElement(By.xpath("(//td[text()='" + GPthree + "'])[4]//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("RBE  values for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("RBE  values for all Versions are not captured successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		
		String RBEValueone = map.get("RBEValueone");
		if (!(RBEValueone == null)) {
			String qtr = null;
			RBEValueone = ad.replacechartwo(RBEValueone, qtr, ',', '.');
			RBEValueone = RBEValueone.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEValueone1 = ad.Stringtodouble(RBEValueone, cashone);
			
			System.out.println("RBEValue for " + GPone + " in CashSimulationDashboard is " + RBEValueone1);
			BrowserSettings.parentTest.info("RBEValue for " + GPone + " in CashSimulationDashboard is " + RBEValueone1);
		}
		String RBEValuetwo = map.get("RBEValuetwo");
		if (!(RBEValuetwo == null)) {
			String qtr = null;
			RBEValuetwo = ad.replacechartwo(RBEValuetwo, qtr, ',', '.');
			RBEValuetwo = RBEValuetwo.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEValuetwo2 = ad.Stringtodouble(RBEValuetwo, cashone);
			
			System.out.println("RBEValue for " + GPtwo + " in CashsimulationDashboard is " + RBEValuetwo2);
			BrowserSettings.parentTest.info("RBEValue for " + GPtwo + " in CashSimulationDashboard is " + RBEValuetwo2);
		}
		
		String RBEValuethree = map.get("RBEValuethree");
		if (!(RBEValuethree == null)) {
			String qtr = null;
			RBEValuethree = ad.replacechartwo(RBEValuethree, qtr, ',', '.');
			RBEValuethree = RBEValuethree.replaceAll("[^\\d.]", "");
			double cashone = 0;
			RBEValuethree3 = ad.Stringtodouble(RBEValuethree, cashone);
			
			System.out.println("RBEValue  for " + GPthree + " in CashSimulationDashboard is " + RBEValuethree3);
			BrowserSettings.parentTest.info("RBEValue for " + GPthree + " in CashSimulationDashboard is " + RBEValuethree3);
		}
		
		
	}
	
	
	public void getRBEValueTotal() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Calculate RBEValue Total");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("RBEValue1",
				driver.findElement(By.xpath("//tr[td[text()=' RBE Value ']]//td[7]"))
						.getText());
		
			map.put("RBEValue2",
					driver.findElement(By.xpath("//tr[td[text()=' RBE Value ']//following-sibling::td[1]]//following-sibling::tr[1]//td[5]"))
							.getText());
			map.put("RBEValue3",
					driver.findElement(By.xpath("//tr[td[text()=' RBE Value ']//following-sibling::td[1]]//following-sibling::tr[2]//td[5]"))
							.getText());
			map.put("RBEValue4",
					driver.findElement(By.xpath("//tr[td[text()=' RBE Value ']//following-sibling::td[1]]//following-sibling::tr[3]//td[5]"))
							.getText());
			map.put("RBEValue5",
					driver.findElement(By.xpath("//tr[td[text()=' RBE Value ']//following-sibling::td[1]]//following-sibling::tr[4]//td[5]"))
							.getText());
			
			String RBEValue1=map.get("RBEValue1");
			String qtr = null;
			RBEValue1 = ad.replacechartwo(RBEValue1, qtr, ',', '.');
			RBEValue1 = RBEValue1.replaceAll("[^\\d.]", "");
			double cashone = 0;
			double RBEValueone = ad.Stringtodouble(RBEValue1, cashone);
			
			String RBEValue2=map.get("RBEValue2");
			RBEValue2 = ad.replacechartwo(RBEValue2, qtr, ',', '.');
			RBEValue2 = RBEValue2.replaceAll("[^\\d.]", "");
			double RBEValuetwo = ad.Stringtodouble(RBEValue2, cashone);
			
			String RBEValue3=map.get("RBEValue3");
			RBEValue3 = ad.replacechartwo(RBEValue3, qtr, ',', '.');
			RBEValue3 = RBEValue3.replaceAll("[^\\d.]", "");
			double RBEValuethree = ad.Stringtodouble(RBEValue3, cashone);
			
			
			String RBEValue4=map.get("RBEValue4");
			RBEValue4 = ad.replacechartwo(RBEValue4, qtr, ',', '.');
			RBEValue4 = RBEValue4.replaceAll("[^\\d.]", "");
			double RBEValuefour = ad.Stringtodouble(RBEValue4, cashone);
			
			
			String RBEValue5=map.get("RBEValue5");
			RBEValue5 = ad.replacechartwo(RBEValue5, qtr, ',', '.');
			RBEValue5 = RBEValue5.replaceAll("[^\\d.]", "");
			double RBEValuefive = ad.Stringtodouble(RBEValue5, cashone);
			
			
			
			System.out.println(RBEValueone);
			BrowserSettings.parentTest.info("RBEValueone on Cashflow dashboard is " + RBEValueone);
			System.out.println(RBEValuetwo);
			BrowserSettings.parentTest.info("RBEValuetwo on Cashflow dashboard is " + RBEValuetwo);
			System.out.println(RBEValuethree);
			BrowserSettings.parentTest.info("RBEValuethree on Cashflow dashboard is " + RBEValuethree);
			System.out.println(RBEValuefour);
			BrowserSettings.parentTest.info("RBEValuefour on Cashflow dashboard is " + RBEValuefour);
			System.out.println(RBEValuefive);
			BrowserSettings.parentTest.info("RBEValuefive on Cashflow dashboard is " + RBEValuefive);
			 TotalRBEvalue=RBEValueone+RBEValuetwo+RBEValuethree+RBEValuefour+RBEValuefive;
			System.out.println(TotalRBEvalue);
			BrowserSettings.parentTest.info("TotalRBEvalue on Cashflow dashboard is " + TotalRBEvalue);
			
		
	}
	
	
	public void readTotalCashflowBeforeWCR() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read TotalCashflowBeforeWCR");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("TotalCashflowBeforeWCR",
				driver.findElement(By.xpath("//td[text()=' Total cash flow after WCR ']//following-sibling::td[6]"))
						.getText());
		String TotalCashflowBeforeWCR=map.get("TotalCashflowBeforeWCR");
		String qtr = null;
		TotalCashflowBeforeWCR = ad.replacechartwo(TotalCashflowBeforeWCR, qtr, ',', '.');
		TotalCashflowBeforeWCR = TotalCashflowBeforeWCR.replaceAll("[^\\d.]", "");
		double cashone = 0;
		TotalCashflowBeforeWCR1 = ad.Stringtodouble(TotalCashflowBeforeWCR, cashone);
		System.out.println("TotalCashflowBeforeWCR  in CashSimulationDashboard is " + TotalCashflowBeforeWCR1);
		BrowserSettings.parentTest.info("TotalCashflowBeforeWCR  in CashSimulationDashboard is " + TotalCashflowBeforeWCR1);
		
		
		
	}
	public void readTotalFlowAfterWCR() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read TotalCashflowafterWCR");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("TotalCashflowafterWCR",
				driver.findElement(By.xpath("//td[text()=' Total cash flow after WCR ']//following-sibling::td[6]"))
						.getText());
		String TotalCashflowAfterWCR=map.get("TotalCashflowafterWCR");
		String qtr = null;
		TotalCashflowAfterWCR = ad.replacechartwo(TotalCashflowAfterWCR, qtr, ',', '.');
		TotalCashflowAfterWCR = TotalCashflowAfterWCR.replaceAll("[^\\d.]", "");
		double cashone = 0;
		TotalCashflowafterWCR1= ad.Stringtodouble(TotalCashflowAfterWCR, cashone);
		System.out.println("readTotalFlowAfterWCR  in CashSimulationDashboard is " + TotalCashflowafterWCR1);
		BrowserSettings.parentTest.info("TotalCashFlowAfterWCR  in CashSimulationDashboard is " + TotalCashflowafterWCR1);
		
	}
	
	public void readWCR() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read WCR");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("WCR",
				driver.findElement(By.xpath("//td[text()='WCR']//following-sibling::td[6]"))
						.getText());
		String WCR=map.get("WCR");
		String qtr = null;
		WCR = ad.replacechartwo(WCR, qtr, ',', '.');
		WCR = WCR.replaceAll("[^\\d.]", "");
		double cashone = 0;
		WCR1= ad.Stringtodouble(WCR, cashone);
		System.out.println("WCR  in CashSimulationDashboard is " + WCR1);
		BrowserSettings.parentTest.info("WCR  in CashSimulationDashboard is " + WCR1);
		
		
	}
	
	public void readBusinessLink() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("readBusinessLink");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("BusinessLink",
				driver.findElement(By.xpath("//td[text()=' Business Link']//following-sibling::td[6]"))
						.getText());
		String BusinessLink=map.get("BusinessLink");
		String qtr = null;
		BusinessLink = ad.replacechartwo(BusinessLink, qtr, ',', '.');
		BusinessLink = BusinessLink.replaceAll("[^\\d.]", "");
		double cashone = 0;
		BL= ad.Stringtodouble(BusinessLink, cashone);
		System.out.println("Business link  in CashSimulationDashboard is " + BL);
		BrowserSettings.parentTest.info("Business link   in CashSimulationDashboard is " + BL);
		
	}
	public void readCapex() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Capex");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("Capex",
				driver.findElement(By.xpath("//td[text()=' CAPEX']//following-sibling::td[6]"))
						.getText());
		String Capex=map.get("Capex");
		String qtr = null;
		Capex = ad.replacechartwo(Capex, qtr, ',', '.');
		Capex = Capex.replaceAll("[^\\d.]", "");
		double cashone = 0;
		Capex1= ad.Stringtodouble(Capex, cashone);
		System.out.println("Capex Value  in CashSimulationDashboard is " + Capex1);
		BrowserSettings.parentTest.info("Capex Value   in CashSimulationDashboard is " + Capex1);
		
	}
	
	public void readDevelopmentCost() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Development Cost");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("DevelopmentCost",
				driver.findElement(By.xpath("//td[text()=' Development costs']//following-sibling::td[5]"))
						.getText());
		String DevelopmentCost=map.get("DevelopmentCost");
		String qtr = null;
		DevelopmentCost = ad.replacechartwo(DevelopmentCost, qtr, ',', '.');
		DevelopmentCost = DevelopmentCost.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevelopmentCost1= ad.Stringtodouble(DevelopmentCost, cashone);
		System.out.println("DevCost in CashSimulationDashboard is " + DevelopmentCost1);
		BrowserSettings.parentTest.info("DevCost  in CashSimulationDashboard is " + DevelopmentCost1);
		
	}
	
	public void readDevelopmentCost22() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Development Cost 22");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("DevelopmentCost22",
				driver.findElement(By.xpath("//td[text()=' Development costs']//following-sibling::td[6]"))
						.getText());
		String DevelopmentCost=map.get("DevelopmentCost22");
		String qtr = null;
		DevelopmentCost = ad.replacechartwo(DevelopmentCost, qtr, ',', '.');
		DevelopmentCost = DevelopmentCost.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevelopmentCost22= ad.Stringtodouble(DevelopmentCost, cashone);
		System.out.println("DevCost in CashSimulationDashboard is " + DevelopmentCost22);
		BrowserSettings.parentTest.info("DevCost22  in CashSimulationDashboard is " + DevelopmentCost22);
		
	}
	
	public void readDevCostLumpSum() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read DevCost LumpSum");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("DevCostLumpSum",
				driver.findElement(By.xpath("//td[text()=' Development revenue Lump Sum']//following-sibling::td[5]"))
						.getText());
		String DevCostLumpSum=map.get("DevCostLumpSum");
		String qtr = null;
		DevCostLumpSum = ad.replacechartwo(DevCostLumpSum, qtr, ',', '.');
		DevCostLumpSum = DevCostLumpSum.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevCostLumpSum1= ad.Stringtodouble(DevCostLumpSum, cashone);
		System.out.println("DevCostLumpSum in CashSimulationDashboard is " + DevCostLumpSum1);
		BrowserSettings.parentTest.info("DevCostLumpSum  in CashSimulationDashboard is " + DevCostLumpSum1);
		
		
	}
	
	public void readDevRevuneLumpSum22() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read DevCost LumpSum");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("DevRevenueLumpSum22",
				driver.findElement(By.xpath("//td[text()=' Development revenue Lump Sum']//following-sibling::td[6]"))
						.getText());
		String DevCostLumpSum=map.get("DevRevenueLumpSum22");
		String qtr = null;
		DevCostLumpSum = ad.replacechartwo(DevCostLumpSum, qtr, ',', '.');
		DevCostLumpSum = DevCostLumpSum.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevCostLumpSum22= ad.Stringtodouble(DevCostLumpSum, cashone);
		System.out.println("DevCostLumpSum in CashSimulationDashboard for year 2022 is " + DevCostLumpSum22);
		BrowserSettings.parentTest.info("DevCostLumpSum  in CashSimulationDashboard for year 2022 is is " + DevCostLumpSum22);
		
		
	}
	
	
	public void readQuantityCashInternal() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Quantity Cash Internal");
		ad = new ActionDriver();

		map = new HashMap<>();
		
		
		try {

			if (!GPone.equals("NA")) {
				map.put("QuantityCashInternal1",
						driver.findElement(By.xpath("//tr[td[text()= ' Qty Mark up External']]//parent::td[text()='Quantity']//following-sibling::td[text()='" + GPone + "']//following-sibling::td[4]"))
								.getText());
			}
			if (!GPtwo.equals("NA")) {
				map.put("QuantityCashInternal2",
						driver.findElement(By.xpath("//tr[td[text()= ' Qty Mark up External']]//following-sibling::tr[1]//parent::td[text()='" + GPtwo + "']//following-sibling::td[4]"))
								.getText());
			}
			if (!GPthree.equals("NA"))

			{
				map.put("QuantityCashInternal3",
						driver.findElement(By.xpath("//tr[td[text()= ' Qty Mark up External']]//following-sibling::tr[2]//parent::td[text()='" + GPthree + "']//following-sibling::td[4]"))
								.getText());
			}
			BrowserSettings.childTest.pass("QuantityCashInternal1 values for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("QuantityCashInternal1  values for all Versions are not captured successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		
		String QuantityCashInternal1 = map.get("QuantityCashInternal1");
		if (!(QuantityCashInternal1 == null)) {
			String qtr = null;
			QuantityCashInternal1 = ad.replacechartwo(QuantityCashInternal1, qtr, ',', '.');
			QuantityCashInternal1 = QuantityCashInternal1.replaceAll("[^\\d.]", "");
			double cashone = 0;
			QuantityCashInternal11 = ad.Stringtodouble(QuantityCashInternal1, cashone);
			
			System.out.println(" QuantityCashInternal Value for " + GPone + " in CashSimulationDashboard is " + QuantityCashInternal11);
			BrowserSettings.parentTest.info("QuantityCashInternal Value for " + GPone + " in CashSimulationDashboard is " + QuantityCashInternal11);
		}
		String QuantityCashInternal2 = map.get("QuantityCashInternal2");
		if (!(QuantityCashInternal2 == null)) {
			String qtr = null;
			QuantityCashInternal2 = ad.replacechartwo(QuantityCashInternal2, qtr, ',', '.');
			QuantityCashInternal2 = QuantityCashInternal2.replaceAll("[^\\d.]", "");
			double cashone = 0;
			QuantityCashInternal22 = ad.Stringtodouble(QuantityCashInternal2, cashone);
			
			System.out.println(" QuantityCashInternal Value for " + GPtwo + " in CashSimulationDashboard is " + QuantityCashInternal22);
			BrowserSettings.parentTest.info("QuantityCashInternal Value for " + GPtwo + " in CashSimulationDashboard is " + QuantityCashInternal22);
		}
		
		String QuantityCashInternal3 = map.get("QuantityCashInternal3");
		if (!(QuantityCashInternal3 == null)) {
			String qtr = null;
			QuantityCashInternal3 = ad.replacechartwo(QuantityCashInternal3, qtr, ',', '.');
			QuantityCashInternal3 = QuantityCashInternal3.replaceAll("[^\\d.]", "");
			double cashone = 0;
			QuantityCashInternal33 = ad.Stringtodouble(QuantityCashInternal3, cashone);
			
			System.out.println("QuantityCashInternal  for " + GPthree + " in CashSimulationDashboard is " + QuantityCashInternal33);
			BrowserSettings.parentTest.info("QuantityCashInternal for " + GPthree + " in CashSimulationDashboard is " + QuantityCashInternal33);
		}
		
	}
	
	public void getTotalPNV() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Calculate RBEValue Total");
		ad = new ActionDriver();

		map = new HashMap<>();
		
		
			map.put("PNVValue1",
					driver.findElement(By.xpath("(//td[text()='" + GPone + "'])[2]//following-sibling::td[4]"))
							.getText());
			map.put("PNVValue2",
					driver.findElement(By.xpath("(//td[text()='" + GPtwo + "'])[2]//following-sibling::td[4]"))
							.getText());
			map.put("PNVValue3",
					driver.findElement(By.xpath("(//td[text()='" + GPthree + "'])[2]//following-sibling::td[4]"))
							.getText());
			map.put("PNVValue4",
					driver.findElement(By.xpath("(//td[text()='" + GPfour + "'])[2]//following-sibling::td[4]"))
							.getText());
			
			String PNVValue1=map.get("PNVValue1");
			String qtr = null;
			PNVValue1 = ad.replacechartwo(PNVValue1, qtr, ',', '.');
			PNVValue1 = PNVValue1.replaceAll("[^\\d.]", "");
			double cashone = 0;
			double PNVValueone = ad.Stringtodouble(PNVValue1, cashone);
			
			String PNVValue2=map.get("PNVValue2");
			PNVValue2 = ad.replacechartwo(PNVValue2, qtr, ',', '.');
			PNVValue2 = PNVValue2.replaceAll("[^\\d.]", "");
			double PNVValuetwo = ad.Stringtodouble(PNVValue2, cashone);
			
			String PNVValue3=map.get("PNVValue3");
			PNVValue3 = ad.replacechartwo(PNVValue3, qtr, ',', '.');
			PNVValue3 = PNVValue3.replaceAll("[^\\d.]", "");
			double PNVValuethree = ad.Stringtodouble(PNVValue3, cashone);
			
			
			String PNVValue4=map.get("PNVValue4");
			PNVValue4 = ad.replacechartwo(PNVValue4, qtr, ',', '.');
			PNVValue4 = PNVValue4.replaceAll("[^\\d.]", "");
			double PNVValuefour = ad.Stringtodouble(PNVValue4, cashone);
			
			
			
			
			
			
			System.out.println(PNVValueone);
			BrowserSettings.parentTest.info("PNVValueone on Cashflow dashboard is " + PNVValueone);
			
			BrowserSettings.parentTest.info("PNVValuetwo on Cashflow dashboard is " + PNVValuetwo);
			System.out.println(PNVValuetwo);
			
			BrowserSettings.parentTest.info("PNVValuethree on Cashflow dashboard is " + PNVValuethree);
			System.out.println(PNVValuethree);
			
			BrowserSettings.parentTest.info("PNVValuefour on Cashflow dashboard is " + PNVValuefour);
			System.out.println(PNVValuefour);
			
			 TotalPNV=PNVValueone+PNVValuetwo+PNVValuethree+PNVValuefour;
			System.out.println(TotalPNV);
			BrowserSettings.parentTest.info("TotalPNVvalue on Cashflow dashboard is " + TotalPNV);
			
		
	}
	public void readDevRevLS22() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read DevCost LumpSum");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("DevCostLumpSum",
				driver.findElement(By.xpath("//td[text()=' Development revenue Lump Sum']//following-sibling::td[6]"))
						.getText());
		String DevCostLumpSum=map.get("DevCostLumpSum");
		String qtr = null;
		DevCostLumpSum = ad.replacechartwo(DevCostLumpSum, qtr, ',', '.');
		DevCostLumpSum = DevCostLumpSum.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevrevLumpSum22= ad.Stringtodouble(DevCostLumpSum, cashone);
		System.out.println("DevRevinueLumpSum in CashSimulationDashboard  for 2022 is " + DevrevLumpSum22);
		BrowserSettings.parentTest.info("DevRevinueLumpSum in CashSimulationDashboard for 2022 is " + DevrevLumpSum22);
	}
	
	public void readdevRevuneMarkup() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read devRevuneMarkup");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("devRevuneMarkup",
				driver.findElement(By.xpath("//td[text()=' Development revenue Mark Up']//following-sibling::td[6]"))
						.getText());
		String devRevuneMarkup=map.get("devRevuneMarkup");
		String qtr = null;
		devRevuneMarkup = ad.replacechartwo(devRevuneMarkup, qtr, ',', '.');
		devRevuneMarkup = devRevuneMarkup.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevrevMarkup22= ad.Stringtodouble(devRevuneMarkup, cashone);
		System.out.println("devRevuneMarkup in CashSimulationDashboard is for 2022 is " + DevrevMarkup22);
		BrowserSettings.parentTest.info("devRevuneMarkup in CashSimulationDashboard is for 2022 is " + DevrevMarkup22);
		
	}
	
	public void readNAVCustomerCostCashforOEM22() {
		//td[text()='Cost Cash for OEM']//following-sibling::td[6]
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read readNAVCustomerCostCashforOEM22");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("readNAVCustomerCostCashforOEM22",
				driver.findElement(By.xpath("//td[text()='Cost Cash for OEM']//following-sibling::td[6]"))
						.getText());
		String CostCashOEM=map.get("readNAVCustomerCostCashforOEM22");
		String qtr = null;
		CostCashOEM = ad.replacechartwo(CostCashOEM, qtr, ',', '.');
		CostCashOEM = CostCashOEM.replaceAll("[^\\d.]", "");
		double cashone = 0;
		CostCashOEM22= ad.Stringtodouble(CostCashOEM, cashone);
		System.out.println("Cost Cash OEM in CashSimulationDashboard is for 2022 is " + CostCashOEM22);
		BrowserSettings.parentTest.info("Cost Cash OEM in CashSimulationDashboard is for 2022 is " + CostCashOEM22);
		
	}
	
	public void readCashflowProjectBeforeActualization22() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Cash flowProjectBeforeActualization22");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("CFProjectBeforeActualization",
				driver.findElement(By.xpath("//td[span[text()='Cash-flow project before actualization']]//following-sibling::td[6]"))
						.getText());
		String CFPBActualization=map.get("CFProjectBeforeActualization");
		String qtr = null;
		CFPBActualization = ad.replacechartwo(CFPBActualization, qtr, ',', '.');
		CFPBActualization = CFPBActualization.replaceAll("[^\\d.]", "");
		double cashone = 0;
		CFPBActualization22= ad.Stringtodouble(CFPBActualization, cashone);
		System.out.println("Cash Flow Before Actualization on CashSimulationDashboard  for 2022 is " + CFPBActualization22);
		BrowserSettings.parentTest.info("Cash Flow Before Actualization on CashSimulationDashboard for 2022 is " + CFPBActualization22);
		
	}
	
	public void readCashflowProjectCommunatedone() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//i[@class='pi pi-chevron-right'])[5]")).click();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Cash CashflowProjectCommunatedone");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("CFProjectCommunated1",
				driver.findElement(By.xpath("//td[text()='Cash-flow project cumulated']//following-sibling::td[6]"))
						.getText());
		String CFProjectCommunated1=map.get("CFProjectCommunated1");
		String qtr = null;
		CFProjectCommunated1 = ad.replacechartwo(CFProjectCommunated1, qtr, ',', '.');
		CFProjectCommunated1 = CFProjectCommunated1.replaceAll("[^\\d.]", "");
		double cashone = 0;
		CFPCommulated= ad.Stringtodouble(CFProjectCommunated1, cashone);
		System.out.println("Cash Flow Commulated on CashSimulationDashboard  for 2022 is " + CFPCommulated);
		BrowserSettings.parentTest.info("Cash Flow Commulated on CashSimulationDashboard for 2022 is " + CFPCommulated);
		
	}
	
	public void readPBRNetPresentvalueCONTRACTUAL21() {
		
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read PBRNetPresentvalueCONTRACTUAL");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("PBRNetPresentvalueCONTRACTUAL",
				driver.findElement(By.xpath("//td[span[text()='PBR: Net Present value CONTRACTUAL']]//following-sibling::td[5]"))
						.getText());
		String PBRNetPresentvalueCONTRACTUAL=map.get("PBRNetPresentvalueCONTRACTUAL");
		String qtr = null;
		PBRNetPresentvalueCONTRACTUAL = ad.replacechartwo(PBRNetPresentvalueCONTRACTUAL, qtr, ',', '.');
		PBRNetPresentvalueCONTRACTUAL = PBRNetPresentvalueCONTRACTUAL.replaceAll("[^\\d.]", "");
		double cashone = 0;
		PBRNetPresentvalueCONTRACTUAL21= ad.Stringtodouble(PBRNetPresentvalueCONTRACTUAL, cashone);
		System.out.println("PBRNetPresentvalueCONTRACTUAL on CashSimulationDashboard  for 2021 is " + PBRNetPresentvalueCONTRACTUAL21);
		BrowserSettings.parentTest.info("PBRNetPresentvalueCONTRACTUAL on CashSimulationDashboard for 2021 is " + PBRNetPresentvalueCONTRACTUAL21);
		
		
	}
	
	public void readCashINProjectafteractualization21() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//i[@class='pi pi-chevron-right'])[3]")).click();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Cash Cash IN Project afteractualization");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("CashINProjectafteractualization",
				driver.findElement(By.xpath("//td[text()='Cash IN Project after actualization']//following-sibling::td[5]"))
						.getText());
		String CashINProjectafteractualization=map.get("CashINProjectafteractualization");
		String qtr = null;
		CashINProjectafteractualization = ad.replacechartwo(CashINProjectafteractualization, qtr, ',', '.');
		CashINProjectafteractualization = CashINProjectafteractualization.replaceAll("[^\\d.]", "");
		double cashone = 0;
		CashINProjectafteractualization21= ad.Stringtodouble(CashINProjectafteractualization, cashone);
		System.out.println("Cash IN Project afteractualization 21 on CashSimulationDashboard  for 2021 is " + CashINProjectafteractualization21);
		BrowserSettings.parentTest.info("Cash IN Project afteractualization 21 on CashSimulationDashboardon CashSimulationDashboard for 2022 is " + CashINProjectafteractualization21);
		
		
	}
	
	public void readCashOutProjectafteractualization21() throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//i[@class='pi pi-chevron-right'])[3]")).click();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read Cash OUT Project after actualization");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("CashoutProjectafteractualization",
				driver.findElement(By.xpath("//td[text()='Cash OUT Project after actualization']//following-sibling::td[5]"))
						.getText());
		String CashoutProjectafteractualization=map.get("CashoutProjectafteractualization");
		String qtr = null;
		CashoutProjectafteractualization = ad.replacechartwo(CashoutProjectafteractualization, qtr, ',', '.');
		CashoutProjectafteractualization = CashoutProjectafteractualization.replaceAll("[^\\d.]", "");
		double cashone = 0;
		CashOUTProjectafteractualization21= ad.Stringtodouble(CashoutProjectafteractualization, cashone);
		System.out.println("Cash IN Project afteractualization 21 on CashSimulationDashboard  for 2021 is " + CashOUTProjectafteractualization21);
		BrowserSettings.parentTest.info("Cash IN Project afteractualization 21 on CashSimulationDashboardon CashSimulationDashboard for 2022 is " + CashOUTProjectafteractualization21);
		
		
	}
	
	public void readPBRNetPresentvalueREAL21() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("read PBR Net Present value REAL");
		ad = new ActionDriver();

		map = new HashMap<>();
		map.put("PBRNetPresentvalueREAL",
				driver.findElement(By.xpath("//td[span[text()='PBR: Net Present value REAL']]//following-sibling::td[5]"))
						.getText());
		String PBRNetPresentvalueREAL=map.get("PBRNetPresentvalueREAL");
		String qtr = null;
		PBRNetPresentvalueREAL = ad.replacechartwo(PBRNetPresentvalueREAL, qtr, ',', '.');
		PBRNetPresentvalueREAL = PBRNetPresentvalueREAL.replaceAll("[^\\d.]", "");
		double cashone = 0;
		PBRNetPresentvalueREAL21= ad.Stringtodouble(PBRNetPresentvalueREAL, cashone);
		System.out.println("PBRNetPresentvalueREAL on CashSimulationDashboard  for 2021 is " + PBRNetPresentvalueREAL21);
		BrowserSettings.parentTest.info("PBRNetPresentvalueREAL on CashSimulationDashboard for 2021 is " + PBRNetPresentvalueREAL21);
		
	}
	
	
	
	
	//td[text()=' Development revenue Lump Sum']//following-sibling::td[6]
	public void openFinancialDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open FinancialDashboard");
		ad = new ActionDriver();
		ad.click(driver, buttonFinancialOverview, "Clicked on Financial Overview button Successfully");
		
	}
}
