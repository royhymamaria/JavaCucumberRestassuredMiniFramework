package com.pds.stepdefinitions;

import com.pds.userConstants.userConstants;
import com.pds.utils.ConfigLoader;
import com.pds.utils.ReportUtils;
import com.pds.utils.RequestSpecUtils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @Before
    public void beforeScenario() {
        // Read environment from Maven or default to "QA"
        String env = System.getProperty("env", "QA");

        // Load config file
        ConfigLoader.loadConfig(env);
        // Initialize GET RequestSpec
        RequestSpecUtils.getRequestSpecForGet();
        // Initialize POST RequestSpec
        RequestSpecUtils.getRequestSpecForPost();

        // ✅ Print all headers and confirmation
        System.out.println("ℹ\uFE0F Info: Global setup done - Base URL & Headers configured");
    }
    //  generate report using ReportBuilder
//    @AfterAll
//    public static void generateCucumberReport() {
//        ReportUtils.generateReport("target/cucumber-json-test");
//    }


}
