package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//b[normalize-space()='EX - ADHITYA BAYU W']")
	public WebElement lblName;
	@FindBy(xpath = "//span[normalize-space()='Data']")
	public WebElement linkData;
	@FindBy(xpath = "//a[normalize-space()='Pengajuan Cuti']")
	public WebElement linkPengajuanNav;
	@FindBy(xpath = "//h4[normalize-space()='Pengajuan Cuti']")
	public WebElement linkPengajuanTask;
	@FindBy(xpath = "//h4[normalize-space()='Promotion']")
	public WebElement linkPromotion;
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
}
