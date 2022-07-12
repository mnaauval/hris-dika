package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApprovalPage extends Utilities {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//h1[@class='page-header hidden-print']")
	public WebElement lblPersetujuanCuti;
	@FindBy(xpath = "//p[@id='duration']")
	public WebElement duration;
	@FindBy(xpath = "//textarea[@id='approve_notes']")
	public WebElement txtNotes;
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
	@FindBy(xpath = "//button[normalize-space()='Close']")
	public WebElement btnClose;
	@FindBy(xpath = "//button[normalize-space()='×']")
	public WebElement btnCross;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	public WebElement btnOk;
	@FindBy(xpath = "//button[normalize-space()='No']")
	public WebElement btnNo;
	@FindBy(xpath = "//h2[@id='swal2-title']")
	public WebElement actionAccept;
	@FindBy(xpath = "//div[@id='modal-leave']")
	public WebElement modalLeave;
	@FindBy(xpath = "//div[@class='modal-header']")
	public WebElement modalHeader;

	public ApprovalPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}

	public String getLeaveName() {
		return driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr/td[2]/b")).getText();
	}

	public String getLeaveDate() {
		return driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr/td[2]/p")).getText();
	}

	public String getCount() {
		return driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr/td[3]/p")).getText();
	}

	public String getType() {
		return driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr/td[4]/p")).getText();
	}

	public String getStatus() {
		return driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr/td[5]/p[2]")).getText();
	}

	public String getDisabledAtt(WebElement elem) {
		String disabled = "";
		try {
			disabled = elem.getAttribute("disabled");
		} catch (Exception e) {
			// TODO: handle exception
			return "nothing";
		}
		return disabled;
	}
}
