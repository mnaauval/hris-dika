package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL PENGAJUAN CUTI/HRISTableDataCuti.feature", glue = "definitions.data")
public class HRISTableDataCutiRunner extends AbstractTestNGCucumberTests {

}
