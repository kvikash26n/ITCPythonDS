package com.cctv.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class RegEdit extends TestBase {
	GenericUtilities util;

	@FindBy(xpath = "//*[@ng-click='EditOrganisation()']")
	@CacheLookup

	private WebElement EditOrgButton;

	@FindBy(xpath = "//*[@id='OrgOptions']/div[2]/input")
	@CacheLookup
	private WebElement orgname;

	@FindBy(xpath = "//button[@ng-click='AddressValidation(0,Registration.OrganisationInfo.AddressInfo)']")
	@CacheLookup
	private WebElement validateAddress;

	public RegEdit() {

		PageFactory.initElements(driver, this);

	}

	public void editRegistration() throws Exception {
		util = new GenericUtilities();
		util.click(EditOrgButton);

	}

	public boolean isvalidateAddressButtonEnabled() {

		validateAddress.isEnabled();
		return false;
	}
}
