package com.cctv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageT1 extends TestBase {
	public GenericUtilities util;
	// WebDriver driver;

	String t2uploadFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\uploadT2.xlsx";

	@FindBy(xpath = ".//*[@id='page-content-wrapper']/div/ul/li[2]/a")

	WebElement clickT1Tab;
	@FindBy(xpath = ".//*[@id='btnsearchT']")
	WebElement seatchT1Button;
	@FindBy(xpath = ".//*[@id='RegistrationPanel']/div/h4/a")
	WebElement manageUsersLink;
	@FindBy(xpath = ".//*[@id='orgType']")
	@CacheLookup
	WebElement OrgTypeDropdown;

	@FindBy(xpath = ".//*[@id='dvsearchT1user']/div[1]/fieldset/div[2]/input")
	@CacheLookup
	WebElement orgName;
	@FindBy(xpath = ".//*[@id='dvsearchT1user']/div[1]/fieldset/div[3]/input")
	@CacheLookup
	WebElement firstName;
	@FindBy(css = ".fa.fa-upload")
	@CacheLookup
	WebElement bulkUploadT2;
	@FindBy(xpath = ".//*[@id='uploadexcel']")
	@CacheLookup
	WebElement bulkUploadT2Selectfile;
	@FindBy(xpath = ".//*[@id='dvupload']/div[3]/button[1]")
	@CacheLookup
	WebElement finalUploadbutton;

	// create t1 user fields below
	@FindBy(xpath = ".//button[@id='btnCrateT1']")
	@CacheLookup
	WebElement createt1button;
	@FindBy(xpath = ".//*[@id='orgTypeT1']")
	@CacheLookup
	WebElement orgTypeDropDown;
	@FindBy(xpath = "//select[@id=\"orgNameT1\"]")
	@CacheLookup
	WebElement orgNameDropDown;
	@FindBy(xpath = "	.//*[@id=\"emailAddressT1\"]")
	@CacheLookup
	WebElement emailAddress;
	@FindBy(xpath = ".//*[@id='surnameT1']")
	@CacheLookup
	WebElement surName;
	@FindBy(xpath = ".//*[@id='givenNameT1']")
	@CacheLookup
	WebElement givenName;
	@FindBy(xpath = ".//*[@id='phoneNumberT1']")
	@CacheLookup
	WebElement phoneNumber;
	@FindBy(xpath = ".//*[@id='empNumberT1']")
	@CacheLookup
	WebElement empNo;
	@FindBy(xpath = ".//*[@id='branchAreaT1']")
	@CacheLookup
	WebElement branchAreaT1;
	@FindBy(xpath = "//*[@id=\"cameraPermission2T1\"]")
	@CacheLookup
	WebElement accessToAllCamerasCheckBox;
	@FindBy(xpath = ".//*[@name=\"viewConnectedCamerasT1\"]")
	@CacheLookup
	WebElement viewConnectedCamerasCheckBox;
	@FindBy(xpath = ".//*[@id='btnsubmitT1']")
	@CacheLookup
	WebElement submitButton;
	@FindBy(xpath = ".//*[@id='userT1Msg']/div/div/div[1]/p")
	@CacheLookup
	WebElement userT1Msg;
	@FindBy(xpath = ".//*[@id='userT1Msg']/div/div/div[2]/button")
	@CacheLookup
	WebElement Successalert;

	@FindBy(xpath = ".//*[@id='uploadsuccess']/div/div/div[2]/button")
	@CacheLookup
	WebElement uploadsuccess;
	@FindBy(xpath = ".//*[@href='/Content/Excel/Bulk Upload Template for T2 User.xlsx']")
	@CacheLookup
	WebElement bulkuploadT2Template;

	// lock T1 users fields
	@FindBy(xpath = "(.//i[@class=\"fa fa-lock\"])[position()=2]")
	@CacheLookup
	WebElement T1LockIcon;
	@FindBy(xpath = "(.//*[@class=\"ng-binding\"])[position()=1]")
	@CacheLookup
	WebElement T1LockWindowMessage;

	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.lockreason\"]")
	@CacheLookup
	WebElement T1LockWindowcommentField;

	@FindBy(xpath = ".//button[@ng-click=\"lockaccount('lock')\"]")
	@CacheLookup
	WebElement T1LockWindowButton;

	@FindBy(xpath = ".//*[@ng-show=\"useraccount=='T1'\"]")
	@CacheLookup
	WebElement T1LockConfirmPopUPText;
	@FindBy(xpath = ".//*[@id='lockValidationMsg']/div/div/div[2]/button")
	@CacheLookup
	WebElement T1LockConfirmPopupOKButton;

	// migrate T2 user fields

	@FindBy(xpath = "(.//*[@class=\"fa fa-external-link\"])[position()=1]")
	@CacheLookup
	WebElement T1MigrateIcon;

	@FindBy(xpath = ".//*[@id=\"toMigrateAc2\"]")
	@CacheLookup
	WebElement T1MigrateToOption;

	@FindBy(xpath = "(.//*[@ng-disabled=\"enableMigrate==true\"])[position()=1]")
	@CacheLookup
	WebElement T1MigrateButton;
	@FindBy(xpath = ".//*[@id=\"migratePopupT1Tab\"]/div/div/div/p")
	@CacheLookup
	WebElement T1MigrateokbuttonText;
	@FindBy(xpath = "(.//*[@ng-click=\"UpdateMigrateUserDetails(MigrateRequestUser1Org,MigrateRequestUser2Org)\"])[position()=1]")
	@CacheLookup
	WebElement T1MigrateYESButton;

	@FindBy(xpath = ".//*[@id='migrateAlertMsgT1Tab']/div/div/div[1]/p[2]")
	@CacheLookup
	WebElement T1MigratedText;

	@FindBy(xpath = "(.//*[@ng-click=\"MigrationBack()\"])[position()=2]")
	@CacheLookup
	WebElement T1MigratedOKButton;

	// t1 unlock fields

	@FindBy(xpath = "(.//*[@aria-label=\"Filter for column\"])[position()=11]")
	@CacheLookup
	WebElement T1Statuscolumnfield;
	@FindBy(xpath = ".//*[@class=\"fa fa-unlock-alt\"]")
	@CacheLookup
	WebElement T1UnlockIcon;
	@FindBy(xpath = "(.//*[@ng-show=\"!active\"])[position()=1]")
	@CacheLookup
	WebElement T1UnlockWindowText;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.lockreason\"]")
	@CacheLookup
	WebElement T1UnlockWindowReasonBox;
	@FindBy(xpath = ".//button[@ng-click=\"lockaccount('unlock')\"]")
	@CacheLookup
	WebElement T1UnlockWindowbutton;
	@FindBy(xpath = "//*[@id=\"lockMsg\"]/div/div/div[1]/p[2]")
	@CacheLookup
	WebElement T1UnlockWindowSuccessText;
	@FindBy(xpath = ".//*[@id='lockMsg']/div/div/div[2]/button")
	@CacheLookup
	WebElement T1UnlockWindowOKbutton;

	public ManageT1() {
	//	PageFactory.initElements(driver, this);
	}

	public void uploadT2() throws Exception {
		util = new GenericUtilities();
		log.info("******** T2 upload started *********");
		Thread.sleep(3000);
		util.click(manageUsersLink);
		// Thread.sleep(6000);
		util.click(clickT1Tab);
		// Thread.sleep(3000);
		util.click(seatchT1Button);
		Thread.sleep(3000);
		bulkUploadT2.click();
		log.info("Selecting upload file");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id=\"uploadexcel\"])[position()=1]")).click();
		Thread.sleep(3000);
		util.selectUploadFilebyRobot(t2uploadFilePath);
		Thread.sleep(3000);
		/*
		 * util.sendKeys(bulkUploadT2Selectfile, t2uploadFilePath); Thread.sleep(3000);
		 */
		util.click(finalUploadbutton);
		Thread.sleep(5000);
		util.click(uploadsuccess);
		Thread.sleep(3000);
		log.info("********T2 uploaded Successfully*******");

	}

	public void creat1T1user(String orgType, String orgName, String email, String SurName, String GivenName,
			String phoneNo, String EmpNO, String branch) throws Exception {
		util = new GenericUtilities();
		log.info("************Creating new T1 user**********");
		Thread.sleep(6000);
		util.click(manageUsersLink);
		Thread.sleep(4000);
		util.click(clickT1Tab);
		Thread.sleep(3000);
		util.click(createt1button);
		Thread.sleep(4000);
		util.selectByName(orgType, orgTypeDropDown);
		Thread.sleep(3000);
		util.selectByIndex(1, orgNameDropDown);
		util.sendKeys(emailAddress, email);
		util.sendKeys(surName, SurName);
		util.sendKeys(givenName, GivenName);
		util.sendKeys(phoneNumber, phoneNo);
		util.sendKeys(empNo, EmpNO);
		util.sendKeys(branchAreaT1, branch);

		util.click(accessToAllCamerasCheckBox);
		Thread.sleep(3000);
		util.click(viewConnectedCamerasCheckBox);
		Thread.sleep(3000);
		util.click(submitButton);
		util.getText(userT1Msg);
		util.click(Successalert);
		Thread.sleep(2000);

		log.info("************New T1 user crrated**********");

	}

	public void downloadBulkT2UploadTemplate() throws Exception {
		util = new GenericUtilities();
		log.info("******* T2 template download started********");
		util.click(manageUsersLink);

		util.click(clickT1Tab);
		util.click(bulkuploadT2Template);

		/*
		 * String downloadPath1 = "C:\\Users\22231\\Downloads"; String
		 * FileName1="Bulk Upload Template for T2 User.xlsx";
		 * SoftAssert.assertTrue(base.isFileDownloaded(downloadPath1, FileName1),
		 * "Failed to download Expected document");
		 */
		log.info("******* T2 template download finished********");

	}

	public void lockT1user() throws Exception {

		util = new GenericUtilities();
		log.info("******** T1 locking started ******");
		util.click(manageUsersLink);
		util.click(clickT1Tab);
		Thread.sleep(3000);
		util.click(seatchT1Button);
		Thread.sleep(3000);
		util.click(T1LockIcon);
		util.getText(T1LockWindowMessage);
		util.sendKeys(T1LockWindowcommentField, "Locking T1 user");
		util.click(T1LockWindowButton);
		util.getText(T1LockConfirmPopUPText);
		util.click(T1LockConfirmPopupOKButton);

	}

	public void migrateT2user() throws Exception {

		try {
			
			log.info("******** Migrate T2 started *********");
			util = new GenericUtilities();
			Thread.sleep(2000);
			util.click(manageUsersLink);
			util.click(clickT1Tab);
			Thread.sleep(2000);
			util.click(seatchT1Button);
			Thread.sleep(2000);
			util.click(T1MigrateIcon);
			Thread.sleep(2000);
			util.selectByIndex(1, T1MigrateToOption);
			Thread.sleep(2000);
			util.click(T1MigrateButton);
			Thread.sleep(2000);
			util.getText(T1MigrateokbuttonText);
			util.click(T1MigrateYESButton);
			util.getText(T1MigratedText);
			util.click(T1MigratedOKButton);
			
			log.info("******** Migrate T2 finished *********");
		}

		catch (Exception e) {

			log.info(" T2 migration failed " + e);
		}

	}

	public void UnlockT1user(String T1Accno) throws Exception {

		util = new GenericUtilities();
		log.info("******** T1 Unlocking started ******");
		try {
			util.click(manageUsersLink);
			util.click(clickT1Tab);
			Thread.sleep(3000);  
			util.click(seatchT1Button);
			util.click(T1Statuscolumnfield);
			util.sendKeys(T1Statuscolumnfield, T1Accno);
			util.click(T1UnlockIcon);
			util.getText(T1UnlockWindowText);
			util.sendKeys(T1UnlockWindowReasonBox, "Unlocking t1 User " + T1Accno);
			util.click(T1UnlockWindowbutton);
			util.getText(T1UnlockWindowSuccessText);
			util.click(T1UnlockWindowOKbutton);

			log.info("******** T1 Unlocking finished ******");
		} catch (Exception e) {

			log.info("********** no records to unlock ******** " + e);

		}

	}
}
