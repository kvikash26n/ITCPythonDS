package com.cctv.testpages;

import org.testng.annotations.Test;

import com.cctv.pages.AlertsandActions;
import com.cctv.utils.TestBase;

public class AlertAndActionsTest extends TestBase {

	@Test(priority=2,enabled=false)

	public void searchAlerts() throws Exception {

		AlertsandActions action1 = new AlertsandActions();

		action1.supressAndAckAlert();
		// driver.quit();
	}

	@Test(priority = 1, invocationCount = 1)
	public void validateAddress() throws Exception {

		AlertsandActions action1 = new AlertsandActions();

		action1.validateRegistrantAddress();
		/*
		 * AtomicInteger sequence = new AtomicInteger(0); int count =
		 * sequence.getAndAdd(1);
		 * System.out.println(" ************test run count is " + count +
		 * Thread.currentThread().getId());
		 */

	}

}
