package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@onlyentries", features = "src/test/resources/features/HRISFormCuti.feature", 
glue = "definitions.data")
public class HRISShowEntriesRunner extends AbstractTestNGCucumberTests {

}
