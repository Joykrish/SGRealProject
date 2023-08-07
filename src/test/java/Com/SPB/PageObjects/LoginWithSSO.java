package Com.SPB.PageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class LoginWithSSO extends BrowserSettings {
	Properties property;
	FileInputStream fs;
	ActionDriver ad;

	@FindBy(xpath = "//span[text()='Sign in  ']")
	private WebElement btnSignin;

	@FindBy(xpath = "//input[@id='login.submit.id']")
	private WebElement btnconnection;

	@FindBy(xpath = "//*[@id=\"content\"]/div/form/fieldset/div[2]/div/button[2]")
	private WebElement btnallow;

	public LoginWithSSO() {
		PageFactory.initElements(driver, this);
	}

	public HomePage loginintoapplication() throws Exception {

		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Loign into the Application");

		// fs= new
		// FileInputStream(System.getProperty("C://Users//j8994868//eclipse-workspace//IMASM//PriceBuilderVersion1//src//main//java//Com//SPB//Configuration//Config.properties"));
	//	Log.info("set the path for congig file");
		fs = new FileInputStream(System.getProperty("user.dir") + "\\Config.properties");
		property = new Properties();
		property.load(fs);

		ad = new ActionDriver();

		// ad.navigateToApplication("https://dev-xcalc.sekurit.saint-gobain.com/");
		//Log.info("read the url from config file and save this into the url string variable");
		String url = property.getProperty("url");
		System.out.println(url);
		Log.info("printed the url successfully");
		ad.navigateToApplication(url);
		//Log.info("navigated to application successully");
		try {
			driver.findElement(By.xpath("//span[text()='Sign in  ']")).click();
			BrowserSettings.childTest.pass(" Clicked SignINbutton");
			//ad.click(driver, btnSignin, "SignINbutton");
			//Log.info("clicked on sign buttton successfully");
		} catch (Exception e) {

			//Log.info("button doesn't exist");
		}

		try {
			//ad.click(driver, btnconnection, "ConnectionButton");
			driver.findElement(By.xpath("//input[@id='login.submit.id']")).click();
			BrowserSettings.childTest.pass(" Clicked ConnectionButton");
			//Log.info("clicked on connection successfully");
		} catch (Exception e) {
			//Log.info("clicked on connection doesn't exist");
			// TODO: handle exception
		}

		Thread.sleep(1000);
		return new HomePage();

	}

}
