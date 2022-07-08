package runner.pengajuan;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", 
features = "src/test/resources/features/003-MODUL PENGAJUAN CUTI/HRISSelectLeaveType.feature", glue = "definitions.data")
public class HRISSelectLeaveTypeRunner extends AbstractTestNGCucumberTests {

}
