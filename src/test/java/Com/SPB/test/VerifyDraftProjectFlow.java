package Com.SPB.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;
import Com.SPB.PageObjects.DraftProjectFlow;
import Com.SPB.PageObjects.LoginWithSSO;
import Com.SPB.PageObjects.NewRFQ;
import Com.SPB.PageObjects.ProjectDashboard;

public class VerifyDraftProjectFlow extends BrowserSettings {
  ActionDriver ad;
	@Test(enabled=true)
  
  //This test is to verify the functionality of "Create Draft" button
  //After entering the data for the project which is not exist in MPT,entering Car production,Roof Quantities when user clicks on Create draft 
  //button the message"" should appear
  //after selecting the currency use should redirected to the project dashbaord
  //Test Data:Row 4,5,6,7,8
  public void CreateDraftdraftproject() throws Exception {
		ad = new ActionDriver();
	  Log.startTestCase("CreateDraftdraftproject");
	  NewRFQ nr=new NewRFQ();
	  LoginWithSSO lg=new LoginWithSSO();
	  lg.loginintoapplication();
	  nr.importproject();
	  nr.selectCustomer();
	  nr.selectBrand();
	  nr.selectDevCode();
	  nr.selectBody();
	  nr.selectRegion();
	  nr.ClickSearch();
	  DraftProjectFlow df=new DraftProjectFlow();
	  df.SelectGPone();
	  df.SelectGPtwo();
	  df.SelectGPthree();
	  df.SelectGPfour();
	  df.EnterCarproduction();
	  df.EnterRoofQuantities();
	  df.ClickCreateDraft();
	  df.ClickConfirmbtn();
	  df.projectavailablenowmessage();
	  Thread.sleep(10000);
	  Assert.assertEquals(DraftProjectFlow.projectavailablenow,"Your project is now available in My RFQ's");
	  df.ClickonProjectImportComplete();
	  df.SelectCurrency();
	  df.ClickConfirmCurrency();
	  Thread.sleep(10000);
	  ProjectDashboard pg=new ProjectDashboard();
	  String Projectname=pg.GetSelectedProjectName();
	  ad.verificationByAssert(Projectname, NewRFQ.DevCode);
		/*
		 * if(Projectname.contains(NewRFQ.DevCode)) { System.out.
		 * println("PASS:Project Imported Sucessfully and now Avaialble in RFQ"); } else
		 * System.out.println("FAIL:Project not Imported Successfully "); //
		 * Assert.assertEquals(actual,DraftProjectFlow.projectavailablenow);
		 */	  
	  Log.endTestCase("CreateDraftdraftproject");
	  	  
  }

//@Test(priority=2,enabled=true)
public void VerifyPreviousbutton() throws Exception {
	NewRFQ nr=new NewRFQ();
	  nr.importproject();
	  nr.selectCustomer();
	  nr.selectBrand();
	  nr.selectDevCode();
	  nr.selectBody();
	  nr.selectRegion();
	  nr.ClickSearch();
	  DraftProjectFlow df=new DraftProjectFlow();
	  df.ClickonPrevious();
	  ActionDriver ac=new ActionDriver();
	  ac.getcurrenturl();
	  Assert.assertEquals(ac.getcurrenturl(), "https://dev-xcalc.sekurit.saint-gobain.com/project");
	  
	  
	
}
}
