package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	@BeforeTest
	public void setUP(String browsername) {
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}

}
