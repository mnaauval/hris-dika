package runner.signature;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@spv", features = "src/test/resources/features/004-MODUL SIGNATURE/HRISDrawSignature.feature", 
glue = "definitions.data")
public class HRISDrawSignatureSPVRunner extends AbstractTestNGCucumberTests {

}
