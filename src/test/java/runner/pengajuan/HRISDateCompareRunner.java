package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/PagePengajuan/HRISDateCompare.feature", glue = "definitions.data")
public class HRISDateCompareRunner extends AbstractTestNGCucumberTests {

}
