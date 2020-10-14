package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = {"com/company/stepDefs", "com/company/runners/hooks", "com/company/models"}
)
public class RunAcceptanceDebugIT {
}
