package com.cctv.testpages;

import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

@SuppressWarnings("unused")
public class FlipkartTest extends TestBase {

	public static void main(String[] args) throws Exception {

		GenericUtilities util = new GenericUtilities();

		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir") + "\\drivers\\chromedriver.exe") ;
		// WebDriver driver= new ChromeDriver();
	//	setDriver("chrome", "https://www.flipkart.com");
		System.out.println(driver);
		// driver.get("https://www.flipkart.com");
		FileUtils.mkdir("D:\\CCTVAutomation\\mylatest\\cctv2\\screenshots");
		String methodName = "flipkart";
		util.takeScreenShotByAShotUtility(methodName, driver);

		driver.quit();
	}

}
