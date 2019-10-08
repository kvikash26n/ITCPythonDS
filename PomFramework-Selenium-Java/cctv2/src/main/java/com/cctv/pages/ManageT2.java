package com.cctv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageT2 extends TestBase {
	GenericUtilities util;
	@FindBy(xpath = ".//*[@ng-click=\"ShowHide('T2',3)\"]")
	@CacheLookup	
	WebElement t2abclick;
	@FindBy(xpath = ".//*[@id='orgTypeT2']")
	@CacheLookup
	WebElement orgTypeDropdown;
	@FindBy(xpath = ".//*[@ng-model=\"ManageUser.SearchT2VM.OrganisationName\"]")
	@CacheLookup
	WebElement orgName;
	@FindBy(xpath = "ng-model=\"ManageUser.SearchT2VM.FirstName\"")
	@CacheLookup
	WebElement firstName;
	@FindBy(xpath = ".//*[@name=\"surnameT2\"]")
	@CacheLookup
	WebElement surName;
	@FindBy(xpath = ".//*[@id='searchT2']")
	@CacheLookup
	WebElement searchT2Button;
	@FindBy(xpath = ".//*[@ui-grid-one-bind-title=\"paginationThrough\"]")
	@CacheLookup
	WebElement countOfResults;
	@FindBy(xpath = ".//*[@href=\"/ManageUser/ManageUser\"]")
	
	WebElement manageUsersLink;

	public ManageT2() {

		PageFactory.initElements(driver, this);

	}

	public void searchT2Users(int OrgType, String OrgName, String FirstName, String SurName) throws Exception {
		util = new GenericUtilities();
		log.info("***********Search T2 Users Started*********");

		util.click(manageUsersLink);
		util.click(t2abclick);
		Thread.sleep(4000);
		validateT2TabLoad();
		util.selectByIndex(OrgType, orgTypeDropdown);
		util.sendKeys(orgName, "Organisation");
		util.click(searchT2Button);
		util.getText(countOfResults);
		log.info("***********Search T2 Users Started*********");

	}

	public void validateT2TabLoad() {

		util = new GenericUtilities();
		log.info("**** Asserting T2 tab load *********");
		try {

			SoftAssert s_assert = new SoftAssert();
			s_assert.assertEquals(driver.getTitle(), "Manage T2 Users");

			log.info("T2 page load pass.");
		} catch (Exception e) {

			log.info("T2 page load failed." + e);

		}

	}

}
