package com.cctv.utils;
/*package com.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	WebDriver driver = null;
	GenericUtilities util;
	
	String filePath =  System.getProperty("user.dir")+"\\test-output\\screenshot\\" ;
	
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("***** Success " + result.getName()
				+ " test has passed *****");
		String methodName = result.getName().toString().trim();
		util.takeScreenShot(methodName);
		

	}
	
	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("***** Error " + result.getName()
				+ " test has failed *****");
		String methodName = result.getName().toString().trim();
		util.takeScreenShot(methodName);
	}
	
	public void takeScreenShot(String methodName) {
		// get the driver
		driver= new TestBase().getDriver();
		driver.manage().window().maximize();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String destFileName = formater.format(calendar.getTime());
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
	
		
		try {
			FileUtils.copyFile(scrFile,
					new File(filePath + methodName + destFileName+".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
	}
}
*/