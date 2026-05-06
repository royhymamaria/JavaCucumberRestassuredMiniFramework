package com.pds.runners;

import io.cucumber.java.es.Cuando;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "com.pds.stepdefinitions"},
        monochrome = true,
        tags = "@get or @post",  // this will skip all scenarios tagged with @ignore
        plugin = {
        "pretty",
        "json:target/cucumber-json/cucumber.json",// json: path is what ReportBuilder from cucumber-reporting library will read.
        "html:target/cucumber-html-report"
        }
)
public class TestRunner {
}
