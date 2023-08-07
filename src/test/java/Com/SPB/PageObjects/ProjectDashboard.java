package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.test.VerifyVersionCreation;

public class ProjectDashboard extends BrowserSettings {

	ActionDriver ad;

	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH") + "\\" + fileName;
	ExcelOpearations excel = new ExcelOpearations(path);

	public static String Scenariname;
	public static String ScenarioDescription;
	public static String lblSelectedScenarioS;
	public static String SelectScenario;
	public static String SelectScenariotoberanamed;
	public static String selectScenariotoArchieved;
	public static String one;
	public static String renameScenarioName;
	public static String renameScenarioDescrption;
	public static String RenameConfirm;
	public static String archieveConfirm;
	public static String PNVR1;
	public static String PNVY1num;
	public static String MVC1;
	public static String RBCY1;
	public static String em;
	public static String pbr;
	public static String glassPosition;
	public static String internalVal;
	public static String ScenarioNotsubmittedIV;

	public String CP;

	public static Boolean existImport;

	public String QuotedPriceGP1;
	public String QuotedPriceGP2;
	public String QuotedPriceGP3;

	public static String SelectedProject;
	@FindBy(xpath = "//div[@class='SearchProjectText Line-blue']")
	private WebElement SelectedProjectName;

	@FindBy(xpath = "//div//span[@class='ui-dropdown-trigger-icon ui-clickable pi pi-chevron-down']")
	private WebElement dropdownScenario;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/p-dropdown[1]/div[1]/label[1]")
	private WebElement lblSelectedScenario;

	@FindBy(xpath = "//span[contains(text(),'Add Scenario')]")
	private WebElement btnaddscenario;

	@FindBy(xpath = "//button[@class='ui-button-rounded ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-text ui-button-success']")
	private WebElement btnconfirm;

	@FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-invalid']")
	private WebElement txtScenarioName;

	@FindBy(xpath = "//textarea[@class='ng-untouched ng-pristine ng-invalid ui-inputtext ui-corner-all ui-state-default ui-widget']")
	private WebElement txtScenarioDescription;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[2]/div[1]/div[3]/app-list-scenario[1]/p-card[1]/div[1]/div[2]/div[1]/p-table[1]/div[1]/p-paginator[1]/div[1]/a[4]/span[1]")
	private WebElement btnForward;

	@FindBy(xpath = "//span[text()='Rename']")
	private WebElement btnrename;

	@FindBy(xpath = "//span[text()='Archive']")
	private WebElement btnArchieve;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[2]/div[1]/div[3]/app-list-scenario[1]/app-edit-scenario[1]/form[1]/p-dialog[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
	private WebElement txtRenameScenarioName;

	@FindBy(xpath = "//body/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[2]/div[1]/div[3]/app-list-scenario[1]/app-edit-scenario[1]/form[1]/p-dialog[1]/div[1]/div[2]/div[1]/div[4]/textarea[1]")
	private WebElement txtRenameScenarioDesc;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement btnSave;
	@FindBy(xpath = "(//div[@class='ui-toast-detail' and text()='Scenario updated successfully'])[1]")
	private WebElement mssgRenameSuccessfullyConfirm;

	@FindBy(xpath = "//span[text()=' PNV (Y1) ']//following-sibling::span[@class='item-right-orange']")
	private WebElement PNV;

	@FindBy(xpath = "//span[text()=' MVC (Y1) ']//following-sibling::span[@class='item-right-orange']")
	private WebElement MVC;

	@FindBy(xpath = "//span[text()=' RBC (Y1) ']//following-sibling::span[@class='item-right-orange']")
	private WebElement RBC;

	@FindBy(xpath = "//span[text()=' EM ']//following-sibling::span[@class='item-right-orange']")
	private WebElement EM;

	@FindBy(xpath = "//span[text()=' PBR ']//following-sibling::span[@class='item-right-orange']")
	private WebElement PBR;

	@FindBy(xpath = "(//div[@class='label-header'])[3]")
	public static WebElement internalValidation;

	@FindBy(xpath = "//span[text()=' In progress ']")
	public static WebElement internalValidationInPr;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-chevron-down'])[1]")
	private WebElement excelDropdown;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Export']")
	private WebElement excelExportMenu;

	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Import']")
	private WebElement excelImportMenu;

	@FindBy(xpath = "//body/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[2]/div[1]/div[2]/app-informations[1]/p-card[1]/div[1]/div[2]/div[1]/div[1]/div[12]/app-currency[1]/p-autocomplete[1]/span[1]/input[1]")
	private WebElement currencyDropDown;

	@FindBy(xpath = "//li[@id='']")
	private WebElement currencyEuro;

	@FindBy(xpath = "(//div[@class='ui-toast-detail' and text()='Scenario Archive Successfully'])[1]")
	private WebElement mssgArchieveSuccessfullyConfirm;

	@FindBy(xpath = "(//div[@class='p-col-12 p-md-6'])[4]")
	private WebElement CarProduction;

	// span[@class='ng-tns-c1-14 ng-star-inserted' and text()='EUR']

	public ProjectDashboard() {
		PageFactory.initElements(driver, this);
	}

	public String GetSelectedProjectName() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Get Selected ProjectName");
		ad = new ActionDriver();
		return SelectedProject = ad.GetText(SelectedProjectName, "Name of Project is captured Successfully");
	}

