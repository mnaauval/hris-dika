package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL PENGAJUAN CUTI/HRISSubmit.feature", glue = "definitions.data")
public class HRISSubmitRunner extends AbstractTestNGCucumberTests {

}
