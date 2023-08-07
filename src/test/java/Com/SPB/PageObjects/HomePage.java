package Com.SPB.PageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class HomePage extends BrowserSettings {
	
	String Projecttobesearched;
	
	
	//ExcelOpearations excel=new ExcelOpearations("C://Users//j8994868//eclipse-workspace//IMASM//PriceBuilderVersion1//TestData//PriceBuilderData.xlsx");

	LoginWithSSO obj;
	public static String logo;

	ActionDriver ad;
	

	
	@FindBy(xpath = "//input[@placeholder='Global Search ..']")
	public static WebElement txtsearchprojectGlobal;
	

	@FindBy(xpath = "//input[@placeholder='Search a Project By Devcode']")
	private WebElement txtsearchproject;

	@FindBy(xpath = "//div[text()='X-Calc']")
	private WebElement xCalcLogo;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/app-topbar[1]/div[1]/ul[1]/li[3]/p-autocomplete[1]/span[1]/div[1]/ul[1]/li[1]/div[1]/div[1]")
	private WebElement firstelement;

	@FindBy(xpath = "//div[@class='background-img-admin new-project']")
	private WebElement ImglinkNewRFQ;
	
	@FindBy(xpath = "//div[@class='background-img-admin  my-project']")
	private WebElement ImglinkMYRFQ;
	
	@FindBy(xpath = "//div[@class='background-img-admin kpi']")
	private WebElement ImgBenchMarkPrice;
	
	@FindBy(xpath = "//div[@class='background-img-admin validation']")
	private WebElement ImgValidation;
	
	@FindBy(xpath = "//div[@class='background-img administration']")
	private WebElement ImgAdmin;
	
	

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public static String devcodetobeseached;
	String fileName = "PriceBuilderData.xlsx";
	//String path =System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH");
	String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	ExcelOpearations excel=new ExcelOpearations(path);
	

	public String GetXcalclogo() throws IOException {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Captured Get Xcalc Logo");
		ad=new ActionDriver();

		//return logo = xCalcLogo.getText();
		return logo=ad.GetText(xCalcLogo, "Caputured Xcalc Logo Successfully");

	}
	
	
	public void searchProject(String testcases) throws Exception {
	
		
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Search Project");
		
		if(testcases=="Cashflow") {
			devcodetobeseached=excel.getCellData("CashSimulation", "Value",6);
			Projecttobesearched=excel.getCellData("CashSimulation", "Valueone",6);
			
		}
		else if ((testcases=="other")){
			devcodetobeseached=excel.getCellData("Sheet1", "Value",2);
		    Projecttobesearched=excel.getCellData("Sheet1", "Valueone",2);
			System.out.println(Projecttobesearched);
		}
		
		
		
		System.out.println(devcodetobeseached);
		obj = new LoginWithSSO();
		obj.loginintoapplication();
		//Log.info("Succefully logined into the application");
		Thread.sleep(10000);

		ad = new ActionDriver();
		ad.typenew(txtsearchproject, devcodetobeseached, "Typed the dev code into the textbox successfully");
		Thread.sleep(1000);
		//Log.info("Sucessfully typed the projectname to the Global Searh box");
		List<WebElement> searchbox=driver.findElements(By.xpath("/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/app-topbar[1]/div[1]/ul[1]/li[3]/p-autocomplete[1]/span[1]/div[1]/ul[1]/li[1]/div[1]/div[1]"));
		System.out.println(searchbox.size());
		if(searchbox.size()==0) {
			
			
			  ad.click(driver, txtsearchproject, "");
			  txtsearchproject.sendKeys(Keys.BACK_SPACE); Thread.sleep(1000);
			  
			  ad = new ActionDriver();
			  
			  clickProject();
			 
			
			
			
		}
		else {
			
			clickProject();
			
			//ad.click(driver, firstelement, "first element to be clicked");
		}
		
		//if(firstelement.isDisplayed()) {
		//ad.click(driver, firstelement, "FirstSeachResult");
		//Log.info("typed successfully in the  Searh box at first attempt");
		//}
		//else {
			//ad = new ActionDriver();
			//ad.clear(txtsearchproject, "seachrpoject");
			//ad.typenew(txtsearchproject, devcodetobeseached, "SearchProject");
			//Log.info(" typed successfully in the  Searh box at second attempt");
			
		//}
		//Log.info("Sucessfully Clicked the first projectname in to the Global Searh box");
		
	}
	
public void clickProject() throws IOException {
	
		
		
		int totalproject=driver.findElements(By.xpath("//li[@role='option']")).size();
		System.out.println(totalproject);
		

		List<String> ProjectNames = new ArrayList<String>();
		boolean broke = false;
		for (int i = 1; i <= totalproject; i++) {

			String ProjectSelectorselector = "(//li[@role='option'])["+i+"]";
					
			WebElement we = driver.findElement(By.xpath(ProjectSelectorselector));
			
		String ProjectName=we.getText();
		//System.out.println(ProjectName);
		ProjectNames.add(ProjectName);
		if(ProjectName.equals(Projecttobesearched)) {
			we.click();
			
		}
		
		
		}
		broke=true;
	}

	
	public void OpenNewRFQ() throws Exception  {
		
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on ImageNEWRFQ");
		
		Thread.sleep(10000);
		ad = new ActionDriver();
		ad.click(driver, ImglinkNewRFQ, "Clicked on ImageNEWRFQ seccessfully");
		Log.info("Clicked on ImageNEWRFQ seccessfully");
	}

	public void OpenMyRFQ() throws Exception {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on ImageMYRFQ");
		
		Thread.sleep(10000);
		ad = new ActionDriver();
		ad.click(driver, ImglinkMYRFQ, "Clicked on ImageMyRFQ seccessfully");
		Log.info("Clicked on ImageMyRFQ seccessfully");
	}
	
	public void OpenBenchMarkPRice() throws Exception {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on ImageBenchMarkPRice");
		
		Thread.sleep(10000);
		ad = new ActionDriver();
		ad.click(driver, ImgBenchMarkPrice, "Clicked on ImageBenchMarkPrice seccessfully");
		Log.info("Clicked on ImageBenchMarkPrice seccessfully");
	}
	
	public void OpenValidation() throws Exception {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on ImageValidation");
		
		Thread.sleep(10000);
		ad = new ActionDriver();
		ad.click(driver, ImgValidation, "Clicked on ImageValidation seccessfully");
		Log.info("Clicked on ImageValidation seccessfully");
	}
	public void OpenAdministration() throws Exception {
		BrowserSettings.childTest=BrowserSettings.parentTest.createNode("Click on ImageAdministration");
		
		Thread.sleep(10000);
		ad = new ActionDriver();
		ad.click(driver, ImgAdmin, "Clicked on OpenAdministration seccessfully");
		Log.info("Clicked on ImageAdministration seccessfully");
	}


}
