package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@tagspecial", 
features = "src/test/resources/features/PagePengajuan/HRISCutiDateCount.feature", glue = "definitions.data")
public class HRISCutiSpecialRunner extends AbstractTestNGCucumberTests {

}
