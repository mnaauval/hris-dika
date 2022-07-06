package definitions.data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePage;
import pom.LoginPage;
import pom.PengajuanPage;

public class HRISBukcetDataDefine {

	private WebDriver driver;
//	private ChromeOptions o;
	private LoginPage login;
	private HomePage home;
	private PengajuanPage propose;

	@SuppressWarnings("deprecation")
	@Before
	public void init() {
//		o = new ChromeOptions();
//		o.addArguments("−−incognito");
		System.setProperty("url", "https://dev.ptdika.com/employee/panel/login/");
		System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		login = PageFactory.initElements(driver, LoginPage.class);
		home = PageFactory.initElements(driver, HomePage.class);
		propose = PageFactory.initElements(driver, PengajuanPage.class);
	}

	@Given("User has logged in as SPV")
	public void hasLoggedInAsSPV() {
		login.setCredentials("EXD8200015", "admin12345");
		login.clickLogin();
	}

	@Given("User has logged in as MNGR")
	public void hasLoggedInAsMNGR() {
		login.setCredentials("EXD8120011", "admin12345");
		login.clickLogin();
	}

	@And("User at Home Page")
	public void at_Home() {
		System.out.println(home.lblName.getText());
		String actual = home.lblName.getText();
		if (actual.equals("EX - ADHITYA BAYU W")) {
			String expected = "EX - ADHITYA BAYU W";
			Assert.assertEquals(actual, expected);
		} else if (actual.equals("EX - AHMAD ZAKI BIN TAMIMI")) {
			String expected = "EX - AHMAD ZAKI BIN TAMIMI";
			Assert.assertEquals(actual, expected);
		}
	}

	@When("User click Pengajuan Cuti in My Task")
	public void clickPengajuanCutiTask() {
		home.linkPengajuanTask.click();
	}

	@When("User click Data in Navbar")
	public void clickDataBucket() {
		home.linkData.click();
	}

	@And("User click Pengajuan Cuti in Navbar")
	public void clickPengajuanCutiNav() {
		home.linkPengajuanNav.click();
	}

	@Then("User at Page Pengajuan Cuti")
	public void at_Pengajuan() {
		System.out.println(propose.lblPengajuanCuti.getText());
		String actual = propose.lblPengajuanCuti.getText();
		String expected = "Pengajuan cuti";
		Assert.assertEquals(actual, expected);

	}

	@Then("Show total cuti")
	public void showTotalCuti() {
		System.out.println(propose.lblTotalCuti.getText());
		Assert.assertEquals(propose.lblTotalCuti.getText(), "12 Hari");
	}

	@Then("Show total cuti yang bisa diambil")
	public void showTotalCutiBisaDiambil() {
		System.out.println(propose.lblTotalCutiBisaDiambil.getText());
		Assert.assertEquals(propose.lblTotalCutiBisaDiambil.getText(), "12 Hari");
	}

	@Then("Show total cuti bersama")
	public void showTotalCutiBersama() {
		System.out.println(propose.lblTotalCutiBersama.getText());
		Assert.assertEquals(propose.lblTotalCutiBersama.getText(), "0 Hari");
	}

	@Then("Show total cuti approved")
	public void showTotalCutiApproved() {
		System.out.println(propose.lblTotalCutiApproved.getText());
		Assert.assertEquals(propose.lblTotalCutiApproved.getText(), "0 Hari");
	}

	@Then("Show total cuti request")
	public void showTotalCutiRequest() {
		System.out.println(propose.lblTotalCutiRequest.getText());
		Assert.assertEquals(propose.lblTotalCutiRequest.getText(), "0 Hari");
	}

	@Then("Show total sisa cuti")
	public void showTotalSisaCuti() {
		System.out.println(propose.lblTotalSisaCuti.getText());
		Assert.assertEquals(propose.lblTotalSisaCuti.getText(), "12 Hari");
	}

	@Then("User click button form cuti")
	public void clickBtnForm() {
		propose.btnForm.click();
	}

	@And("User select type {string}, pick range date {string} {string} {string} {string} and input notes")
	public void selectType(String type, String dateFrom, String yearFrom, String dateTo, String yearTo) {
		String notes = "Ini notes test";
		System.out.println(type);
		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
		propose.selectType(type);
		propose.sleep(1000);
		propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo);
		propose.txtNotes.sendKeys(notes);
	}

//	@And("User pick range date {string} {string} {string} {string} and input notes")
//	public void typeNotChoosen(String dateFrom, String yearFrom, String dateTo, String yearTo) {
//		String notes = "Ini notes test";
//		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
//		propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo);
//		propose.txtNotes.sendKeys(notes);
//		System.out.println("Type not choosen");
//	}

	@And("^User select type (.*), select special (.*), pick range date (.*) (.*) (.*) (.*)$")
	public void selectType(String type, String special, String dateFrom, String yearFrom, String dateTo,
			String yearTo) {
		System.out.println(type);
		System.out.println(special);
		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
		propose.selectType(type);
		propose.sleep(1000);
		propose.selectSpecial(special);
		propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo);
	}

