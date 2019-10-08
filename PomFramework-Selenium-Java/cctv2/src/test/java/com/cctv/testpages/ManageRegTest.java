package com.cctv.testpages;

import org.testng.annotations.Test;

import com.cctv.pages.ManageReg;
import com.cctv.utils.TestBase;

public class ManageRegTest extends TestBase {

	@Test(priority = 3, enabled = true)
	public void searchRegUsers() throws Exception {

		ManageReg reg = new ManageReg();
		reg.searchRegUsers();

	}

	@Test(priority = 11)
	public void withdrawRegAcc() throws Exception {

		ManageReg reg = new ManageReg();

		reg.withdrawRegAcc();
	}

	@Test(priority = 2)
	public void ReActivateRegAcc() throws Exception {

		ManageReg reg = new ManageReg();
		reg.ReActivateRegAcc();
	}

	@Test(priority = 1)
	public void bulkUploadCamera() throws Exception {

		ManageReg reg = new ManageReg();
		reg.bulkUploadCamera("R000005579");
	}
}
