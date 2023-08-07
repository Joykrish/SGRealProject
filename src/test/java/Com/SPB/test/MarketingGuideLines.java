package Com.SPB.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.MyRFQ;

public class MarketingGuideLines extends BrowserSettings {
	@Test(enabled=true)
	public void MarktingGuidelines() throws Exception {
		LoginWithSSO lg = PageFactory.initElements(driver, LoginWithSSO.class);
		HomePage Hm = PageFactory.initElements(driver, HomePage.class);
		MyRFQ RQ = PageFactory.initElements(driver, MyRFQ.class);

		Log.info("Login into the application");
		lg.loginintoapplication();
		Hm.OpenMyRFQ();
		Thread.sleep(1000);
		RQ.ClickMarketingGuidelines();
		Thread.sleep(10000);
		File filelocation = new File("C:\\Users\\j8994868\\Downloads");
		System.out.println(filelocation);
		File[] totalFiles = filelocation.listFiles();
		List<String> DownloadedFiles = new ArrayList<String>();
		for (File file : totalFiles) {
			String FName=file.getName();
			DownloadedFiles.add(FName);
			
		}
		System.out.println(DownloadedFiles);
			
			if (DownloadedFiles.contains("GuidelinePrices.xlsx")) {
				System.out.println("File downloaded successfully");
				BrowserSettings.parentTest.pass("PASS:File Downloaded Successfully");
				
			}
			else {
				System.out.println("File is not downloaded successfully");
				BrowserSettings.parentTest.fail("FAIL:File is not Downloaded Successfully");
				
			}

		}

	}

