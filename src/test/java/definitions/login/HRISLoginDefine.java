package definitions.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;

public class HRISLoginDefine {
	
	private WebDriver driver;
	private LoginPage login;
	
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
	}
	
	@Given("User at Login Page")
	public void at_Login() {
		
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
		
	}
	
	@And("Show error")
	public void showErrors() {
		
	}
	
	@After
	public void close() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
