package Com.SPB.PageObjects;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class validation extends BrowserSettings{
	
	public static String vaDevcode;
	
	@FindBy(xpath = "//span[text()='All Pending projects']")
	public static WebElement tabAllhproject;
	
	@FindBy(xpath = "//input[@icon='pi pi-user']")
	public static WebElement txtsearchproject;
	
	@FindBy(xpath = "//span[text()='Open']")
	public static WebElement btnOpen;
	
	
	
	
	
	
	ActionDriver ad=new ActionDriver();
	
	
	MyRFQ MR = PageFactory.initElements(driver, MyRFQ.class);
	
	public validation() {
		PageFactory.initElements(driver, this);
	}
	public void searchProjectGlobal() throws IOException, NoSuchElementException {
		
BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Global Search Verification");
		
 String fileName = "PriceBuilderData.xlsx";
 String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
 ExcelOpearations excel=new ExcelOpearations(path);

		
	 vaDevcode=excel.getCellData("Sheet1", "Valueone",18);
		ad = new ActionDriver();
		ad.typenew(txtsearchproject, vaDevcode, "Typed in GlobalSearch box Successfully");	
		Log.info(" Devcode Sucessfully typed in GlobalSeach test box ");
	}
	public void openMyProjects() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("openMyProjects");
		ad.click(driver, tabAllhproject, "clicked on AllPrjects Tab Successfully");
		
	}
	public void clickOpenButton() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("open button");
		ad = new ActionDriver();
		ad.click(driver, btnOpen, "Clicked On Open Button Successfully");
		
		
	}
}
