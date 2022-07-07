package runner.general;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/General/HRISLogin.feature", 
glue = "definitions.login")
public class HRISLoginRunner extends AbstractTestNGCucumberTests {

}
