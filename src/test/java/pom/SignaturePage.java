package pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignaturePage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions builder;
	private Action drawAction;
	private Alert alert;

	@FindBy(xpath = "//canvas[@id='signature']")
	private WebElement canvas;
	@FindBy(xpath = "//button[@id='btnSave']")
	public WebElement btnSave;
	@FindBy(xpath = "//span[@class='fas fa-eraser']")
	public WebElement btnDelete;

	public SignaturePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		builder = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void drawSignature() {
		drawAction = builder.moveToElement(canvas).clickAndHold().moveByOffset(-50, 60).moveByOffset(-60, -70)
				.moveByOffset(150, 60).moveByOffset(-60, -70).doubleClick().build();
		drawAction.perform();
	}

	public String getAlertMsg() {
		try {
			alert = driver.switchTo().alert();
			System.out.println(alert.getText() + " Alert is Displayed");
			alert.accept();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			System.err.println(e);
			return "Alert is Not Displayed";
		}
	}
}
