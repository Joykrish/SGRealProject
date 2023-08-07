package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class CostDashboard extends BrowserSettings {

	public static String pnvOnCost;
	public static String mvcOnCost;
	public static String rbcOnCost;
	public static String emOnCost;
	public static String pbrOnCost;

	public static String pnvOnCostGP;
	public static String mvcOnCostGP;
	public static String rbcOnCostGP;
	public static String emOnCostGP;
	public static String pbrOnCostGP;
	public static HashMap<String, String> yearlyQTYmap;
	public static double V1YearlyQTYF11;
	public static double V2YearlyQTYF1111;
	public static double V3YearlyQTYF11112;

	public static HashMap<String, String> pnvyear1map;
	public static double PNVY111V1111;
	public static double PNVY111V2222;
	public static double PNVY111V3333;

	public static HashMap<String, String> QuotedPRicemap;
	public static double QuotedPriceV11;
	public static double QuotedPriceV22;
	public static double QuotedPriceV33;

	public static HashMap<String, String> TotalCostmap;
	public static String TotalCostV1;
	public static String TotalCostV2;
	public static String TotalCostV3;

	public static HashMap<String, String> ExtendedMarkupmap;
	public static String ExtendedMarginV1;
	public static String ExtendedMarginV2;
	public static String ExtendedMarginV3;

	public static HashMap<String, String> ExtendedMarkupmapYear;

	public static String exMarkUP;

	public static HashMap<String, String> MVCmap;

	public static String MVCV1;
	public static String MVCV2;
	public static String MVCV3;

	public static HashMap<String, String> RBCmap;
	public static String RBCV1;
	public static String RBCV2;
	public static String RBCV3;

	public static HashMap<String, String> EMmap;
	public static String EMV1;
	public static String EMV2;
	public static String EMV3;

	public static HashMap<String, String> DevCostmap;
	public static String DevCostV1;
	public static String DevCostV2;
	public static String DevCostV3;

	public static HashMap<String, String> DevRevenuemap;
	public static String DevRevenueV1;
	public static String DevRevenueV2;
	public static String DevRevenueV3;

	public static HashMap<String, String> PBRmap;
	public static String PBRV1;

	public static HashMap<String, String> PNVY1;
	public static String PNVY1K;

	public static HashMap<String, String> MarginVarCostmap;
	public static String MarginVarcost;

	public static HashMap<String, String> RBCNPmap;
	public static String RBCNP;

	public static HashMap<String, String> RBENPmap;
	public static String RBENP;

	public static HashMap<String, String> EMNPmap;
	public static String EMNP;

	ActionDriver ad;

	@FindBy(xpath = "//td[text()=' PNV Year 1(k)']//following-sibling::td[@class='gray-back']")
	private WebElement pnvY1;

	@FindBy(xpath = "//td[text()=' PNV Year 1(k)']//following-sibling::td[@class='blue-back']")
	private WebElement pnvGP;

	@FindBy(xpath = "//td[text()=' MVC% ']//following-sibling::td[@class='gray-back']")
	private WebElement mvcY1;

	@FindBy(xpath = "//td[text()=' MVC% ']//following-sibling::td[@class='blue-back']")
	private WebElement mvcGP;

	@FindBy(xpath = "//td[text()=' RBC% ']//following-sibling::td[@class='gray-back']")
	private WebElement RBCY1;

	@FindBy(xpath = "//td[text()=' RBC% ']//following-sibling::td[@class='blue-back']")
	private WebElement RBCGP;

	@FindBy(xpath = "//td[text()=' EM% 5 years']//following-sibling::td[@class='gray-back']")
	private WebElement EM;

	@FindBy(xpath = "//td[text()=' EM% 5 years']//following-sibling::td[@class='blue-back']")
	private WebElement EMGP;

	@FindBy(xpath = "//td[text()=' Dev Revenue (lump sum…)']//following-sibling::td[@class='bold item-white-back'][2]")
	private WebElement PBR;

	@FindBy(xpath = "//td[text()=' Dev Revenue (lump sum…)']//following-sibling::td[@class='bold item-white-back'][1]")
	private WebElement PBRGP;

	@FindBy(xpath = "(//tr[@class='bold ng-star-inserted'])[3]//td[3]")
	private WebElement version1YearlyQTY;

	@FindBy(xpath = "(//tr[@class='bold ng-star-inserted'])[3]//td[5]")
	private WebElement version2YearlyQTY;

	@FindBy(xpath = "(//tr[@class='bold ng-star-inserted'])[3]//td[7]")
	private WebElement version3YearlyQTY;

	@FindBy(xpath = "//td[text()=' PNV Year 1(k)']//following-sibling::td[@style='text-align: center'][2]")
	private WebElement pnvVersion1;

	@FindBy(xpath = "//td[text()=' PNV Year 1(k)']//following-sibling::td[@style='text-align: center'][4]")
	private WebElement pnvVersion2;

	@FindBy(xpath = "//td[text()=' PNV Year 1(k)']//following-sibling::td[@style='text-align: center'][6]")
	private WebElement pnvVersion3;

	@FindBy(xpath = "//td[text()=' Quoted Price / (pce) (excl. MU)']//following-sibling::td[@class='ng-star-inserted'][2]")
	private WebElement QPVersion1;

	@FindBy(xpath = "//td[text()=' Quoted Price / (pce) (excl. MU)']//following-sibling::td[@class='ng-star-inserted'][4]")
	private WebElement QPVersion2;

	@FindBy(xpath = "//td[text()=' Quoted Price / (pce) (excl. MU)']//following-sibling::td[@class='ng-star-inserted'][6]")
	private WebElement QPVersion3;
	
	@FindBy(xpath = "//td[text()=' Quoted Price / (pce) (excl. MU)']//following-sibling::td[@class='blue-back']")
	private WebElement QuotedPriceAverageGP;
	

	@FindBy(xpath = "//td[text()=' Total Cost / pce (Latest Exch Rate) ']//following-sibling::td[@class='ng-star-inserted'][2]")
	private WebElement TotalcostVersion1;

	@FindBy(xpath = "//td[text()=' Total Cost / pce (Latest Exch Rate) ']//following-sibling::td[@class='ng-star-inserted'][4]")
	private WebElement TotalcostVersion2;

	@FindBy(xpath = "//td[text()=' Total Cost / pce (Latest Exch Rate) ']//following-sibling::td[@class='ng-star-inserted'][6]")
	private WebElement TotalcostVersion3;

	@FindBy(xpath = "//td[text()=' External Average Mark-up (pce) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][2]")
	private WebElement ExtendedMarginVersion1;

	@FindBy(xpath = "//td[text()=' External Average Mark-up (pce) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][4]")
	private WebElement ExtendedMarginVersion2;

	@FindBy(xpath = "//td[text()=' External Average Mark-up (pce) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][6]")
	private WebElement ExtendedMarginVersion3;

	@FindBy(xpath = "//td[text()=' MVC% ']//following-sibling::td[@style='text-align: center'][2]")
	private WebElement MVCVersion1;

	@FindBy(xpath = "//td[text()=' MVC% ']//following-sibling::td[@style='text-align: center'][4]")
	private WebElement MVCVersion2;

	@FindBy(xpath = "//td[text()=' MVC% ']//following-sibling::td[@style='text-align: center'][6]")
	private WebElement MVCVersion3;

	@FindBy(xpath = "//td[text()=' RBC% ']//following-sibling::td[@style='text-align: center'][2]")
	private WebElement RBCVersion1;

	@FindBy(xpath = "//td[text()=' RBC% ']//following-sibling::td[@style='text-align: center'][4]")
	private WebElement RBCVersion2;

	@FindBy(xpath = "//td[text()=' RBC% ']//following-sibling::td[@style='text-align: center'][6]")
	private WebElement RBCVersion3;

	@FindBy(xpath = "//td[text()=' EM% 5 years']//following-sibling::td[@style='text-align: center'][2]")
	private WebElement EMVersion1;

	@FindBy(xpath = "//td[text()=' EM% 5 years']//following-sibling::td[@style='text-align: center'][4]")
	private WebElement EMVersion2;

	@FindBy(xpath = "//td[text()=' EM% 5 years']//following-sibling::td[@style='text-align: center'][6]")
	private WebElement EMVersion3;

	@FindBy(xpath = "(//td[text()=\" Dev. Cost ('000)\"])[2]//following-sibling::td[@style='text-align: center'][2]")
	private WebElement DevCosVersion1;

	@FindBy(xpath = "(//td[text()=\" Dev. Cost ('000)\"])[2]//following-sibling::td[@style='text-align: center'][4]")
	private WebElement DevCosVersion2;

	@FindBy(xpath = "(//td[text()=\" Dev. Cost ('000)\"])[2]//following-sibling::td[@style='text-align: center'][6]")
	private WebElement DevCosVersion3;

	@FindBy(xpath = "(//td[text()=\" Dev Revenue (lump sum…)\"])[2]//following-sibling::td[@style='text-align: center'][2]")
	private WebElement DevRevenueVersion1;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-costs-margin[1]/form[1]/div[1]/div[2]/app-costs-bottom[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[32]/td[6]")
	private WebElement PBRVersion1;

	@FindBy(xpath = "//td[text()='External Mark-up Year(s) : ']//following-sibling::td[@style='text-align: center']")
	private WebElement Externalmarkup;

	@FindBy(xpath = "//td[text()=' PNV Y1(k)']//following-sibling::td[@class='blue-back']")
	private WebElement PNVY1WE;

	@FindBy(xpath = "//td[text()=\" Margin Var Cost ('000) \"]//following-sibling::td[@class='blue-back']")
	private WebElement MarginVCost;

	@FindBy(xpath = "//td[text()=\" RBC ('000) \"]//following-sibling::td[@class='blue-back']")
	private WebElement RBC;

	@FindBy(xpath = "//td[text()=\" RBE ('000) \"]//following-sibling::td[@class='blue-back']")
	private WebElement RBE;

	@FindBy(xpath = "//td[text()=\" EM 5 years\"]//following-sibling::td[@class='blue-back']")
	private WebElement EM1;

	// td[text()=" EM 5 years"]//following-sibling::td[@class='blue-back']

	public CostDashboard() {
		PageFactory.initElements(driver, this);
	}

	public void readPNVAverageProjectCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  PNVAverageProject on Cost Dashboard");
		ad = new ActionDriver();
		String PNVAverage = ad.GetText(pnvY1,"pnv1 value captured Successfully");
		String PNVAV = ad.replacechartwo(PNVAverage, "st", ',', '.');

		pnvOnCost = PNVAV.replaceAll("[^\\d.]", "");
		System.out.println("Value of Project PNV% on Cost Dashboard is " + pnvOnCost);
		// Log.info("Read and display the Average project PNV value on cost dashboard
		// ");

	}

	public void readMVCAverageProjectCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  MVCverageProject on Cost Dashboard");
		ad = new ActionDriver();
		mvcOnCost = ad.GetText(mvcY1,"mvcY1 value captured Successfully");
		System.out.println("Value of Project MVC% on Cost Dashboard is " + mvcOnCost);
		// Log.info("Read and display the Average project MVC value on cost dashboard
		// ");

	}

	public void readRBCAverageProjectCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  RBCverageProject on Cost Dashboard");
		ad = new ActionDriver();
		rbcOnCost = ad.GetText(RBCY1,"RBCY1 value captured Successfully");
		System.out.println("Value of Project RBC% on Cost Dashboard is " + rbcOnCost);
		// Log.info("Read and display the Average project RBC value on cost dashboard
		// ");

	}

	public void readEMAverageProjectCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  EMverageProject on Cost Dashboard");
		ad = new ActionDriver();
		emOnCost = ad.GetText(EM,"EM value captured Successfully");
		System.out.println("Value of Project EM on Cost Dashboard is " + emOnCost);
		// Log.info("Read and display the Average project EM value on cost dashboard ");

	}

	public void readPBRAverageProjectCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  PBRverageProject on Cost Dashboard");
		ad = new ActionDriver();
		pbrOnCost = ad.GetText(PBR,"PBR value captured Successfully");
		System.out.println("Value of Project PBR on Cost Dashboard is " + pbrOnCost);
		// Log.info("Read and display the Average project PBR value on cost dashboard
		// ");

	}

	public void readPNVAvergeGPCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  PNVverageGP on Cost Dashboard");
		ad = new ActionDriver();
		String pnvCostGP = ad.GetText(pnvGP,"pnvGP value captured Successfully");
		String pnvCostGP1 = ad.replacechartwo(pnvCostGP, "st", ',', '.');

		pnvOnCostGP = pnvCostGP1.replaceAll("[^\\d.]", "");
		System.out.println("Value of GP PNV% on Cost Dashboard is " + pnvOnCostGP);
		// Log.info("Read and display the GLASS PNV value on cost dashboard ");

	}

	public void readMVCAvergeGPCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  MVCaverageGP on Cost Dashboard");
		ad = new ActionDriver();
		mvcOnCostGP = ad.GetText(mvcGP,"mvcGP value captured Successfully");
		System.out.println("Value of GP MVC% on Cost Dashboard is " + mvcOnCostGP);
		// Log.info("Read and display the Average project MVC value on cost dashboard
		// ");

	}

	public void readRBCAvergeGPCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  MVCaverageGP on Cost Dashboard");
		ad = new ActionDriver();
		rbcOnCostGP = ad.GetText(RBCGP,"RBCGP value captured Successfully");
		System.out.println("Value of GP RBC% on Cost Dashboard is " + rbcOnCostGP);
		// Log.info("Read and display the GP RBC value on cost dashboard ");

	}

	public void readEMAvergeGPCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  EMaverageGP on Cost Dashboard");
		ad = new ActionDriver();
		emOnCostGP = ad.GetText(EMGP,"EMGP value captured Successfully");
		System.out.println("Value of GP EM on Cost Dashboard is " + emOnCostGP);
		// Log.info("Read and display the GP EM value on cost dashboard ");

	}

	public void readPBRAvergeGPCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  PBRaverageGP on Cost Dashboard");
		ad = new ActionDriver();
		pbrOnCostGP = ad.GetText(PBRGP,"PBRGP value captured Successfully");
		System.out.println("Value of GP PBR on Cost Dashboard is " + pbrOnCostGP);
		// Log.info("Read and display the GP PBR value on cost dashboard ");
	}

	public void readyearlyQuantities() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read  readyearlyQuantities on Cost Dashboard");
		ad = new ActionDriver();
		yearlyQTYmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//yearlyQTYmap.put("CostVersion1YearlyQTY", version1YearlyQTY.getText());
			yearlyQTYmap.put("CostVersion1YearlyQTY", ad.GetText(version1YearlyQTY, "version1YearlyQTY captured Successfully"));

			String Version1YearlyQuantity = yearlyQTYmap.get("CostVersion1YearlyQTY");

			String V1YearlyQTYS = null;
			// String V1YearlyQTYS1=ad.splitString(Version1YearlyQuantity, V1YearlyQTYS,
			// ',');
			String V1YearlyQTYS1 = ad.replacechartwo(Version1YearlyQuantity, V1YearlyQTYS, ',', '.');
			System.out.println(V1YearlyQTYS1);
			String V1YearlyQTYS1Formatted = V1YearlyQTYS1.replaceAll(" ", "");
			System.out.println(V1YearlyQTYS1Formatted);

			double V1YearlyQTYD1 = 0;
			double V1YearlyQTYD11 = ad.Stringtodouble(V1YearlyQTYS1Formatted, V1YearlyQTYD1);
			System.out.println(V1YearlyQTYD11);
			double V1YearlyQTYF1 = 0;
			V1YearlyQTYF11 = ad.Mathround(V1YearlyQTYD11, V1YearlyQTYF1);
			System.out.println(V1YearlyQTYF11);

			System.out.println("Version1 yearly quantities on Cost Dashbaord is = " + V1YearlyQTYF11);
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//yearlyQTYmap.put("CostVersion2YearlyQTY", version2YearlyQTY.getText());
			yearlyQTYmap.put("CostVersion2YearlyQTY",ad.GetText(version2YearlyQTY, "version2YearlyQTY captured Successfully"));
			String Version2YearlyQuantity = yearlyQTYmap.get("CostVersion2YearlyQTY");

			String V1YearlyQTYSS = null;
			// String V1YearlyQTYS1=ad.splitString(Version1YearlyQuantity, V1YearlyQTYS,
			// ',');
			String V1YearlyQTYS11 = ad.replacechartwo(Version2YearlyQuantity, V1YearlyQTYSS, ',', '.');
			System.out.println(V1YearlyQTYS11);
			String V1YearlyQTYS1Formatted1 = V1YearlyQTYS11.replaceAll(" ", "");
			System.out.println(V1YearlyQTYS1Formatted1);

			double V1YearlyQTYD112 = 0;
			double V1YearlyQTYD111 = ad.Stringtodouble(V1YearlyQTYS1Formatted1, V1YearlyQTYD112);
			System.out.println(V1YearlyQTYD111);
			double V1YearlyQTYF111 = 0;
			V2YearlyQTYF1111 = ad.Mathround(V1YearlyQTYD111, V1YearlyQTYF111);
			System.out.println(V2YearlyQTYF1111);

			System.out.println("Version2 yearly quantities on Cost Dashbaord is = " + V2YearlyQTYF1111);
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//yearlyQTYmap.put("CostVersion3YearlyQTY", version3YearlyQTY.getText());
			yearlyQTYmap.put("CostVersion3YearlyQTY",ad.GetText(version3YearlyQTY, "version3YearlyQTY is captured Successfully"));

			String Version3YearlyQuantity = yearlyQTYmap.get("CostVersion3YearlyQTY");

			String V1YearlyQTYSSS = null;

			String V1YearlyQTYS111 = ad.replacechartwo(Version3YearlyQuantity, V1YearlyQTYSSS, ',', '.');
			System.out.println(V1YearlyQTYS111);
			String V1YearlyQTYS1Formatted11 = V1YearlyQTYS111.replaceAll(" ", "");
			System.out.println(V1YearlyQTYS1Formatted11);

			double V1YearlyQTYD1122 = 0;
			double V1YearlyQTYD1111 = ad.Stringtodouble(V1YearlyQTYS1Formatted11, V1YearlyQTYD1122);
			System.out.println(V1YearlyQTYD1111);
			double V1YearlyQTYF1112 = 0;
			V3YearlyQTYF11112 = ad.Mathround(V1YearlyQTYD1111, V1YearlyQTYF1112);
			System.out.println(V3YearlyQTYF11112);

			System.out.println("Versio3 yearly quantities on Cost Dashbaord is = " + V3YearlyQTYF11112);
		}

	}

	public void readPNVyear1() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readPNVyear1 on Cost Dashboard");
		ad = new ActionDriver();
		pnvyear1map = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//pnvyear1map.put("PNVY1V1", pnvVersion1.getText());
			pnvyear1map.put("PNVY1V1", ad.GetText(pnvVersion1,"Captured pnvVersion1 Successfully "));
			String PNVY1V1 = pnvyear1map.get("PNVY1V1");
			String PNVY11V11 = ad.replacechartwo(PNVY1V1, "newString", ',', '.');
			String PNVY11V111 = PNVY11V11.replaceAll(" ", "");
			System.out.println(PNVY11V111);
			double var = 0;
			PNVY111V1111 = ad.Stringtodouble(PNVY11V111, var);
			System.out.println("PNVY1Version1 value on the Cost Dashboard is=" + PNVY111V1111);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//pnvyear1map.put("PNVY1V2", pnvVersion2.getText());
			pnvyear1map.put("PNVY1V2", ad.GetText(pnvVersion2, "pnvVersion2 is Captured Successfully"));
			String PNVY1V2 = pnvyear1map.get("PNVY1V2");
			String PNVY11V22 = ad.replacechartwo(PNVY1V2, "newString", ',', '.');
			String PNVY11V222 = PNVY11V22.replaceAll(" ", "");
			System.out.println(PNVY11V222);
			double var = 0;
			PNVY111V2222 = ad.Stringtodouble(PNVY11V222, var);
			System.out.println("PNVY1Version2 value on the Cost Dashboard is=" + PNVY111V2222);
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//pnvyear1map.put("PNVY1V3", pnvVersion3.getText());
			pnvyear1map.put("PNVY1V2", ad.GetText(pnvVersion3, "pnvVersion3 is Captured Successfully"));

			String PNVY1V3 = pnvyear1map.get("PNVY1V3");
			String PNVY11V33 = ad.replacechartwo(PNVY1V3, "newString", ',', '.');
			String PNVY11V333 = PNVY11V33.replaceAll(" ", "");
			System.out.println(PNVY11V333);
			double var = 0;
			PNVY111V3333 = ad.Stringtodouble(PNVY11V333, var);
			System.out.println("PNVY1Version2 value on the Cost Dashboard is=" + PNVY111V3333);

		}

	}

	public void readQuatedPrice() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readQuatedPrice on Cost Dashboard");
		ad = new ActionDriver();
		QuotedPRicemap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//QuotedPRicemap.put("QPV1", QPVersion1.getText());
			QuotedPRicemap.put("QPV1", ad.GetText(QPVersion1, "QPVersion1 is captured Successfully"));
			String QuotedPriceV1 = QuotedPRicemap.get("QPV1");
			QuotedPriceV1 = ad.replacechartwo(QuotedPriceV1, "ns", ',', '.');
			double a = 0.0;
			QuotedPriceV11 = ad.Stringtodouble(QuotedPriceV1, a);
			System.out.println("Quoted Price for Version 1 on Cost Dashboard is =" + QuotedPriceV11);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//QuotedPRicemap.put("QPV2", QPVersion2.getText());
			QuotedPRicemap.put("QPV2", ad.GetText(QPVersion2, "QPVersion2 is captured Successfully"));
			String QuotedPriceV2 = QuotedPRicemap.get("QPV2");
			QuotedPriceV2 = ad.replacechartwo(QuotedPriceV2, "ns", ',', '.');
			double a = 0.0;
			QuotedPriceV22 = ad.Stringtodouble(QuotedPriceV2, a);
			System.out.println("Quoted Price for Version 2 on Cost Dashboard is =" + QuotedPriceV22);

		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//QuotedPRicemap.put("QPV3", QPVersion3.getText());
			QuotedPRicemap.put("QPV3", ad.GetText(QPVersion3, "QPVersion3 is captured Successfully"));
			String QuotedPriceV3 = QuotedPRicemap.get("QPV3");
			QuotedPriceV3 = ad.replacechartwo(QuotedPriceV3, "ns", ',', '.');
			double a = 0.0;
			QuotedPriceV33 = ad.Stringtodouble(QuotedPriceV3, a);
			System.out.println("Quoted Price for Version 3 on Cost Dashboard is =" + QuotedPriceV33);

		}
	}

	public void readTotalCost() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readTotalCost on Cost Dashboard");
		ad = new ActionDriver();
		TotalCostmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//TotalCostmap.put("TotalCostV1", TotalcostVersion1.getText());
			TotalCostmap.put("TotalCostV1", ad.GetText(TotalcostVersion1, "TotalcostVersion1 is captured Successfully"));
			
			TotalCostV1 = TotalCostmap.get("TotalCostV1");
			System.out.println("Total cost for Version1 on Cost Dashboard=" + TotalCostV1);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//TotalCostmap.put("TotalCostV2", TotalcostVersion2.getText());
			TotalCostmap.put("TotalCostV2", ad.GetText(TotalcostVersion2, "TotalcostVersion2 is captured Successfully"));
			TotalCostV2 = TotalCostmap.get("TotalCostV2");
			System.out.println("Total cost for Version2 on Cost Dashboard=" + TotalCostV2);

		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//TotalCostmap.put("TotalCostV3", TotalcostVersion3.getText());
			TotalCostmap.put("TotalCostV3", ad.GetText(TotalcostVersion3,"TotalcostVersion3 is captured Successfully"));
			TotalCostV3 = TotalCostmap.get("TotalCostV3");
			System.out.println("Total cost for Version2 on Cost Dashboard=" + TotalCostV3);

		}

	}

	public void readExternalMarkup() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readExternalMarkup on Cost Dashboard");
		ad = new ActionDriver();
		ExtendedMarkupmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//ExtendedMarkupmap.put("ExtendedMarginV1", ExtendedMarginVersion1.getText());
			ExtendedMarkupmap.put("ExtendedMarginV1", ad.GetText(ExtendedMarginVersion1, "ExtendedMarginVersion1 captured Successfully"));
			String ExMarV1 = ExtendedMarkupmap.get("ExtendedMarginV1");
			ExtendedMarginV1 = ad.replacechartwo(ExMarV1, "new", ',', '.');
			System.out.println("Extended Margin for Version1 on Cost Dashboard=" + ExtendedMarginV1);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//ExtendedMarkupmap.put("ExtendedMarginV2", ExtendedMarginVersion2.getText());
			ExtendedMarkupmap.put("ExtendedMarginV2", ad.GetText(ExtendedMarginVersion2, "ExtendedMarginVersion2 captured Successfully"));
			String ExMarV2 = ExtendedMarkupmap.get("ExtendedMarginV2");
			ExtendedMarginV2 = ad.replacechartwo(ExMarV2, "new", ',', '.');
			System.out.println("Extended Margin for Version2 on Cost Dashboard=" + ExtendedMarginV2);

		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//ExtendedMarkupmap.put("ExtendedMarginV3", ExtendedMarginVersion3.getText());
			ExtendedMarkupmap.put("ExtendedMarginV3", ad.GetText(ExtendedMarginVersion3, "ExtendedMarginVersion3 captured Successfully"));
			String ExMarV3 = ExtendedMarkupmap.get("ExtendedMarginV3");
			ExtendedMarginV3 = ad.replacechartwo(ExMarV3, "new", ',', '.');
			System.out.println("Extended Margin for Version2 on Cost Dashboard=" + ExtendedMarginV3);

		}
	}

	public void readExternalMarkUpYears() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readExternalMarkUpYears on Cost Dashboard");
		ad = new ActionDriver();
		ExtendedMarkupmapYear = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//ExtendedMarkupmapYear.put("ExMarkUPYearsV1", Externalmarkup.getText());
			ExtendedMarkupmapYear.put("ExMarkUPYearsV1", ad.GetText(Externalmarkup, "Externalmarkup captured Successfully"));
			
			exMarkUP = ExtendedMarkupmapYear.get("ExMarkUPYearsV1");

			System.out.println("ExternalMarkUpYears for Version1 on Cost Dashboard=" + exMarkUP);

		}
	}

	public void readMVCPercent() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readMVCPercent on Cost Dashboard");
		ad = new ActionDriver();
		MVCmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//MVCmap.put("MVCPercentV1", MVCVersion1.getText());
			MVCmap.put("MVCPercentV1", ad.GetText(MVCVersion1, "MVCVersion1 captured Successfully"));
			MVCV1 = MVCmap.get("MVCPercentV1");

			System.out.println("MVC for Version1 on Cost Dashboard=" + MVCV1);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			//MVCmap.put("MVCPercentV2", MVCVersion2.getText());
			MVCmap.put("MVCPercentV2", ad.GetText(MVCVersion2, "MVCVersion2 is captured Successfully"));
			MVCV2 = MVCmap.get("MVCPercentV2");
			System.out.println("MVC for Version2 on Cost Dashboard=" + MVCV2);

		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			//MVCmap.put("MVCPercentV3", MVCVersion3.getText());
			MVCmap.put("MVCPercentV3", ad.GetText(MVCVersion3, "MVCVersion3 is captured Successfully"));
			MVCV3 = MVCmap.get("MVCPercentV2");

			System.out.println("MVC for Version2 on Cost Dashboard=" + MVCV3);

		}
	}

	public void readRBCPercent() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readRBCPercent on Cost Dashboard");
		ad = new ActionDriver();
		RBCmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//RBCmap.put("RBCPercentV1", RBCVersion1.getText());
			RBCmap.put("RBCPercentV1", ad.GetText(RBCVersion1, "RBCVersion1 is captured Successfully"));
			RBCV1 = RBCmap.get("RBCPercentV1");

			System.out.println("RBC for Version1 on Cost Dashboard=" + RBCV1);

		}

		if (!ProjectSimulation.Version2.equals("NA")) {
			//RBCmap.put("RBCPercentV2", RBCVersion2.getText());
			RBCmap.put("RBCPercentV2", ad.GetText(RBCVersion2, "RBCVersion2 is captured Successfully"));
			RBCV2 = RBCmap.get("RBCPercentV2");

			System.out.println("RBC for Version2 on Cost Dashboard=" + RBCV2);

		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			//RBCmap.put("RBCPercentV3", RBCVersion3.getText());
			RBCmap.put("RBCPercentV3", ad.GetText(RBCVersion3, "RBCPercentV3 is captured Successfully"));
			RBCV3 = RBCmap.get("RBCPercentV3");

			System.out.println("RBC for Version3 on Cost Dashboard=" + RBCV3);

		}

	}

	public void readEM5year() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readEM5year on Cost Dashboard");
		ad = new ActionDriver();
		EMmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//EMmap.put("EMV1", EMVersion1.getText());
			EMmap.put("EMV1", ad.GetText(EMVersion1, "EMVersion1 is captured successfully"));
			EMV1 = EMmap.get("EMV1");

			System.out.println("EM for Version1 on Cost Dashboard=" + EMV1);

		}

		if (!ProjectSimulation.Version2.equals("NA")) {
			//EMmap.put("EMV2", EMVersion2.getText());
			EMmap.put("EMV2", ad.GetText(EMVersion2, "EMVersion2 is captured successfully"));
			EMV2 = EMmap.get("EMV2");

			System.out.println("EM for Version2 on Cost Dashboard=" + EMV2);

		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			//EMmap.put("EMV3", EMVersion3.getText());
			EMmap.put("EMV3", ad.GetText(EMVersion3, "EMVersion3 is captured successfully"));
			EMV3 = EMmap.get("EMV3");

			System.out.println("EM for Version3 on Cost Dashboard=" + EMV3);

		}

	}

	public void readDevCost() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readDevCost on Cost Dashboard");
		ad = new ActionDriver();
		DevCostmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//DevCostmap.put("DCV1", DevCosVersion1.getText());
			DevCostmap.put("DCV1", ad.GetText(DevCosVersion1, "DevCosVersion1 is captured Successfully"));
			String DCV1 = DevCostmap.get("DCV1");
			String DC1V1 = ad.replacechartwo(DCV1, "new", ',', '.');
			DevCostV1 = DC1V1.replaceAll("[^\\d.]", "");
			if (DevCostV1.isEmpty()) {
				DevCostV1 = "0";
			}

			System.out.println("Dev Cost for Version1 on Cost Dashboard=" + DevCostV1);

		}

		if (!ProjectSimulation.Version2.equals("NA")) {
			//DevCostmap.put("DCV2", DevCosVersion2.getText());
			DevCostmap.put("DCV2", ad.GetText(DevCosVersion2, "DevCosVersion2 is captured Successfully"));

			String DCV2 = DevCostmap.get("DCV2");
			String DC2V2 = ad.replacechartwo(DCV2, "new", ',', '.');
			DevCostV2 = DC2V2.replaceAll("[^\\d.]", "");

			if (DevCostV2.isEmpty()) {
				DevCostV2 = "0";
			}

			System.out.println("Dev Cost for Version2 on Cost Dashboard=" + DevCostV2);

		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			//DevCostmap.put("DCV3", DevCosVersion3.getText());
			DevCostmap.put("DCV3", ad.GetText(DevCosVersion3, "DevCosVersion3 is captured Successfully"));
			String DCV3 = DevCostmap.get("DCV3");
			String DC3V3 = ad.replacechartwo(DCV3, "new", ',', '.');
			DevCostV3 = DC3V3.replaceAll("[^\\d.]", "");

			if (DevCostV3.isEmpty()) {
				DevCostV3 = "0";
			}
			System.out.println("Dev Cost for Version3 on Cost Dashboard=" + DevCostV3);

		}

	}

	public void readDevRevenue() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readDevRevenue on Cost Dashboard");
		ad = new ActionDriver();
		DevRevenuemap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//DevRevenuemap.put("DRV1", DevRevenueVersion1.getText());
			DevRevenuemap.put("DRV1", ad.GetText(DevRevenueVersion1, "DevRevenueVersion1 is captured Successfully"));
			String DRV1 = DevRevenuemap.get("DRV1");
			String DR1V1 = ad.replacechartwo(DRV1, "new", ',', '.');
			DevRevenueV1 = DR1V1.replaceAll("[^\\d.]", "");
			if (DevRevenueV1.isEmpty()) {
				DevRevenueV1 = "0";
			}

			System.out.println("Dev Revenue for Version1 on Cost Dashboard=" + DevRevenueV1);

		}

	}

	public void readPBR() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read PBR on Cost Dashboard");
		ad = new ActionDriver();
		PBRmap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			//PBRmap.put("PBRV1", PBRVersion1.getText());
			PBRmap.put("PBRV1", ad.GetText(PBRVersion1, "PBRVersion1 is captured Successfully"));
			 PBRV1 = PBRmap.get("PBRV1");
			String PBR11V1 = ad.replacechartwo(PBRV1, "new", ',', '.');
			PBRV1 = PBR11V1.replaceAll("[^\\d.]", "");
			if (PBRV1.isEmpty()) {
				PBRV1 = "0";
			}

			System.out.println("PBR for Version1 on Cost Dashboard=" + PBRV1);

		}

	}

	public void readPNVY1K() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readPNVY1K on Cost Dashboard");
		PNVY1 = new HashMap<>();
		//PNVY1.put("PBRV1", PNVY1WE.getText());
		PNVY1.put("PBRV1", ad.GetText(PNVY1WE, "PNVY1WE is captured Successfully"));
		PNVY1K = PNVY1.get("PBRV1");
		System.out.println("PNV1 value on Cost dashboard is " + PNVY1K);

	}

	public void readMarginVarCost() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readMarginVarCost on Cost Dashboard");
		MarginVarCostmap = new HashMap<>();
		//MarginVarCostmap.put("MarginVarCost", MarginVCost.getText());
		MarginVarCostmap.put("MarginVarCost", ad.GetText(MarginVCost, "MarginVarCost is captured Successfully"));
		MarginVarcost = MarginVarCostmap.get("MarginVarCost");
		System.out.println("MarginVarCost on Cost Dashboard is = " + MarginVarcost);

	}

	public void readRBCNonpercent() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readRBCNonpercent on Cost Dashboard");
		RBCNPmap = new HashMap<>();
		//RBCNPmap.put("RBC", RBC.getText());
		RBCNPmap.put("RBC", ad.GetText(RBC, "RBC is captured Successfully"));
		RBCNP = RBCNPmap.get("RBC");
		System.out.println("RBC on Cost Dashboard is = " + RBCNP);

	}

	public void readRBENonpercent() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readRBENonpercent on Cost Dashboard");
		RBENPmap = new HashMap<>();
		//RBENPmap.put("RBE", RBE.getText());
		RBENPmap.put("RBE", ad.GetText(RBE, "RBE is captured Successfully"));
		RBENP = RBENPmap.get("RBE");
		System.out.println("RBC on Cost Dashboard is = " + RBENP);

	}

	public void readEMNonpercent() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read readEMNonpercent on Cost Dashboard");
		EMNPmap = new HashMap<>();
		//EMNPmap.put("EM", EM1.getText());
		EMNPmap.put("EM", ad.GetText(EM1, "EM1 is captured Successfully"));
		EMNP = EMNPmap.get("EM");
		System.out.println("EM non percent on Cost Dashboard is = " + EMNP);

	}
	
	public String readQuotedPriceAverageGlassPosition() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read QuotedPrice for average Glass Position on Cost Dashboard");
		return ad.GetText(QuotedPriceAverageGP, "QuotedPrice Average Glass Position is read successfully");
	}

}