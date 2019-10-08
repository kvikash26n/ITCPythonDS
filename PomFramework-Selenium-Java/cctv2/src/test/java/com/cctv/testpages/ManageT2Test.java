package com.cctv.testpages;

import org.testng.annotations.Test;

import com.cctv.pages.ManageT2;
import com.cctv.utils.TestBase;

public class ManageT2Test extends TestBase {
	
	
	@Test
	public void searchT2Users() throws Exception {
		
		ManageT2 manage= new ManageT2();
		
		manage.searchT2Users(1,"organisation","account","test");
		
	

		
	}
	
	
	
	
	
	
	
	
	

}
