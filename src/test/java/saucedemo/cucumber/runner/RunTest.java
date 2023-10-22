package saucedemo.cucumber.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/saucedemo/cucumber/features",
        glue = "saucedemo.cucumber.stepDef",
        tags = "@Regression",
        plugin = {"html:target/HTML_report.html"}
)
public class RunTest {

}
