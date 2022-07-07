package runner.general;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/General/HRISGoToPageApproval.feature", 
glue = "definitions.data")
public class HRISGoToPageApprovalRunner extends AbstractTestNGCucumberTests {

}
