package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor je;

	public Utilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		je = (JavascriptExecutor) driver;
	}

	public void sleep(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToElem(WebElement elm) {
		je.executeScript("arguments[0].scrollIntoView(true);", elm);
	}

	public void zoomOut(int percent) {
		String zoomJS = "document.body.style.zoom='" + percent + "%'";
		System.out.println(zoomJS);
		je.executeScript(zoomJS);
	}
}
