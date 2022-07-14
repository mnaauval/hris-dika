package definitions.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.ApprovalPage;
import pom.HomePage;
import pom.LoginPage;
import pom.PengajuanPage;
import pom.SignaturePage;
import pom.Utilities;

public class HRISBukcetDataDefine {

	private WebDriver driver;
//	private ChromeOptions o;
	private LoginPage login;
	private HomePage home;
	private PengajuanPage propose;
	private ApprovalPage approve;
	private SignaturePage signature;

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
		approve = PageFactory.initElements(driver, ApprovalPage.class);
		signature = PageFactory.initElements(driver, SignaturePage.class);
	}

//	<<====================================== LOGIN ======================================>>

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

//	<<====================================== HOME ======================================>>

	@And("User at Home Page")
	public void at_Home() {
		String actual = home.lblName.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual + " at home");
		boolean check = false;
		if (actual.contains("EX - ADHITYA BAYU W")) {
			check = true;
			Assert.assertTrue(check);
		} else if (actual.contains("EX - AHMAD ZAKI BIN TAMIMI")) {
			check = true;
			Assert.assertTrue(check);
		}
	}

	@When("User click Pengajuan Cuti in My Task")
	public void clickPengajuanCutiTask() {
		home.linkPengajuanTask.click();
	}

	@When("User click Approval Cuti in My Task")
	public void clickApprovalTask() {
		home.linkApprovalTask.click();
	}

	@When("User click Data in Navbar")
	public void clickDataBucket() {
		home.linkData.click();
	}

	@And("User click Pengajuan Cuti in Navbar")
	public void clickPengajuanCutiNav() {
		home.linkPengajuanNav.click();
	}

	@And("User click Approval Cuti in Navbar")
	public void clickApprovalCuti() {
		home.linkApprovalNav.click();
	}

	@And("User click Tanda Tangan Digital in Navbar")
	public void clickSignature() {
		home.linkSignature.click();
	}

	@And("User logout from Nav")
	public void clickLogoutNav() {
		login.scrollToElem(login.btnLogoutNav);
		login.btnLogoutNav.click();
	}

//	<<====================================== PENGAJUAN ======================================>>

	@Then("User at Pengajuan Cuti Page")
	public void at_Pengajuan() {
		String actual = propose.lblPengajuanCuti.getText();
		System.out.println(actual + " at pengajuan cuti");
		String expected = "Pengajuan cuti";
		Assert.assertEquals(actual, expected);
	}

//	<====================================== TABLE RESULT ======================================>

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

	@Then("Show total cuti approved changed")
	public void showTotalCutiApprovedChanged() {
		String count = propose.lblTotalCutiApproved.getText();
		count = count.replace(" Hari", "").trim();
		int actual = Integer.parseInt(count);
		int expected = Integer.parseInt(propose.getCount());
		System.out.println(actual + " <-> " + expected);
		Assert.assertEquals(actual, expected);
	}

	@Then("Show total cuti request changed")
	public void showTotalCutiRequestChanged() {
		String count = propose.lblTotalCutiRequest.getText();
		count = count.replace(" Hari", "").trim();
		int actual = Integer.parseInt(count);
		int expected = Integer.parseInt(propose.getCount());
		System.out.println(actual + " <-> " + expected);
		Assert.assertEquals(actual, expected);
	}

	@Then("Show Show total sisa cuti changed")
	public void showTotalSisaCutiChanged() {
		String count = propose.lblTotalSisaCuti.getText();
		count = count.replace(" Hari", "").trim();
		String approve = propose.lblTotalCutiApproved.getText();
		approve = approve.replace(" Hari", "").trim();
		String request = propose.lblTotalCutiRequest.getText();
		request = request.replace(" Hari", "").trim();

		int actual = Integer.parseInt(count);
		int approveInt = Integer.parseInt(approve);
		int requestInt = Integer.parseInt(request);
		int expected = 12 - (approveInt + requestInt);
		System.out.println(actual + " <-> " + expected);
		Assert.assertEquals(actual, expected);
	}

