package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/HRISResultTableCuti.feature", 
glue = "definitions.data")
public class HRISResultTableCutiRunner extends AbstractTestNGCucumberTests {

}
