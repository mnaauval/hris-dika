package runner.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@MNGR", features = "src/test/resources/features/001-MODUL LOGIN/HRISLogout.feature", 
glue = "definitions.login")
public class HRISLogoutMNGRRunner extends AbstractTestNGCucumberTests {

}
