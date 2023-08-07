package Com.SPB.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.LoginWithSSO;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class VerifyClick extends BrowserSettings {
	ActionDriver ad;
  @Test(dataProvider = "URLDATA")
  public void clickVerify(String url, String Filepath) throws Exception {
	  ad = new ActionDriver();
	  LoginWithSSO lg = new LoginWithSSO();
		Log.info("Login into the application");
		lg.loginintoapplication();
		driver.get(url);
		
		
		List<WebElement> listofimage = driver.findElements(By.tagName("a"));
		System.out.println(listofimage.size());
	Log.info("size of list which having a tag");

		
		File file = new File(
				"C:\\PricebuilderTestResult\\" + Filepath + ".csv");
		
	//	Log.info("Excel file has been generated");
		FileWriter outputfile = new FileWriter(file);
		Log.info("File writer has been initialized");
		CSVWriter writer = new CSVWriter(outputfile);
		Log.info("CSV writer has been initialized");
		List<String[]> dataone = new ArrayList<String[]>();
		Log.info("array list has been initialized");
		dataone.add(new String[] { "Image", "ResponseCode", "ResponseMessage" });
		Log.info(" add elemetns to the array list");
		
		
		
		
		for (WebElement image : listofimage) {
			Log.info(" start for each image we captured");
			String imagesrc = image.getAttribute("href");
			Log.info("get the image with src attribute");
			
				URL urlone = new URL(imagesrc);
				Log.info("Assign this with verialble url");
				URLConnection urlconnection = urlone.openConnection();
				Log.info("Connection opened");

				HttpURLConnection httpurlconnection = (HttpURLConnection) urlconnection;
				httpurlconnection.setConnectTimeout(20000);
				Log.info("Initialized HTTPURLconnect");

				
			/*
			 * String loginPassword = "jaykishore.pendharkar@saint-gobain.com" + ":" +
			 * "Vrindavan1!"; String basicAuth = "Basic :" + new
			 * String(Base64.getEncoder().encode(loginPassword.getBytes()));
			 * System.out.println(basicAuth); httpurlconnection.setRequestProperty
			 * ("Authorization", basicAuth);
			 */
				  
				
				  String auth = "jaykishore.pendharkar@saint-gobain.com" + ":" + "Vrindavan1!";
				  //String encoded = new sun.misc.BASE64Encoder().encode(auth.getBytes());
				  
				 // httpurlconnection.setRequestProperty("Authorization", "Basic " + encoded);
				  Log.info("Connected with basic Authentication");
				 
				httpurlconnection.connect();
				Log.info("Http Connection successfull");

				{
					dataone.add(new String[] { imagesrc, String.valueOf(httpurlconnection.getResponseCode()),
							httpurlconnection.getResponseMessage() });
					Log.info("added each element to the list");
				}

				httpurlconnection.disconnect();
				Log.info("Connection Disconnected");

			
		}
		writer.writeAll(dataone);
		Log.info("Written to the list");

		writer.close();
		Log.info("Writer closed");
		//driver.close();
		Log.endTestCase("End BrokenImageDataDriven Test");
  }
  
  @DataProvider(name = "URLDATA")
	public Object[][] readExcel() throws BiffException, IOException {
		// File f=new
		// File("C:\\Users\\j8994868\\eclipse-workspace\\IMASM\\SPBPRICEBUILDER\\TestData\\Scenario.xlsx");
		String path=System.getProperty("user.home")+"/PriceBuilderDataDriven.xls";
		//File file = new File(getClass().getClassLoader().getResource("BrokenImagesdata.xls").getFile());
		File file=new File(path);
		System.out.println(file.getAbsolutePath());
		//String path="BrokenImagesdata.xls";
		//File f = new File(path);s
		Workbook w = Workbook.getWorkbook(file);
		Sheet s = w.getSheet("Sheet1");
		Cell pne = s.getCell(1, 1);
		System.out.println(pne);
		int columns = s.getColumns();
		int rows = s.getRows();
		System.out.println(columns + "" + rows);

		String inputdata[][] = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell c = s.getCell(j, i);
				inputdata[i][j] = c.getContents();
				System.out.println(inputdata[i][j]);
			}
		}
		return inputdata;

	}
}
