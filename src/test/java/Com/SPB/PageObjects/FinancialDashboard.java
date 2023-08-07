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

public class FinancialDashboard extends BrowserSettings {

	public static String PricePce;
	public static String Quantity1;
	public static String Quantity2;
	public static String Quantity3;
	public static String AddedValue;
	public static String y1;
	
	public double Businesslink11;

	public static HashMap<String, String> FinancialFigures;
	public static HashMap<String, String> AddedValueH;
	public static HashMap<String, String> ProjectMVC;
	public static HashMap<String, String> ProjectRBC;
	public HashMap<String,String> CapexMap;
	public double capex1;
	public double DevCost1;
	public double DevCostlumpsum1;
	
	public HashMap<String,String> RBEPercent;
	public String qty1;
	public String qty2;
	public String qty3;
	public static String RBCnoper;

	public static HashMap<String, String> Y1H;
	public static String ProjectMVCper;

	public static HashMap<String, String> MVCGP;
	public static String GPMVCnoper;

	public static HashMap<String, String> RBCGP;
	public static String GPEBCnoper;

	public static HashMap<String, String> RBEGP;
	public static String GPRBEnoper;

	public static HashMap<String, String> ProjectEM;
	public static String ProjectEMper;

	public static HashMap<String, String> EMGP;
	public static String GPEMCnoper;
	
	public static HashMap<String, String> Businesslink1;
	public static HashMap<String, String> DevCostxMap;
	public HashMap<String, String> DevCostlumpsumMap;
	
	
	
	
	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	ExcelOpearations excel=new ExcelOpearations(path);

	@FindBy(xpath = "//span[text()='Financial Overview']")
	private WebElement financialDashboard;
	
	@FindBy(xpath = "//p[text()='Financial Overview']")
	private WebElement financialDashboard1;
	
	@FindBy(xpath="//span[@class='Menu']")
	private WebElement menu;
	
	ActionDriver ad;

	public FinancialDashboard() {
		PageFactory.initElements(driver, this);
	}

