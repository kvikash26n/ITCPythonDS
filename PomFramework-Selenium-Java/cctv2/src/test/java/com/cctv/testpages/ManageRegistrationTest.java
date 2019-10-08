package com.cctv.testpages;

import org.testng.annotations.Test;

import com.cctv.pages.ManageRegistration;
import com.cctv.utils.TestBase;

public class ManageRegistrationTest extends TestBase {

	@Test(enabled=false)
	public void clickCOmpleteButton() throws Exception {

		ManageRegistration comp = new ManageRegistration();

		comp.completeRegistration();

	}

	@Test(enabled=true)

	public void addSiteToACompletedRegAccount() throws Exception {
		
		ManageRegistration comp = new ManageRegistration();

		comp.addnewSiteToACompletedAccount();

	}

}
