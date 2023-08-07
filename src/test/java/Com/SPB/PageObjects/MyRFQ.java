package Com.SPB.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class MyRFQ extends BrowserSettings {
	ActionDriver ad;
	public static String devcode;

	@FindBy(xpath = "//input[@placeholder='Global Search ..']")
	public static WebElement txtsearchproject;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and contains(text(),\"Marketing Guidelines - Last update date : \")]")
	public static WebElement txtMarketingGuidelines;

	// span[@class='ui-button-text ui-clickable' and contains(text(),"Marketing
	// Guidelines - Last update date : ")]
	public MyRFQ() {
		PageFactory.initElements(driver, this);
	}

	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH") + "\\" + fileName;
	ExcelOpearations excel = new ExcelOpearations(path);

	public void GlobalSearch(String test) throws IOException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Global Search Verification");
		ad = new ActionDriver();
		if (test == "cashsimulation") {
			devcode = excel.getCellData("CashSimulation", "Value", 6);
			System.out.println("devcode is " + devcode);
			ad.typenew(txtsearchproject, devcode, "Typed dev code into GlobalSearch box successfully");
			Log.info(" Devcode Sucessfully typed in GlobalSeach test box ");
		}
		else {
		devcode = excel.getCellData("Sheet1", "Value", 18);

		ad.typenew(txtsearchproject, devcode, "Typed dev code into GlobalSearch box successfully");
		Log.info(" Devcode Sucessfully typed in GlobalSeach test box ");
		}
	}

	public void ClickMarketingGuidelines() throws IOException {
		ad = new ActionDriver();
		BrowserSettings.childTest = BrowserSettings.parentTest
				.createNode("Marketing Guidelines Verification Verification");
		ad.click(driver, txtMarketingGuidelines, "Clicked on Marketing Guidelines button successfully");
	}

	public void Openbutton() {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Open button");
		try {
			driver.findElement(By.xpath("//td[text()='" + devcode + "']//following-sibling::td//span[text()='Open']"))
					.click();
			BrowserSettings.parentTest.pass("Clicked on Open button Successfully");
		} catch (Exception e) {
			// TODO: handle exception
			BrowserSettings.childTest.fail("Unable to Clicked on Open button Successfully");
			BrowserSettings.childTest.info(e);
			throw e;
		}

		Log.info("Sucessfully clicked on Open button ");
	}

}
