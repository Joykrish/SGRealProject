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
import Com.SPB.Configration.Log;

public class ProjectSimulation extends BrowserSettings {
	ActionDriver ad;
	/*
	 * 
	 * public static String yearlyQTYVersionTwo; public static String
	 * yearlyQTYVersionThree; public static String yearlyQTYVersionFour;
	 */
	public static HashMap<String, String> map;
	public static String fileName = "PriceBuilderData.xlsx";
	public static String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	public static ExcelOpearations excel=new ExcelOpearations(path);
	public static String Version1 = excel.getCellData("Sheet1", "Value", 30);
	public static String Version2 = excel.getCellData("Sheet1", "Value", 31);
	public static String Version3 = excel.getCellData("Sheet1", "Value", 32);

	public static double yearlyQTV1F1;
	public static double yearlyQTV2FF1;
	public static double yearlyQTV3FFF1;

	public static double ComSurV1;

	public static double ComSurV2;

	public static double ComSurV3;

	public static double pnvVersion1;
	public static double pnvVersion2;
	public static double pnvVersion3;

	public static double QPV11;
	public static double QPV22;
	public static double QPV33;

	public static String AVV1;
	public static String AVV2;
	public static String AVV3;

	public static String TCV1;
	public static String TCV2;
	public static String TCV3;

	public static String EMCV1;
	public static String EMCV2;
	public static String EMCV3;

	public static String MVCV1;
	public static String MVCV2;
	public static String MVCV3;

	public static String RBCV1;
	public static String RBCV2;
	public static String RBCV3;

	public static String EM5V1;
	public static String EM5V2;
	public static String EM5V3;
	
	public static String EMYV1;

	public static String DevCostV11;
	public static String DevCostV22;
	public static String DevCostV33;

	public static String DevRevenueV11;
	public static String DevRevenueV22;
	public static String DevRevenueV33;

	public static String PBRV11;
	public static String PBRV22;
	public static String PBRV33;

	@FindBy(xpath = "//p[text()='Simulation']//parent::div[@class='simulate-dashboard']")
	private WebElement simulationDashboard;

	public ProjectSimulation() {
		PageFactory.initElements(driver, this);
	}

	public void openSimulationDashboard() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Open Simulation Dashboard");
		ad = new ActionDriver();

		ad.click(driver, simulationDashboard, "Clicked on SimulationDashboard Successfully");
		// driver.findElement(By.xpath("//p[text()='Simulation']//parent::div[@class='simulate-dashboard']")).click();