	public void openFinancialDashboard(String test) throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Financial Dashboard");
		ad = new ActionDriver();
		if (test=="FinancialOverview") {
			ad.click(driver, financialDashboard1, "Clicked on Financial dashbaord Successfully");
		}
		else {
		ad.click(driver, financialDashboard, "Clicked on Financial dashbaord Successfully");
		}
	}

	public String readMenu() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Financial Dashboard");
		ad = new ActionDriver();
		String Menu=ad.GetText(menu, "Read menu Successfuly");
		return Menu;
		
	}
	public void readPricepce() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readPricepce");
		FinancialFigures = new HashMap<>();
		String glassPosition=excel.getCellData("Sheet1", "Value", 26);
		try {
			FinancialFigures.put("Price/Pce", driver.findElement(By.xpath("(//span[text()=' "
					+ glassPosition + " ']//parent::td//following-sibling::td[1])[1]")).getText());
			BrowserSettings.childTest.pass("Successfully Captured Price/Pce value ");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Did not  Capture Price/Pce value Successfully ");
			BrowserSettings.childTest.info(e);
		}

		PricePce = FinancialFigures.get("Price/Pce");

		System.out.println("Price/Pce on financial dashboard is " + PricePce);

	}

	public void readQuantity() throws InterruptedException {
		
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Quantity");
		FinancialFigures = new HashMap<>();
		String glassPosition=excel.getCellData("Sheet1", "Value", 26);
		
		Thread.sleep(10000);
		try {
			FinancialFigures.put("Quantity", driver.findElement(By.xpath(
					"(//span[text()=' " + glassPosition + " ']//parent::td//following-sibling::td[2])[1]"))
					.getText());
			BrowserSettings.childTest.pass("Quantity captured successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Quantity did not captured successfully");
			BrowserSettings.childTest.info(e);
		}
		

		Quantity1 = FinancialFigures.get("Quantity");

		System.out.println("Quantity on financial dashboard is " + Quantity1);

	}
 public void readQuantityforcashflow() throws InterruptedException {
	CashSimulation cs=new CashSimulation();
		
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Quantity");
		FinancialFigures = new HashMap<>();
		
		Thread.sleep(10000);
		if(!cs.GPone.equals("NA"))
		{
		 qty1=driver.findElement(By.xpath(
				"(//span[text()=' "+cs.GPone+" ']//parent::td//following-sibling::td[2])[1]"))
				.getText();
		System.out.println(qty1);
		
		
		try {
			FinancialFigures.put("Quantity",qty1 );
			BrowserSettings.childTest.pass("Quantity captured successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Quantity did not captured successfully");
			BrowserSettings.childTest.info(e);
		}
		

		Quantity1 = FinancialFigures.get("Quantity");

		System.out.println("Quantity on financial dashboard for "+cs.GPone+" is " + Quantity1);
		BrowserSettings.parentTest.info("Quantity on financial dashboard for "+cs.GPone+" is " + Quantity1);
		}
		
		if(!cs.GPtwo.equals("NA"))
		{
		String qty2=driver.findElement(By.xpath(
				"(//span[text()=' "+cs.GPtwo+" ']//parent::td//following-sibling::td[2])[1]"))
				.getText();
		System.out.println(qty2);
		
		
		try {
			FinancialFigures.put("Quantity",qty2 );
			BrowserSettings.childTest.pass("Quantity captured successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Quantity did not captured successfully");
			BrowserSettings.childTest.info(e);
		}
		

		Quantity2 = FinancialFigures.get("Quantity");

		System.out.println("Quantity on financial dashboard for "+cs.GPtwo+" is " + Quantity2);
		BrowserSettings.parentTest.info("Quantity on financial dashboard for "+cs.GPtwo+" is " + Quantity2);
		}
		
		if(!cs.GPthree.equals("NA"))
		{
		String qty3=driver.findElement(By.xpath(
				"(//span[text()=' "+cs.GPthree+" ']//parent::td//following-sibling::td[2])[1]"))
				.getText();
		System.out.println(qty3);
		
		
		try {
			FinancialFigures.put("Quantity",qty3 );
			BrowserSettings.childTest.pass("Quantity captured successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Quantity did not captured successfully");
			BrowserSettings.childTest.info(e);
		}
		

		Quantity3 = FinancialFigures.get("Quantity");

		System.out.println("Quantity on financial dashboard for "+cs.GPthree+" is " + Quantity3);
		BrowserSettings.parentTest.info("Quantity on financial dashboard for "+cs.GPthree+" is " + Quantity3);
		}
	}


	public void AddedValue() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Quantity");
		AddedValueH = new HashMap<>();
		String glassPosition=excel.getCellData("Sheet1", "Value", 26);
		try {
			AddedValueH.put("AverageValue", driver.findElement(By.xpath(
					"(//span[text()=' " + glassPosition + " ']//parent::td//following-sibling::td[3])[1]"))
					.getText());
			BrowserSettings.childTest.pass("Added value captured Sucessfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Added value did not capture Sucessfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exceptions
		}
		

		String AddedValue1 = AddedValueH.get("AverageValue");

		AddedValue = AddedValue1.replaceAll("[^\\d.]", "");
		if(AddedValue.isEmpty()) {
			AddedValue="0.0";
		}

		System.out.println("Added value on financial dashboard is " + AddedValue);

	}

	public void SOP1() {

	}

	public void Y1() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Y1");
		Y1H = new HashMap<>();
		try {
			String glassPosition=excel.getCellData("Sheet1", "Value", 26);
			Y1H.put("Y1 Value", driver.findElement(By.xpath(
					"(//span[text()=' " + glassPosition + " ']//parent::td//following-sibling::td[5])[1]"))
					.getText());
			BrowserSettings.childTest.pass("Y1  captured Sucessfully");
			
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Did not Capture the Y1  captured Sucessfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		

		y1 = Y1H.get("Y1 Value");

		System.out.println("Y1 value on financial dashboard is " + y1);

	}

	public void ProjectMVC() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("ProjectMVC");
		ProjectMVC = new HashMap<>();
		try {
			ProjectMVC.put("ProjectMVC",
					driver.findElement(By.xpath("(//td[text()='MVC %'])[1]//following-sibling::td[5]")).getText());
			BrowserSettings.childTest.pass("ProjectMVC Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("ProjectMVC did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		ProjectMVCper = ProjectMVC.get("ProjectMVC");
		System.out.println("Project MVC value on financial dashboard table is " + ProjectMVCper);
	}

	public void MVCGP() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read MVCGP");
		MVCGP = new HashMap<>();
		try {
			String glassPosition=excel.getCellData("Sheet1", "Value", 26);
			MVCGP.put("GPMVC", driver.findElement(By.xpath(
					"(//span[text()=' " + glassPosition + " '])[2]//parent::td//following-sibling::td[5]"))
					.getText());
			BrowserSettings.childTest.pass("MVCGP Captured Successfully");
			
		} catch (Exception e) {
			BrowserSettings.childTest.fail("MVCGP did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		GPMVCnoper = MVCGP.get("GPMVC");
		// GPMVCnoper=GPMVCnoperup.replaceAll("[^\\d.]", "");
		System.out.println("GP MVC value on financial dashboard table is " + GPMVCnoper);

	}

	public void ProjectRBC() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read ProjectRBC");
		ProjectRBC = new HashMap<>();
		try {
			ProjectRBC.put("ProjectRBC",
					driver.findElement(By.xpath("(//td[text()='RBC %'])[1]//following-sibling::td[5]")).getText());
			BrowserSettings.childTest.pass("ProjectRBC Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("ProjectRBC did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		RBCnoper = ProjectRBC.get("ProjectRBC");
		System.out.println("Project RBC value on financial dashboard table is " + RBCnoper);
	}

	public void RBCGP() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read RBCGP");
		RBCGP = new HashMap<>();
		try {
			RBCGP.put("GPRBC", driver.findElement(By.xpath(
					"(//span[text()=' " + ProjectDashboard.glassPosition + " '])[3]//parent::td//following-sibling::td[5]"))
					.getText());
			BrowserSettings.childTest.pass("RBCGP Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("RBCGP did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		GPEBCnoper = RBCGP.get("GPRBC");
		// GPMVCnoper=GPMVCnoperup.replaceAll("[^\\d.]", "");
		System.out.println("GP RBC value on financial dashboard table is " + GPEBCnoper);

	}

	public void RBEGP() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read RBEGP");
		RBEGP = new HashMap<>();
		try {
			RBEGP.put("GPRBE", driver.findElement(By.xpath(
					"(//span[text()=' " + ProjectDashboard.glassPosition + " '])[4]//parent::td//following-sibling::td[5]"))
					.getText());
			BrowserSettings.childTest.pass("GPRBE Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("GPRBE did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		GPRBEnoper = RBEGP.get("GPRBE");
		// GPMVCnoper=GPMVCnoperup.replaceAll("[^\\d.]", "");
		System.out.println("GP RBE value on financial dashboard table is " + GPRBEnoper);

	}

	public void ProjectEM() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read ProjectEM");
		ProjectEM = new HashMap<>();
		try {
			ProjectEM.put("ProjectEM",
					driver.findElement(By.xpath("(//td[text()='EM %'])[1]//following-sibling::td[5]")).getText());
			BrowserSettings.childTest.pass("ProjectEM Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("ProjectEM did Captured Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		ProjectEMper = ProjectEM.get("ProjectEM");
		System.out.println("Project RBC value on financial dashboard table is " + ProjectEMper);
	}

	public void EMGP() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read EMGP");
		EMGP = new HashMap<>();
		try {
			EMGP.put("GPEM", driver.findElement(By.xpath(
					"(//span[text()=' " + ProjectDashboard.glassPosition + " '])[5]//parent::td//following-sibling::td[5]"))
					.getText());
			BrowserSettings.childTest.pass("EMGP Captured Successfully");
		} catch (Exception e) {
			BrowserSettings.childTest.fail("EMGP did not Capture Successfully");
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		GPEMCnoper = EMGP.get("GPEM");
		// GPMVCnoper=GPMVCnoperup.replaceAll("[^\\d.]", "");
		System.out.println("GP RBC value on financial dashboard table is " + GPEMCnoper);

	}

	public double readRBEPercentage(String GlassPosition) {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read ReadRBE Percentage");
		RBEPercent = new HashMap<>();
		ad = new ActionDriver();

		RBEPercent.put("RBEPercentage", driver.findElement(By.xpath("(//tr[td//text()=' "+GlassPosition+" '][4]//following-sibling::tr[td//text()='RBE %'][1]//td[6])")).getText());
		String RBEPercentage=RBEPercent.get("RBEPercentage");
		String qtr = null;
		RBEPercentage = ad.replacechartwo(RBEPercentage, qtr, ',', '.');
		RBEPercentage = RBEPercentage.replaceAll("[^\\d.]", "");
		double cashone = 0;
		double RBEPercentage1 = ad.Stringtodouble(RBEPercentage, cashone);
		RBEPercentage1=RBEPercentage1 % 100;
		return RBEPercentage1;

	}
	
	public void readBusinessLink() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Business Link");
		Businesslink1 = new HashMap<>();
		ad = new ActionDriver();

		Businesslink1.put("Businesslink", driver.findElement(By.xpath("(//td[text()='Business Link'])[2]//following-sibling::td[5]")).getText());
		String Businesslink=Businesslink1.get("Businesslink");
		String qtr = null;
		Businesslink = ad.replacechartwo(Businesslink, qtr, ',', '.');
		Businesslink = Businesslink.replaceAll("[^\\d.]", "");
		double cashone = 0;
		 Businesslink11 = ad.Stringtodouble(Businesslink, cashone);
		BrowserSettings.parentTest.info("Bussiness link value on Financial Overview Dashboard is " +Businesslink11 );
		
		
		
	}
	
	public void readCapex() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Business Link");
		CapexMap = new HashMap<>();
		ad = new ActionDriver();

		CapexMap.put("Capex", driver.findElement(By.xpath("(//td[text()='Business Link'])[2]//following-sibling::td[5]")).getText());
		String Capex=CapexMap.get("Capex");
		String qtr = null;
		Capex = ad.replacechartwo(Capex, qtr, ',', '.');
		Capex = Capex.replaceAll("[^\\d.]", "");
		double cashone = 0;
		capex1 = ad.Stringtodouble(Capex, cashone);
		BrowserSettings.parentTest.info("Capex value on Financial Overview Dashboard is " +capex1 );
		
		}
	
	public void readDevCost() {
		
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Dev Cost");
		DevCostxMap = new HashMap<>();
		ad = new ActionDriver();

		DevCostxMap.put("DevCost", driver.findElement(By.xpath("//td[text()='Dev Cost']//following-sibling::td[4]")).getText());
		String DevCost=DevCostxMap.get("DevCost");
		String qtr = null;
		DevCost = ad.replacechartwo(DevCost, qtr, ',', '.');
		DevCost = DevCost.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevCost1 = ad.Stringtodouble(DevCost, cashone);
		System.out.println("DevCost value on Financial Overview Dashboard is " + DevCost1);
		BrowserSettings.parentTest.info("DevCost value on Financial Overview Dashboard is " + DevCost1 );
		
	}
	
	public void readDevCostLumpSum() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read DevCostLumpSum");
		DevCostlumpsumMap = new HashMap<>();
		ad = new ActionDriver();

		DevCostlumpsumMap.put("DevCostlumpsum", driver.findElement(By.xpath("//td[text()='Dev Revenue - Lumpsum']//following-sibling::td[4]")).getText());
		String DevCostlumpsum=DevCostlumpsumMap.get("DevCostlumpsum");
		String qtr = null;
		DevCostlumpsum = ad.replacechartwo(DevCostlumpsum, qtr, ',', '.');
		DevCostlumpsum = DevCostlumpsum.replaceAll("[^\\d.]", "");
		double cashone = 0;
		DevCostlumpsum1 = ad.Stringtodouble(DevCostlumpsum, cashone);
		System.out.println("DevCostlumpsum value on Financial Overview Dashboard is " + DevCostlumpsum1);
		BrowserSettings.parentTest.info("DevCostlumpsum value on Financial Overview Dashboard is " + DevCostlumpsum1 );
		
	}

}
