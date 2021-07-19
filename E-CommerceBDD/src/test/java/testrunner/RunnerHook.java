package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {".\\src\\test\\java\\features\\SearchCourse.feature"},
		glue= {"stepDefinitions","hook"},
		dryRun=false,
		tags = "@RegressionTest",
		monochrome = true,
		plugin= {"pretty","html:target/SmokeTest.html",
				"json:target/SmokeTest.json"}
		
		//tags = "not @RegressionTest"// not -> exclude and-> if both tag should be there in same scenario
		//or-> it will exceute the scenario which is having any one of tag
		)
public class RunnerHook extends AbstractTestNGCucumberTests{

}