		Log.info("Clicked on Simulation");
	}

	public void yearlyQuatities() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode(" Read yearlyQuatities");
		ad = new ActionDriver();

		map = new HashMap<>();
		try {
			
		
		if (!Version1.equals("NA")) {
			map.put("yearlyQTYVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][1]"))
					.getText());
		}
		if (!Version2.equals("NA")) {
			map.put("yearlyQTYVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][1]"))
					.getText());
		}
		if (!Version3.equals("NA"))

		{
			map.put("yearlyQTYVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][1]"))
					.getText());
		}
		BrowserSettings.childTest.pass("yearlyQTY for all Versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable capture to yearlyQTY for all Versions successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

		String yearlyQTYVersionOne = map.get("yearlyQTYVone");
		if (!(yearlyQTYVersionOne == null)) {

			String yearlyQTV1U = null;
			String yearlyQTV1U1 = ad.replacechar(yearlyQTYVersionOne, yearlyQTV1U, ',');
			System.out.println(yearlyQTV1U1);
			double yearlyQTV1D = 0;
			double yearlyQTV1D1 = ad.Stringtodouble(yearlyQTV1U1, yearlyQTV1D);
			System.out.println(yearlyQTV1D1);
			yearlyQTV1F1 = ad.Mathround(yearlyQTV1D1, yearlyQTV1F1);

			System.out.println(yearlyQTV1F1);

			System.out.println("Yearly Quantity for version1 in SimulationDashboard is " + yearlyQTV1F1);
		}
		String yearlyQTYVersionTwo = map.get("yearlyQTYVtwo");
		if (!(yearlyQTYVersionTwo == null)) {

			String yearlyQTV2UU = null;
			String yearlyQTV2UU1 = ad.replacechar(yearlyQTYVersionTwo, yearlyQTV2UU, ',');
			System.out.println(yearlyQTV2UU1);
			double yearlyQTV2DD = 0;
			double yearlyQTV2DD1 = ad.Stringtodouble(yearlyQTV2UU1, yearlyQTV2DD);
			System.out.println(yearlyQTV2DD1);
			yearlyQTV2FF1 = ad.Mathround(yearlyQTV2DD1, yearlyQTV2FF1);

			System.out.println(yearlyQTV2FF1);

			System.out.println("Yearly Quantity for version2 in SimulationDashboard is " + yearlyQTV2FF1);
		}

		String yearlyQTYVersionThree = map.get("yearlyQTYVthree");
		if (!(yearlyQTYVersionThree == null)) {

			String yearlyQTV3UUU = null;
			String yearlyQTV3UUU1 = ad.replacechar(yearlyQTYVersionThree, yearlyQTV3UUU, ',');
			System.out.println(yearlyQTV3UUU1);
			double yearlyQTV3DDD = 0;
			double yearlyQTV3DDD1 = ad.Stringtodouble(yearlyQTV3UUU1, yearlyQTV3DDD);
			System.out.println(yearlyQTV3DDD1);
			yearlyQTV3FFF1 = ad.Mathround(yearlyQTV3DDD1, yearlyQTV3FFF1);

			System.out.println(yearlyQTV3FFF1);

			System.out.println("Yearly Quantity for version3 in SimulationDashboard is " + yearlyQTV3FFF1);
		}
	}

	public void commonSurface() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode(" Read commonSurface");
		ad = new ActionDriver();
		map = new HashMap<>();
		try {
			
		
		if (!Version1.equals("NA")) {
			map.put("commonSurfaceVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][1]"))
					.getText());
		}
		if (!Version2.equals("NA")) {
			map.put("commonSurfaceVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][1]"))
					.getText());
		}
		if (!Version3.equals("NA"))

		{
			map.put("commonSurfaceVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][1]"))
					.getText());
		}
		BrowserSettings.childTest.pass("CommonSurface for all versions are captured successfully");
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable to read CommonSurface for all versions are captured successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		String commonSurfaceV1 = map.get("commonSurfaceVone");

		if (!(commonSurfaceV1 == null)) {
			double ComSurV = 0;
			ComSurV1 = ad.Stringtodouble(commonSurfaceV1, ComSurV);
			// double newone = 0;
			// ComSurV1=ad.Mathround(ComSurV1, newone);
			System.out.println("Common Surface Value for V1 on Simulation Dashboard is " + ComSurV1);

		}
		String commonSurfaceV2 = map.get("commonSurfaceVtwo");
		if (!(commonSurfaceV2 == null)) {
			double ComSurV = 0;
			ComSurV2 = ad.Stringtodouble(commonSurfaceV2, ComSurV);
			System.out.println("Common Surface Value for V2 on Simulation Dashboard is " + ComSurV2);

		}
		String commonSurfaceV3 = map.get("commonSurfaceVthree");
		if (!(commonSurfaceV3 == null)) {
			double ComSurV = 0;
			ComSurV3 = ad.Stringtodouble(commonSurfaceV3, ComSurV);
			System.out.println("Common Surface Value for V3 on Simulation Dashboard is " + ComSurV3);

		}

	}

	public void pnv() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select pnv");
		ad = new ActionDriver();
		map = new HashMap<>();
		try {
			
		
		if (!Version1.equals("NA")) {
			map.put("PNVVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][2]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("PNVVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][2]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("PNVVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center;background-color:	#D3D3D3;'][2]"))
					.getText());
			BrowserSettings.childTest.pass("PNV for all versions captured Successfully");
		}
		} catch (Exception e) {
			BrowserSettings.parentTest.fail("Unable to capture PNV for all versions Successfully");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		String pnvV1 = map.get("PNVVone");
		System.out.println(pnvV1);
		if (!(pnvV1 == null)) {
			String pnv1 = null;
			String pnvV11 = ad.replacechartwo(pnvV1, pnv1, ',', '.');
			String str = pnvV11.replaceAll("[^\\d.]", "");
			System.out.println(str);
			double pnv = 0;
			pnvVersion1 = ad.Stringtodouble(str, pnv);
			System.out.println("PNVk for Version 1 on Simulation Dashboard is= " + pnvVersion1);
		}

		String pnvV2 = map.get("PNVVtwo");
		System.out.println(pnvV2);
		if (!(pnvV2 == null)) {
			String pnv2 = null;
			String pnvV22 = ad.replacechartwo(pnvV2, pnv2, ',', '.');
			String str1 = pnvV22.replaceAll("[^\\d.]", "");
			System.out.println(str1);
			double pnvv = 0;
			pnvVersion2 = ad.Stringtodouble(str1, pnvv);
			System.out.println("PNVk for Version 2 on Simulation Dashboard is= " + pnvVersion2);
		}

		String pnvV3 = map.get("PNVVthree");
		System.out.println(pnvV3);
		if (!(pnvV3 == null)) {
			String pnv3 = null;
			String pnvV33 = ad.replacechartwo(pnvV3, pnv3, ',', '.');
			String str2 = pnvV33.replaceAll("[^\\d.]", "");
			System.out.println(str2);
			double pnvvv = 0;
			pnvVersion3 = ad.Stringtodouble(str2, pnvvv);
			System.out.println("PNVk for Version 3 on Simulation Dashboard is= " + pnvVersion3);
		}

	}

	public void QuotedPrice() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select QuotedPrice");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("QuotedPriceVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][2]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("QuotedPriceVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][2]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("QuotedPriceVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][2]"))
					.getText());
			

		}
		BrowserSettings.childTest.pass("QuotedPrice for all versions Captured successfully");
} catch (Exception e) {
	BrowserSettings.parentTest.fail("Unable to capture QuotedPrice for all versions successfully");
	BrowserSettings.childTest.info(e);
	throw e;

	// TODO: handle exception
}
		String QutedPriceV1 = map.get("QuotedPriceVone");
		System.out.println(QutedPriceV1);
		if (!(QutedPriceV1 == null)) {
			
			String QPV1 = ad.replacechartwo(QutedPriceV1, "string",',','.');
			QPV1=QPV1.replaceAll("[^\\d.]", "");
			double a=0.0;
			QPV11=ad.Stringtodouble(QPV1,a );
			System.out.println(QPV11);

			System.out.println("QuotedPrice for Version 1 on Simulation Dashboard is= " + QPV1);
		}
		String QutedPriceV2 = map.get("QuotedPriceVtwo");
		System.out.println(QutedPriceV2);
		if (!(QutedPriceV2 == null)) {
			String QPV2 = ad.replacechartwo(QutedPriceV2, "string",',','.');
			QPV2=QPV2.replaceAll("[^\\d.]", "");
			double a=0.0;
			QPV22=ad.Stringtodouble(QPV2,a );
			System.out.println(QPV22);

			System.out.println("QuotedPrice for Version 2 on Simulation Dashboard is= " + QPV22);
		}
		String QutedPriceV3 = map.get("QuotedPriceVthree");
		System.out.println(QutedPriceV3);
		if (!(QutedPriceV3 == null)) {
			String QPV3 = ad.replacechartwo(QutedPriceV3, "string",',','.');
			QPV3=QPV3.replaceAll("[^\\d.]", "");
			double a=0.0;
			QPV33=ad.Stringtodouble(QPV3,a );
			System.out.println(QPV33);

			System.out.println("QuotedPrice for Version 3 on Simulation Dashboard is= " + QPV33);
		}
	}

	public void addedValue() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select addedValue");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("AddedValueVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][3]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("AddedValueVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][3]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("AddedValueVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][3]"))
					.getText());

		}
		BrowserSettings.parentTest.pass("Captured Added value for all version successfully");
} catch (Exception e) {
	BrowserSettings.parentTest.fail(" Unable Captured Added value for all version successfully");
	BrowserSettings.childTest.info(e);
	throw e;
	// TODO: handle exception
}
		String AVV11 = map.get("AddedValueVone");
		if (!(AVV11 == null)) {
			AVV1 = AVV11.replaceAll(" ", "");

			System.out.println("Added Value for Version1 on Simulation Dashboard is " + AVV1);
		}

		String AVV22 = map.get("AddedValueVtwo");
		if (!(AVV22 == null)) {
			AVV2 = AVV22.replaceAll(" ", "");
			System.out.println("Added Value for Version2 on Simulation Dashboard is " + AVV2);
		}

		String AVV33 = map.get("AddedValueVthree");
		if (!(AVV33 == null)) {
			AVV3 = AVV33.replaceAll(" ", "");
			System.out.println("Added Value for Version3 on Simulation Dashboard is " + AVV3);
		}

	}

	public void totalCost() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read totalCost");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	
	if (!Version1.equals("NA")) {
			map.put("TotalCostVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][4]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("TotalCostVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][4]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("TotalCostVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][4]"))
					.getText());

		}
		BrowserSettings.childTest.pass("Total Cost for all Versions captured successfully");
} catch (Exception e) {
	// TODO: handle exception
	BrowserSettings.parentTest.fail("Unable to Total Cost for all Versions captured successfully");
	BrowserSettings.childTest.info(e);
	throw e;
}
	
		TCV1 = map.get("TotalCostVone");
		if (!(TCV1 == null)) {
			System.out.println("Total cost for Version1 on Simulation Dashboard=" + TCV1);
		}

		TCV2 = map.get("TotalCostVtwo");

		if (!(TCV2 == null)) {
			System.out.println("Total cost for Version2 on Simulation Dashboard=" + TCV2);
		}
		TCV3 = map.get("TotalCostVthree");
		if (!(TCV3 == null)) {
			System.out.println("Total cost for Version3 on Simulation Dashboard=" + TCV3);
		}

	}

	public void ExternalMark() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read ExternalMark");
		
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	
	if (!Version1.equals("NA")) {
			map.put("ExternalMarkUpVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][5]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("ExternalMarkUpVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][5]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("ExternalMarkUpVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][5]"))
					.getText());

		}
		BrowserSettings.childTest.pass("ExternalMarkUp for all versions captured successfully");
} catch (Exception e) {
	BrowserSettings.parentTest.fail("Unable to capture ExternalMarkUp for all versions successfully");
	BrowserSettings.childTest.info(e);
	throw e;
	// TODO: handle exception
}
	
		EMCV1 = map.get("ExternalMarkUpVone");
		if (!(EMCV1 == null)) {
			System.out.println(" External Markup for Version1 on Simulation Dashboard=" + EMCV1);
		}

		EMCV2 = map.get("ExternalMarkUpVtwo");
		if (!(EMCV2 == null)) {
			System.out.println(" External Markup for Version1 on Simulation Dashboard=" + EMCV2);
		}
		EMCV3 = map.get("ExternalMarkUpVthree");
		if (!(EMCV3 == null)) {
			System.out.println(" External Markup for Version1 on Simulation Dashboard=" + EMCV3);
		}

	}

	public void ExternalMarkupYear() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode(" Read ExternalMarkupYear");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("ExternalMarkupyearVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][6]"))
					.getText());

		}
		BrowserSettings.childTest.pass("ExternalMarkupYear value read successfully");
} catch (Exception e) {
	BrowserSettings.parentTest.fail("Unable to read ExternalMarkupYear value successfully");
	BrowserSettings.childTest.info(e);
	throw e;
	// TODO: handle exception
}

		EMYV1 = map.get("ExternalMarkupyearVone");
		if (!(EMYV1 == null)) {
			System.out.println(" External Markup year for Version1 on Simulation Dashboard=" + EMYV1);
		}

	}

	public void MVCpercent() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode(" Read MVCpercent");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("MVC%yearVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][7]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("MVC%yearVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][7]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("MVC%yearVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][7]"))
					.getText());

		}
		BrowserSettings.childTest.pass("MVC%year for all versions captured successfully");
} catch (Exception e) {
	// TODO: handle exception
	BrowserSettings.parentTest.fail("MVC%year for all versions captured is not captured successfully");
	BrowserSettings.childTest.info(e);
	throw e;
}
		MVCV1 = map.get("MVC%yearVone");
		if (!(MVCV1 == null)) {
			System.out.println(" MVC  for Version1 on Simulation Dashboard=" + MVCV1);
		}
		MVCV2 = map.get("MVC%yearVtwo");
		if (!(MVCV2 == null)) {
			System.out.println(" MVC  for Version2 on Simulation Dashboard=" + MVCV2);
		}
		MVCV3 = map.get("MVC%yearVthree");
		if (!(MVCV3 == null)) {
			System.out.println(" MVC for Version3 on Simulation Dashboard=" + MVCV3);
		}
	}

	public void RBCpercent() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read RBCpercent");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("RBC%Vone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][8]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("RBC%Vtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][8]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("RBC%Vthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][8]"))
					.getText());

		}
		BrowserSettings.childTest.pass("RBC% value for all versions are captured successfully");
} catch (Exception e) {
	// TODO: handle exception
	BrowserSettings.parentTest.fail(" Unable to capture RBC% value for all versions successfully");
	BrowserSettings.childTest.info(e);
	throw e;
}
		RBCV1 = map.get("RBC%Vone");
		if (!(RBCV1 == null)) {
			System.out.println(" RBC  for Version1 on Simulation Dashboard=" + RBCV1);
		}
		RBCV2 = map.get("RBC%Vtwo");
		if (!(RBCV2 == null)) {
			System.out.println(" RBC  for Version2 on Simulation Dashboard=" + RBCV2);
		}
		RBCV3 = map.get("RBC%Vthree");
		if (!(RBCV2 == null)) {
			System.out.println(" RBC for Version3 on Simulation Dashboard=" + RBCV3);
		}
	}

	public void EM5years() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read EM5years");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	

		if (!Version1.equals("NA")) {
			map.put("EM5Vone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][9]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("EM5Vtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][9]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("EM5Vthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][9]"))
					.getText());

		}
		BrowserSettings.parentTest.pass("EM5 for all versions captured successfully");
		
} catch (Exception e) {
	// TODO: handle exception
	BrowserSettings.parentTest.fail(" Unable to capture EM5 for all versions successfully");
	BrowserSettings.childTest.info(e);
	throw e;
}
		EM5V1 = map.get("EM5Vone");
		if (!(EM5V1 == null)) {
			System.out.println(" EM  for Version1 on Simulation Dashboard=" + EM5V1);
		}
		EM5V2 = map.get("EM5Vtwo");
		if (!(EM5V2 == null)) {
			System.out.println(" EM  for Version2 on Simulation Dashboard=" + EM5V2);
		}
		EM5V3 = map.get("EM5Vthree");
		if (!(EM5V3 == null)) {
			System.out.println(" EM for Version3 on Simulation Dashboard=" + EM5V3);
		}
	}

	public void devCost() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read devCost");
		ad = new ActionDriver();
		map = new HashMap<>();
