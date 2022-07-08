package runner.dashboard;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/002-MODUL DASHBOARD/HRISDashboardMNGR.feature", 
glue = "definitions.data")
public class HRISDashboardMNGRRunner extends AbstractTestNGCucumberTests {

}
