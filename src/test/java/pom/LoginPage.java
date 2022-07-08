package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utilities {

	private WebDriver driver;

	@FindBy(xpath = "//h1[normalize-space()='404 Page Not Found']")
	public WebElement lbl404;
	@FindBy(xpath = "//b[normalize-space()='DIKA | EMPLOYEE']")
	public WebElement lblDIKA;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtUname;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtPasswd;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement btnLogin;
	@FindBy(xpath = "//small[normalize-space()='Username atau password salah!']")
	public WebElement lblInvalidCredentials;
	@FindBy(xpath = "//a[@class='dropdown-toggle']//b[@class='caret']")
	public WebElement dropProfile;
	@FindBy(xpath = "//a[@class='dropdown-item']")
	public WebElement btnLogoutDrop;
	@FindBy(xpath = "//span[normalize-space()='Logout']")
	public WebElement btnLogoutNav;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	public void setCredentials(String uname, String passwd) {
		txtUname.sendKeys(uname);
		txtPasswd.sendKeys(passwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public boolean getError() {
		if (!driver.findElements(By.xpath("//small[normalize-space()='Username atau password salah!']")).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAttrUnamePresent() {
		boolean check = false;
		try {
			String value = txtUname.getAttribute("required");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}

	public boolean isAttrPasswdPresent() {
		boolean check = false;
		try {
			String value = txtPasswd.getAttribute("required");
			if (value != null) {
				check = true;
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			return check = false;
		}
	}

}
