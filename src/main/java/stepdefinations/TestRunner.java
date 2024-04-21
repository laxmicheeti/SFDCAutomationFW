package stepdefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src\\main\\java\\Features"}
, glue = "stepdefinations", plugin = {"pretty", "html:target/report.html3" },
name="Login+")
public class TestRunner {

	
}
