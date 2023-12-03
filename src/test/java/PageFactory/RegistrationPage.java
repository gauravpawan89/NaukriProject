package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="#name")
	WebElement nameTextField;
	
	@FindBy(id="email")
	WebElement emailTextField;
	
	@FindBy(id="password")
	WebElement passwordTextField;
	
	@FindBy(id="mobile")
	WebElement mobileTextField;
	
	public WebElement getName(String Nname) {
		 nameTextField.sendKeys(Nname);
		 return nameTextField;
	}
	
	public WebElement getEmail(String Nemail) {
		emailTextField.sendKeys(Nemail);
		 return emailTextField;
	}
	
	public WebElement getPassword(String Npass) {
		passwordTextField.sendKeys(Npass);
		 return passwordTextField;
	}
	
	public WebElement getMobile(String Nmobile) {
		mobileTextField.sendKeys(Nmobile);
		 return mobileTextField;
	}
	
}
