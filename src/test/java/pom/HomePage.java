package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utilities {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='alert alert-success fade show m-b-0']")
	public WebElement lblName;
	@FindBy(xpath = "//span[normalize-space()='Data']")
	public WebElement linkData;
	@FindBy(xpath = "//h4[normalize-space()='Pengajuan Cuti']")
	public WebElement linkPengajuanTask;
	@FindBy(xpath = "//a[normalize-space()='Pengajuan Cuti']")
	public WebElement linkPengajuanNav;
	@FindBy(xpath = "//h4[normalize-space()='Approval Cuti']")
	public WebElement linkApprovalTask;
	@FindBy(xpath = "//a[normalize-space()='Persetujuan Cuti']")
	public WebElement linkApprovalNav;
	@FindBy(xpath = "//a[normalize-space()='Tanda Tangan Digital']")
	public WebElement linkSignature;
	@FindBy(xpath = "//h4[normalize-space()='Promotion']")
	public WebElement linkPromotion;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
	}
}
