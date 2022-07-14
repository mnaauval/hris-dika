package runner.approval;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL APPROVAL/HRISTableDataCuti.feature", glue = "definitions.data")
public class HRISTableDataCutiRunner extends AbstractTestNGCucumberTests {

}
