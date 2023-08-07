package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class BundleOperations extends BrowserSettings {

	ActionDriver ad;
	public static String bundletobeseached;
	public static String BundleName;

	

	@FindBy(xpath = ("//span[@class=\"ui-button-text ui-clickable\" and text()=\" My Bundles\"]"))
	private WebElement MyBundle;

	public static String mybundlelist;
	@FindBy(xpath = ("//div[text()='My Bundle List ']"))
	WebElement mybundlelisttext;

	@FindBy(xpath = ("//span[@class='ui-button-text ui-clickable' and text()='Create Bundle']"))
	WebElement CreateBundle;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-list-bundles/div/div/div/form/p-dialog[1]/div/div[2]/div/div[2]/input")
	WebElement bundlename;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-list-bundles/div/div/div/form/p-dialog[1]/div/div[2]/div/div[4]/textarea")
	WebElement bundledescription;

	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']")
	WebElement clickdropdownproject;

	@FindBy(xpath = "//div[@class='ng-tns-c9-3']")
	List<WebElement> projects;

	@FindBy(xpath = "//li[@role='option']")
	List<WebElement> projectlisted;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-list-bundles[1]/div[1]/div[1]/div[1]/form[1]/p-dialog[1]/div[1]/div[2]/div[1]/div[6]/p-autocomplete[1]/span[1]/div[1]/ul[1]/li[1]/div[1]/div[1]")
	WebElement selectfirstproject;

	@FindBy(xpath = "//span[@class=\"ui-button-text ui-clickable\" and text()=\"Confirm \"]")
	WebElement confirmbutton;

	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-clickable pi pi-chevron-down']")
	WebElement clickBundleoneAction;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Open']")
	WebElement clickonOpen;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Edit']")
	WebElement clickonEdit;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Delete']")
	WebElement clickonDelete;

	public static String SelectedBundle;
	@FindBy(xpath = "//span[@class='Menu']")
	WebElement SelectedBundleName;

	public static String BundleAdd;
	@FindBy(xpath = "//div[@class='ui-toast-detail']")
	WebElement BundleAddedText;

	public static String BundleUpdate;
	@FindBy(xpath = "//div[@class='ui-toast-detail']")
	WebElement BundleUpdateText;

	public static String DeleteBundle;
	@FindBy(xpath = "//div[@class='ui-toast-detail' and text()='Bundle Deleted']")
	WebElement DeleteBundleText;

	@FindBy(xpath = "(//div[contains(@class,'ui-card-body')]/div//tr[4]//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])")
	WebElement clickonlocatedproject;

	@FindBy(xpath = "(//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset'])//li[@role='option']")
	List<WebElement> allscenarios;

	@FindBy(xpath = "(//div[contains(@class,'ui-card-body')]/div//tr[4]//span[@class='ui-button-text ui-clickable' and text()='Open'])")
	WebElement Openscenario;

	String validation1;
	@FindBy(xpath = "//span[@class='item-left-padding ng-star-inserted' and text()=' Approved ']")
	WebElement validationapproved;

	@FindBy(xpath = "//span[text()='Confirm ']")
	WebElement buttonConfirm;

	@FindBy(xpath = "//input[@class='ng-tns-c9-3']")
	WebElement globalSearchInput;

	@FindBy(xpath = "(//span[text()='ui-btn'])[1]")
	WebElement globalSearch;

	@FindBy(xpath = "//span[text()='Open']")
	WebElement openBundle;

	public BundleOperations() {
		PageFactory.initElements(driver, this);

	}
	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	ExcelOpearations excel=new ExcelOpearations(path);


	public void MyBundle() throws IOException {
		// TODO Auto-generated method stub
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("My Bundle");
		ad = new ActionDriver();
		ad.click(driver, MyBundle, "Clicked on My Bundle tab successfully");

	}

	public void openBuble() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open Bundle");
		ad = new ActionDriver();
		BundleName = excel.getCellData("BundleOperations", "Value", 2);
		ad.typenew(globalSearchInput, BundleName, "BundleName");
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("(//td[text()='" + BundleName + "'])[1]//following-sibling::td//span[text()='Action']"))
				.click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//span[text()='Open']")).click();
		ad.click(driver, openBundle, "Clicked on Open Bundle button Successfully");

	}

	public void verifyBundlelistpage() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ad = new ActionDriver();
		Thread.sleep(10000);
		WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'My Bundle List')]"));
		Log.info("Successfully opened bundle list");
	}

	public String GetmyBundlelistpage() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Capture text of My bundle list");
		ad = new ActionDriver();

		// return mybundlelist = mybundlelisttext.getText();
		return ad.GetText(mybundlelisttext, "Captured My Bundle list text Successfully");
	}

	public void clickProject() throws IOException, InterruptedException {

		String projectone = excel.getCellData("BundleOperations", "Value", 4);// Project tobe selected for bundle
																				// System.out.println(projectone);
		System.out.println(projectone);
		String projecttwo = excel.getCellData("BundleOperations", "Value", 5);// Project to be selected for bundle
																				// System.out.println(projecttwo);
		System.out.println(projecttwo);
		String projecthree = excel.getCellData("BundleOperations", "Value", 6);// Project to be selected for bundle
																				// System.out.println(projecthree);
		System.out.println(projecthree);
		String projectfour = excel.getCellData("BundleOperations", "Value", 7);//// Project to be selected for bundle
																				//// System.out.println(projectfour);
		System.out.println(projectfour);

		String devcodeone = excel.getCellData("BundleOperations", "DevCode", 4);// Project tobe selected for bundle
																				// System.out.println(projectone);
		System.out.println(devcodeone);
		String devcodetwo = excel.getCellData("BundleOperations", "DevCode", 5);// Project to be selected for bundle
																				// System.out.println(projecttwo);
		System.out.println(devcodetwo);
		String devcodethree = excel.getCellData("BundleOperations", "DevCode", 6);// Project to be selected for bundle
																					// System.out.println(projecthree);
		System.out.println(devcodethree);
		String devcodefour = excel.getCellData("BundleOperations", "DevCode", 7);//// Project to be selected for bundle
																					//// System.out.println(projectfour);
		System.out.println(devcodefour);
		driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']")).click();

		int totalproject = driver.findElements(By.xpath("//div[@class='ng-tns-c9-3']")).size();
		System.out.println(totalproject);

		List<String> ProjectNames = new ArrayList<String>();
		boolean broke = false;
		for (int i = 1; i <= totalproject; i++) {

			String ProjectSelectorselector = "(//div[@class='ng-tns-c9-3'])[" + i + "]";
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']")).click();

			WebElement we = driver.findElement(By.xpath(ProjectSelectorselector));

			String ProjectName = we.getText();
			System.out.println(ProjectName);
			ProjectNames.add(ProjectName);
			if (ProjectName.equals(projectone) || ProjectName.equals(projecttwo) || ProjectName.equals(projecthree)
					|| ProjectName.equals(projectfour)) {
				// driver.findElement(By.xpath("//input[@class=\"undefined\"]")).sendKeys(devcodeone);
				we.click();
				if (ProjectNames.contains(projectone) && ProjectNames.contains(projecttwo)
						&& ProjectNames.contains(projecthree) && ProjectNames.contains(projectfour)) {
					broke = true;
				}
				if (broke)
					break;
			}

			if (broke)
				break;

		}

	}

	public void CreateBundle() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Create Bundle");
		// TODO Auto-generated method stub
		ad = new ActionDriver();
		ad.click(driver, CreateBundle, "Clicked on Create Bundle button successfully");

		BundleName = excel.getCellData("BundleOperations", "Value", 2);
		ad.typenew(bundlename, BundleName, "BundleName");
		System.out.println(BundleName);
		String description = excel.getCellData("BundleOperations", "Value", 3);
		ad.typenew(bundledescription, description, "description");
		System.out.println(description);

		clickProject();
		ad.click(driver, buttonConfirm, "Clicked on Confirm button successfully ");
		Thread.sleep(2000);
	}

	public void BundlectionEdit() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Bundle Edit");
		ad = new ActionDriver();
		BundleName = excel.getCellData("BundleOperations", "Value", 2);

		System.out.println(BundleName);
		ad.typenew(globalSearchInput, BundleName, "typed bundlename into the search box successfully");
		driver.findElement(
				By.xpath("(//td[text()='" + BundleName + "'])[1]//following-sibling::td//span[text()='Action']"))
				.click();
		ad.click(driver, clickonEdit, "Clicked on Edit button Successfully");
		Log.info(" Edit Bundle page opened ");
		Thread.sleep(3000);

		ad.click(driver, confirmbutton, "Clicked on Confirm button Successfully");
	}

	public void BundlectionDelete() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Bundle Delete");
		ad = new ActionDriver();
		BundleName = excel.getCellData("BundleOperations", "Value", 2);
		System.out.println(BundleName);
		ad.typenew(globalSearchInput, BundleName, "typed bundlename into the search box");
		driver.findElement(
				By.xpath("(//td[text()='" + BundleName + "'])[1]//following-sibling::td//span[text()='Action']"))
				.click();
		Thread.sleep(5000);
		ad.click(driver, clickonDelete, "Clicked on Delete button Successfully");
		ad.click(driver, confirmbutton, "Clicked on Confirm button Successfully");

	}

	public void selectScenarios() throws InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Scenario");
		ad = new ActionDriver();
		String Projectnameone = excel.getCellData("BundleOperations", "Value", 9);
		String Projectnametwo = excel.getCellData("BundleOperations", "Value", 10);
		String Projectnamethree = excel.getCellData("BundleOperations", "Value", 11);
		String Projectnamefour = excel.getCellData("BundleOperations", "Value", 12);

		int totalProjects = driver
				.findElements(By.xpath("//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']")).size();

		for (int i = 1; i <= totalProjects; i++) {
			String dropdownP = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[" + i + "]";
			WebElement we = driver.findElement(By.xpath(dropdownP));
			we.click();
			Thread.sleep(10000);
			int totalScenarios = driver.findElements(By.xpath("//li[@role='option']")).size();
			for (int j = 1; j <= totalScenarios; j++) {
				String Scenarios = "(//li[@role='option'])[" + j + "]";
				WebElement we1 = driver.findElement(By.xpath(Scenarios));
				if (we1.getText().equals(Projectnameone)) {
					we1.click();
					break;
				}
				if (we1.getText().equals(Projectnametwo)) {
					we1.click();
					break;

				}
				if (we1.getText().equals(Projectnamethree)) {
					we1.click();
					break;

				}
				if (we1.getText().equals(Projectnamefour)) {
					we1.click();
					break;

				}
			}
		}

	}

	public void verifyscenarios() throws IOException, InterruptedException {
		ad = new ActionDriver();
		// String BundleName = excel.getCellData("BundleOperations", "Value", 2);
		// System.out.println(BundleName);
		// ad.typenew(globalSearchInput, BundleName, "typed bundlename into the search
		// box");
		// ad.click(driver, globalSearch, "Global Searched button clicked");
		Thread.sleep(10000);
		// driver.findElement(
		// By.xpath("(//td[text()='" + BundleName +
		// "'])[1]//following-sibling::td//span[text()='Action']"))
		// .click();

		// ad.click(driver, clickonOpen, "Open button click");

		int totalbuttons = driver.findElements(By.xpath("(//span[text()='Open'])")).size();
		System.out.println(totalbuttons);

		for (int i = 1; i <= totalbuttons; i++) {
			WebElement we = driver.findElement(By.xpath("(//span[text()='Open'])[" + i + "]"));
			we.click();
			Thread.sleep(10000);
			String status = driver.findElement(By.xpath("(//div[@class='label-header'])[3]")).getText();
			System.out.println(status);
			driver.navigate().back();
			if (status.contains("Rejected")) {
				Assert.assertTrue(false);
			}

		}
	}

	/*
	 * Log.info("Successfully open bundle"); ad.click(driver, clickonlocatedproject,
	 * "Clicked on dropdown"); List<WebElement> totalscenarios=allscenarios;
	 * 
	 * System.out.println("Total scenarios= "+totalscenarios.size());
	 * 
	 * int size= totalscenarios.size(); for(int i=0;i<size;i++) { ad.click(driver,
	 * Openscenario, "openscenario");
	 */

	public void clickBundleoneAction() throws Exception {
		// TODO Auto-generated method stub
		ad = new ActionDriver();

		ad.click(driver, clickBundleoneAction, "Clicked on Action button of first bundle  successfully");
		ad.click(driver, clickonOpen, "Clicked on Open button Successfully");
	}

	public String GetSelectedBundleName() throws IOException {

		//return SelectedBundle = SelectedBundleName.getText();
		return ad.GetText(SelectedBundleName, "Text for Bundle Name captured Successfully");
	}

	public String GetAddedBundleText() throws IOException {
		//return BundleAdd = BundleAddedText.getText();
		return ad.GetText(BundleAddedText, "Text for Bundle Added captured Successfully");
	}

	public String GetDeleteBundlePage() throws IOException {
		//return DeleteBundle = DeleteBundleText.getText();
		return ad.GetText(DeleteBundleText, "Text for Bundle Deleted captured Successfully");

	}

	public String GetBundleUpdateText() throws IOException {
		//return BundleUpdate = BundleUpdateText.getText();
		return ad.GetText(BundleUpdateText, "Text for Bundle Updated captured Successfully");

	}
}
