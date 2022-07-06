package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/HRISDrawSignature.feature", 
glue = "definitions.data")
public class HRISDrawSignatureRunner extends AbstractTestNGCucumberTests {

}
