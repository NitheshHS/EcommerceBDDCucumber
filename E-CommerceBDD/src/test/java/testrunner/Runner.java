package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {".\\src\\test\\java\\features"},
		glue= {"stepDefinitions"},
		dryRun=false,
		tags = "@FunctionalTest"
		)
public class Runner extends AbstractTestNGCucumberTests{

}
