package ru.market.yandex;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features"
        , glue = {"ru\\market\\yandex\\stepDefinitions"}
        , plugin = {"pretty", "html:target/cucumber-html-report"}
        , tags = {"@All"}
)
public class RunTest {
}