package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/HRISStepKeepSession.feature", glue = "definitions.data")
public class HRISStepKeepSessionRunner extends AbstractTestNGCucumberTests {

}
