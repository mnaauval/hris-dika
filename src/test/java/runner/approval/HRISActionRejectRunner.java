package runner.approval;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL APPROVAL/HRISActionReject.feature", glue = "definitions.data")
public class HRISActionRejectRunner extends AbstractTestNGCucumberTests {

}
