package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/appfeatures" }, glue = { "stepdefinations", "com.qa.apphooks" },

		plugin = { "pretty", "summary", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-reports" }, monochrome = true

)

public class ToDoTestRunner {

}
