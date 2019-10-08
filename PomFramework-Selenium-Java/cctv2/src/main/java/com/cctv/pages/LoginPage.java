
package com.cctv.pages;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;
import com.cctv.utils.TestData;

public class LoginPage extends TestBase {
	public GenericUtilities util;
	public TestData data;

	public LoginPage() {
//super();
		data = new TestData(driver);
		// PageFactory.initElements(driver, this);

	}

	public void login(String username, String pwd) throws Exception {

		log.info("********* login started **********");
		GenericUtilities util = new GenericUtilities();
		util.highlighElement(data.acceptAndContinue);
		util.click(data.acceptAndContinue);
		util.highlighElement(data.loginbutton);
		data.loginbutton.click();
		util.sendKeys(data.userId, username);
		util.sendKeys(data.password, pwd);
		util.click(data.SignInButton);
		log.info("********* login finished **********");
	}

}