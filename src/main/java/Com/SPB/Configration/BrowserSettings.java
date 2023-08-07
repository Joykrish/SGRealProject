package Com.SPB.Configration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSettings {
	public static WebDriver driver;
	ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	Properties property;

	//@BeforeTest
	public void loadConfig() {
		// ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("org.freemarker.loggerLibrary", "none");

		try {
			property = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Config.properties");
			property.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void report() {
		String fileName = "Demotest.html";
		String pathreport = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH");
		pathreport = pathreport + "\\" + fileName;
		htmlreporter = new ExtentHtmlReporter(pathreport);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}

	@BeforeMethod
	public void method(Method method) {
		parentTest = extent.createTest(method.getName());
	}

	@BeforeClass
	public void beforeClass() {
		String fileNamechrome = "msedgedriver.exe";
		String pathchromeone = System.getenv("HOMEDRIVE") + "" + System.getenv("HOMEPATH");
		pathchromeone = pathchromeone + "\\" + fileNamechrome;

		System.setProperty("webdriver.edge.driver", pathchromeone);
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chrome\\chromedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
	driver.close();
		extent.flush();
	}
}