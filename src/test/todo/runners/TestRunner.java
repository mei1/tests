package test.todo.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
//@RunWith tells JUnit that tests should run using Cucumber class present in ‘Cucumber.api.junit‘ package
@RunWith(Cucumber.class)
//@CucumberOptions tells Cucumber where to look for feature files, what reporting system to use and some other things
@CucumberOptions(
		// folder location for all .features files
		features = "classpath:test/todo/features"
		,glue={"classpath:test/stepDefinitions"}
		,monochrome = false
		)
public class TestRunner {

}
