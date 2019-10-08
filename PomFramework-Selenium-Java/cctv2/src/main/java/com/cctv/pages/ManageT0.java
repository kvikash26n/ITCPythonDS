
package com.cctv.pages;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;
import com.cctv.utils.TestData;

public class ManageT0 extends TestBase {

	TestData data;

	GenericUtilities util;

	// Logger log= Logger.getLogger(getClass());

	public ManageT0() {

		data = new TestData(driver);

		// PageFactory.initElements(driver, this);

	}

	public void editt0details(String string, String string2, String string3, String string4, String string5)
			throws Exception {
		util = new GenericUtilities();
		log.info("****************Started editing t0****************");
		Thread.sleep(3000);
		util.click(data.EditMydetailsLink);	Thread.sleep(3000);
		util.scrollIntoView(data.editdetails);
		util.click(data.editdetails);	Thread.sleep(3000);
		util.sendKeys(data.surnameeditt0, string);
		util.sendKeys(data.givenName, string2);
		util.sendKeys(data.phonenumber, string3);
		util.sendKeys(data.empNumber, string4);
		util.sendKeys(data.branchArea, string5);
		Thread.sleep(2000);
		util.click(data.savechanges);
		Thread.sleep(2000);
		log.info("****************editing t0 done****************");

	}

	public void searchT0Users(String Firstname, String Lastname) throws Exception {
		util = new GenericUtilities();
		log.info("****************Search T0 started ****************");
		util.click(data.manageuserslink);
		util.sendKeys(data.firstnameT0, Firstname);
		util.sendKeys(data.surnameT0, Lastname);
		util.click(data.searchbuttonT0);
		util.getText(data.countOfSearchResults);
		log.info("****************Search T0 finished ****************");

	}

	public void searchOnlyArchivedT0Users() throws Exception {

		util = new GenericUtilities();
		util.click(data.manageuserslink);
		util.click(data.T0archiveCheckbox);
		Thread.sleep(2000);
		util.click(data.searchbuttonT0);
		Thread.sleep(2000);

	}

	public void creatingt0user(String email, String surname, String firstname, String phone, String EmpId,
			String Branch) throws Exception {
		util = new GenericUtilities();
		log.info("****************Create T0 started****************");
		util.click(data.manageuserslink);
		Thread.sleep(3000);
		util.click(data.createnewt0button);
		util.sendKeys(data.emailfieldT0, email);
		util.sendKeys(data.createt0surname, surname);
		util.sendKeys(data.createt0givenname, firstname);
		util.sendKeys(data.createt0phonenumber, phone);
		util.scrollIntoView(data.createnewt0submit);
		util.click(data.createnewt0submit);
		Thread.sleep(2000);
		util.getText(data.successAlertCreateT0);
		Thread.sleep(2000);
		util.click(data.T0successAlertOkButton);
		Thread.sleep(2000);

		log.info("****************Create T0 finished****************");

	}

	public void lockingT0() throws Exception {
		log.info("********locking T0 started********");
		util = new GenericUtilities();
		Thread.sleep(3000);
		util.click(data.manageuserslink1);Thread.sleep(3000);
		util.click(data.searchbuttonT0);
		Thread.sleep(8000);
		//searchT0StatusColumn("Active");
		util.scrollToElement(driver, data.countOfSearchResults);
		util.getText(data.countOfSearchResults);
		util.scrollIntoView(data.countOfSearchResults);
		util.click(data.lockT0Icon);
		util.sendKeys(data.lockT0Comments, "Locking T0 User");
		Thread.sleep(3000);
		util.click(data.lockT0Button);
		Thread.sleep(7000);
		util.getText(data.T0accountLockMessage);
		Thread.sleep(3000);
		util.click(data.T0okLockButton);
		log.info("********locking T0 finished********");
	}

