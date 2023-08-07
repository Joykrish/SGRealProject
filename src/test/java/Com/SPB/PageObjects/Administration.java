package Com.SPB.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.SPB.Commands.ActionDriver;
import Com.SPB.Commands.ExcelOpearations;
import Com.SPB.Configration.BrowserSettings;
import Com.SPB.Configration.Log;

public class Administration extends BrowserSettings {
//this is for Administration module
	//checking merge req
	ActionDriver ad;

	
	public static String userdelete;

	@FindBy(xpath = "//div[text()='Administration ']")
	WebElement clickonAdmin;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Add User']")
	WebElement clickonaddUser;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-administartion/div/div/div/form/p-dialog[1]/div/div[2]/div/div[1]/div[2]/input")
	WebElement enterSgid;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-administartion/div/div/div/form/p-dialog[1]/div/div[2]/div/div[2]/div[2]/input")
	WebElement firstName;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-administartion/div/div/div/form/p-dialog[1]/div/div[2]/div/div[3]/div[2]/input")
	WebElement lastName;

	@FindBy(xpath = "/html/body/app-root/app-main/div/div[1]/div/app-administartion/div/div/div/form/p-dialog[1]/div/div[2]/div/div[4]/div[2]/input")
	WebElement emailAdress;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()=\"Add User Role\"]")
	WebElement addUserrole;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[1]")
	WebElement dropdownRole;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[2]")
	WebElement dropdownJob;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[3]")
	WebElement dropdownRegion;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[4]")
	WebElement dropdownCountry;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[5]")
	WebElement dropdownCustomerGroup;

	@FindBy(xpath = "(//span[@class='ui-button-icon-left ui-clickable pi pi-caret-down'])[6]")
	WebElement dropdownBrand;

	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Save ']")
	WebElement savebutton;

	@FindBy(xpath = "//input[@placeholder='Global Search ..']")
	private WebElement txtusername;
	
	@FindBy(xpath = "//span[@class='ui-menuitem-text' and text()='Edit']")
	private WebElement actEditButton;
	
	
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Save ']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[@class='ui-button-text ui-clickable' and text()='Confirm ']")
	private WebElement deleteConfirmButton;
	
	@FindBy(xpath = "//div[@class='ui-toast-detail']")
	private WebElement toasterMessage;
	
	@FindBy(xpath = "//div[@class='ui-toast-detail' and text()='User Added successfully']")
	private WebElement AddusertoasterMessage;
	
	
	
	
	
	
	
	
	
	
	
	
	public static String adduser;
	@FindBy(xpath="//div[text()='User Added successfully']")
	WebElement UserAddition;
	
	String EditUser;
	@FindBy(xpath="//div[text()='User Updated successfully']")
	WebElement userupdate;

	String DeleteUser;
	@FindBy(xpath="//div[text()='User Deleted']")
	WebElement userdel;

	public Administration() {
		PageFactory.initElements(driver, this);
	}
	
	String fileName = "PriceBuilderData.xlsx";
	String path = System.getenv("HOMEDRIVE")+""+System.getenv("HOMEPATH")+"\\"+fileName;
	ExcelOpearations excel=new ExcelOpearations(path);

	public void CreateUser() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Create new User");
		// TODO Auto-generated method stub
		ad = new ActionDriver();
		ad.click(driver, clickonAdmin,"Clicked on Admin button successfully");
		Thread.sleep(3000);
		ad.click(driver, clickonaddUser, "Clicked on Add user button successfully");
		
		String SGID = excel.getCellData("Administration", "Value", 2);
		ad.typenew(enterSgid, SGID, "SGID entered");

		

		ad.click(driver, addUserrole,"Clicked on Add user role button Successfully");
		Thread.sleep(3000);

		// To select Role
		ad.click(driver, dropdownRole, "Clicked on Role dropdown Successfully");
		String Role = excel.getCellData("Administration", "Value", 6);
		Thread.sleep(1000);
		WebElement roleselect = driver
				.findElement(By.xpath("//span[@class='ng-tns-c1-21 ng-star-inserted' and text()='" + Role + "']"));
		ad.click(driver, roleselect, Role);

