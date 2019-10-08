package com.cctv.testpages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cctv.pages.LoginPage;
import com.cctv.pages.ManageT0;
import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageT0Test extends TestBase {
	
    ManageT0 manageT0;
    LoginPage loginPage;
	String sheetNameT0Create = "T0Create";
	String sheetNameT0Search = "T0Search";
	String sheetNameT0Edit = "T0Edit";
	String TestDataSheetPath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx";
	
	
	public ManageT0Test() {
	
			
	}

	
	@DataProvider(name = "getT0CreateData")
	public Object[][] getT0CreateData() {
		Object data[][] = GenericUtilities.getTestData(sheetNameT0Create, TestDataSheetPath);
		return data;
	}

	@DataProvider(name = "getT0SearchData")
	public Object[][] getT0SearchData() {
		Object data[][] = GenericUtilities.getTestData(sheetNameT0Search, TestDataSheetPath);
		return data;
	}

	@DataProvider(name = "getT0EditData")
	public Object[][] getT0EditData() {
		Object data[][] = GenericUtilities.getTestData(sheetNameT0Edit, TestDataSheetPath);
		return data;
	}

	@Test(priority = 1, dataProvider = "getT0EditData", enabled = false)
	public void editt0test(String FirstName, String LastName, String phoneno, String empno, String Branch)
			throws Exception {
		manageT0= new ManageT0();
		Thread.sleep(4000);
		manageT0.editt0details(FirstName, LastName, phoneno, empno, Branch);
		
	}

	@Test(priority = 2, dataProvider = "getT0SearchData", enabled = true)
	public void searchT0users(String Firstname, String Lastname) throws Exception {
		Thread.sleep(2000);
		manageT0= new ManageT0();
		manageT0.searchT0Users(Firstname, Lastname);
		Thread.sleep(5000);
		// manage.searchOnlyArchivedT0Users();

	}

	@Test(priority = 3, dataProvider = "getT0CreateData", enabled = false)
	public void creatingt0user1(String email, String surname, String firstname, String phone, String EmpId,
			String Branch) throws Exception {
		manageT0= new ManageT0();
		Thread.sleep(2000);
		manageT0.creatingt0user(email, surname, firstname, phone, EmpId, Branch);

	}

	@Test(priority = 4,enabled=false)

	public void lockT0UnlockArchiveDeArchive() throws Exception {

		manageT0= new ManageT0();
		manageT0.lockingT0();
		manageT0.unlockingT0();
		manageT0.archiveT0();
		manageT0.deArchiveT0();

	}

	@Test(priority = 5,enabled=false)
	public void ContactT0() throws Exception {
		manageT0= new ManageT0();
	 manageT0.ContactT0Users(1, "Email subject while contacting T0");

	}

	@Test(priority = 6,enabled=false)

	public void searchT0StatusColumn1() throws Exception {
		manageT0= new ManageT0();
		manageT0.searchT0StatusColumn("Active");

	}
	
	
	/*@AfterMethod
	public void tearDown(){
		
		log.info(" Quitting browser & driver");
	//	driver.quit();
	}*/
}

