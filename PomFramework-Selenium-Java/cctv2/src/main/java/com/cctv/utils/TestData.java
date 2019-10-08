package com.cctv.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestData {
	public final static String USER_NAME = "T000001263";
	public final static String PASSWORD = "Log!n@123";
	public final static long PAGE_LOAD_TIMEOUT = 60;
	public final static long IMPLICIT_WAIT = 30;

	// CCTV login element x paths

	@FindBy(xpath = "/html/body/section/section/div/div/article/div/div[2]/a")
	@CacheLookup
	public WebElement acceptAndContinue;
	@FindBy(xpath = "html/body/section/div/section/div/form/div[2]/button[1]")
	@CacheLookup
	public WebElement loginbutton;
	@FindBy(xpath = ".//*[@id='cred_userid_inputtext']")
	@CacheLookup
	public WebElement userId;
	@FindBy(xpath = ".//*[@id='cred_password_inputtext']")
	@CacheLookup
	public WebElement password;
	@FindBy(xpath = ".//*[@id='cred_sign_in_button']")
	@CacheLookup
	public WebElement SignInButton;

	// contact t0 users
	@FindBy(xpath = "(.//*[@data-original-title='Contact'])[position()=1]")
	@CacheLookup
	public WebElement T0ContactIcon;

	@FindBy(xpath = ".//*[@id='contact']")
	@CacheLookup
	public WebElement T0ContactWindow;
	@FindBy(xpath = "(.//*[@ng-show='grid.options.totalItems > 0'])[position()=1]")
	@CacheLookup
	public WebElement T0resultcount;

	@FindBy(xpath = ".//*[@class=\"mail-drpdwn ng-pristine ng-untouched ng-valid\"]")
	@CacheLookup
	public WebElement T0ChooseTemplateDropdown;
	@FindBy(xpath = "(.//span[@class=\"ng-binding\"])[position()=1]")
	@CacheLookup
	public WebElement T0ToAddressEmail;
	@FindBy(xpath = "(.//span[@class=\"ng-binding\"])[position()=2]")
	@CacheLookup
	public WebElement T0FROMAddressEmail;

	@FindBy(xpath = ".//*[@ng-model=\"mailtemplate.Subject\"]")
	@CacheLookup
	public WebElement T0EmailSubject;

	@FindBy(xpath = "id=\"ui-tinymce-1_ifr\"")
	@CacheLookup
	public WebElement T0EmailBodyFrame;

	@FindBy(xpath = ".//*[@id='tinymce']")
	@CacheLookup
	public WebElement T0EmailText;
	@FindBy(xpath = "//button[@ng-click=\"contact()\"]")
	@CacheLookup
	public WebElement T0EmailSendButton;
	@FindBy(xpath = "(.//p[@class=\"messageWrap defaultFont\"])[position()=8]")
	@CacheLookup
	public WebElement T0EmailSendConfirmBox;
	@FindBy(xpath = ".//*[@id='userContactMsg']/div/div/div[2]/button")
	@CacheLookup
	public WebElement T0EmailSendFinalOKButton;

	// search t0 users
	@FindBy(xpath = ".//*[@id='dvsearchT0user']/div[1]/fieldset/div[1]/input")
	@CacheLookup
	public WebElement firstnameT0;
	@FindBy(xpath = ".//*[@id='dvsearchT0user']/div[1]/fieldset/div[2]/input")
	@CacheLookup
	public WebElement surnameT0;

	@FindBy(xpath = ".//*[@id='dvsearchT0user']/div[1]/fieldset/div[3]/button")

	public WebElement searchbuttonT0;
	@FindBy(xpath = ".//*[@id='archived']")
	@CacheLookup
	public WebElement archivedcheckT0;
	@FindBy(xpath = "(//*[@id='RegistrationPanel']/div/h4/a)[position()=1]")

	public WebElement manageuserslink;
	@FindBy(xpath = "(//*[@id='RegistrationPanel']/div/h4/a)[position()=1]")

	public WebElement manageuserslink1;

	@FindBy(xpath = "(.//*[@ng-show='grid.options.totalItems > 0'])[position()=1]")

	public WebElement countOfSearchResults;

	// create t0 user field locators

	@FindBy(xpath = ".//*[@id='emailAddress']")
	@CacheLookup
	public WebElement emailfieldT0;
	@FindBy(xpath = ".//*[@id='surname']")
	@CacheLookup
	public WebElement createt0surname;
	@FindBy(xpath = ".//*[@id='givenName']")
	@CacheLookup
	public WebElement createt0givenname;
	@FindBy(xpath = ".//*[@id='phoneNumber']")
	@CacheLookup
	public WebElement createt0phonenumber;
	@FindBy(xpath = ".//*[@id='empNumber']")
	@CacheLookup
	public WebElement createt0empnumber;
	@FindBy(xpath = ".//*[@id='branchArea']")
	@CacheLookup
	public WebElement createt0brancharea;
	@FindBy(xpath = ".//*[@id='btnsubmitT0']")
	@CacheLookup
	public WebElement createnewt0submit;
	@FindBy(xpath = "//button[text()='Create New T0 Account']")
	@CacheLookup
	public WebElement createnewt0button;
	@FindBy(xpath = ".//*[@id='userT0Msg']/div/div/div[1]/p")
	@CacheLookup
	public WebElement successAlertCreateT0;
	@FindBy(xpath = ".//*[@id='userT0Msg']/div/div/div[2]/button")
	@CacheLookup
	public WebElement T0successAlertOkButton;

	// edit t0 field locators
	@FindBy(xpath = ".//*[@id='searchPanel']/div/h4/a")

	public WebElement EditMydetailsLink;
	@FindBy(xpath = ".//*[@value='Edit Profile']")

	public WebElement editdetails;
	@FindBy(xpath = ".//*[@id='RegistrationPanel']/div/h4/a")

	public WebElement ManageUsers;
	@FindBy(xpath = ".//*[@id='surname']")
	@CacheLookup
	public WebElement surnameeditt0;
	@FindBy(xpath = ".//*[@id='givenName']")
	@CacheLookup
	public WebElement givenName;
	@FindBy(xpath = ".//*[@id='phoneNumber']")
	@CacheLookup
	public WebElement phonenumber;
	@FindBy(xpath = ".//*[@id='empNumber']")
	@CacheLookup
	public WebElement empNumber;
	@FindBy(xpath = ".//*[@id='branchArea']")
	@CacheLookup
	public WebElement branchArea;
	@FindBy(xpath = ".//*[@id='logout']/div/h4/a")
	@CacheLookup
	public WebElement logout;
	@FindBy(xpath = ".//*[@id='dvupdateT0user']/div/div/div[2]/input[3]")
	@CacheLookup
	public WebElement savechanges;
	@FindBy(xpath = ".//*[@id='dvupdateT0user']/div/div/div[1]/p[1]/strong")
	@CacheLookup
	public WebElement savesuccess;

	// locking t0 fields
	@FindBy(xpath = "(.//*[@data-original-title='Lock/Unlock'])[position()=1]")

	public WebElement lockT0Icon;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.lockreason\"]")

	public WebElement lockT0Comments;
	@FindBy(xpath = "//*[@ng-click=\"lockaccount('lock')\"]")
	public WebElement lockT0Button;
	@FindBy(xpath = ".//*[@id='lockMsg']//following-sibling::div//following-sibling::div//following-sibling::div[1]//following-sibling::p[1]")
	public WebElement T0accountLockMessage;
	@FindBy(xpath = ".//*[@id='lockMsg']//following-sibling::div//following-sibling::div[2]//following-sibling::button")
	public WebElement T0okLockButton;

	// UNlocking t0 fields
	@FindBy(xpath = "(.//*[@class=\"fa fa-unlock-alt\"])[position()=1]")
	public WebElement unlockT0Icon;
	@FindBy(xpath = ".//*[@id='lock']/div[2]/textarea")
	public WebElement unlockT0Comments;
	@FindBy(xpath = "(//*[@class='btn btnWidth btnInline btn-sm btn-custom-blue'])[1]")
	public WebElement unlockT0Button;
	@FindBy(xpath = ".//*[@id='lockMsg']//following-sibling::div//following-sibling::div//following-sibling::div[1]//following-sibling::p[2]")
	public WebElement T0accountUnLockMessage;
	@FindBy(xpath = ".//*[@id='lockMsg']//div//div//following-sibling::div[2]//button")
	public WebElement T0okUnlockButton;

	// archive t0 fields
	@FindBy(xpath = "(.//*[@class='fa fa-archive'])[position()=1]")
	public WebElement archivet0icon;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.archivereason\"]")
	public WebElement archiveT0Reasonbox;
	@FindBy(xpath = "(//*[@class=\"modal-footer text-center adminFooter ng-scope\"]//following-sibling::button[1])[position()=1]")
	public WebElement archiveT0Button;
	@FindBy(xpath = "(.//*[@ng-show=\"active\"])[position()=2]")
	public WebElement T0accountArchiveMessage;
	@FindBy(xpath = ".//*[@id='archiveMsg']/div/div/div[2]/button")
	@CacheLookup
	public WebElement T0okArchiveButton;

	// Dearchive t0 fields
	@FindBy(xpath = ".//*[@ng-model='ManageUser.SearchT0VM.archived']")
	public WebElement T0archiveCheckbox;
	@FindBy(xpath = "(.//*[@class='fa fa-dropbox'])[position()=1]")
	public WebElement T0deArchiveIcon;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.archivereason\"]")
	public WebElement T0deArchiveReason;
	@FindBy(xpath = "//button[@ng-show='!active']")
	public WebElement T0deArchiveButton;
	@FindBy(xpath = "(.//*[@ng-show=\"!active\"])[position()=2]")
	@CacheLookup
	public WebElement T0deArchiveText;
	@FindBy(xpath = ".//*[@id='archiveMsg']/div/div/div[2]/button")
	@CacheLookup
	public WebElement T0okDeArchiveButton;

	// T0 column searches
	@FindBy(xpath = "(.//*[@ng-if=\"colFilter.type !== 'select'\"])[position()=4]")

	public WebElement T0TabStatusColumnFilter;
	@FindBy(xpath = ".//*[@ng-model=\"grid.options.paginationPageSize\"]")
	@CacheLookup
	public WebElement T0SearchNavigation;

	public TestData(WebDriver driver) {

	PageFactory.initElements(driver, this);

	}

}
