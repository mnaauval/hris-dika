package runner.login;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/001-MODUL LOGIN/HRISPageSignIn.feature", 
glue = "definitions.login")
public class HRISPageSignInMNGRRunner extends AbstractTestNGCucumberTests {

}
