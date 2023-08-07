package Com.SPB.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class DraftProjectFlow extends BrowserSettings {
	ActionDriver ad;
	public static String confirmmessage;
	public static String projectavailablenow;

	
	

	@FindBy(xpath = "//input[@class='ui-fluid ui-inputtext ng-untouched ng-pristine ng-invalid ui-corner-all ui-state-default ui-widget']")
	private WebElement txtCarProduction;

	@FindBy(xpath = "//input[@class='ui-fluid ui-inputtext ng-untouched ng-pristine ng-valid ui-corner-all ui-state-default ui-widget']")
	private WebElement txtCarRoofQuantities;

	@FindBy(xpath = "//input[@class='ui-fluid ui-inputtext ng-untouched ng-pristine ng-valid ui-corner-all ui-state-default ui-widget']")
	private WebElement checkboxGP;
	
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Create Draft']")
	private WebElement btnCreateDraft;
	
	@FindBy(xpath = "//span[text()='Previous']")
	private WebElement btnPrevious;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Confirm']")
	private WebElement ConfirmButton;
	
	@FindBy(xpath = "//label [text()=' Confirm Project Importation']")
	private WebElement ConfirmProjectImportMessage;

	@FindBy(xpath = "//span[@class=\"ui-messages-summary ng-tns-c11-16 ng-star-inserted\"]")
	private WebElement ProjectAvailableMessage;

	@FindBy(xpath = "//span[text()='Complete']")
	private WebElement CompleteButtonProjectimport;
	
	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down']")
	private WebElement ClickCurrencyDropdown;
	
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Confirm ' ]")
	private WebElement btnCurrencyConfirm;
	
	
	

	public DraftProjectFlow() {
		PageFactory.initElements(driver, this);
	}
	public static String fileName = "PriceBuilderData.xlsx";
	public static String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	public static ExcelOpearations excel=new ExcelOpearations(path);

	public static String Carproduction = excel.getCellData("Sheet1", "Value", 10);
	public static String RoofQuanties = excel.getCellData("Sheet1", "Value", 11);
	public static String GP1 = excel.getCellData("Sheet1", "Value", 12);
	public static String GP2 = excel.getCellData("Sheet1", "Value", 13);
	public static String GP3 = excel.getCellData("Sheet1", "Value", 14);
	public static String GP4 = excel.getCellData("Sheet1", "Value", 15);
	public static String currency=excel.getCellData("Sheet1", "Value", 16);

	public void EnterCarproduction() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Enter Car Production Value");

		ad = new ActionDriver();
		ad.typenew(txtCarProduction, Carproduction, "Car production value entered successfully");
		Log.info("Entered the Car Production value successfully ");

	}

	public void EnterRoofQuantities() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Enter Roof Quantities");

		ad = new ActionDriver();
		ad.typenew(txtCarRoofQuantities, RoofQuanties, "RoofQuanties value entered Successfully");
		Log.info("Entered the Roof Quantities value successfully ");
	}

	public void SelectGPone() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select GP one");
		ad = new ActionDriver();
		
		try {
			driver.findElement(By.xpath("//label[@class='ng-star-inserted ui-chkbox-label' and text()='" + GP1 + "']"))
			.click();
			BrowserSettings.childTest.pass("Successfully selected the Glass Position" + GP1 );
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Unable to clicked on  : " + GP1 ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		
		Log.info("Selected first Glass Postion ");

	}

	public void SelectGPtwo() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select GP two");
		ad = new ActionDriver();
		try {
			driver.findElement(By.xpath("//label[@class='ng-star-inserted ui-chkbox-label' and text()='" + GP2 + "']"))
			.click();
			BrowserSettings.childTest.pass("Successfully selected the Glass Position" + GP2 );
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Unable to clicked on  : " + GP2 ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		
		Log.info("Selected Second Glass Postion ");
	}

	public void SelectGPthree() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select GP three");
		ad = new ActionDriver();
		try {
			driver.findElement(By.xpath("//label[@class='ng-star-inserted ui-chkbox-label' and text()='" + GP3 + "']"))
			.click();
			BrowserSettings.childTest.pass("Successfully selected the Glass Position" + GP3 );
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Unable to clicked on  : " + GP3 ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			BrowserSettings.childTest.info(e);
			throw e;
			// TODO: handle exception
		}
		
		Log.info("Selected third Glass Postion ");
	}

	public void SelectGPfour() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select GP four");
		ad = new ActionDriver();
		try {
			driver.findElement(By.xpath("//label[@class='ng-star-inserted ui-chkbox-label' and text()='" + GP4 + "']"))
			.click();
			BrowserSettings.childTest.pass("Successfully selected the Glass Position" + GP4 );
		} catch (Exception e) {
			BrowserSettings.childTest.fail("Unable to clicked on  : " + GP4 ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			BrowserSettings.childTest.info(e);
			// TODO: handle exception
		}
		
		Log.info("Selected fourth Glass Postion ");

	}
	
	public void ClickCreateDraft() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on Create Draft button");
		ad = new ActionDriver();
		ad.click(driver, btnCreateDraft, "Clicked on CreateDraft Button Successfully");
		Log.info("Clicked on Create Draft button");
	}
	
	public void ClickonPrevious() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on Previous button");
		ad=new ActionDriver();
		ad.click(driver, btnPrevious, "Clicked on Previous Button Successfully");
		Log.info("Clicked on previous button");
	}

	public void ClickConfirmbtn() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on Confirm button");
		ad = new ActionDriver();
		ad.click(driver, ConfirmButton, "Clicked on ConfirmButton Successfully");
		Log.info("Clicked on Confirm button");
	}

	public void getConfirmmessage() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Get Confirmation message");
		
		confirmmessage = ad.GetText(ConfirmProjectImportMessage, "Confirmation Draft Message captured successfully ");
		Log.info("Successfully read the Confirm message");
	}

	public void projectavailablenowmessage() throws InterruptedException, IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Verify project available message");
		Thread.sleep(10000);
		projectavailablenow = ad.GetText(ProjectAvailableMessage, "Project Available Message Captured Successfully");
		System.out.println(projectavailablenow);
		Log.info("Successfully read the project available now  message");
	}

	public void ClickonProjectImportComplete() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on the Complete button");
		ad = new ActionDriver();
		ad.click(driver, CompleteButtonProjectimport, "Complete Button to IMport project is clicked Successfully");
		Log.info("Successfully clicked on the Project Import COMPLETED button");

	}
	
	public void SelectCurrency() throws IOException, InterruptedException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Select Currency");
		ad = new ActionDriver();
		ad.click(driver, ClickCurrencyDropdown, "Clicked on CurrenCy Dropdown successfully");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+currency+"']")).click();
		Log.info("Successfully Selected the currency");

	}
	public void ClickConfirmCurrency() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on Confirm button");
		ad = new ActionDriver();
		ad.click(driver, btnCurrencyConfirm, "Clicked on ConfirmCurrency button successfully ");
		Log.info("Successfully Clicked on Confirm currently button");
	}
	public String screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
}
}