//	<====================================== FORM CUTI ======================================>

	@Then("User click button form cuti")
	public void clickBtnForm() {
		propose.btnForm.click();
	}

//	====================================== INPUT FIELD CUTI ======================================

	@And("User select type {string}, pick range date {string} {string} {string} {string} and input {string}")
	public void selectTypeNotes(String type, String dateFrom, String yearFrom, String dateTo, String yearTo,
			String notes) {
//		System.out.println(type);
//		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
		System.out.println(propose.selectType(type) + " selected");
		propose.sleep(1000);
		System.out.println(propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo) + " input");
		propose.txtNotes.sendKeys(notes);
	}

	@And("^User select type (.*), select special (.*), pick range date (.*) (.*) (.*) (.*)$")
	public void selectType(String type, String special, String dateFrom, String yearFrom, String dateTo,
			String yearTo) {
//		System.out.println(type);
//		System.out.println(dateFrom + ", " + yearFrom + " - " + dateTo + ", " + yearTo);
		System.out.println(propose.selectType(type) + " selected");
		System.out.println(special + " selected");
		propose.sleep(1000);
		propose.selectSpecial(special);
		System.out.println(propose.pickRangeDate(dateFrom, yearFrom, dateTo, yearTo) + " input");
	}

	@And("User select type {string}")
	public void selectType(String type) {
		System.out.println(type);
		System.out.println(propose.selectType(type) + " selected");
	}

	@And("^User input notes (.*)$")
	public void inputNotes(String notes) {
		System.out.println("Input notes : " + notes);
		propose.txtNotes.sendKeys(notes);
	}

	@Then("User click submit")
	public void clickSubmit() {
		propose.btnSubmit.click();
	}

	@Then("Show error type field")
	public void typeFieldError() {
		String actual = propose.getErrorField(propose.lblErrorType);
		System.out.println(actual + " <- error type field");
		String expected = "The type field is required.";
		Assert.assertEquals(actual, expected);
	}

	@And("Show error special field")
	public void specialFieldError() {
		String actual = propose.getErrorField(propose.lblErrorSpecial);
		System.out.println(actual + " <- error special field");
		String expected = "The type special field is required.";
		Assert.assertEquals(actual, expected);
	}

	@Then("Show error date field")
	public void dateFieldError() {
		String actual = propose
				.getErrorField(driver.findElement(By.xpath("//div[@id='content']/div[2]/div/div/div[2]/div")));
		actual = actual.replace("×", "").trim();
		System.out.println(actual + " <- error date field");
		String expected = "Danger! The type field is required.";
		Assert.assertEquals(actual, expected);
	}

	@Then("Show error note field")
	public void noteFieldError() {
		// no alert error
		Assert.assertTrue(false);
	}

	@And("Database occured")
	public void databaseOccured() {
		String actual = propose.lblError1604.getText();
		System.out.println(actual + " <- database error");
		String expected = "Error Number: 1064";
		Assert.assertEquals(actual, expected);
	}

	@Then("User validate select type {string}")
	public void validateSelectType(String type) {
		propose.sleep(2000);
		String actual = propose.getSelectAtt();
		System.out.println(actual + " <- validate type");
		System.out.println(type);
		if (type.equalsIgnoreCase("Annual")) {
			String expected = "Annual";
			Assert.assertEquals(actual, expected);
		} else if (type.equalsIgnoreCase("Special")) {
			String expected = "Special";
			Assert.assertEquals(actual, expected);
		} else if (type.equalsIgnoreCase("empty")) {
			String expected = "-- Select leave type --";
			Assert.assertEquals(actual, expected);
		}
	}

	@Then("User validate date {string}")
	public void validateDate(String content) {
		propose.sleep(2000);
		String date = propose.getDateAtt();
		String dateStr = new String(date);
		String expected = "";
		String temp = "";
		String actual = "";
		if (content.equalsIgnoreCase("not empty")) {
			expected = propose.getDate();
			System.out.println(dateStr + "<->" + expected);
			String[] arrStr = dateStr.split("-");
			int i = 0;
			for (String string : arrStr) {
				string = string.trim();
				System.out.println(string);
				String[] arrStr2 = string.split(",");
				if (i == 0) {
					temp = arrStr2[i];
				}
				i++;
			}
			System.out.println(temp);

			String[] arrStr3 = temp.trim().split(" ");
			System.out.println(arrStr3[0]);
			System.out.println(arrStr3[1]);
			actual = arrStr3[1] + " " + arrStr3[0];
			System.out.println(actual);
			SimpleDateFormat sdf = new SimpleDateFormat("d MMMM", Locale.US);
			Date myDate = null;
			try {
				myDate = sdf.parse(actual);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sdf.applyPattern("d MMM");
			actual = sdf.format(myDate);
			System.out.println(actual);
		} else if (content.equalsIgnoreCase("empty")) {
			expected = "";
			actual = dateStr;
			System.out.println(dateStr + "<->" + expected);
		}

		Assert.assertTrue(expected.matches(".*" + actual + ".*"));
	}

	@Then("User validate notes")
	public void validateNotes() {
		propose.sleep(2000);
		String actual = propose.getNotesAtt();
		System.out.println(actual + " <- validate notes");
		String expected = "Ini test notes";
		Assert.assertEquals(actual, expected);
	}

	@Then("User clear field")
	public void clearField() {
		propose.date.clear();
		propose.txtNotes.clear();
	}

	@And("User click new")
	public void clickNew() {
		propose.sleep(1000);
		propose.btnNew.click();
		propose.sleep(1000);
	}

//	====================================== TABLE DATA CUTI ======================================

	@And("Data cuti created")
	public void showDataCuti() {
		home.sleep(2000);
		String actual = propose.alertSuccess.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual + " <- data cuti created");
		String expected = "Pengajuan cuti berhasil diinput";
		Assert.assertEquals(actual, expected);
		propose.sleep(2000);
	}

	@And("Data cuti not created")
	public void showError() {
		String actual = propose.alertFailed.getText();
		actual = actual.replace("×", "").trim();
		System.out.println(actual + " <- data cuti not created");
		if (actual.equals("Permintaan cuti anda yang sebelumnya masih di SPV anda")) {
			String expected = "Permintaan cuti anda yang sebelumnya masih di SPV anda";
			Assert.assertEquals(actual, expected);
		} else if (actual.equals("Permintaan cuti melebihi kapasitas sisa cuti")) {
			String expected = "Permintaan cuti melebihi kapasitas sisa cuti";
			Assert.assertEquals(actual, expected);
		}
	}

	@Then("User validate {string} data column contain {string}")
	public void validateColumn(String column, String data) {
		String strDate = new String(propose.getDate());
		String strCount = new String(propose.getCount());
		String strType = new String(propose.getType());
		String strStatus = new String(propose.getStatus());
		System.out.println("-- validate column contain data --");
		System.out.println(strDate);
		System.out.println(strCount);
		System.out.println(strType);
		System.out.println(strStatus);
		System.out.printf("Check column \"%s\" contains data \"%s\"\n", column, data);
		boolean check = true;
		if (column.equalsIgnoreCase("leave")) {
			System.out.println("leave true");
			Assert.assertTrue(strDate.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("count")) {
			System.out.println("count true");
			Assert.assertTrue(strCount.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("type")) {
			System.out.println("type true");
			Assert.assertTrue(strType.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("status")) {
			System.out.println("status true");
			Assert.assertTrue(strStatus.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("action")) {
			driver.get("https://dev.ptdika.com/employee/data/cuti");
			if (data.equalsIgnoreCase("cancel")) {
				System.out.println(data);
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
			} else if (data.equalsIgnoreCase("edit")) {
				System.out.println(data);
				try {
					driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
					propose.actionEdit.click();
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e);
					try {
						propose.actionEditTd.click();
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
		}
	}

	@Then("User validate data not exist")
	public void validateEmptyTable() {
//		driver.get("https://dev.ptdika.com/employee/data/cuti");
		String actual = new String(propose.getEmptyData());
		System.out.println(actual + " <- validate data not exist");
		if (actual.equalsIgnoreCase("1")) {
			String expected = "1";			
			Assert.assertTrue(actual.matches(".*" + expected + ".*"));
		} else if (actual.equalsIgnoreCase("No matching records found")) {
			String expected = "No matching records found";
			Assert.assertTrue(actual.matches(".*" + expected + ".*"));			
		}
	}

	@When("^User search by value (.*)$")
	public void searchByValue(String value) {
		propose.getCount(); // just scroll to element
		propose.txtSearch.clear();
		propose.txtSearch.sendKeys(value);
//		propose.txtSearch.sendKeys(Keys.ENTER);
		propose.sleep(2000);
	}

	@When("^User validate search (.*)$")
	public void validateSearch(String value) {
		String strDate = new String(propose.getDate());
		String strCount = new String(propose.getCount());
		String strType = new String(propose.getType());
		String strStatus = new String(propose.getStatus1());
		System.out.println("-- validate search --");
		System.out.println(strDate);
		System.out.println(strCount);
		System.out.println(strType);
		System.out.println(strStatus);
		System.out.println(value);
		propose.scrollToElem(driver.findElement(By.xpath("//input[@placeholder='Enter value here']")));
//		propose.screenshootElm(propose.txtSearch);
		if (value.equalsIgnoreCase("November")) {
			System.out.println("leave column");
			Assert.assertTrue(strDate.matches(".*" + value + ".*"));
		} else if (value.equalsIgnoreCase("90")) {
			System.out.println("count column");
			Assert.assertTrue(strCount.matches(".*" + value + ".*"));
		} else if (value.equalsIgnoreCase("Annual")) {
			System.out.println("type column");
			Assert.assertTrue(strType.matches(".*" + value + ".*"));
		} else if (value.equalsIgnoreCase("persalinan")) {
			System.out.println("special column");
			Assert.assertTrue(strType.matches(".*" + value + ".*"));
		} else if (value.equalsIgnoreCase("Incomplete")) {
			System.out.println("status column");
			Assert.assertTrue(strStatus.matches(".*" + value + ".*"));
		} else {
			Assert.assertTrue(true);
		}
	}

	@When("^User choose show (.*) entries$")
	public void showEntries(String entries) {
		System.out.println("Shows " + entries);
		propose.selectEntries(entries);
	}

	@Then("^User validate show entries (.*)$")
	public void validateEntries(String entries) {
		boolean check = false;
		propose.scrollToElem(driver.findElement(By.xpath("//input[@placeholder='Enter value here']")));
		if (entries.equals("10")) {
			if (!driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[10]/td[1]")).isEmpty()) { // if element
				propose.scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[10]/td[1]"))); // exist
				check = true;
				System.out.println("entries 10 true");
			}
		} else if (entries.equals("25")) {
			if (!driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[11]/td[1]")).isEmpty()) { // if element
				propose.scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[11]/td[1]"))); // exist
				check = true;
				System.out.println("entries 25 true");
			}
		}
		Assert.assertTrue(check);
	}

	@And("^Count less than (.*)$")
	public void coutLessThan(String count) {
		int actual = Integer.parseInt(propose.getCount());
		System.out.println("Count less than -> " + actual);
		int expected = Integer.parseInt(count);
		boolean check = false;
		if (actual < expected) {
			check = true;
			System.out.println("True");
		}
		propose.scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[3]/p")));
		Assert.assertTrue(check);
	}

	@And("^Count equals (.*)$")
	public void countEquals(String count) {
		int actual = Integer.parseInt(propose.getCount());
		System.out.println("Count equals -> " + actual);
		int expected = Integer.parseInt(count);
		boolean check = false;
		if (actual == expected) {
			check = true;
			System.out.println("True");
		}
		propose.scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[3]/p")));
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
			propose.sleep(2000);
			propose.btnValidateAction.click();
		}
		propose.sleep(2000);
		propose.btnValidateAction.click();
		System.out.println("Data deleted");
	}

	@And("Check action")
	public void checkAction() {
		boolean check = true;
		driver.get("https://dev.ptdika.com/employee/data/cuti");
		propose.scrollToElem(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")));
		// propose.zoomOut(67);
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
			propose.actionDelete.click();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.err.println(e);
			check = false;
			try {
				propose.actionDeleteTd.click();
			} catch (NoSuchElementException e2) {
				// TODO: handle exception
				System.err.println(e2);
				check = false;
			}
		}

		System.out.println("Check delete action present");
		Assert.assertTrue(check);
	}

	@And("Validate alert")
	public void validateAlert() {
		String actual = propose.handleAlert();
		System.out.println(actual + " <- validate alert");
		if (actual.equals("No allert")) {
			Assert.assertTrue(false);
		}
	}

//	<<====================================== APPROVAL ======================================>>

	@Then("User at Approval Cuti Page")
	public void at_Approval() {
		String actual = approve.lblPersetujuanCuti.getText();
		System.out.println(actual + " <- at approval");
		String expected = "Persetujuan cuti";
		Assert.assertEquals(actual, expected);
	}

	@Then("User validate modal {string}")
	public void validateModal(String data) {
		approve.sleep(1000);
		String strDate = new String(approve.getLeaveDate());
		System.out.println("-- validate modal --");
		System.out.println(strDate);
		System.out.println(data);
		String actual = "";
		if (data.equalsIgnoreCase("present")) {
			System.out.println(approve.modalHeader.isDisplayed());
			Assert.assertTrue(approve.modalHeader.isDisplayed());
		} else if (data.equalsIgnoreCase("tanggal")) {
			actual = driver.findElement(By.xpath("//*[@id=\"duration\"]")).getText();
			System.out.println(actual);
			String[] arrStr = actual.split("-");
			arrStr[0] = arrStr[0].replace("2022", "").trim();
			actual = arrStr[0];
			SimpleDateFormat sdf = new SimpleDateFormat("d MMMM", Locale.US);
			Date myDate = null;
			try {
				myDate = sdf.parse(actual);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sdf.applyPattern("d MMM");
			actual = sdf.format(myDate);
			System.out.println(actual);
			Assert.assertTrue(strDate.matches(".*" + actual + ".*"));
		}
	}

	@And("^User input approval notes (.*)$")
	public void inputApprovalNotes(String notes) {
		System.out.println("Input approval notes : " + notes);
		approve.txtNotes.sendKeys(notes);
	}

	@And("User validate approval notes {string} button")
	public void validateApprovalNotes(String button) {
		// asumsi kolom notes kosong tidak bisa disubmit ->
		// jika muncul button konfirmasi yes/no maka flow berlanjut
		// shg jika flow berlanjut maka salah
		System.out.println("-- validate approval notes empty/not --");
		approve.sleep(1000);
		boolean check = false;
		boolean checkNotes = false;
		boolean alertAccept = false;
		if (button.equalsIgnoreCase("return")) {
			approve.btnReturn.click();
			if (approve.handleAlert().equalsIgnoreCase("No allert")) {
				System.out.println("Notes terisi");
				checkNotes = true;
			} else {
				System.out.println("Notes kosong");
				checkNotes = false;
			}
			approve.handleAlert();
			approve.sleep(1000);
			approve.btnReturnIt.click();
		} else if (button.equalsIgnoreCase("reject")) {
			approve.btnReject.click();
			if (approve.handleAlert().equalsIgnoreCase("No allert")) {
				System.out.println("Notes terisi");
				checkNotes = true;
			} else {
				System.out.println("Notes kosong");
				checkNotes = false;
			}
			approve.handleAlert();
			approve.sleep(1000);
			approve.btnRejectIt.click();
		} else if (button.equalsIgnoreCase("approve")) {
			approve.btnApprove.click();
			if (approve.handleAlert().equalsIgnoreCase("No allert")) {
				System.out.println("Notes terisi");
				checkNotes = true;
			} else {
				System.out.println("Notes kosong");
				checkNotes = false;
			}
			approve.handleAlert();
			approve.sleep(1000);
			approve.btnApproveIt.click();
		}
		approve.sleep(1000);
		alertAccept = approve.actionAccept.isDisplayed();
		System.out.println(alertAccept);
		System.out.println(checkNotes);
		if (alertAccept == true && checkNotes == true) {
			check = true;
			System.out.println("flow berlanjut");
		} else if (alertAccept == true && checkNotes == false) {
			check = false;
			System.out.println("flow berhenti");
		} else if (alertAccept == false && checkNotes == false) {
			check = true;
			System.out.println("flow berlanjut");
		} else if (alertAccept == false && checkNotes == true) {
			check = false;
			System.out.println("flow berhenti");
		}
		approve.btnOk.click();
		System.out.println("flow berlanjut");
		Assert.assertTrue(check);
	}

	@Then("User validate approval {string} data column contain {string}")
	public void validateAproveColumn(String column, String data) {
		System.out.printf("Check column \"%s\" contains data \"%s\"\n", column, data);
		String strName = new String(approve.getLeaveName());
		String strDate = new String(approve.getLeaveDate());
		String strCount = new String(approve.getCount());
		String strType = new String(approve.getType());
		String strStatus = new String(approve.getStatus());
		boolean check = true;
		if (column.equalsIgnoreCase("leave name")) {
			System.out.println(strName);
			Assert.assertTrue(strName.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("leave date")) {
			System.out.println(strDate);
			Assert.assertTrue(strDate.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("count")) {
			System.out.println(strCount);
			Assert.assertTrue(strCount.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("leave type")) {
			System.out.println(strType);
			Assert.assertTrue(strType.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("status")) {
			System.out.println(strStatus);
			Assert.assertTrue(strStatus.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("missing data")) {
			System.out.println(strName);
			Assert.assertFalse(strName.matches(".*" + data + ".*"));
		} else if (column.equalsIgnoreCase("action")) {
			driver.get("https://dev.ptdika.com/employee/data/cuti/approval");
			if (data.equalsIgnoreCase("cancel")) {
				System.out.println(data);
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
			} else if (data.equalsIgnoreCase("edit")) {
				System.out.println(data);
				try {
					driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
					propose.actionEdit.click();
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e);
					try {
						propose.actionEditTd.click();
					} catch (Exception e2) {
						// TODO: handle exception
						System.err.println(e2);
						check = false;
					} finally {
						Assert.assertTrue(check);
					}
				}
				Assert.assertTrue(check);
			} else if (data.equalsIgnoreCase("none")) {
				System.out.println(data);
				try {
					driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
					propose.actionEdit.click();
				} catch (Exception e) {
					// TODO: handle exception
					check = true;
					Assert.assertTrue(check);
				}
				Assert.assertTrue(check);
			}
		}
	}

	@And("User edit data")
	public void clickEdit() {
//		driver.get("https://dev.ptdika.com/employee/data/cuti");
		try {
			driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr/td[1]")).click();
			approve.actionEdit.click();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
			approve.actionEditTd.click();
		}
		System.out.println("-- edit data --");
	}

	@And("User {string} {string} cuti")
	public void modalAction(String action, String button) {
		System.out.println(action + " " + button);
		approve.sleep(1000);
		if (button.equals("approve")) {
			System.out.println(button + " check");
			approve.btnApprove.click();
			if (action.equalsIgnoreCase("validate")) {
				approve.btnApproveIt.click();
			}
		} else if (button.equals("reject")) {
			System.out.println(button + " check");
			approve.btnReject.click();
			approve.getAlertMsg();
			if (action.equalsIgnoreCase("validate")) {
				approve.btnRejectIt.click();
			}
		} else if (button.equals("return")) {
			System.out.println(button + " check");
			approve.btnReturn.click();
			approve.getAlertMsg();
			if (action.equalsIgnoreCase("validate")) {
				approve.btnReturnIt.click();
			}
		}
		approve.sleep(1000);
		if (action.equalsIgnoreCase("validate")) {
			approve.btnOk.click();
		} else if (action.equalsIgnoreCase("cancel")) {
			approve.btnNo.click();
		}
	}

	@Then("User close modal with {string}")
	public void closeModal(String data) {
		approve.sleep(1000);
//		System.out.println(data);
		if (data.equalsIgnoreCase("close")) {
			approve.btnClose.click();
			System.out.println(data + " clicked");
			Assert.assertTrue(true);
		} else if (data.equalsIgnoreCase("cross")) {
			approve.btnCross.click();
			System.out.println(data + " clicked");
			Assert.assertTrue(true);
		} else if (data.equalsIgnoreCase("leave modal")) {
			approve.modalLeave.click();
			System.out.println(data + " clicked");
			Assert.assertTrue(true);
		}
		driver.get("https://dev.ptdika.com/employee/data/cuti/approval");
	}

	@Then("User validate modal action {string}")
	public void validateModalAction(String action) {
		approve.sleep(1000);
		System.out.printf(action + " disabled ");
		// asumsi ketika melakukan cancel/no ->
		// button "action" seharusnya tidak disabled
		if (action.equalsIgnoreCase("return")) {
			System.out.println(approve.getDisabledAtt(approve.btnReturn));
			System.out.println();
			boolean actual = Boolean.parseBoolean(approve.getDisabledAtt(approve.btnReturn));
			Assert.assertFalse(actual);
		} else if (action.equalsIgnoreCase("reject")) {
			System.out.println(approve.getDisabledAtt(approve.btnReject));
			System.out.println();
			boolean actual = Boolean.parseBoolean(approve.getDisabledAtt(approve.btnReject));
			Assert.assertFalse(actual);
		} else if (action.equalsIgnoreCase("approve")) {
			System.out.println(approve.getDisabledAtt(approve.btnApprove));
			System.out.println();
			boolean actual = Boolean.parseBoolean(approve.getDisabledAtt(approve.btnApprove));
			Assert.assertFalse(actual);
		}
	}

//	@Then("User validate modal action {string} with notes")
//	public void validateModalActionWithNotes(String action) {
//		approve.sleep(1000);
//		System.out.printf(action + " disabled ");
//		if (action.equalsIgnoreCase("return")) {
//			System.out.println(approve.getDisabledAtt(approve.btnReturn));
//			System.out.println();
//			boolean actual = Boolean.parseBoolean(approve.getDisabledAtt(approve.btnReturn));
//			Assert.assertTrue(actual);
//		}
//	}

//	<<====================================== SIGNATURE ======================================>>

	@Then("User at Signature Page")
	public void at_Signature() {
		String actual = signature.lblSignature.getText();
		System.out.println(actual + " at signature");
		String expected = "Setup Tanda Tangan";
		Assert.assertEquals(actual, expected);
	}

	@And("User draw signature")
	public void drawSignature() {
		signature.drawSignature();
	}

	@Then("User save signature")
	public void clickSaveSignature() {
		signature.btnSave.click();
	}

	@Then("User delete signature")
	public void clickDeleteSignature() {
		signature.btnDelete.click();
	}

	@And("User validate signature")
	public void validateSignature() {
		String actual = signature.handleAlert();
		System.out.println(actual);
		if (actual.equals("Succesfully uploaded")) {
			String expected = "Succesfully uploaded";
			Assert.assertEquals(actual, expected);
		} else if (actual.equals("Please provide signature first.")) {
			String expected = "Please provide signature first.";
			Assert.assertEquals(actual, expected);
		}
	}

	@And("User validate empty canvas")
	public void validateEmptyCanvas() {
		signature.checkEmptyCanvas();
	}

	@After
	public void tearDown(Scenario scenario) {
		propose.sleep(2000);
		System.out.println(scenario.getStatus());

		if (scenario.isFailed() || scenario.getStatus().equals("FAILED") || scenario.getStatus().equals("UNDEFINED")) {
			System.out.println("take screenshot");
			String file = "<img src='file://" + propose.screenshoot(driver) + "'height=\"350\" width=\"792\"/>";
			Reporter.log(file);
			driver.close();
		}
		driver.close();
	}
}
