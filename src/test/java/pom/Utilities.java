package pom;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class Utilities {

	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor je;
	private Alert alert;

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

	public String getAlertMsg() {
		String msg = "Alert is Not Displayed";
		try {
//			alert = wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			msg = alert.getText();
			System.out.println(msg + " Alert is Displayed");
			sleep(1000);
			alert.accept();
		} catch (NoAlertPresentException e) {
			msg = "Alert is Not Displayed";
			System.err.println(e);
		}
		return msg;
	}

	public boolean isAlertExist() {
		boolean check = false;
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			check = true;
			alert.accept();
		} catch (TimeoutException eTO) {
			check = false;
		}
		return check;
	}

	public String handleAlert() {
		String msg = "No allert";
		if (isAlertPresent()) {
			alert = driver.switchTo().alert();
			msg = alert.getText();
			System.out.println(alert.getText());
			sleep(1000);
			alert.accept();
		}
		return msg;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}
	
	public String screenshoot(WebDriver driver, String title) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\Project\\Java\\TestNG\\HRIS\\src\\test\\resources\\SS\\" + title + ".PNG";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}
	
	public String screenshootElm(WebElement elm) {
		File srcFile = elm.getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\Project\\Java\\TestNG\\HRIS\\src\\test\\resources\\SS\\" + waktu + ".PNG";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}
}
