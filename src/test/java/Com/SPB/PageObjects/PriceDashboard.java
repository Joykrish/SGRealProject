package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;

public class PriceDashboard extends BrowserSettings {
	ActionDriver ad;
	public static HashMap<String, String> CommonSurfacemap;
	public static double ComSurfaceV1PriceD;
	public static double ComSurfaceV2PriceD;
	public static double ComSurfaceV3PriceD;

	public static HashMap<String, String> AddedValuemap;
	public static String AddedValueV1;
	public static String AddedValueV2;
	public static String AddedValueV3;

	public static HashMap<String, String> QuotedPricePCE;
	public static String quotedPricePCE;

	public static HashMap<String, String> Valume1;
	public static String Valume;

	public static HashMap<String, String> AddedValueH;
	public static String AddedValue;

	@FindBy(xpath = "//td[text()='Comm surface (sqm) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][1]")
	private WebElement CSV1;

	@FindBy(xpath = "//td[text()='Comm surface (sqm) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][2]")
	private WebElement CSV2;

	@FindBy(xpath = "//td[text()='Comm surface (sqm) ']//following-sibling::td[@class='ui-editable-column ng-star-inserted'][3]")
	private WebElement CSV3;

	@FindBy(xpath = "//td[text()=' Added Value (%)']//following-sibling::td[@class='ng-star-inserted'][1]")
	private WebElement AVVersion1;

	@FindBy(xpath = "//td[text()=' Added Value (%)']//following-sibling::td[@class='ng-star-inserted'][2]")
	private WebElement AVVersion2;

	@FindBy(xpath = "//td[text()=' Added Value (%)']//following-sibling::td[@class='ng-star-inserted'][3]")
	private WebElement AVVersion3;

	@FindBy(xpath = "//td[text()=' Quoted Price (pce) ']//following-sibling::td[1]")
	private WebElement QuatedPricePce;

	@FindBy(xpath = "//td[text()=' Volume (unit) ']//following-sibling::td[1]")
	private WebElement Valumeone;

	@FindBy(xpath = "//td[text()=' Added Value (%)']//following-sibling::td[1]")
	private WebElement AddedValueWE;

	public PriceDashboard() {
		PageFactory.initElements(driver, this);
	}

	public void readCommonSurface() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("readCommonSurface");
		ad = new ActionDriver();
		CommonSurfacemap = new HashMap<>();

		if (!ProjectSimulation.Version1.equals("NA")) {
			CommonSurfacemap.put("PriceVersion1CommonSurface", ad.GetText(CSV1, "Read CSV1 value Successfully"));
			String ComSurfaceV1 = CommonSurfacemap.get("PriceVersion1CommonSurface");
			String CMV1 = null;
			String ComSurfaceV1P = ad.replacechartwo(ComSurfaceV1, CMV1, ',', '.');
			double ComSurfaceV1PriceDashboard = 0;
			ComSurfaceV1PriceD = ad.Stringtodouble(ComSurfaceV1P, ComSurfaceV1PriceDashboard);

			System.out.println("Value of Common SurfaceVersion 1 on price dashboard is " + ComSurfaceV1PriceD);

		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			CommonSurfacemap.put("PriceVersion2CommonSurface", ad.GetText(CSV2, "Read CSV2 value Successfully"));
			String ComSurfaceV2 = CommonSurfacemap.get("PriceVersion2CommonSurface");
			String CMV2 = null;
			String ComSurfaceV2P = ad.replacechartwo(ComSurfaceV2, CMV2, ',', '.');
			double ComSurfaceV2PriceDashboard = 0;
			ComSurfaceV2PriceD = ad.Stringtodouble(ComSurfaceV2P, ComSurfaceV2PriceDashboard);

			System.out.println("Value of Common SurfaceVersion 1 on price dashboard is " + ComSurfaceV2PriceD);

		}

		if (!ProjectSimulation.Version3.equals("NA")) {
			CommonSurfacemap.put("PriceVersion2CommonSurface", ad.GetText(CSV3, "Read CSV3 value Successfully"));
			String ComSurfaceV3 = CommonSurfacemap.get("PriceVersion2CommonSurface");
			String CMV3 = null;
			String ComSurfaceV3P = ad.replacechartwo(ComSurfaceV3, CMV3, ',', '.');
			double ComSurfaceV3PriceDashboard = 0;
			ComSurfaceV3PriceD = ad.Stringtodouble(ComSurfaceV3P, ComSurfaceV3PriceDashboard);

			System.out.println("Value of Common SurfaceVersion 2 on price dashboard is " + ComSurfaceV3PriceD);

		}

	}

	public void readAddedValue() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("readAddedValue");
		ad = new ActionDriver();
		AddedValuemap = new HashMap<>();
		if (!ProjectSimulation.Version1.equals("NA")) {
			AddedValuemap.put("AddedValueV1", ad.GetText(AVVersion1, "Read Added Value value Successfully"));

			AddedValueV1 = AddedValuemap.get("AddedValueV1");
			if (AddedValueV1.equals("")) {
				AddedValueV1 = "0.0%";
			}
			System.out.println("Added Value for Version1 on Price  Dashboard is =" + AddedValueV1);
		}
		if (!ProjectSimulation.Version2.equals("NA")) {
			AddedValuemap.put("AddedValueV2", ad.GetText(AVVersion2, "Read Added Value Successfully"));
			AddedValueV2 = AddedValuemap.get("AddedValueV2");
			if (AddedValueV2.equals("")) {
				AddedValueV2 = "0.0%";
			}
			System.out.println("Added Value for Version2 on Price  Dashboard is =" + AddedValueV2);
		}
		if (!ProjectSimulation.Version3.equals("NA")) {
			AddedValuemap.put("AddedValueV3", ad.GetText(AVVersion3, "Read Added Value Successfully"));
			AddedValueV3 = AddedValuemap.get("AddedValueV3");
			if (AddedValueV3.equals("")) {
				AddedValueV3 = "0.0%";
			}
			System.out.println("Added Value for Version3 on Price  Dashboard is =" + AddedValueV3);
		}
	}

	public void readQuatedPricePce() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("readQuatedPricePce");
		QuotedPricePCE = new HashMap<>();
		QuotedPricePCE.put("QuatedPricePce", ad.GetText(QuatedPricePce, "QuatedPricePce is Captured Successfully"));
		quotedPricePCE = QuotedPricePCE.get("QuatedPricePce");
		System.out.println("quotedPricePCES on Price Dashboard is " + quotedPricePCE);

	}

	public void readValume() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("readValume");
		Valume1 = new HashMap<>();
		Valume1.put("QuatedPricePce", ad.GetText(Valumeone, "read valume Captured Successfully"));
		Valume = Valume1.get("QuatedPricePce");
		System.out.println("Volume on Price Dashboard is " + Valume);

	}

	public void readAddedValue1() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Added Value");
		AddedValueH = new HashMap<>();
		AddedValueH.put("AddedValue", ad.GetText(AddedValueWE, "Read Added Value Successfully"));
		String AddedValueP = AddedValueH.get("AddedValue");
		AddedValue = AddedValueP.replaceAll("[^\\d.]", "");
		if(AddedValue.isEmpty()) {
			AddedValue="0.0";
		}
		System.out.println("Added Value on Price Dashboard is " + AddedValue);

	}

}
