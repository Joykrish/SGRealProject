package Com.SPB.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyScenarioFunctions extends BrowserSettings {
	ActionDriver ad;

	@Test(enabled=true)
	public void VerifyAddScenario() throws Exception {
		ad=new ActionDriver();
		// this is to test whether newly added scenario get selectemxd the Scenario
		// Drop-down or not
		//test data,Row 2,20,21
		Log.startTestCase("VerifyAddScenario");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.searchProject("other");
		ProjectDashboard pg = PageFactory.initElements(driver, ProjectDashboard.class);
		pg.ClickAddScenario();
		pg.enterScenarioName();
		pg.enterScenarioDescription();
		pg.ConfirmAddScenario();
		Thread.sleep(10000);
		String ss = pg.SelectedScenario();
		System.out.println(ss);
		ad.verificationByAssert(pg.Scenariname, ss);
		//Assert.assertEquals(ss, pg.Scenariname);
		Log.endTestCase("VerifyAddScenario");

	}
	@Test(enabled=true)
	
	//this is verify whether rename scenario is working properly or not 
	//test data=Row 2,22,23,24
	public void VerifyRenameScenario() throws Exception {
		ad=new ActionDriver();
		Log.startTestCase("VerifyRenameScenario");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		hm.searchProject("other");
		ProjectDashboard pg = PageFactory.initElements(driver, ProjectDashboard.class);
		pg.selectScenarioTobeRenamed();
		Thread.sleep(1000);
		pg.scrolltoScenarioDashboard();
		//pg.ClickonForwardbuttonSC();
		Thread.sleep(10000);
		//pg.clickActionbuttonSC();
		pg.paginationScenario();
		pg.renameScenario();
		
		
		
		Thread.sleep(1000);
		//Assert.assertEquals(ProjectDashboard.RenameConfirm,"Scenario updated successfully");
		ad.verificationByAssert(ProjectDashboard.RenameConfirm, "Scenario updated successfully");
		String confirmationScenarioRenamed=ProjectDashboard.RenameConfirm;
		System.out.println(confirmationScenarioRenamed);
		
		Log.startTestCase("VerifyRenameScenario");
		
		
	}
	@Test(enabled=true)
	//This test is to make scenario archieve
	//Test data=row 27
	
	public void VerifyArchievescenario() throws Exception {
		ad=new ActionDriver();
		Log.startTestCase("VerifyRenameScenario");
		HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectDashboard pg = PageFactory.initElements(driver, ProjectDashboard.class);
		hm.searchProject("other");
		
		pg.selectScenarioTobeArchieved();
		Thread.sleep(10000);
		pg.scrolltoScenarioDashboard();
		pg.paginationScenarioArchieve();
		Thread.sleep(2000);
		
		/*List WebElement=driver.findElements(By.xpath("//tr[@ _ngcontent-gkg-c16]"));
		System.out.println();
		ArrayList list=new ArrayList();
		for (int i = 1; i < WebElement.size(); i++) {
			String ArchiedScenario=driver.findElement(By.xpath("(//tr[@ _ngcontent-gkg-c16])["+i+"]")).getText();
			for (Object object : list) {
			list.add(object);
			System.out.println(list);
			if(ArchiedScenario.equals(ProjectDashboard.selectScenariotoArchieved)){
				Assert.assertTrue(true);
				
				
			}
			else
			{
				Assert.assertTrue(false);
			}
			
			}
			break;*/
			
			
			
		ad.verificationByAssert(ProjectDashboard.archieveConfirm, "Scenario Archive successfully");
		//Assert.assertEquals(ProjectDashboard.archieveConfirm,"Scenario Archive Successfully");
	}
		
	}