	public void unlockingT0() throws Exception {

		log.info("********Unlocking T0 started********");
		util = new GenericUtilities();
		Thread.sleep(4000);
		util.click(data.manageuserslink1);
		Thread.sleep(3000);
		util.click(data.searchbuttonT0);
		Thread.sleep(8000);searchT0StatusColumn("Locked");
		util.scrollToElement(driver, data.countOfSearchResults);
		util.getText(data.countOfSearchResults);
		util.click(data.unlockT0Icon);
		util.sendKeys(data.unlockT0Comments, "UNLocking T0 User");
		util.click(data.unlockT0Button);Thread.sleep(6000);
		util.getText(data.T0accountUnLockMessage);
		Thread.sleep(2000);
		util.click(data.T0okUnlockButton);Thread.sleep(2000);
		log.info("********Unlocking T0 finished********");
	}

	public void archiveT0() throws Exception {
		log.info("********Archive T0 started********");
		util = new GenericUtilities();
		util.click(data.manageuserslink);
		Thread.sleep(3000);
		util.click(data.searchbuttonT0);Thread.sleep(2000);
		searchT0StatusColumn("Active");
		util.getText(data.countOfSearchResults);
		util.JSscroll(data.countOfSearchResults);Thread.sleep(2000);
		util.click(data.archivet0icon);Thread.sleep(2000);
		util.sendKeys(data.archiveT0Reasonbox, "Archiving T0 User");
		util.click(data.archiveT0Button);Thread.sleep(2000);
		util.getText(data.T0accountArchiveMessage);Thread.sleep(2000);
		util.click(data.T0okArchiveButton);
		log.info("********De Archive T0 finished********");
	}

	public void deArchiveT0() throws Exception {

		log.info("********De Archive T0 started********");
		util = new GenericUtilities();
		util.click(data.manageuserslink);
		Thread.sleep(3000);
		util.click(data.T0archiveCheckbox);Thread.sleep(2000);
		util.click(data.searchbuttonT0);
		util.JSscroll(data.T0deArchiveIcon);Thread.sleep(2000);
		// util.getText(countOfSearchResults);
		util.click(data.T0deArchiveIcon);Thread.sleep(2000);
		util.sendKeys(data.T0deArchiveReason, "Archiving T0 User");
		util.click(data.T0deArchiveButton);Thread.sleep(2000);
		util.getText(data.T0deArchiveText);
		Thread.sleep(1000);
		util.click(data.T0okDeArchiveButton);

		log.info("********De Archive T0 finished********");
	}

	public void ContactT0Users(int index, String EmailBodyText) throws Exception {

		log.info("********Contact T0 started********");
		util = new GenericUtilities();
		util.click(data.manageuserslink);
		Thread.sleep(3000);
		util.click(data.searchbuttonT0);
		Thread.sleep(2000);

		util.scrollIntoView(data.T0resultcount);
		util.getText(data.T0resultcount);
		Thread.sleep(2000);
		util.click(data.T0ContactIcon);
		util.switchToFrameById(driver, "ui-tinymce-1_ifr");
		util.selectByIndex(index, data.T0ChooseTemplateDropdown);
		util.getText(data.T0ToAddressEmail);
		util.getText(data.T0FROMAddressEmail);
		util.getText(data.T0EmailSubject);

		util.sendKeys(data.T0EmailText, EmailBodyText);
		Thread.sleep(2000);
		// util.switchToDefaultWindow(driver);
		// Thread.sleep(2000);
		util.click(data.T0EmailSendButton);
		util.getText(data.T0EmailSendConfirmBox);
		util.click(data.T0EmailSendFinalOKButton);
		log.info("********Contact T0 finished********");

	}

	public void searchT0StatusColumn(String ColFilterText) throws Exception {
		
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		log.info("******** "+ name+" started********");
		util = new GenericUtilities();
		util.click(data.manageuserslink);
		Thread.sleep(3000);
		util.click(data.searchbuttonT0);
		Thread.sleep(4000);
		util.JSscroll(data.T0TabStatusColumnFilter);
		util.click(data.T0TabStatusColumnFilter);
		util.sendkeysActions(data.T0TabStatusColumnFilter, ColFilterText);
		util.selectByIndex(3, data.T0SearchNavigation);
		log.info("******** "+ name+" finished********");
	}

}