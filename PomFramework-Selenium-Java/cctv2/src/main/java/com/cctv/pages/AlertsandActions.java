package com.cctv.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cctv.utils.GenericUtilities;
import com.cctv.utils.TestBase;

public class AlertsandActions extends TestBase {
	// GenericUtilities util;

	// Alerts and actions page elements

	@FindBy(xpath = ".//*[@href=\"/Alert/Alerts\"]")
	@CacheLookup
	WebElement AlertsLink;
	@FindBy(xpath = ".//*[@id='regtypeselect']")
	@CacheLookup
	WebElement AlertTypeDropDown;
	@FindBy(xpath = "(.//*[@class=\"glyphicon glyphicon-calendar\"])[position()=1]")
	@CacheLookup
	WebElement fromDateCalIcon;
	@FindBy(xpath = "html/body/div[2]/div[1]/table/tbody/tr[1]/td[5]")
	@CacheLookup
	WebElement dateFromCalwindow;
	@FindBy(xpath = "(.//*[@class=\"glyphicon glyphicon-calendar\"])[position()=2]")
	@CacheLookup
	WebElement toDateCalIcon;
	@FindBy(xpath = "html/body/div[2]/div[1]/table/tbody/tr[2]/td[6]")
	@CacheLookup
	WebElement dateToCalWindow;
	@FindBy(xpath = ".//*[@ui-grid-one-bind-title=\"paginationThrough\"]")
	@CacheLookup
	WebElement resultCount;

	@FindBy(xpath = ".//*[@ng-click=\"GetSearchedAlerts(alertSearchDTO)\"]")
	@CacheLookup
	WebElement searchButton;
	@FindBy(xpath = "(.//*[@class='ui-grid-cell-contents'])[position()=2]")
	WebElement selectFirstActiveRec;
	@FindBy(xpath = ".//*[@ng-click=\"ClickToSuppress(selectedRows,alertSearchDTO);\"]")
	@CacheLookup
	WebElement suppressButton;

	@FindBy(xpath = "//*[@id=\"suppressAlertModal\"]/div/div/div[3]/button[1]")
	@CacheLookup
	WebElement oksuppress;
	@FindBy(xpath = "//*[@id=\"confirm\"]/div/p")
	@CacheLookup
	WebElement suppressAlertPopUpText;

	@FindBy(xpath = ".//*[@id='tab1']/div/div/div[1]/button[2]")
	WebElement Ackbutton;
	@FindBy(xpath = ".//*[@id='AcknowledgeAlertModal']/div/div/div[3]/button[1]")
	WebElement ackOkButton;
	@FindBy(xpath = ".//*[@id='confirm']/div/p")
	WebElement ackOkgetText;

	// suppress tab fields

	@FindBy(xpath = ".//*[@ng-click=\"GetUpdatedSuppressedAlerts(alertSearchDTO)\"]")
	WebElement suppressedTab;
	@FindBy(xpath = "(.//*[@ ng-class=\"{'ui-grid-row-selected': row.isSelected}\"])[position()=1]")
	WebElement suppressTab1stElement;

	// validate address fields

	@FindBy(xpath = "//*[@id=\"userDataPanel\"]/div/h4/a")

	WebElement AlertsnActionslink;
	@FindBy(xpath = "//*[@id=\"manualAlerturi\"]")

	WebElement ManualAddressTab;

	@FindBy(xpath = "(//*[@ng-click=\"grid.appScope.verifyAddress(row)\"])[position()=2]")

	WebElement VerifyAddresslink;

	@FindBy(xpath = "//*[@id=\"tier1\"]/div[5]/button[1]")

	WebElement AcceptAddress;

	@FindBy(xpath = "//*[@id=\"confirmMessage\"]/div[1]/label[1]")

	WebElement AdressValidatedMesage;

	@FindBy(xpath = "//*[@id=\"confirmMessage\"]/div[2]/button")

	WebElement CloseButton;

