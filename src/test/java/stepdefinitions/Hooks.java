package stepdefinitions;

import config.ConfigLoader;
import io.cucumber.java.AfterAll;
// import constants.userConstants;
import io.cucumber.java.Before;
import utils.reporting.ReportUtils;
import utils.request.RequestSpecUtils;

// import java.util.HashMap;
// import java.util.Map;

public class Hooks {

    @Before
    public void beforeScenario() {
        // Read environment from Maven or default to "QA"
        String env = System.getProperty("env", "QA");

        // Load config file
        ConfigLoader.loadConfig(env);
        // Initialize GET RequestSpec
        RequestSpecUtils.getRequestSpecForGetMethod();
        // Initialize POST RequestSpec
        RequestSpecUtils.getRequestSpecForPostMethod();

        // ✅ Print all headers and confirmation
        System.out.println("ℹ\uFE0F Info: Global setup done - Base URL & Headers configured");
    }

    @AfterAll
    public static void generateCucumberReport() {
    ReportUtils.generateReport("target/cucumber-json");
}

}
