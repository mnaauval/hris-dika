package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/DeleteData2.feature", glue = "definitions.data")
public class TestRunner2 extends AbstractTestNGCucumberTests {

}
