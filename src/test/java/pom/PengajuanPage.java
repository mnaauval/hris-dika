package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PengajuanPage extends Utilities {

	private WebDriver driver;
	private WebDriverWait wait;
	private Select select;

	@FindBy(xpath = "//h1[@class='page-header hidden-print']")
	public WebElement lblPengajuanCuti;
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	public WebElement lblTotalCuti;
	@FindBy(xpath = "//tbody/tr[2]/td[2]")
	public WebElement lblTotalCutiBisaDiambil;
	@FindBy(xpath = "//tbody/tr[3]/td[2]")
	public WebElement lblTotalCutiBersama;
	@FindBy(xpath = "//tbody/tr[4]/td[2]")
	public WebElement lblTotalCutiApproved;
	@FindBy(xpath = "//tbody/tr[5]/td[2]")
	public WebElement lblTotalCutiRequest;
	@FindBy(xpath = "//tbody/tr[6]/td[2]")
	public WebElement lblTotalSisaCuti;
	@FindBy(xpath = "//button[@id='toggleForm']")
	public WebElement btnForm;
	@FindBy(xpath = "//select[@id='type']")
	private WebElement selType;
	@FindBy(xpath = "//select[@id='type_special']")
	private WebElement selSpecial;
	@FindBy(xpath = "//small[normalize-space()='The type field is required.']")
	public WebElement lblErrorType;
	@FindBy(xpath = "//input[@id='leave_periode']")
	private WebElement date;
	@FindBy(xpath = "//small[normalize-space()='The leave periode field is required.']")
	public WebElement lblErrorDate;
	@FindBy(xpath = "//textarea[@id='notes']")
	public WebElement txtNotes;
	@FindBy(xpath = "//button[@id='btnSubmit']")
	public WebElement btnSubmit;
	@FindBy(xpath = "//div[@class='alert alert-success fade show']")
	public WebElement alertSuccess;
	@FindBy(xpath = "//div[@class='alert alert-danger fade show']")
	public WebElement alertFailed;
	@FindBy(xpath = "//select[@name='dataTable_length']")
	private WebElement selEntries;
	@FindBy(xpath = "//input[@placeholder='Enter value here']")
	public WebElement txtSearch;
	@FindBy(xpath = "//i[@class='fa fa-times']")
//	@FindBy(xpath = "//table[@id='dataTable']/tbody/tr/td[6]/button/i")
//	@FindBy(xpath = "//i[@class='fa fa-times']")
	public WebElement actionDeleteTd;
	@FindBy(xpath = "//span[@class='dtr-data']//i[@class='fa fa-times']")
	public WebElement actionDelete;
	@FindBy(xpath = "//button[normalize-space()='Yes, cancle it!']")
//	@FindBy(xpath = "(//button[@type='button'])[9]")
	public WebElement btnValidateAction;
	@FindBy(xpath = "//p[normalize-space()='Error Number: 1064']")
	public WebElement lblError1604;

	public PengajuanPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void selectType(String type) {
		scrollToElem(selType);
		select = new Select(selType);
		select.selectByVisibleText(type);
	}

	public void selectSpecial(String special) {
		scrollToElem(selSpecial);
		select = new Select(selSpecial);
		select.selectByVisibleText(special);
	}

	public void selectEntries(String entries) {
		scrollToElem(selSpecial);
		select = new Select(selEntries);
		select.selectByVisibleText(entries);
	}
	
	public String getErrorField(WebElement element) {
		scrollToElem(element);
		sleep(1000);
		return element.getText();
	}

	public void pickRangeDate(String dateFrom, String yearFrom, String dateTo, String yearTo) {
		this.date.sendKeys(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
	}

	public String getDate() {
//		scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[2]/p")));
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[2]/p")).getText();
	}

	public String getCount() {
//		scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[3]/p")));
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[3]/p")).getText();
	}

	public String getType() {
//		scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[4]/p")));
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[4]/p")).getText();
	}

	public String getStatus() {
//		scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[5]/p")));
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[5]/p")).getText();
	}
}
