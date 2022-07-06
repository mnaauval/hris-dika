package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@onlysearch", features = "src/test/resources/features/HRISFormCuti.feature", 
glue = "definitions.data")
public class HRISSearchRunner extends AbstractTestNGCucumberTests {

}
