package runner.general;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/General/HRISDrawSignature.feature", 
glue = "definitions.data")
public class HRISDrawSignatureRunner extends AbstractTestNGCucumberTests {

}
