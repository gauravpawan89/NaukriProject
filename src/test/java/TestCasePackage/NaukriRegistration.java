package TestCasePackage;

import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class NaukriRegistration extends BaseClass {
	
	String url;
	
	@Test
	public void carrerRegistration() {
		
		getDriver().get(url);
		getDriver().manage().window().maximize();
		
	}

}
