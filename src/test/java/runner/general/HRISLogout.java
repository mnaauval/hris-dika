package runner.general;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/General/HRISLogout.feature", 
glue = "definitions.login")
public class HRISLogout extends AbstractTestNGCucumberTests {

}
