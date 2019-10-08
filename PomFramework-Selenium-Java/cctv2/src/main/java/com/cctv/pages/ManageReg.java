package com.cctv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageReg extends TestBase {

	GenericUtilities util;

	String bulkUploadCameraFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\uploadCamera.xlsx";
	// Search Registrations fields
	@FindBy(xpath = ".//a[text()='Manage Registrations']")
	
	WebElement ManageRegLink;

	@FindBy(xpath = "(.//*[@id='orgTypeT2'])[position()=1]")
	@CacheLookup
	WebElement orgTypeDropdownT2;

	@FindBy(xpath = ".//*[@id=\"searchT2\"]")

	WebElement searchT2Button;

	@FindBy(xpath = ".//*[@class=\"ng-binding\" and @ng-show=\"grid.options.totalItems > 0\"]")
	@CacheLookup
	WebElement CountOFResultsT2;

	@FindBy(xpath = "(.//*[@aria-label=\"Filter for column\"])[position()=1]")
	@CacheLookup
	WebElement accnoColumnSearchfield;

	// bulk upload

	@FindBy(xpath = ".//*[@class=\"fa fa-upload\"]")
	@CacheLookup
	WebElement bulkUploadCam;
	@FindBy(xpath = "//*[@id=\"dvupload\"]/div[2]/div[3]/span[1]")
	
	WebElement selectBulkuploadFile;

	@FindBy(xpath = "(.//*[@type=\"button\"])[text()=\"Upload\"]")
	@CacheLookup
	WebElement selectBulkuploadButton;

	@FindBy(xpath = "(//p[@class=\"text-info text-success\"])[position()=1]")
	@CacheLookup
	WebElement bulkUploadCamMessage;

	// Withdraw reg acc
	@FindBy(xpath = "(.//*[@class=\"fa fa-circle-o\"])[position()=1]")
	@CacheLookup
	WebElement RegWithdrawIcon;

	@FindBy(xpath = ".//*[@name='withdraw']")
	@CacheLookup
	WebElement RegWithdrawReasondropdown;
	@FindBy(xpath = ".//*[@ng-if=\"accountStatusLookupId != 205\"]")
	@CacheLookup
	WebElement RegWithdrawOtherReasonTitle;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.SearchRegistrantVM.WithdrawRemark\"]")
	@CacheLookup
	WebElement RegWithdrawOtherReasonBox;

	@FindBy(xpath = ".//button[contains(text(),'Withdraw')]")
	@CacheLookup
	WebElement RegWithdrawButtonClick;
	@FindBy(xpath = ".//p[contains(text(),'withdrawn successfully')]")
	@CacheLookup
	WebElement withdrawMessageSuccessText;
	@FindBy(xpath = "//*[@id=\"withdrawMsg\"]/div/div/div[2]/button")

	WebElement withdrawRegOKbutton;

	// reactivate registration

	
	@FindBy(xpath = "(//*[@id=\"orgTypeT2\"])[position()=2]")
	@CacheLookup
	WebElement RegReactoption;
	
	
	@FindBy(xpath = "(.//*[@title=\"Re-Activate\"])[position()=1]")
	@CacheLookup
	WebElement RegReactIcon;

	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.SearchRegistrantVM.WithdrawRemark\"]")
	@CacheLookup
	WebElement RegReactreasonBox;

	@FindBy(xpath = "//button[contains(text(),'Re-Activate')]")
	@CacheLookup
	WebElement RegReactButton;

	@FindBy(xpath = ".//*[contains(text(),'re-activated successfully')]")
	@CacheLookup
	WebElement RegReactMessageText;
	@FindBy(xpath = "//*[@id=\"reactivateMsg\"]/div/div/div[2]/button")
	@CacheLookup
	WebElement RegReactOKButton;
	

	public ManageReg() {

		PageFactory.initElements(driver, this);

	}

	public void withdrawRegAcc() throws Exception {
		
		log.info("********* Withdraw reg acc started **********");
		util = new GenericUtilities();
		util.click(ManageRegLink);
		Thread.sleep(1000);
		util.click(searchT2Button);
		Thread.sleep(2000);
	//	util.getText(CountOFResultsT2);
		util.click(RegWithdrawIcon);
		util.selectByIndex(4, RegWithdrawReasondropdown);
		util.getText(RegWithdrawOtherReasonTitle);
		util.sendKeys(RegWithdrawOtherReasonBox, " Withdrawing reg acc ");
		util.click(RegWithdrawButtonClick);
		Thread.sleep(3000);
		util.getText(withdrawMessageSuccessText);Thread.sleep(3000);
		util.click(withdrawRegOKbutton);Thread.sleep(3000);
		log.info("********* Withdraw reg acc finished **********");
	}
	
	public void ReActivateRegAcc() throws Exception {
		
		log.info("********* Reactivate reg acc started **********");
		util = new GenericUtilities();
		util.click(ManageRegLink);
		Thread.sleep(2000);
		util.selectByIndex(5, RegReactoption);
		util.click(searchT2Button);
		Thread.sleep(2000);
		util.getText(CountOFResultsT2);
		util.click(RegReactIcon);
		util.sendKeys(RegReactreasonBox, " Withdrawing reg acc ");
		util.click(RegReactButton);
		util.getText(RegReactMessageText);
		util.click(RegReactOKButton);
		
		log.info("********* Reactivate reg acc finished **********");

	}

	public void searchRegUsers() throws Exception {

		util = new GenericUtilities();
		util.click(ManageRegLink);
		Thread.sleep(2000);
		util.selectByIndex(1, orgTypeDropdownT2);
		util.click(searchT2Button);
		Thread.sleep(2000);
		util.getText(CountOFResultsT2);

	}

	public void bulkUploadCamera(String Accno) throws Exception {

		log.info("********** bulk upload camera started for acc no " + Accno + " ********");
		util = new GenericUtilities();
		util.click(ManageRegLink);
		Thread.sleep(2000);
		util.click(searchT2Button);
		util.getText(CountOFResultsT2);
		util.click(accnoColumnSearchfield);
		util.sendKeys(accnoColumnSearchfield, Accno);
		util.click(bulkUploadCam);
		Thread.sleep(2000);
		util.click(selectBulkuploadFile);
		//selectBulkuploadFile.sendKeys(bulkUploadCameraFilePath); not working always hence used robot class
		Thread.sleep(3000);
		util.selectUploadFilebyRobot(bulkUploadCameraFilePath);
		
		util.click(selectBulkuploadButton);
		util.getText(bulkUploadCamMessage);

		log.info("********** bulk upload camera Finished for acc no " + Accno + " ********");

	}

}
