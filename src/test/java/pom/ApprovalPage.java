package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovalPage {

	private WebDriver driver;

	@FindBy(xpath = "//h1[@class='page-header hidden-print']")
	public WebElement lblPersetujuanCuti;

	public ApprovalPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
}
