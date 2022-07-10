package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovalPage extends Utilities {

	private WebDriver driver;

	@FindBy(xpath = "//h1[@class='page-header hidden-print']")
	public WebElement lblPersetujuanCuti;
	@FindBy(xpath = "//span[@class='dtr-data']//i[@class='fa fa-edit']")
	public WebElement actionEdit;
	@FindBy(xpath = "//i[@class='fa fa-edit']")
	public WebElement actionEditTd;
	@FindBy(xpath = "//button[@id='btnApprove']")
	public WebElement btnApprove;
	@FindBy(xpath = "//button[@id='btnReject']")
	public WebElement btnReject;
	@FindBy(xpath = "//button[@id='btnReturn']")
	public WebElement btnReturn;
	@FindBy(xpath = "//button[normalize-space()='Yes, approve it!']")
	public WebElement btnApproveIt;
	@FindBy(xpath = "//button[normalize-space()='Yes, reject it!']")
	public WebElement btnRejectIt;
	@FindBy(xpath = "//button[normalize-space()='Yes, return it!']")
	public WebElement btnReturnIt;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	public WebElement btnOk;
	@FindBy(xpath = "//button[normalize-space()='No']")
	public WebElement btnNo;
	@FindBy(xpath = "//div[@id='modal-leave']")
	public WebElement leaveModal;

	public ApprovalPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	public String getLeave() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[2]")).getText();
	}

	public String getCount() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[3]")).getText();
	}

	public String getType() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[4]")).getText();
	}

	public String getStatus() {
		return driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td[5]")).getText();
	}
}
