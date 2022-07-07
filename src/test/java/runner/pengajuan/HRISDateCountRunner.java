package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@countdate", 
features = "src/test/resources/features/PagePengajuan/HRISCutiDateCount.feature", glue = "definitions.data")
public class HRISDateCountRunner extends AbstractTestNGCucumberTests {

}
