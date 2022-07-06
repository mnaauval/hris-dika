package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUname;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPasswd;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnLogin;
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void setCredentials(String uname, String passwd) {
		txtUname.sendKeys(uname);
		txtPasswd.sendKeys(passwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
}
