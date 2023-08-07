package Com.SPB.Commands;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import Com.SPB.Commands.*;
import Com.SPB.Configration.BrowserSettings;




public class ActionDriver {
WebDriver driver;
public ActionDriver() {
	
	driver=BrowserSettings.driver;
}
public void navigateToApplication(String url) {
	
	try {
		driver.get(url);
		BrowserSettings.childTest.pass("Successfully Navigated to: " +url);
	}  	catch (Exception e) {
		BrowserSettings.childTest.fail("Unable to navigated to: " +url);
	}
	
}
public String getcurrenturl() {
	
	try {
	 driver.getCurrentUrl();
		
		BrowserSettings.childTest.pass("Caputured URL successully " );
		
	} catch (Exception e) {
		BrowserSettings.childTest.fail("Unable to capture the URL");
	}
	
return driver.getCurrentUrl();
}

	/*
	 * public void click(By locator) throws Exception {
	 * 
	 * driver.findElement(locator).click();
	 * 
	 * }
	 */
	
	public void click(WebDriver driver, WebElement ele,String elename) throws IOException {
		try {
			Actions act = new Actions(driver);
			//act.moveToElement(ele).click().build().perform();
			ele.click();
			BrowserSettings.childTest.pass("Successfully cliked on: " + elename);
			} 
			catch (Exception e) {
			BrowserSettings.childTest.fail("Unable to click : " + elename ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			BrowserSettings.childTest.info(e);
			throw e;
			}	
	}
		public void movetoelementandclick(WebDriver driver, WebElement ele,String elename) throws IOException {
			
			try {
				Actions act = new Actions(driver);
				act.moveToElement(ele).click().build().perform();
				ele.click();
				BrowserSettings.childTest.pass("Successfully cliked on: " + elename);
			} catch (Exception e) {
				// TODO: handle exception
				BrowserSettings.childTest.fail("Unable to click : " + elename ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				BrowserSettings.childTest.info(e);
				throw e;
			}
			
		}

		

	
		
	
	/*
	 * public void type(By locator,String txt,String elename) throws Exception { try
	 * { driver.findElement(locator).sendKeys(txt);
	 * BrowserSettings.childTest.pass("Successfully typed in : " + elename
	 * +"With data: "+txt); } catch (Exception e) { BrowserSettings.childTest.
	 * fail("Unable to typed in :  \" + elename +\"With data: "+txt
	 * ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build()
	 * ); BrowserSettings.childTest.info(e); throw e; } }
	 */
	public void verificationByAssert(String Actual,String expected) {
		
			if(Actual.contains(expected)) {
				Assert.assertTrue(true);
				BrowserSettings.childTest.pass("Assert verification is PASS ");
			}
			else {
				Assert.assertTrue(false);
				BrowserSettings.childTest.fail("Assert verification is FAIL");
				
			}
	
		
	}
		
		public boolean typenew(WebElement ele, String text,String elename) throws IOException {
			boolean flag = false;
			try {
				flag = ele.isDisplayed();
				ele.clear();
				ele.sendKeys(text);
				BrowserSettings.childTest.pass("Successfully typed in : " + elename +"With data: "+text);
				// logger.info("Entered text :"+text);
				flag = true;
			} catch (Exception e) {
				BrowserSettings.childTest.fail("Unable to typed in :  \" + elename +\"With data: "+text ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				BrowserSettings.childTest.info(e);
				throw e;
				
				
			} finally {
				if (flag) {
					System.out.println("Successfully entered value");
				} else {
					System.out.println("Unable to enter value");
				}

			}
			return flag;
		}
			
		public void clear(WebElement we,String elename) throws IOException {
				
			try {
				we.clear();
				BrowserSettings.childTest.pass("Successfully clear in : " + elename );
			} catch (Exception e) {
				// TODO: handle exception
				BrowserSettings.childTest.fail("Unable to clear in :  " + elename,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
				BrowserSettings.childTest.info(e);
				throw e;
			}
			
				
			}
			

	/*
	 * public String gettext(By locator) throws Exception { try {
	 * driver.findElement(locator).getText();
	 * BrowserSettings.childTest.pass("Successfully read value from : " + locator);
	 * return driver.findElement(locator).getText();
	 * 
	 * } catch(Exception e) {
	 * BrowserSettings.childTest.fail("unable to read the text from "+ locator);
	 * BrowserSettings.childTest.info(e); throw e; } }
	 */
				public String GetText(WebElement element,String Elename) throws IOException {
					try {
						
						BrowserSettings.childTest.pass("Sucessfully Captured the text  of  : " + Elename );
						return element.getText();
					} catch (Exception e) {
						BrowserSettings.childTest.fail("Failed to Captured the text  of : " + Elename,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
						BrowserSettings.childTest.info(e);
						throw e;
						// TODO: handle exception
					}
					
					
					
					
				}
				
			public boolean checkExistence(WebElement we,String elename) throws IOException {
				try {
					boolean ele=we.isDisplayed();
					System.out.println(ele);
					BrowserSettings.childTest.pass("Sucessfully checked the existence of  : " + elename );
					
					return ele;
				}
				
				catch (Exception e) {
					// TODO: handle exception
					BrowserSettings.childTest.fail("Did not check the existence of  : " + elename,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
					BrowserSettings.childTest.info(e);
					throw e;
				}
			
				
			}
			
			
			
			public String splitString(String string,String newString,char c) {
				if (string.contains(""+c+"")) {
				String[] one=string.split("\\"+c+"");
					
			 newString=one[0];
				
				}
				else {
					newString=string;
				}
				return newString;
			}
			public String replacechar(String string,String newString,char c) {
				if (string.contains(""+c+"")) {
					newString=string.replace(""+c+"", "");
					
				}
				else {
					newString=string;
				}
				return newString;
				
			}
			
			public String replacechartwo(String string,String newString,char c,char d) {
				if(!string.isEmpty()) {
				if (string.contains(""+c+"")) {
					newString=string.replace(""+c+"", ""+d+"");
					
				}
				else {
					newString=string;
				}
				return newString;
				
			}
			else
			{
				return newString="0";
			}
			}
			public int StringtoInt(String string,int var) {
				var=Integer.parseInt(string);
				return var;
			}
			public double Stringtodouble(String string,double var) 
			{
				if(!string.isEmpty()) {
				var=Double.parseDouble(string);
				
				}
				else {
				var=0.0;
				}
				return var;
			}

			public double Mathround(double var,double newone) {
				
				newone=Math.round(var);
				return newone;
			}
			
			
			public String screenshot() {
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		}
			
			public Boolean Isdisplayed(By locator) {
				return driver.findElement(locator).isDisplayed();
				
			}


}