	public void ClickAddScenario() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on Add Scenario");
		ad = new ActionDriver();
		ad.click(driver, btnaddscenario, "Clicked on AddScenario Successfully");
		Log.info("Successfully clicked on Add Scenario Dropdown");

	}

	public void enterScenarioName() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Enter the name of the Scenario");
		Scenariname = excel.getCellData("Sheet1", "Value", 20);
		ad = new ActionDriver();
		ad.typenew(txtScenarioName, Scenariname, "scenarioname typed Successfully");
		Log.info("Successfully typed the name of scenario" + Scenariname);

	}

	public void enterScenarioDescription() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Enter the Description of the Scenario");
		ScenarioDescription = excel.getCellData("Sheet1", "Value", 21);
		ad = new ActionDriver();
		ad.typenew(txtScenarioDescription, ScenarioDescription, "ScenarioDescription entered Successfully");
		Log.info("Successfully typed the Description of scenario" + ScenarioDescription);
	}

	public void ConfirmAddScenario() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Enter the Confirm Scenario button");
		ad = new ActionDriver();
		ad.click(driver, btnconfirm, "Confirmbutton clicked successfully");
		Log.info("Successfully clicked on the Confirm button");
	}

	public String SelectedScenario() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Get the text of selected Scenario ");
		Log.info("Successfully read the selected scenario name" + lblSelectedScenario.getText());
		// return lblSelectedScenarioS = lblSelectedScenario.getText();
		return lblSelectedScenarioS = ad.GetText(lblSelectedScenario, "Successfully Captured Scenario Name");

	}

	public void selectscenario() throws IOException, InterruptedException {
		Thread.sleep(10000);
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Scenario");
		ad = new ActionDriver();
		ad.click(driver, dropdownScenario, "clicked on ScenarioDropdown Successfully");

		VerifyVersionCreation xl = new VerifyVersionCreation();

		SelectScenario = excel.getCellData("Sheet1", "Value", 22);

		try {
			driver.findElement(By.xpath("//span[text()='" + SelectScenario + "']")).click();
			BrowserSettings.parentTest.pass("Clicked on selected scenario Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to clicked on selected scenario Successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// Log.info("Successfully clicked on the selected scenario"+ SelectScenario);

	}

	public void selectscenarioVersion() throws IOException, InterruptedException {
		Thread.sleep(10000);
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Scenario");
		ad = new ActionDriver();
		ad.click(driver, dropdownScenario, "clicked on ScenarioDropdown Successfully");

		VerifyVersionCreation xl = new VerifyVersionCreation();

		SelectScenario = excel.getCellData("Sheet1", "VersionCreation", 22);

		try {
			driver.findElement(By.xpath("//span[text()='" + SelectScenario + "']")).click();
			BrowserSettings.parentTest.pass("Clicked on selected scenario Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to clicked on selected scenario Successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// Log.info("Successfully clicked on the selected scenario"+ SelectScenario);

	}

	public void selectScenariowithStatus() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Scenario");
		ad = new ActionDriver();
		ad.click(driver, dropdownScenario, "clikconScenarioDropdown");
		ScenarioNotsubmittedIV = excel.getCellData("Sheet1", "Valueone", 22);
		try {
			driver.findElement(By.xpath("//span[text()='" + ScenarioNotsubmittedIV + "']")).click();
			BrowserSettings.childTest.pass("Scenario Selection Completed successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to perform Scenario Selection ");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// Log.info("Successfully clicked on the selected scenario"+ SelectScenario);

	}

	public void selectScenarioTobeRenamed() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Scenario to be renamed");
		ad = new ActionDriver();
		ad.click(driver, dropdownScenario, "clicked on ScenarioDropdown Successfully");
		SelectScenariotoberanamed = excel.getCellData("Sheet1", "Value", 25);
		try {
			driver.findElement(By.xpath("//span[text()='" + SelectScenariotoberanamed + "']")).click();
			BrowserSettings.childTest.pass("Scenario to be renamed is selected successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Scenario to be renamed is selected not selected successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// Log.info("Successfully clicked on the scenario to be renamed"+
		// SelectScenariotoberanamed);

	}

	public void selectScenarioTobeArchieved() throws IOException {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Archive Scenario Selection");
		ad = new ActionDriver();
		ad.click(driver, dropdownScenario, "click on ScenarioDropdown Successfully");
		selectScenariotoArchieved = excel.getCellData("Sheet1", "Value", 27);
		try {
			driver.findElement(By.xpath("//span[text()='" + selectScenariotoArchieved + "']")).click();
			BrowserSettings.childTest.pass("Scenario to be archieved is selected successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Scenario to be archieved is not selected successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		// Log.info("Successfully clicked on the scenario to be archieved"+
		// selectScenariotoArchieved);

	}

	public void scrolltoScenarioDashboard() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Scroll to Scenario Dashboard");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)");
			Log.info("Successfully scroll down");
			BrowserSettings.parentTest.pass("Successfully scrolled down");

		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to Successfully scrolled down");
			BrowserSettings.childTest.info(e);
			throw e;
		}

	}

	public void ClickonForwardbuttonSC() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Forward Button");

		ad = new ActionDriver();
		if (driver.findElement(By.xpath(
				"//body/app-root[1]/app-main[1]/div[1]/div[1]/div[1]/app-dashboard-existing[1]/form[1]/div[1]/div[2]/div[1]/div[3]/app-list-scenario[1]/p-card[1]/div[1]/div[2]/div[1]/p-table[1]/div[1]/p-paginator[1]/div[1]/a[4]"))
				.isEnabled()) {
			ad.click(driver, btnForward, "Forwardbutton clicked Successfully");
			Log.info("Successfully clicked on forward button on scenario dashboard");
		}
	}

	public void clickActionbuttonSC() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Action Button of Scenario");

		System.out.println(SelectScenario);
		try {
			driver.findElement(By.xpath("//td[text()='" + SelectScenario
					+ "']//following-sibling::td//span[@class='ui-button-text ui-clickable']")).click();
			BrowserSettings.parentTest.pass("Successfully clicked on Select Scenario");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.parentTest.fail("Unable to Successfully clicked on Select Scenario");
			BrowserSettings.childTest.info(e);
			throw e;

		}

		Log.info("Successfully clicked on action button of selected scenario ");
	}

	public void ClickRenamebuttonSC() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Rename Button of Scenario");
		ad = new ActionDriver();
		ad.click(driver, btnrename, "Clicked on RenameButton successfully");
		Log.info("Successfully clicked on rename button of selected scenario ");

	}

	public void paginationScenario() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Pagination of the Scenario");

		int pagination = driver.findElements(By.xpath(
				"/html/body/app-root/app-main/div/div[1]/div/app-dashboard-existing/form/div/div[2]/div/div[3]/app-list-scenario/p-card/div/div[2]/div/p-table/div/p-paginator/div/span/a"))
				.size();

		System.out.println(pagination);

		List<String> ScenarioNames = new ArrayList<String>();
		boolean broke = false;
		for (int i = 1; i <= pagination; i++) {

			String Paginationselector = "//a[contains(text(),'" + i + "')]";
			WebElement we = driver.findElement(By.xpath(Paginationselector));
			ad = new ActionDriver();

			ad.movetoelementandclick(driver, we, "ClickonPagenumber");

			Thread.sleep(1000);
			List<WebElement> scenarioname = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[1]"));
			System.out.println(scenarioname.size());

			for (WebElement webElement : scenarioname) {
				one = webElement.getText();
				System.out.println(one);
				ScenarioNames.add(one);

				if (one.equals(SelectScenariotoberanamed)) {

					Thread.sleep(2000);
					ad = new ActionDriver();
					String clickaction = "//td[text()='" + SelectScenariotoberanamed
							+ "']//following-sibling::td//span[@class='ui-button-text ui-clickable']";
					WebElement we2 = driver.findElement(By.xpath(clickaction));
					ad.click(driver, we2, "click onelement");

					Thread.sleep(10000);
					ad.click(driver, btnrename, "Renamebutton");
					broke = true;
					if (broke)
						break;
				}

			}
			System.out.println(broke);
			if (broke)
				break;
		}
		Log.info("Successfully clicked on all pages and clicked on action>rename button of selected scenario ");
	}

	public void renameScenario() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Rename Scenario");
		renameScenarioName = excel.getCellData("Sheet1", "Value", 23);
		renameScenarioDescrption = excel.getCellData("Sheet1", "Value", 24);

		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.clear(txtRenameScenarioName, "RenameTextBox");
		Log.info("Successfully cleared Rename Scenario Name text box ");
		Thread.sleep(10000);
		ad.clear(txtRenameScenarioDesc, "RenameScenarioDescriptionTextBox");
		Log.info("Successfully cleared Rename Scenario Description text box ");
		ad.typenew(txtRenameScenarioName, renameScenarioName, "scenarioname");
		Log.info("Successfully typed Rename Scenario name into text box ");
		ad.typenew(txtRenameScenarioDesc, renameScenarioDescrption, "scenarioDescription");
		Log.info("Successfully typed Rename Scenario description into text box ");
		ad.click(driver, btnSave, "Savebutton");
		Log.info("Successfully Clicked on SAVE button ");
		Log.info("Successfully Clicked on confirm button ");
		RenameConfirm = ad.GetText(mssgRenameSuccessfullyConfirm, "Rename Scenario Message Captured Successfully");

	}

	public void paginationScenarioArchieve() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Pagination of the Scenario");

		int pagination = driver.findElements(By.xpath(
				"/html/body/app-root/app-main/div/div[1]/div/app-dashboard-existing/form/div/div[2]/div/div[3]/app-list-scenario/p-card/div/div[2]/div/p-table/div/p-paginator/div/span/a"))
				.size();

		System.out.println(pagination);
		Log.info("total number of available pages are counted");

		List<String> ScenarioNames = new ArrayList<String>();
		boolean broke = false;
		for (int i = 1; i <= pagination; i++) {

			String Paginationselector = "//a[contains(text(),'" + i + "')]";
			Log.info("Xpath for first page number elemenet is saved in  Paginationselector string");
			WebElement we = driver.findElement(By.xpath(Paginationselector));
			ad = new ActionDriver();
			Log.info("Xpath for first page number elemenet is saved in  Webelement");
			ad.movetoelementandclick(driver, we, "ClickonPagenumber");

			Thread.sleep(1000);
			List<WebElement> scenarioname = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[1]"));
			System.out.println(scenarioname.size());

			for (WebElement webElement : scenarioname) {
				one = webElement.getText();
				System.out.println(one);
				ScenarioNames.add(one);

				if (one.equals(selectScenariotoArchieved)) {

					Thread.sleep(2000);
					ad = new ActionDriver();
					String clickaction = "//td[text()='" + selectScenariotoArchieved
							+ "']//following-sibling::td//span[@class='ui-button-text ui-clickable']";
					WebElement we2 = driver.findElement(By.xpath(clickaction));
					ad.click(driver, we2, "click onelement");

					Thread.sleep(10000);
					ad.click(driver, btnArchieve, "Archievebutton");
					broke = true;
					if (broke)
						break;
				}

			}
			System.out.println(broke);
			if (broke)
				break;
		}
		Log.info("Successfully clicked on all pages and clicked on action>rename button of selected scenario ");
		archieveConfirm = ad.GetText(mssgArchieveSuccessfullyConfirm, "Captured Archive Successfully message ");
		System.out.println(archieveConfirm);
	}

	public void ReadProjectIndicator_old() throws InterruptedException, IOException {
		int totalIndicators = driver.findElements(By.xpath("//span[@class='item-right-orange']")).size();
		System.out.println(totalIndicators);
		List<String> IndicatorValues = new ArrayList<String>();
		for (int i = 1; i <= totalIndicators; i++) {

			String indicators = "(//span[@class='item-right-orange'])[" + i + "]";
			WebElement we = driver.findElement(By.xpath(indicators));
			ad = new ActionDriver();

			String indval = ad.GetText(we, "Indicator Captured Successfully");
			System.out.println(indval);
			String[] indi = { "a", "b", "c", "d", "e" };
			for (int j = 0; j < indi.length; j++) {
				System.out.println(indi[j]);
				// indi[j]=indval;

			}

			// System.out.println(indval);
			IndicatorValues.add(indval);
			System.out.println(IndicatorValues.size() + "size");

		}

	}

	public void readPNVY1() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read PNVY1");

		ad = new ActionDriver();
		PNVR1 = ad.GetText(PNV, "Read PNVY1 Successfully");
		String PNV = ad.replacechartwo(PNVR1, "st", ',', '.');

		PNVY1num = PNV.replaceAll("[^\\d.]", "");

		/*
		 * if(PNVR1.contains(" kR$")) { String Trm1= " kR$";
		 * PNVY1num=PNVR1.replace(Trm1,""); }
		 * 
		 * else if (PNVR1.contains(" k€")) { String Trm= " k€";
		 * PNVY1num=PNVR1.replace(Trm,""); } else if (PNVR1.contains(" k$US")) { String
		 * Trm= " k$US"; PNVY1num=PNVR1.replace(Trm,""); } else if
		 * (PNVR1.contains(" kTHB")) { String Trm= " kTHB";
		 * PNVY1num=PNVR1.replace(Trm,""); }
		 * 
		 * else if (PNVR1.contains(" k?")) { String Trm2= " k?";
		 * PNVY1num=PNVR1.replace(Trm2,"");
		 * 
		 * }
		 */
		System.out.println("Values of PNV(Y1) on Project/Glass dashboard is " + PNVY1num);
		// Log.info("Successfully read PNV(Y1) on project/Glapp Position Dashboard ");
	}

	public void readMVCY1() throws IOException {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read MVCY1");
		ad = new ActionDriver();
		MVC1 = ad.GetText(MVC, "Successfully Captured MVC value");
		System.out.println("Values of MVC(Y1) on Project/Glass dashboard is " + MVC1);
		// Log.info("Successfully read MVC(Y1) on project/Glapp Position Dashboard ");
	}

	public void readRBCY1() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read RBCY1");
		ad = new ActionDriver();
		RBCY1 = ad.GetText(RBC, "Successfully Captured RBC value");
		System.out.println("Values of RBC(Y1) on Project/Glass dashboard is " + RBCY1);
		// Log.info("Successfully read RBC(Y1) on project/Glapp Position Dashboard ");
	}

	public void readEM() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read EM");
		ad = new ActionDriver();
		em = ad.GetText(EM, "Successfully Captured EM value");
		System.out.println("Values of EM on Project/Glass dashboard is " + em);
		// Log.info("Successfully read EM on project/Glapp Position Dashboard ");
	}

	public void readPBR() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read PBR");
		ad = new ActionDriver();
		pbr = ad.GetText(PBR, "Successfully Captured PBR value");
		System.out.println("Values of PBR on Project?Glass dashboard is " + pbr);
		// Log.info("Successfully read PBR on project/Glapp Position Dashboard ");
	}

	public void selectGlassPosition(String testcase) throws InterruptedException, IOException {

		CashSimulation cs = new CashSimulation();
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Glass Position");
		if (testcase == "verifytakerate-cashflow") {

			if (!cs.GPone.equals("NULL")) {
				Thread.sleep(10000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//td[text()='" + cs.GPone
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ele.click();
				Thread.sleep(10000);
				driver.navigate().back();
				// driver.findElement(By.xpath("//td[text()='"+cs.GPone+"']//following-sibling::td//button//span[text()='Edit
				// Price & Cost']")).click();

			}
			if (!cs.GPtwo.equals("NULL")) {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//td[text()='" + cs.GPtwo
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ele.click();

				// driver.findElement(By.xpath("//td[text()='"+cs.GPtwo+"']//following-sibling::td//button//span[text()='Edit
				// Price & Cost']")).click();
				Thread.sleep(1000);
				driver.navigate().back();
				Thread.sleep(1000);

			}
			if (!cs.GPthree.equals("NULL")) {
				driver.findElement(By.xpath("//td[text()='" + cs.GPthree
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']")).click();

			}

		}

		else if (testcase == "verifyQuotedPrice") {
			if (!cs.GPone.equals("NULL")) {
				Thread.sleep(10000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//td[text()='" + cs.GPone
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ele.click();

				Thread.sleep(10000);
				GlassPositionDashboard gs = new GlassPositionDashboard();
				gs.openCostDashboard();
				Thread.sleep(10000);

				CostDashboard cd = new CostDashboard();

				QuotedPriceGP1 = cd.readQuotedPriceAverageGlassPosition();
				System.out.println("Quoted Price for "+cs.GPone+" on Cost Dashboard is  "+ QuotedPriceGP1);
				BrowserSettings.parentTest.info("Quoted Price for "+cs.GPone+" on Cost Dashboard is  "+ QuotedPriceGP1);

				driver.navigate().back();
				Thread.sleep(10000);
				driver.switchTo().activeElement();
				Thread.sleep(10000);
				driver.findElement(By.xpath("(//div[@role='dialog']//child::div[2])[3]")).click();
				Thread.sleep(10000);
				driver.navigate().back();
				// driver.findElement(By.xpath("//td[text()='"+cs.GPone+"']//following-sibling::td//button//span[text()='Edit
				// Price & Cost']")).click();

			}
			if (!cs.GPtwo.equals("NULL")) {

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//td[text()='" + cs.GPtwo
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ele.click();

				// driver.findElement(By.xpath("//td[text()='"+cs.GPtwo+"']//following-sibling::td//button//span[text()='Edit
				// Price & Cost']")).click();
				Thread.sleep(10000);
				GlassPositionDashboard gs = new GlassPositionDashboard();
				gs.openCostDashboard();

				CostDashboard cd = new CostDashboard();

				QuotedPriceGP2 = cd.readQuotedPriceAverageGlassPosition();
				System.out.println("Quoted Price for "+cs.GPtwo+" on Cost Dashboard is  "+ QuotedPriceGP2);
				BrowserSettings.parentTest.info("Quoted Price for "+cs.GPtwo+" on Cost Dashboard is  "+ QuotedPriceGP2);

				Thread.sleep(10000);

				driver.navigate().back();
				driver.findElement(By.xpath("(//div[@role='dialog']//child::div[2])[3]")).click();
				Thread.sleep(10000);
				driver.navigate().back();

				Thread.sleep(1000);

			}
			if (!cs.GPthree.equals("NULL")) {
				driver.findElement(By.xpath("//td[text()='" + cs.GPthree
						+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']")).click();
				Thread.sleep(10000);
				GlassPositionDashboard gs = new GlassPositionDashboard();
				gs.openCostDashboard();

				CostDashboard cd = new CostDashboard();
				Thread.sleep(10000);
				QuotedPriceGP3 = cd.readQuotedPriceAverageGlassPosition();
				System.out.println("Quoted Price for "+cs.GPthree+" on Cost Dashboard is  "+ QuotedPriceGP3);
				BrowserSettings.parentTest.info("Quoted Price for "+cs.GPthree+" on Cost Dashboard is  "+ QuotedPriceGP3);
				driver.navigate().back();
				driver.findElement(By.xpath("(//div[@role='dialog']//child::div[2])[3]")).click();
				Thread.sleep(10000);
				driver.navigate().back();

				Thread.sleep(1000);
			}
		}

		else if (testcase == "other") {

			glassPosition = excel.getCellData("Sheet1", "Value", 26);
			driver.findElement(By.xpath("//td[text()='" + glassPosition
					+ "']//following-sibling::td//button//span[text()='Edit Price & Cost']")).click();

		}

		// Log.info("Successfully Selected Glass Position");
	}

	public void verifyInternalValidationStatus() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Get Internal Validation Status");
		ad = new ActionDriver();
		internalVal = ad.GetText(internalValidation, "Successfully Captured internal validation status");
		System.out.println(internalVal);
		// Log.info("Successfully Verified and read the status of Internal Validation");

	}

	public void clickExcelDropdown() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on the Excel Drop-down");
		ad = new ActionDriver();
		ad.click(driver, excelDropdown, "Clicked on exelExportMenu Successfully");
		// Log.info("Successfully Clicked on Excel Drop down");
	}

	public boolean existenceImportOption() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Verify for the Import Option");
		ad = new ActionDriver();
		existImport = ad.checkExistence(excelImportMenu, "Excel import");
		// Log.info("Successfully Verified existence of Import button");
		return existImport;

	}

	public void selectCurrency() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Verify for the Currency Selection");

		ad = new ActionDriver();

		ad.movetoelementandclick(driver, currencyDropDown, "clickon currency dropdown");
		ad.clear(currencyDropDown, "Cleard Currency");
		Thread.sleep(1000);
		ad.typenew(currencyDropDown, "EUR", "typed Euro into the currencydrop down");
		Thread.sleep(1000);
		try {
			ad.movetoelementandclick(driver, currencyEuro, "Seleced Euro");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("Euro is alread selected");
		}

	}

	public void readCarProduction() throws IOException, InterruptedException {
		Thread.sleep(10000);
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Read Car Production");

		ad = new ActionDriver();
		String CarProductionValue = ad.GetText(CarProduction, "ReadCarProductionSuccessfully");

		CP = CarProductionValue.replaceAll("[^\\d.]", "");
		System.out.println("Car production value on Project Dashboard is " + CP);
		BrowserSettings.parentTest.info("Car production value on Project Dashboard is " + CP);

	}

}
