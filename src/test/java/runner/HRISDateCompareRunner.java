package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@comparecurrent", 
features = "src/test/resources/features/HRISDateCompare.feature", glue = "definitions.data")
public class HRISDateCompareRunner extends AbstractTestNGCucumberTests {

}