//		//To enter Job Title
		ad.click(driver, dropdownJob, "Clicked on job dropdown Successfully");
		Thread.sleep(1000);
		String job = excel.getCellData("Administration", "Value", 7);

		WebElement jobselect = driver
				.findElement(By.xpath("//span[@class='ng-tns-c1-22 ng-star-inserted' and text()='" + job + "']"));
       	ad.click(driver, jobselect, job);

		// To select Region
		ad.click(driver, dropdownRegion, "Clicked on Region dropdown Successfully");
		Thread.sleep(1000);
		String region = excel.getCellData("Administration", "Value", 8);
		WebElement regionselect = driver
				.findElement(By.xpath("//span[@class='ng-tns-c1-23 ng-star-inserted' and text()='" + region + "']"));
		ad.click(driver, regionselect, region);

		// To select Country
		ad.click(driver, dropdownCountry, "Clicked On Country dropdown Successfully ");
		Thread.sleep(1000);
		String country = excel.getCellData("Administration", "Value", 9);
		WebElement countryselect = driver
				.findElement(By.xpath("//span[@class='ng-tns-c1-24 ng-star-inserted' and text()='" + country + "']"));
		ad.click(driver, countryselect, country);

		// To select CustomerGroup
		ad.movetoelementandclick(driver, dropdownCustomerGroup, "Clicked on Customer Group dropdown Successfully");
		Thread.sleep(1000);
		String customegroup = excel.getCellData("Administration", "Value", 10);
		WebElement customergroupselect = driver.findElement(
				By.xpath("//span[@class='ng-tns-c1-25 ng-star-inserted' and text()='" + customegroup + "']"));
		ad.click(driver, customergroupselect, customegroup);

		// To select Brand
		ad.movetoelementandclick(driver, dropdownBrand, "Clicked on Brand drop down Successfully");
		Thread.sleep(1000);
		String brand = excel.getCellData("Administration", "Value", 11);
		WebElement brandselect = driver
				.findElement(By.xpath("//span[@class='ng-tns-c1-26 ng-star-inserted' and text()='" + brand + "']"));
		ad.click(driver, brandselect, brand);
		Thread.sleep(10000);
        //ad.click(driver, savebutton, "Saved");
		ad.movetoelementandclick(driver, savebutton, "Clicked on SAVE button Successfully");
		
       

	}

	public void GlobalSearchUser() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Global User Search Verification");
		ad = new ActionDriver();
		ad.click(driver, clickonAdmin, "Clicked on Admin button successfully");
		Log.info(" Successfully click on Adminstration ");
		Thread.sleep(3000);
		String username = excel.getCellData("Administration", "Value", 12);
		ad.typenew(txtusername, username, "typed in GlobalSearch box successfully ");
		Thread.sleep(3000);
		Log.info(" Username Sucessfully typed in GlobalSeach test box ");
		driver.findElement(
				By.xpath("(//td[text()='" + username + "'])[1]//following-sibling::td//span[text()='Action']")).click();

		Thread.sleep(1000);
	}

	public void ActionbuttonEdit() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Edit User Verification");
		ad = new ActionDriver();
		ad.click(driver, clickonAdmin,"Clicked on Admin button successfully");
		Thread.sleep(10000);
		String UserName =  excel.getCellData("Administration", "Value", 12);
		System.out.println(UserName);
		ad.typenew(txtusername, UserName, "typed in GlobalSearch box successfully ");
		//driver.findElement(By.xpath("//input[@icon='pi pi-user']")).sendKeys(UserName);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//td[text()='" + UserName + "'])[1]//following-sibling::td//span[text()='Action']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[@class='ui-menuitem-text' and text()='Edit']")).click();
		ad.click(driver, actEditButton, "Clicked on Edit button Sucessfully");
		Log.info("Successfully open Edit user page");
		Thread.sleep(2000);
		ad.click(driver,savebutton ,"Clicked on Save Button Successfully");
		//driver.findElement(By.xpath("//span[@class='ui-button-text ui-clickable' and text()='Save ']")).click();
		Log.info("Successfully Saves user details");
			}
	
	public void ActionbuttonDelete() throws IOException, InterruptedException {
		BrowserSettings.childTest = BrowserSettings.parentTest.createNode("Delete User Verification");
		ad = new ActionDriver();
		ad.click(driver, clickonAdmin,"Clicked on Admin button successfully");
		
		String UserName =  excel.getCellData("Administration", "Value", 12);
		System.out.println(UserName);
		Thread.sleep(3000);
		ad.typenew(txtusername, UserName, "typed in GlobalSearch box successfully ");
		//driver.findElement(By.xpath("//input[@icon='pi pi-user']")).sendKeys(UserName);
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("(//td[text()='" + UserName + "'])[1]//following-sibling::td//span[text()='Action']")).click();
		driver.findElement(By.xpath("//span[@class='ui-menuitem-text' and text()='Delete']")).click();

		//driver.findElement(By.xpath("//span[@class='ui-button-text ui-clickable' and text()='Confirm ']")).click();
		ad.click(driver, deleteConfirmButton, "Successfully Clicked on Delete Confirmation");
		Log.info("Successfully Deleted user");

	}
	

	
	
	public String GetUserEditConfirmation() throws IOException {

		//return EditUser = userupdate.getText();
		return ad.GetText(toasterMessage, "Message Captured Successfully");
		//return EditUser=driver.findElement(By.xpath("//div[@class='ui-toast-detail']")).getText();
	
	}
	

	public String GetUserDeleteConfirmation() throws IOException {
		return ad.GetText(toasterMessage, "Message Captured Successfully");
		//return DeleteUser = userdel.getText();
		//return DeleteUser = driver.findElement(By.xpath("//div[@class='ui-toast-detail']")).getText();
	}
	
	
	public String GetUserAddedConfirmation() throws IOException {
		return ad.GetText(AddusertoasterMessage, "Message Captured Successfully");
		//return adduser =UserAddition.getText();
		//return adduser=driver.findElement(By.xpath("//div[@class='ui-toast-detail' and text()='User Added successfully']")).getText();
	}
}

