package definitions.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePage;
import pom.LoginPage;
import pom.Utilities;

public class HRISLoginDefine {

	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private Utilities util;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
		System.setProperty("url", "https://dev.ptdika.com/employee/panel/login/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		login = PageFactory.initElements(driver, LoginPage.class);
		home = PageFactory.initElements(driver, HomePage.class);
		util = PageFactory.initElements(driver, Utilities.class);
	}

	@Given("User open browser")
	public void openBrowser() {
		System.out.println("Open browser");
	}

	@When("User input url {string}")
	public void inputURL(String URL) {
		driver.get(URL);
	}

	@Then("User validate page {string}")
	public void validatePage(String URL) {
		driver.get(URL);
		home.sleep(2000);
		if (URL.equals("https://dev.ptdika.com/employee/panel/login/")) {
			String actual = login.lblDIKA.getText();
			System.out.println(actual);
			String expected = "DIKA | EMPLOYEE";
			Assert.assertEquals(actual, expected);
		} else if (URL.equals("https://dev.ptdika.com/employee/panel/signin/")) {
			String actual = login.lbl404.getText();
			System.out.println(actual);
			String expected = "404 Page Not Found";
			Assert.assertEquals(actual, expected);
		}
	}

	@Given("User at Login Page")
	public void at_Login() {
		login.sleep(2000);
		System.out.println(login.btnLogin.getText());
		String actual = login.btnLogin.getText();
		String expected = "Login";
		Assert.assertEquals(actual, expected);
	}

	@When("Input valid uname {string} and valid passwd {string}")
	public void setValidCredentials(String uname, String passwd) {
		login.setCredentials(uname, passwd);
	}

	@When("^Input not valid uname (.*) and not valid passwd (.*)$")
	public void setNotValidCredentials(String uname, String passwd) {
		login.setCredentials(uname, passwd);
	}

	@Then("User click login")
	public void clickLogin() {
		login.clickLogin();
	}

	@And("User logged in")
	public void loggedIn() {
		System.out.println(home.lblName.getText());
		String actual = home.lblName.getText();
		actual = actual.replace("×", "").trim();
		boolean check = false;
		if (actual.contains("EX - ADHITYA BAYU W")) {
			check = true;
			Assert.assertTrue(check);
		} else if (actual.contains("EX - AHMAD ZAKI BIN TAMIMI")) {
			check = true;
			Assert.assertTrue(check);
		}
		home.sleep(2000);
	}

	@And("Show error")
	public void showErrors() {
		login.sleep(2000);
		if (login.getError()) {
			System.out.println(login.lblInvalidCredentials.getText());
			String actual = login.lblInvalidCredentials.getText();
			if (actual.equals("Username atau password salah!")) {
				String expected = "Username atau password salah!";
				Assert.assertEquals(actual, expected);
			}
		} else if (login.isAttrUnamePresent() == true) {
			System.out.println("Uname required");
		} else if (login.isAttrPasswdPresent() == true) {
			System.out.println("Passwd required");
		}
	}

	@Then("User logout from Profile")
	public void clickLogoutProfile() {
		login.dropProfile.click();
		login.btnLogoutDrop.click();
	}

	@Then("User logout from Nav")
	public void clickLogoutNav() {
		login.scrollToElem(login.btnLogoutNav);
		login.btnLogoutNav.click();
	}

	@And("User logged out")
	public void loggedOut() {
		System.out.println(login.btnLogin.getText());
		String actual = login.btnLogin.getText();
		String expected = "Login";
		Assert.assertEquals(actual, expected);
	}

	@After
	public void tearDown(Scenario scenario) {
		login.sleep(2000);
		System.out.println(scenario.getStatus());
		driver.close();
	}
}