	@FindBy(xpath = "(.//input[@ ng-model=\"colFilter.term\"])[position()=17]")

	WebElement Accnocolfilter;

	@FindBy(xpath = "/html/body/section/section/div/div[3]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[3]/div[1]")
	WebElement NoDataAvailable;

	WebElement ele = null;
	public static GenericUtilities util;

	public AlertsandActions() {
		super();
		PageFactory.initElements(driver, this);

	}

	public void supressAndAckAlert() throws Exception {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		log.info("******** " + name + " started********");
		util = new GenericUtilities();
		util.click(AlertsLink);
		Thread.sleep(9000);
		util.selectByName("All", AlertTypeDropDown);
		Thread.sleep(5000);
		util.click(fromDateCalIcon);
		Thread.sleep(2000);
		util.click(dateFromCalwindow);
		util.click(toDateCalIcon);
		util.click(dateToCalWindow);
		util.click(searchButton);
		Thread.sleep(14000);
		util.scrollIntoView(selectFirstActiveRec);
		util.getText(resultCount);
		Thread.sleep(2000);
		selectFirstActiveRec.click();
		Thread.sleep(2000);
		util.click(suppressButton);
		Thread.sleep(2000);
		util.getText(suppressAlertPopUpText);
		Thread.sleep(2000);
		util.click(oksuppress);

		Thread.sleep(9000);
		selectFirstActiveRec.click();
		Thread.sleep(4000);
		Ackbutton.click();
		System.out.println(ackOkgetText.getText());

		util.click(ackOkButton);

		log.info("******** " + name + " finished successfully********");

	}

	public void validateRegistrantAddress() throws Exception {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		log.info("******** " + name + " started********");
		
		try {
			
			driver.switchTo().alert().accept();
			
		}
		catch(Exception e) {
			
			log.info(e+ " no alert present");
			
		}
		util = new GenericUtilities();
		// util.zoomOut(); does not work.
		util.click(AlertsnActionslink);
		Thread.sleep(9000);
		ManualAddressTab.click();
		// util.click(ManualAddressTab); field overlap was happening hence
		// clicked directly
		Thread.sleep(13000);
		// int Size=NoDataAvailable.getSize().toString();
		if (!NoDataAvailable.isDisplayed()) {

		
			try {
				for (int j = 1; j < 80; j++) {

					// util.click(ManualAddressTab);
					Thread.sleep(3000);
					// util.sendKeys(recperPage, "1000");

					// util.sendkeysActions(Accnocolfilter, "R0000005");
					//Thread.sleep(4000);

				//	Thread.sleep(3000);
					util.scrollIntoView(Accnocolfilter);
					Thread.sleep(3000);
					util.click(Accnocolfilter);
					WebElement recperPage = driver.findElement(By.xpath(
							"/html/body/section/section/div/div[3]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[3]/div[2]/input"));
					util.sendKeys(recperPage, "1000");
					ele = driver.findElement(
							By.xpath("(//*[@ng-click=\"grid.appScope.verifyAddress(row)\"])[position()=" + j + "]"));
					util.click(ele);

					Thread.sleep(3000);

					Set<String> set = driver.getWindowHandles();
					Iterator<String> it = set.iterator();
					String parentWindowId = it.next();

					String childWindowId = it.next();
					System.out.println(set);

					driver.switchTo().window(childWindowId);

					Thread.sleep(2000);
					
					util.click(AcceptAddress);
					Thread.sleep(3000);
					// util.getText(AdressValidatedMesage);

					// util.click(CloseButton);
					driver.close();
					//Thread.sleep(2000);
					driver.switchTo().window(parentWindowId);
					log.info("***********  No. of Validated address successfully: " + j + "*********");
					//Thread.sleep(3000);
				}
			}

			catch (Exception e) {
				
				log.info(" Error........  " + e );
			//	validateRegistrantAddress();
				

			}
			log.info("******** " + name + " finished********");
		} else {

			log.info(" Error........ No address present to validate! exiting ");

		}
	}

}
