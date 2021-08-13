import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"BancoPopular"},
        tags = {"@login"},
        plugin = {
                "pretty",
                "json:build/cucumber-report/cucumber.json",
                "html:build/cucumber-report/cucumber.html",
                "junit:build/cucumber-report/cucumber.xml"}
)
public class RunTests {
}