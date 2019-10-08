package com.cctv.testpages;

import org.testng.annotations.Test;

import com.cctv.pages.RegEdit;
import com.cctv.utils.TestBase;

public class RegEditTest extends TestBase {

	RegEdit edit;
	
	public RegEditTest()
	{
		
		super();
			
	}
	
@Test(priority=1)

public void EditRegistration() throws Exception {
	
	edit = new RegEdit();
	Thread.sleep(5000);
	
	edit.editRegistration();	
	edit.isvalidateAddressButtonEnabled();
	
	System.out.println(" Edit org button is clicked");
	
	
}

/*
public void EditRegistration1() throws Exception {
	
	
	Thread.sleep(5000); n
	edit.editRegistration();
	
	edit.isvalidateAddressButtonEnabled();
	
	System.out.println(" Edit org button is clicked");
	
	
}*/
	
}
