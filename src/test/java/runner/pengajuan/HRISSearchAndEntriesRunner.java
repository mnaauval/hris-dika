package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "not @datasample", 
features = "src/test/resources/features/003-MODUL PENGAJUAN CUTI/HRISSearchAndEntries.feature", glue = "definitions.data")
public class HRISSearchAndEntriesRunner extends AbstractTestNGCucumberTests {

}
