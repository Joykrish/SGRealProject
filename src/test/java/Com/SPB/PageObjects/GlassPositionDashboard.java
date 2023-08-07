package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class GlassPositionDashboard extends BrowserSettings {
	ActionDriver ad;
	public static String Projectname;
	public static List<String> ActionNames;
	public static Boolean state;
	public static String VersionName;
	public static String VersionDescription;
	public static String confirmVersion;
	public static String textN;

	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH") + "\\" + fileName;
	ExcelOpearations excel = new ExcelOpearations(path);

	@FindBy(xpath = "//img[@style='height: 210px; background: url(\"./assets/img/EM-Background.png\");']")
	private WebElement imgCostdashboard;

	@FindBy(xpath = "(//img[@class='img-style'])[1]")
	private WebElement imgPriceDashboard;

	@FindBy(xpath = "	//label[text()=' Version Validation']")
	private WebElement VersionValidation;

	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btnVersionValidationCancel;

	@FindBy(xpath = "//span[@class='Menu']")
	private WebElement txtProjectName;

	@FindBy(xpath = "//span[text()='Action']")
	private WebElement btnAction;

	@FindBy(xpath = "//button[@class='ui-button-rounded ui-button ui-widget ui-button-success ui-corner-all ui-button-text-only ui-button-text ui-state-default']")
	private WebElement btnAddVersion;

	@FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-invalid']")
	private WebElement txtVersionName;

	@FindBy(xpath = "//body/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-glass-position[1]/app-add-version[1]/form[1]/p-dialog[1]/div[1]/div[2]/div[1]/div[8]/textarea[1]")
	private WebElement txtVersionDescription;

	@FindBy(xpath = "//button[@class='ui-button-rounded ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-text ui-button-success']")
	private WebElement btnConfirm;

	@FindBy(xpath = "(//div[@class='ui-toast-detail' and text()='Version added successfully'])[1]")
	private WebElement mssVersionSuccessfullyConfirm;
	
	@FindBy(xpath = "//div[contains(text(), 'Total Take Rate Selected')]")
	private WebElement takerate;

	
	
	public GlassPositionDashboard() {
		PageFactory.initElements(driver, this);
	}

	public void openCostDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Image Cost Dashboard");
		ad = new ActionDriver();
		ad.click(driver, imgCostdashboard, "Clicked on ImageCostDashboard Successfully");
	}

	public void readGlassPositionIndicators() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Glass Position Indicator");
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		pd.readPNVY1();
		pd.readMVCY1();
		pd.readRBCY1();
		pd.readEM();
		pd.readPBR();
		Log.info("Successfully read all the Glass Position Indicators");

	}

	public void ifexistNoVesrion() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest
				.createNode("Verify in case message existNOVersion pop-up");
		if (VersionValidation.isDisplayed()) {
			ad = new ActionDriver();
			ad.click(driver, btnVersionValidationCancel, "Clicked on Cancelbuton Successfully");
			Log.info("clicked on cancel button for Version Validatoin Window");

		}

	}

	public void openCostandExtendedMarginDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Cost and Extended Margin Dashboard");
		ad = new ActionDriver();
		ad.click(driver, imgCostdashboard, "Clicked on imgCostDashboard Successfully");

	}

	public void openPriceDashboard() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Price Dashboard ");
		ad = new ActionDriver();
		ad.click(driver, imgPriceDashboard, "Clicked on imgPriceDashboard Successfully ");
	}

	public String readprojectname() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Project Name");
		ad = new ActionDriver();
		ActionDriver ad = new ActionDriver();

		return ad.GetText(txtProjectName, "Project Name captured Successfully");

	}

	public void clickActionbutton() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on Action Button");
		Thread.sleep(10000);
		ActionDriver ad = new ActionDriver();
		ad.click(driver, btnAction, "Clicked on ActionbuttonVersion Successfully");

	}

	public void btnActionMenu() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on Action Button");

		List<WebElement> actionmenu = driver.findElements(By.xpath("//span[@class='ui-menuitem-text']"));
		ActionNames = new ArrayList<String>();
		for (int i = 1; i <= actionmenu.size(); i++) {
			WebElement locator = driver.findElement(By.xpath("(//span[@class='ui-menuitem-text'])[" + i + "]"));
			try {
				String menu = locator.getText();
				System.out.println(menu);
				ActionNames.add(menu);
				BrowserSettings.parentTest.pass("Printed and added Action button menus Successfully with data " + menu);
			} catch (Exception e) {
				BrowserSettings.parentTest.fail("Unable to Print and add Action button menus Successfully ");
				// TODO: handle exception
			}

		}
		System.out.println(ActionNames);

	}

	public void stateAddVersion() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Check the state of Add Version button");
		try {
			state = btnAddVersion.isEnabled();
			System.out.println(state);
			BrowserSettings.parentTest.pass("State of Add Version button checked successfully and it is " + state);
		} catch (Exception e) {
			BrowserSettings.parentTest.pass("Unable to check the State of Add Version button");
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}

	}

	public void addVersion() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Add Version");
		VersionName = excel.getCellData("Sheet1", "VersionCreation", 35);
		VersionDescription = excel.getCellData("Sheet1", "VersionCreation", 36);

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Image Cost Dashboard");
		ad = new ActionDriver();

		try {
			ad.click(driver, btnAddVersion, "btnAddVersion");
			try {
				ad.typenew(txtVersionName, VersionName, "Version Name");
			} catch (NoSuchElementException e) {

			}
			try {
				ad.typenew(txtVersionDescription, VersionDescription, "Version Description");
			} catch (NoSuchElementException e) {

			}
			try {
				ad.click(driver, btnConfirm, "Click Confirm button");
			} catch (NoSuchElementException e) {

			}

		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Button is desabled and exception catch successfully");
			BrowserSettings.childTest.fail("Button is desabled");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// }
		// else
		//

	}

	public String readconfirmmessage() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Confirmation message");
		ad = new ActionDriver();
		// confirmVersion=mssVersionSuccessfullyConfirm.getText();
		confirmVersion = ad.GetText(mssVersionSuccessfullyConfirm, "Confirmation Message Caputered Successfully");
		System.out.println(confirmVersion);
		return confirmVersion;
	}

	public void searchspecificVersion() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Search Specific Version ");
		// a[@ng-reflect-klass='ui-paginator-page ui-paginator']

		int pagination = driver.findElements(By.xpath("//a[@ng-reflect-klass='ui-paginator-page ui-paginator']"))
				.size();

		System.out.println(pagination);
		Log.info("total number of available pages are counted");

		List<String> VersionNames = new ArrayList<String>();
		boolean broke = false;
		for (int i = 1; i <= pagination; i++) {
			String Paginationselector = "//a[contains(text(),'" + i + "')]";
			Log.info("Xpath for first page number elemenet is saved in  Paginationselector string");
			WebElement we = driver.findElement(By.xpath(Paginationselector));
			ad = new ActionDriver();
			Log.info("Xpath for first page number elemenet is saved in  Webelement");
			ad.movetoelementandclick(driver, we, "ClickonPagenumber");
			Thread.sleep(1000);
			List<WebElement> name = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[1]"));
			System.out.println(name.size());
			for (WebElement webElement : name) {
				textN = webElement.getText();

				System.out.println(textN);
				VersionNames.add(textN);
				try {
					if (textN.contains(VersionName)) {
						System.out.println("Newly added Version found in the version scenario");
						BrowserSettings.parentTest.pass("Version Found Successfully");
						broke = true;
						if (broke)
							break;

					}
				} catch (Exception e) {
					// TODO: handle exception
					BrowserSettings.childTest.fail("Version is not Found Successfully");
					BrowserSettings.childTest.info(e);
					throw e;
				}

			}

			if (broke)
				break;
		}
	}
	
	public String readtakerate() throws IOException {
		ad = new ActionDriver();
		return ad.GetText(takerate, "take rate captured successfully ");
		
		
	}

}