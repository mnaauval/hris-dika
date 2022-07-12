package runner.approval;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "not @runthis", 
features = "src/test/resources/features/003-MODUL APPROVAL/HRISCloseModal.feature", glue = "definitions.data")
public class HRISCloseModalRunner extends AbstractTestNGCucumberTests {

}
