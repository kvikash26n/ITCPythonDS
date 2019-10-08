package com.cctv.testpages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cctv.pages.ManageT1;
import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageT1Test extends TestBase {
	GenericUtilities util;
	String sheetName="CreateT1Data";
	String TestDataSheetPath = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.xlsx";

	@DataProvider(name = "getCreateT1data")
	public Object[][] getCreateT1data() {

		Object data[][] = GenericUtilities.getTestData(sheetName,TestDataSheetPath);
		return data;
	}

	@Test(priority = 4, enabled=false)
	public void uploadT2users() throws Exception {
		ManageT1 manage = new ManageT1();
		manage.uploadT2();

	}

	@Test(priority = 3, dataProvider = "getCreateT1data", groups = "activ",enabled=true)
	public void creat1T1users(String orgType, String orgName, String email, String SurName, String GivenName,
			String phoneNo, String EmpNO, String branch) throws Exception {
		ManageT1 manage = new ManageT1();
		manage.creat1T1user(orgType, orgName, email, SurName, GivenName, phoneNo, EmpNO, branch);

	}

	/*
	 * @Test(priority = 23)
	 * 
	 * public void downloadT2uploadTemplate() throws Exception { ManageT1 manage =
	 * new ManageT1(); manage.downloadBulkT2UploadTemplate();
	 * 
	 * }
	 */

	@Test(priority = 2, enabled=false)
	public void UnlockT1user() throws Exception {
		ManageT1 manage = new ManageT1();
		manage.UnlockT1user("Locked");

	}

	@Test(priority = 1,enabled=false)

	public void LockT1user() throws Exception {

		ManageT1 manage = new ManageT1();
		manage.lockT1user();
		//manage.migrateT2user();
	}
	
	@Test(priority=5,enabled=false)
	
	public void migrateT2user() throws Exception {

		ManageT1 manage = new ManageT1();
		manage.migrateT2user();
		
		
		
	}
	
	@Test
	
	public void vefirylinks() throws MalformedURLException, IOException {
		
		GenericUtilities util= new GenericUtilities();
		
		util.brokenLinksTest();
	}
	

}
