package BasePackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Logger log = LogManager.getLogger();
	
	@Parameters("p1")
	@BeforeTest
	public void setUP(String browsername) {
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
		    driver.set(ThreadGuard.protect(new ChromeDriver()));
		}
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(ThreadGuard.protect(new FirefoxDriver()));
		}
		
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}

}
