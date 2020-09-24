package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                  "json:target/cucumber.json",
                  "rerun:target/rerun.txt"},
        features = "src/test/resources/features/login.feature",
        glue = "com/company/stepDefs",
        tags = "@ABC-123"
)

public class RunAcceptanceIT {
}
