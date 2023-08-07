package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class MyBundle extends BrowserSettings {

	ActionDriver ad;
	public static double PNVglobal;
	public static double MVCglobal;
	public static double RBCglobal;
	public static double EMglobal;
	public static double PBRglobal;

	public static HashMap<String, String> BundleIndicators;
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()=' My Bundles']")
	private WebElement tabMybundle;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Action']")
	private WebElement btnAction;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Open']")
	private WebElement btnOpen;

	public MyBundle() {
		PageFactory.initElements(driver, this);
	}

	public void clickMyBundle() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode(" Click On MyBundle");
		ad = new ActionDriver();
		ad.click(driver, tabMybundle, "Clicked On MyBundele tab successfully");
	}

	public void globalSearch() throws IOException {
		MyRFQ hp = PageFactory.initElements(driver, MyRFQ.class);
		hp.GlobalSearch("");
	}

	public void openBundle() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("OpenBundle ");
		ad = new ActionDriver();

		ad.click(driver, btnAction, "Clicked on Action Button");
		ad.click(driver, btnOpen, "Clicked on Open button");
	}

	public void readBundleIndicators() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Bundle Indicators");
		BundleIndicators = new HashMap<>();
try {
	BundleIndicators.put("PNV(Y1)",
			driver.findElement(
					By.xpath("//span[text()=' PNV (Y1) ']//following-sibling::span[@class='item-right-orange']"))
					.getText());
	
		
		BundleIndicators.put("MVC (Y1)",
				driver.findElement(
						By.xpath("//span[text()=' MVC (Y1) ']//following-sibling::span[@class='item-right-orange']"))
						.getText());
		BundleIndicators.put("RBC (Y1)",
				driver.findElement(
						By.xpath("//span[text()=' RBC (Y1) ']//following-sibling::span[@class='item-right-orange']"))
						.getText());
		BundleIndicators.put("EM",
				driver.findElement(
						By.xpath("//span[text()=' EM ']//following-sibling::span[@class='item-right-orange']"))
						.getText());
		BundleIndicators.put("PBR",
				driver.findElement(
						By.xpath("//span[text()=' PBR ']//following-sibling::span[@class='item-right-orange']"))
						.getText());
		
		BrowserSettings.parentTest.pass("Captured PNV(Y1),MVC (Y1),RBC (Y1),EM,PBR captured Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to Capture PNV(Y1) Successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}
		String PNV = BundleIndicators.get("PNV(Y1)");
		System.out.println(PNV);
		String MVC = BundleIndicators.get("MVC (Y1)");
		System.out.println(MVC);
		String RBC = BundleIndicators.get("RBC (Y1)");
		System.out.println(RBC);
		String EM = BundleIndicators.get("EM");
		System.out.println(EM);
		String PBR = BundleIndicators.get("PBR");
		System.out.println(PBR);

	}

	public void openBundleProjects() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Bundle Projects ");

		int totalprojects = driver.findElements(By.xpath("(//span[text()='Open'])")).size();
		System.out.println(totalprojects);
		double PNVsummation = 0.0;
		double MVCsummation = 0.0;
		double RBCsummation = 0.0;
		double EMsummation = 0.0;
		double PBRsummation = 0.0;
		for (int i = 1; i <= totalprojects; i++) {

			String OpenButton = "(//span[text()='Open'])[" + i + "]";
			Log.info("Xpath for first page number elemenet is saved in  Paginationselector string");
			WebElement we = driver.findElement(By.xpath(OpenButton));
			ad = new ActionDriver();
			Log.info("Xpath for first page number elemenet is saved in  Webelement");
			ad.movetoelementandclick(driver, we, "clicked on openbutton");
			ProjectDashboard PD = PageFactory.initElements(driver, ProjectDashboard.class);
			PD.selectCurrency();

			Thread.sleep(10000);
			BundleIndicators = new HashMap<>();
			try {
			BundleIndicators.put("PNV(Y1)",
					driver.findElement(By
							.xpath("//span[text()=' PNV (Y1) ']//following-sibling::span[@class='item-right-orange']"))
							.getText());
			BundleIndicators.put("MVC (Y1)",
					driver.findElement(By
							.xpath("//span[text()=' MVC (Y1) ']//following-sibling::span[@class='item-right-orange']"))
							.getText());
			BundleIndicators.put("RBC (Y1)",
					driver.findElement(By
							.xpath("//span[text()=' RBC (Y1) ']//following-sibling::span[@class='item-right-orange']"))
							.getText());
			BundleIndicators.put("EM",
					driver.findElement(
							By.xpath("//span[text()=' EM ']//following-sibling::span[@class='item-right-orange']"))
							.getText());
			BundleIndicators.put("PBR",
					driver.findElement(
							By.xpath("//span[text()=' PBR ']//following-sibling::span[@class='item-right-orange']"))
							.getText());
			BrowserSettings.parentTest.pass("Captured PNV(Y1),MVC (Y1),RBC (Y1),EM,PBR captured Successfully");
			} catch (Exception e) {
				// TODO: handle exception
				BrowserSettings.parentTest.fail("Unable to Capture PNV(Y1),,MVC (Y1),RBC (Y1),EM,PBR Successfully");
				BrowserSettings.childTest.info(e);
				throw e;
			}
			String PNV = BundleIndicators.get("PNV(Y1)");
			String PNVU = ad.replacechartwo(PNV, "new", ',', '.');
			String PNVReplace = PNVU.replaceAll("[^\\d.]", "");
			double a = 0.0;
			double PNVFinal = ad.Stringtodouble(PNVReplace, a);
			PNVsummation = PNVsummation + PNVFinal;
			PNVglobal = PNVsummation;

			

			String MVC = BundleIndicators.get("MVC (Y1)");
			String MVCUpdate = MVC.replaceAll("[^\\d.]", "");
			double MVCFinal = ad.Stringtodouble(MVCUpdate, a);
			MVCsummation = MVCsummation + MVCFinal;
			MVCglobal = MVCsummation / PNVglobal;
			//System.out.println("Bundle MVC is " + MVCglobal);

			String RBC = BundleIndicators.get("RBC (Y1)");
			String RBCUpdate = RBC.replaceAll("[^\\d.]", "");
			double RBCFinal = ad.Stringtodouble(RBCUpdate, a);
			RBCsummation = RBCsummation + RBCFinal;
			RBCglobal = RBCsummation / PNVglobal;

			//System.out.println("Bundle MVC is " + RBCglobal);

			String EM = BundleIndicators.get("EM");
			String EMUpdate = EM.replaceAll("[^\\d.]", "");
			double EMFinal = ad.Stringtodouble(EMUpdate, a);
			EMsummation = EMsummation + EMFinal;
			//System.out.println("Bundle EM is " + EMsummation);

			String PBR = BundleIndicators.get("PBR");
			String PBRupdate = PBR.replaceAll("[^\\d.]", "");
			double PBRFinal = ad.Stringtodouble(PBRupdate, a);
			PBRsummation = PBRsummation + PBRFinal;
			//System.out.println("Bundle PBR is " + PBRsummation);

			driver.navigate().back();

		}
		System.out.println("Bundle PNV =" +PNVglobal);
		System.out.println("Bundle MVC =" +MVCglobal);
		System.out.println("Bundle RBC =" +RBCglobal);
		
		

	}
}