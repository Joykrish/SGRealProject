package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class NewRFQ extends BrowserSettings {
	HomePage hp;
	ActionDriver ad;
	public static String projectsearchmessageone;
	public static String projectsearchmessagetwo;
	public static String fileName = "PriceBuilderData.xlsx";
	public static String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	public static ExcelOpearations excel=new ExcelOpearations(path);
	public static String Customer = excel.getCellData("Sheet1", "Value", 4);
	public static String Brand = excel.getCellData("Sheet1", "Value", 5);
	public static String DevCode = excel.getCellData("Sheet1", "Value", 6);
	public static String body = excel.getCellData("Sheet1", "Value", 7);
	public static String Region = excel.getCellData("Sheet1", "Value", 8);
	
	public static String Customerone = excel.getCellData("Sheet1", "Valueone", 4);
	public static String Brandone = excel.getCellData("Sheet1", "Valueone", 5);
	public static String DevCodeone = excel.getCellData("Sheet1", "Valueone", 6);
	public static String bodyone = excel.getCellData("Sheet1", "Valueone", 7);
	public static String Regionone = excel.getCellData("Sheet1", "Valueone", 8);

	@FindBy(xpath = ("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]"))
	private WebElement dropdownCustomer;

	@FindBy(xpath = ("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[2]"))
	private WebElement dropdownBrand;

	@FindBy(xpath = ("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[3]"))
	private WebElement dropdownDevCode;

	@FindBy(xpath = ("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[4]"))
	private WebElement dropdownBody;

	@FindBy(xpath = ("(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[5]"))
	private WebElement dropdownRegion;

	@FindBy(xpath = ("//span[@class='ui-button-text ui-clickable' and text()='Search ']"))
	private WebElement btnSearch;

	@FindBy(xpath = ("//span[ text()='Project not found on MPT']"))
	private WebElement mssgeexistenceofprojectone;
	
	@FindBy(xpath = ("//label[ text()=' Project already exists']"))
	private WebElement mssgeexistenceofprojecttwo;

	public NewRFQ() {
		PageFactory.initElements(driver, this);
	}

	public void importproject() throws Exception {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open RFQ");

		hp = new HomePage();
		hp.OpenNewRFQ();
		Log.info("Successfully opend the New RFQ module ");
	}

	public void selectCustomer() throws IOException, InterruptedException {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Customer");
		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.click(driver, dropdownCustomer, "CustomerDropdown");
		Thread.sleep(1000);
		System.out.println(Customer);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Customer + "')]"));
		ele.click();
		Log.info("Successfully selected the customer:" + Customer);

	}
	
	public void selectCustomerTwo() throws IOException, InterruptedException {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Customer");
		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.click(driver, dropdownCustomer, "CustomerDropdown");
		Thread.sleep(1000);
		System.out.println(Customer);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Customerone + "')]"));
		ele.click();
		Log.info("Successfully selected the customer:" + Customerone);

	}

	public void selectBrand() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Brand");
		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.click(driver, dropdownBrand, "ClickonBreandDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Brand + "')]"));
		ele.click();
		Log.info("Successfully selected the Brand:" + Brand);
	}
	
	public void selectBrandTwo() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Brand");
		ad = new ActionDriver();
		Thread.sleep(10000);
		ad.click(driver, dropdownBrand, "ClickonBreandDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Brandone + "')]"));
		ele.click();
		Log.info("Successfully selected the Brand:" + Brandone);
	}

	public void selectDevCode() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select DevCode");
		ad = new ActionDriver();
		ad.click(driver, dropdownDevCode, "ClickonDevDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + DevCode + "')]"));
		ele.click();
		Log.info("Successfully selected the DevCode:" + DevCode);
		
	}
	
	public void selectDevCodeTwo() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select DevCode");
		ad = new ActionDriver();
		ad.click(driver, dropdownDevCode, "ClickonDevDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + DevCodeone + "')]"));
		ele.click();
		Log.info("Successfully selected the DevCode:" + DevCode);
		
	}

	public void selectBody() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Body");
		ad = new ActionDriver();
		ad.click(driver, dropdownBody, "ClickonBodyDropdown");
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + body + "')]"));
		ele.click();
		Log.info("Successfully selected the Body:" + body);

	}
	
	public void selectBodyTwo() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Body");
		ad = new ActionDriver();
		ad.click(driver, dropdownBody, "ClickonBodyDropdown");
		Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + bodyone + "')]"));
		ele.click();
		Log.info("Successfully selected the Body:" + body);

	}

	public void selectRegion() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Region");
		ad = new ActionDriver();
		ad.click(driver, dropdownRegion, "ClickonRigionDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Region + "')]"));
		ele.click();
		Log.info("Successfully selected the Region:" + Region);
	}
	
	public void selectRegionTwo() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Select Region");
		ad = new ActionDriver();
		ad.click(driver, dropdownRegion, "ClickonRigionDropdown");
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'" + Regionone + "')]"));
		ele.click();
		Log.info("Successfully selected the Region:" + Region);
	}

	public void ClickSearch() throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Click on Search Button");
		ad.click(driver, btnSearch, "ClickOnSearchButton");
		Log.info("Successfully cliekd on Search button");
	}
//method to capture the message for project that does't exist in MPT
	public void messagecaptureone() throws InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Capture the message that project is not exist in MPT");
		Thread.sleep(10000);
		projectsearchmessageone = mssgeexistenceofprojectone.getText();
		System.out.println(projectsearchmessageone);
		Log.info("Successfully caputured the searchresult message");
	}
	
	//method to capture the message for project that exist in MPT
	public void messagecapturetwo() throws InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Capture the message that project is not exist in MPT");
		Thread.sleep(10000);
		projectsearchmessagetwo = mssgeexistenceofprojecttwo.getText();
		System.out.println(projectsearchmessagetwo);
		Log.info("Successfully captured the proect search message");
	}

}