//	@And("^User select type (.*), pick range date (.*) (.*) (.*) (.*) and input note$")
//	public void specialNotChoosen(String type, String dateFrom, String yearFrom, String dateTo,
//			String yearTo) {
//		String notes = "Ini notes test";
//		System.out.println(type);
//		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
//		System.out.println("Special not choosen");
//		propose.selectType(type);
//		propose.sleep(1000);
//		propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo);
//		propose.txtNotes.sendKeys(notes);
//	}

	@And("^User input notes (.*)$")
	public void inputNotes(String notes) {
		System.out.println(notes);
		propose.txtNotes.sendKeys(notes);
	}

	@Then("User click submit")
	public void clickSubmit() {
		propose.btnSubmit.click();
	}

	@And("Data cuti created")
	public void showDataCuti() {
		System.out.println(propose.alertSuccess.getText());
		String actual = propose.alertSuccess.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		String expected = "Pengajuan cuti berhasil diinput";
		Assert.assertEquals(actual, expected);
		propose.sleep(2000);
	}

	@And("Data cuti not created")
	public void showError() {
		System.out.println(propose.alertFailed.getText());
		String actual = propose.alertFailed.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		if (actual.equals("Permintaan cuti anda yang sebelumnya masih di SPV anda")) {
			String expected = "Permintaan cuti anda yang sebelumnya masih di SPV anda";
			Assert.assertEquals(actual, expected);
		} else if (actual.equals("Permintaan cuti melebihi kapasitas sisa cuti")) {
			String expected = "Permintaan cuti melebihi kapasitas sisa cuti";
			Assert.assertEquals(actual, expected);
		}
	}

	@And("Database occured")
	public void databaseOccured() {
		System.out.println(propose.lblError1604.getText());
		String actual = propose.lblError1604.getText();
		System.out.println(actual);
		String expected = "Error Number: 1064";
		Assert.assertEquals(actual, expected);
	}

	@And("^Count less than (.*)$")
	public void coutLessThan(String count) {
		System.out.println(propose.getCount());
		int actual = Integer.parseInt(propose.getCount());
		System.out.println(actual);
		int expected = Integer.parseInt(count);
		boolean check = false;
		if (actual < expected) {
			check = true;
			System.out.println("True");
		}
		Assert.assertTrue(check);
	}

	@And("^Count equals (.*)$")
	public void countEquals(String count) {
		System.out.println(propose.getCount());
		int actual = Integer.parseInt(propose.getCount());
		System.out.println(actual);
		int expected = Integer.parseInt(count);
		boolean check = false;
		if (actual == expected) {
			check = true;
			System.out.println("True");
		}
		Assert.assertTrue(check);
	}

	@Then("Show error type field")
	public void typeFieldError() {
		System.out.println(propose.alertFailed.getText());
		String actual = propose.alertFailed.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		String expected = "Danger! The type field is required.";
		Assert.assertEquals(actual, expected);
	}

	@Then("Show error special field")
	public void specialFieldError() {
		System.out.println(propose.alertFailed.getText());
		String actual = propose.alertFailed.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual);
		String expected = "Danger! The type special field is required.";
		Assert.assertEquals(actual, expected);
	}

	@When("^User search by value (.*)$")
	public void searchByValue(String value) {
		propose.getCount(); // just scroll to element
		propose.txtSearch.clear();
		propose.txtSearch.sendKeys(value);
		propose.txtSearch.sendKeys(Keys.ENTER);
		propose.sleep(2000);
	}

	@When("^User validate search (.*)$")
	public void validateSearch(String value) {
		String date = propose.getDate();
		String count = propose.getCount();
		String type = propose.getType();
		String status = propose.getStatus();
		boolean check = false;
		System.out.println(date);
		System.out.println(count);
		System.out.println(type);
		System.out.println(status);
		System.out.println(value);
		if (value.contains(date)) {
			check = true;
		} else if (value.contains(count)) {
			check = true;
		} else if (value.contains(type)) {
			check = true;
		} else if (value.contains(status)) {
			check = true;
		} else if (value.isEmpty()) {
			check = true;
		}
		Assert.assertTrue(check);
	}

	@When("^User choose show (.*) entries$")
	public void showEntries(String entries) {
		System.out.println(entries);
		propose.selectEntries(entries);
	}

	@Then("^User validate show (.*)$")
	public void validateEntries(String entries) {
		boolean check = false;
		if (entries.equals("10")) {
			if (!driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[10]/td[1]")).isEmpty()) { // if element
																											// exist
				check = true;
				System.out.println("entries 10 true");
			}
		} else if (entries.equals("25")) {
			if (!driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[11]/td[1]")).isEmpty()) { // if element
																											// exist
				check = true;
				System.out.println("entries 25 true");
			}
		}
		Assert.assertTrue(check);
	}

	@And("User delete data")
	public void deleteAnnual() {
		driver.get("https://dev.ptdika.com/employee/data/cuti");
//		propose.zoomOut(67);
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
			propose.actionDelete.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			propose.actionDeleteTd.click();
			propose.sleep(1000);
			propose.btnValidateAction.click();
		}
		propose.sleep(1000);
		propose.btnValidateAction.click();
	}

	@And("Check action")
	public void checkAction() {
		boolean check = true;
		driver.get("https://dev.ptdika.com/employee/data/cuti");
//		propose.zoomOut(67);
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
			propose.actionDelete.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			try {
				propose.actionDeleteTd.click();
			} catch (Exception e2) {
				// TODO: handle exception
				System.err.println(e2);
				check = false;
			} finally {
				Assert.assertTrue(check);
			}
		}
		Assert.assertTrue(check);
	}

	@After
	public void close() {
		propose.sleep(3000);
		driver.close();
	}
}
