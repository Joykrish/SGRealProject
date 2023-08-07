package Com.SPB.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.CostDashboard;
import Com.SPB.PageObjects.GlassPositionDashboard;
import Com.SPB.PageObjects.HomePage;
import Com.SPB.PageObjects.ProjectDashboard;
import Com.SPB.PageObjects.ProjectSimulation;

public class VerifyVersionCreation extends BrowserSettings {
	public  boolean ScenarioForVersion=true;
	 ActionDriver ad;
  @Test
  public void VerifyVersionCreation() throws Exception {
	 
	  ad=new ActionDriver();
	  HomePage hm = PageFactory.initElements(driver, HomePage.class);
		ProjectSimulation sm = PageFactory.initElements(driver, ProjectSimulation.class);
		ProjectDashboard pd = PageFactory.initElements(driver, ProjectDashboard.class);
		CostDashboard cd = PageFactory.initElements(driver, CostDashboard.class);
		GlassPositionDashboard gd = PageFactory.initElements(driver, GlassPositionDashboard.class);
		
		hm.searchProject("other");
		 
		pd.selectscenarioVersion();

		Thread.sleep(10000);
		
		//pd.selectScenariowithStatus();
		Thread.sleep(10000);
		pd.selectGlassPosition("other");
		Thread.sleep(10000);
		gd.addVersion();
		boolean enblbtn=driver.findElement(By.xpath("//button[@class='ui-button-rounded ui-button ui-widget ui-button-success ui-corner-all ui-button-text-only ui-button-text ui-state-default']")).isEnabled();
		 //System.out.println(enblbtn);
		 if(enblbtn==true) {
		gd.readconfirmmessage();
		//Assert.assertEquals(GlassPositionDashboard.confirmVersion,"Version added successfully");
		ad.verificationByAssert(GlassPositionDashboard.confirmVersion, "Version added successfully");
		gd.searchspecificVersion();
		 }
		 else {
			 System.out.println("Sceanario is submitted for internal Validation:Please select scenario whose validation is not yet started");
		 }
  
  }
}
