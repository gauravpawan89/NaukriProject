package TestCasePackage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import UtilityPackage.ConfigUtility;
import UtilityPackage.ConstantPaths;
import UtilityPackage.WaitUtility;

public class NaukriRegistration extends BaseClass {
	
	ConfigUtility con;
	String fPath = ConstantPaths.fPath;
	
	@Test(priority = 1, description = "Wait for Logo")
	public void carrerRegistration() {
		con = new ConfigUtility(fPath);
		getDriver().get(con.getUrl());
		log.info("Naukri Registration page is launched");
		getDriver().manage().window().maximize();
		WebElement naukriLogo = WaitUtility.waitForImage(getDriver());
		log.info("Wait for Image to be loaded");
		System.out.println("Element is..." + naukriLogo);
		boolean status =naukriLogo.isDisplayed();
		log.info("Image is verified and Displayed");
		Assert.assertTrue(status);
	}
	
	
	
}
