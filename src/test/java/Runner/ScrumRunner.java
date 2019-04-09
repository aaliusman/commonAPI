package Runner;


import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\Feature\\Sprint 1\\Fbsignup.feature",
		glue={"StepDefinition"}, format = {"pretty", "html:test-output"}, //"Json:jason_output/cucmber.json","junit:junit_xml/cucubmer.xml"
		//to generate different format of reports
		monochrome = true, // to display the console output in a proper readable format.
		strict = true,// it will strictly follow the mapping between feature file and stepDefinition
		dryRun = true, // to check mapping is right between feature file and step definition file
		tags = {"@P1, @Regression"}
		)
public class ScrumRunner {



}
