package Com.SPB.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.ProjectDashboard;

public class ExcelOptions extends BrowserSettings {
	 ActionDriver ad;
  @Test
  
  //Verify IMport button available only when internal validation is NO and not available for other validation status 
  
  public void VerifyExcelOptions() throws Exception {
	  Log.startTestCase("VerifyExcelOptions");
	    ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.searchProject("other");
		pd.selectScenariowithStatus();
		pd.verifyInternalValidationStatus();
		pd.clickExcelDropdown();
	
		if(ProjectDashboard.internalVal.contains("Internal Validation :\n" + 
				"Approved")){
			{
				List<WebElement> list =driver.findElements(By.xpath("//span[@class='ui-menuitem-text']"));
				System.out.println(list.size());
				for (int i = 1; i <= list.size(); i++) {
					String menus="(//span[@class='ui-menuitem-text'][1])["+i+"]";
					
					WebElement mn=driver.findElement(By.xpath(menus));
					String impexp=mn.getText();
					System.out.println(impexp);
					//if(!impexp.contains("Import")) {
						//System.out.println("PASS");
					try {
						Assert.assertEquals((!impexp.contains("Import")), true);
						BrowserSettings.parentTest.pass("Assertion PASS");
					} catch (Exception e) {
						// TODO: handle exception
						BrowserSettings.parentTest.fail("Assertion FAIL");
						BrowserSettings.childTest.info(e);
						throw e;
					}
						
					}
				
			}
		}
			if(ProjectDashboard.internalVal.contains("Internal Validation : No"))
			{
				Thread.sleep(10000);
				List<WebElement> listone =driver.findElements(By.xpath("//span[@class='ui-menuitem-text']"));
				System.out.println(listone.size());
				for (int i = 1; i <= listone.size(); i++) {
					String menus="(//span[@class='ui-menuitem-text'][1])["+i+"]";
					
					WebElement mn=driver.findElement(By.xpath(menus));
					String impexp=mn.getText();
					System.out.println(impexp);
					//if(!impexp.contains("Import")) {
						//System.out.println("PASS");
					try {
						Assert.assertEquals((impexp.contains("Import") || impexp.contains("Export")), true);
						BrowserSettings.parentTest.pass("Assertion PASS");
					} catch (Exception e) {
						// TODO: handle exception
						BrowserSettings.parentTest.fail("Assertion FAIL");
						BrowserSettings.childTest.info(e);
						throw e;
					}
						
						//Assert.assertEquals((impexp.contains("Export")), true);
			}
			}
				if(ProjectDashboard.internalVal.contains("Internal Validation :\n" + 
						"Cancelled"))
				{
					List<WebElement> list =driver.findElements(By.xpath("//span[@class='ui-menuitem-text']"));
					System.out.println(list.size());
					for (int i = 1; i <= list.size(); i++) {
						String menus="(//span[@class='ui-menuitem-text'][1])["+i+"]";
						WebElement mn=driver.findElement(By.xpath(menus));
						String impexp=mn.getText();
						System.out.println(impexp);
						//if(!impexp.contains("Import")) {
							//System.out.println("PASS");
						try {
							Assert.assertEquals((!impexp.contains("Import")), true);
							BrowserSettings.parentTest.pass("Assertion PASS");
						} catch (Exception e) {
							// TODO: handle exception
							BrowserSettings.parentTest.fail("Assertion FAIL");
							BrowserSettings.childTest.info(e);
							throw e;
						}
							
						}
						
				}
				if(ProjectDashboard.internalVal.contains("Internal Validation :\n" + 
						"In Progress")) {
					List<WebElement> list =driver.findElements(By.xpath("//span[@class='ui-menuitem-text']"));
					System.out.println(list.size());
					for (int i = 1; i <= list.size(); i++) {
						String menus="(//span[@class='ui-menuitem-text'][1])["+i+"]";
						WebElement mn=driver.findElement(By.xpath(menus));
						String impexp=mn.getText();
						System.out.println(impexp);
						//if(!impexp.contains("Import")) {
							//System.out.println("PASS");
						try {
							Assert.assertEquals((!impexp.contains("Import")), true);
							BrowserSettings.parentTest.pass("Assertion PASS");
						} catch (Exception e) {
							// TODO: handle exception
							BrowserSettings.parentTest.fail("Assertion FAIL");
							BrowserSettings.childTest.info(e);
							throw e;
						}
							
					
				}
			}
  
				Log.endTestCase("VerifyExcelOptions");
  }
  
}

						
					
					
					
				
			
				
				
		
			
			
		
			
  

		
		
			
		
  

