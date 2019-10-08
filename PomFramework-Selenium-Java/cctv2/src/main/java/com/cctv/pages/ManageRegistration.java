package com.cctv.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class ManageRegistration extends TestBase {

	@FindBy(xpath = "(.//*[@id='RegistrationPanel'])[position()=2]")
	WebElement manageRegistrationLink;
	/*
	 * @FindBy(linkText="Manage Registrations") WebElement manageRegistrationLink;
	 */

	@FindBy(xpath = ".//*[@id='site']/div/footer/div[2]/button")
	WebElement completeButton;

	@FindBy(xpath = "(.//*[@id='orgTypeT2'])[position()=2]")
	WebElement accTypeDropdown;

	@FindBy(xpath = ".//*[@id='searchT2']")
	WebElement searchButton;

	@FindBy(xpath = "(.//*[@ class=\"ui-grid-filter-input ui-grid-filter-input-0\"])[position()=1]")
	WebElement accNocolumnsearchBox;
	@FindBy(xpath = "(.//*[@ng-click=\"grid.appScope.ControllerRedirect(row,'Registrant')\"])[position()=1]")
	WebElement accnoLink;

	// Add new system site to an existing completed account
	@FindBy(xpath = ".//*[contains(text(),'CCTV System/Site Information')]")

	WebElement systemSiteTab;

	@FindBy(xpath = ".//*[contains(text(),'+ Add New Site')]")
	@CacheLookup
	WebElement addnewsitebutton;

	@FindBy(xpath = ".//*[contains(text(),'Yes. Use previous System/Site details')]")
	WebElement yesUsePreviousSiteDetailsButton;
	@FindBy(xpath = ".//*[COntains(text(),'No. Add new System/SIte details')]")
	WebElement noAddNewSiteButton;
	@FindBy(xpath = ".//*[contains(text(),'Save Changes')]")
	WebElement saveSitebutton;
	@FindBy(xpath = ".//*[contains(text(),'+ Add Camera To This Site')]")
	WebElement addCameraButton;
	@FindBy(xpath = "(.//*[@ng-model=\"colFilter.term\"])[position()=1]")
	WebElement accnocolfilter;
	@FindBy(xpath = "//*[@name=\"cameraPurpose\"]")
	WebElement dutyStmnt;

	@FindBy(xpath = "//button[text()='Save Changes']")
	WebElement saveCameraButton;

	GenericUtilities util;

	public ManageRegistration() {

		PageFactory.initElements(driver, this);

	}

	public void completeRegistration() throws Exception {
		util = new GenericUtilities();

		try {
			util.click(manageRegistrationLink);
			Thread.sleep(5000);

			util.selectByIndex(3, accTypeDropdown);

			util.click(searchButton);
			Thread.sleep(8000);
			// util.sendKeys(accNocolumnsearchBox, "00001");
			for (int i = 1; i < 2; i++) {

				WebElement ele = driver.findElement(
						By.xpath("(.//*[@ng-click=\"grid.appScope.ControllerRedirect(row,'Registrant')\"])[position()="
								+ i + "]"));
				util.click(ele);
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				String parentWindowId = it.next();
				String childWindowId = it.next();
				System.out.println(set);
				driver.switchTo().window(childWindowId);
				Thread.sleep(6000);
				try {
					util.click(completeButton);
					Thread.sleep(6000);
					driver.close();
					driver.switchTo().window(parentWindowId);
					Thread.sleep(1000);
				} catch (Exception e) {
					driver.close();
					driver.switchTo().window(parentWindowId);
					Thread.sleep(5000);
				}
			}

		}

		catch (Exception e) {

			log.info("Error while completing registration --------- " + e);

			// completeRegistration(); code to relaunch complete registration in case 1st attempt fails
		}
	}

	@SuppressWarnings("static-access")
	public void addnewSiteToACompletedAccount() throws Exception {
		String ss = RandomStringUtils.randomAlphabetic(8);

		util = new GenericUtilities();
		util.click(manageRegistrationLink);
		util.waitForVisibilityOfElement(accTypeDropdown);
		util.selectByIndex(0, accTypeDropdown);

		util.click(searchButton);
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("(.//*[@title=\"Edit/Update Registrant\"])[position()=1]"));
		util.waitForVisibilityOfElement(ele);

		util.sendKeys(accnocolfilter, "R000007586");
		util.click(ele);
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		System.out.println(set);
		driver.switchTo().window(childWindowId);
		//util.waitForVisibilityOfElement(systemSiteTab);
		Thread.sleep(5000);
		util.click(systemSiteTab);
		util.click(addnewsitebutton);
		util.click(yesUsePreviousSiteDetailsButton);

		List<WebElement> ele1 = driver
				.findElements(By.xpath(".//*[@type=\"text\" and  @ng-model=\"site.SystemSiteName\"]"));

		int count = ele1.size();
		System.out.println("Total count of system/sites is " + count);
		count++;
		WebElement newSiteName = driver.findElement(
				By.xpath("(.//*[@type=\"text\" and  @ng-model=\"site.SystemSiteName\"])[position()=" + count + "]"));

		util.sendKeys(newSiteName, ss);

		 Thread.sleep(3000);

		util.selectLastOfSameElementPresentMultipleTimes("(.//*[contains(text(),'Save Changes')])");

		Thread.sleep(2000);
try {
		util.selectLastOfSameElementPresentMultipleTimes("(.//*[contains(text(),'+ Add Camera To This Site')])");
		
		
		 Thread.sleep(4000); }
		 
		 catch (Exception e) {
			 
			 
			 util.selectLastOfSameElementPresentMultipleTimes("(.//*[contains(text(),'+ Add New Camera')])");

			 Thread.sleep(4000); 
			 
			 
		 }
		 

		util.selectLastOfSameElementPresentMultipleTimes(
				"(.//*[@ng-disabled=\"!camera.IsDisabled\" and  @name=\"cameraName\"])");

		util.sendDataTOLastOfSameElementPresentMultipleTimes(
				"(.//*[@ng-disabled=\"!camera.IsDisabled\" and  @name=\"cameraName\"])", ss);

		List<WebElement> camerViewSelectOption = driver.findElements(By.xpath("(.//*[@id='cameraViewSelect'])"));
		int camerViewSelectOptionCount = camerViewSelectOption.size();

		WebElement camerViewSelectOptionFinalbutton = driver
				.findElement(By.xpath("(.//*[@id='cameraViewSelect'])[position()=" + camerViewSelectOptionCount + "]"));
		System.out.println(camerViewSelectOptionFinalbutton);
		util.selectByIndex(3, camerViewSelectOptionFinalbutton);

		// util.selectLastOfSameElementPresentMultipleTimes("//*[@name=\"cameraPurpose\"]");
		List<WebElement> dutyStatementFields = driver.findElements(By.xpath("//*[@name=\"cameraPurpose\"]"));
		int dutyStatementFieldsCount = dutyStatementFields.size();

		WebElement dutyStatementFieldsFinalfield = driver
				.findElement(By.xpath("(//*[@name=\"cameraPurpose\"])[position()=" + dutyStatementFieldsCount + "]"));
		System.out.println(dutyStatementFieldsFinalfield);
		util.click(dutyStatementFieldsFinalfield);

		util.sendKeys(dutyStatementFieldsFinalfield, "This is duty statement");

		// util.selectLastOfSameElementPresentMultipleTimes("(//button[text()='Save
		// Changes'])");
		Thread.sleep(4000);

		List<WebElement> saveChangesButtonFields = driver
				.findElements(By.xpath(".//*[@ng-disabled=\"cameraForm.$invalid\"]"));
		int saveChangesButtonFieldsCount = saveChangesButtonFields.size();

		WebElement saveChangesButtonField = driver.findElement(By.xpath(
				"(.//*[@ng-disabled=\"cameraForm.$invalid\"])[position()=" + saveChangesButtonFieldsCount + "]"));
		System.out.println(saveChangesButtonField);
		saveChangesButtonField.click();
		Thread.sleep(6000);

	    WebElement completeButton=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/uib-accordion/div/div[4]/button"));
	    util.scrollIntoViewAndClick(completeButton);

	    driver.switchTo().window(parentWindowId);
		Thread.sleep(1000);

	}
}
