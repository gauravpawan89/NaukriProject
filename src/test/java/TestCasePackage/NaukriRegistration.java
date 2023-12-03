package TestCasePackage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageFactory.RegistrationPage;
import UtilityPackage.ConfigUtility;
import UtilityPackage.ConstantPaths;
import UtilityPackage.ReadUtility;
import UtilityPackage.WaitUtility;

public class NaukriRegistration extends BaseClass {

	ConfigUtility con;
	String fPath = ConstantPaths.fPath;
	String exPath = ConstantPaths.excelPath;
	RegistrationPage rp;
	ReadUtility ru;

	@Test(priority = 1, description = "Wait for Logo")
	public void logoVerified() {
		con = new ConfigUtility(fPath);
		getDriver().get(con.getUrl());
		log.info("Naukri Registration page is launched");
		getDriver().manage().window().maximize();
		WebElement naukriLogo = WaitUtility.waitForImage(getDriver());
		log.info("Wait for Image to be loaded");
		System.out.println("Element is..." + naukriLogo);
		boolean status = naukriLogo.isDisplayed();
		log.info("Image is verified and Displayed");
		Assert.assertTrue(status);
	}

	@Test(dataProvider = "rData", priority = 2)
	public void carrerRegis(String n, String e, String p, String m) {
		rp = new RegistrationPage(getDriver());
		rp.getName(n);
		rp.getEmail(e);
		rp.getPassword(p);
		rp.getMobile(m);

	}

	@DataProvider(name = "rData")
	public Object[][] regisDataProvider() {
		ru = new ReadUtility(exPath, "sheet1");

		int r = ru.countRows();
		int c = ru.countColumns(r);

		String[][] arr = new String[r][c];

		for (int i = 1; i <= r; i++) {

			for (int j = 0; j < c; j++) {

				arr[i - 1][j] = ru.getData(i, j);

			}

		}
		return arr;

	}

}
