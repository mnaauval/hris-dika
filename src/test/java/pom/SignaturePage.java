package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignaturePage extends Utilities {

	private WebDriver driver;
	private Actions builder;
	private Action drawAction;

	@FindBy(xpath = "//h1[@class='page-header']")
	public WebElement lblSignature;
	@FindBy(xpath = "//canvas[@id='signature']")
	private WebElement canvas;
	@FindBy(xpath = "//button[@id='btnSave']")
	public WebElement btnSave;
	@FindBy(xpath = "//span[@class='fas fa-eraser']")
	public WebElement btnDelete;

	public SignaturePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		builder = new Actions(driver);
	}

	public void drawSignature() {
		drawAction = builder.moveToElement(canvas).clickAndHold().moveByOffset(-50, 60).moveByOffset(-60, -70)
				.moveByOffset(150, 60).moveByOffset(-60, -70).doubleClick().build();
		drawAction.perform();
	}

	public void checkEmptyCanvas() {
		Dimension canvas_dimension = canvas.getSize();
		int canvas_center_x = canvas_dimension.getWidth() / 2;
		int canvas_center_y = canvas_dimension.getHeight() / 2;
		System.out.println(canvas_dimension);
		System.out.println(canvas_center_x);
		System.out.println(canvas_center_y);
//        int button_x = (canvas_center_x / 3) * 2;
//        int button_y = (canvas_center_y / 3) * 2;
//		builder.moveToElement(canvas, button_x, button_y).click().perform();
	}
}
