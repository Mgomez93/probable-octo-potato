package CucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\java\\features",
        glue = {"stepDefenition"},
        dryRun = false,
        tags = "",
        plugin = { "pretty", "html:target/cucumber-reports/report.html",
        		"json:target/cucumber-reports/report.json",
        "rerun: target/failed_scenarios.text"}, // will rerun the failed scenerios and 
        monochrome = true
        )


public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider
	public Object[][]scenarios (){
		return super.scenarios();
	}
	

}