try {
	
		if (!Version1.equals("NA")) {
			map.put("devCostVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][10]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("devCostVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][10]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("devCostVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][10]"))
					.getText());

		}
		BrowserSettings.childTest.pass("devCost for all versions captured successfully");

} catch (Exception e) {
	BrowserSettings.parentTest.fail("devCost for all versions is not captured successfully");
	BrowserSettings.childTest.info(e);
	throw e;
	// TODO: handle exception
}
		String DCV1 = map.get("devCostVone");
		if (!(DCV1 == null)) {
			String DevCostV1 = ad.replacechartwo(DCV1, "new", ',', '.');
			DevCostV11 = DevCostV1.replaceAll("[^\\d.]", "");
			System.out.println(" DevCost for Version1 on Simulation Dashboard=" + DevCostV11);
		}
		String DCV2 = map.get("devCostVtwo");
		if (!(DCV2 == null)) {
			String DevCostV2 = ad.replacechartwo(DCV2, "new", ',', '.');
			DevCostV22 = DevCostV2.replaceAll("[^\\d.]", "");

			System.out.println(" DevCost  for Version2 on Simulation Dashboard=" + DevCostV22);
		}
		String DCV3 = map.get("devCostVthree");
		if (!(DCV3 == null)) {

			String DevCostV3 = ad.replacechartwo(DCV3, "new", ',', '.');
			DevCostV33 = DevCostV3.replaceAll("[^\\d.]", "");
			System.out.println(" DevCost for Version3 on Simulation Dashboard=" + DevCostV33);
		}

	}

	public void devRevenue() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read devRevenue");
		ad = new ActionDriver();
		map = new HashMap<>();
		try {
			
		

		if (!Version1.equals("NA")) {
			map.put("devRevenuetVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][11]"))
					.getText());

		}
		if (!Version2.equals("NA")) {
			map.put("devRevenuetVtwo", driver.findElement(By.xpath("(//td[contains(text(),'" + Version2
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][11]"))
					.getText());

		}

		if (!Version3.equals("NA")) {
			map.put("devRevenuetVthree", driver.findElement(By.xpath("(//td[contains(text(),'" + Version3
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][11]"))
					.getText());

		}
		BrowserSettings.childTest.pass("devRevenue for all version captured successfully");
		} catch (Exception e) {
			
			// TODO: handle exception
			BrowserSettings.parentTest.fail("devRevenue for all version captured is not captured successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}
		String DRV1 = map.get("devRevenuetVone");
		if (!(DRV1 == null)) {
			String DevrevenueV1 = ad.replacechartwo(DRV1, "new", ',', '.');
			DevRevenueV11 = DevrevenueV1.replaceAll("[^\\d.]", "");
			System.out.println(" DevRevenue for Version1 on Simulation Dashboard=" + DevRevenueV11);
		}
		String DRV2 = map.get("devRevenuetVtwo");
		if (!(DRV2 == null)) {
			String DevRevennueV2 = ad.replacechartwo(DRV2, "new", ',', '.');
			DevRevenueV22 = DevRevennueV2.replaceAll("[^\\d.]", "");

			System.out.println(" DevRevenue  for Version2 on Simulation Dashboard=" + DevRevenueV22);
		}
		String DRV3 = map.get("devRevenuetVthree");
		if (!(DRV3 == null)) {

			String DevRevenueV3 = ad.replacechartwo(DRV3, "new", ',', '.');
			DevRevenueV33 = DevRevenueV3.replaceAll("[^\\d.]", "");
			System.out.println(" DevRevenue for Version3 on Simulation Dashboard=" + DevRevenueV33);
		}

	}

	public void PBR() {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Read PBR");

		ad = new ActionDriver();
		map = new HashMap<>();
try {
	
	if (!Version1.equals("NA")) {
			map.put("PBRVone", driver.findElement(By.xpath("(//td[contains(text(),'" + Version1
					+ "')])[1]//following-sibling::td[@style='text-align: center; background-color: rgb(144, 238, 144);'][12]"))
					.getText());

		}
	BrowserSettings.childTest.pass("PBR for version one captured successfully");
		
	} catch (Exception e) {
		// TODO: handle exception
		BrowserSettings.parentTest.fail("PBR for version one is not captured successfully");
		BrowserSettings.childTest.info(e);
		throw e;
	}
		String PBRV = map.get("PBRVone");
		if (!(PBRV == null)) {
			String PBRV1 = ad.replacechartwo(PBRV, "new", ',', '.');
			PBRV11 = PBRV1.replaceAll("[^\\d.]", "");
			System.out.println(" PBR for Version1 on Simulation Dashboard=" + PBRV11);
		}

	}
}
