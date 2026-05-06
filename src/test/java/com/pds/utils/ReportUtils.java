package com.pds.utils;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportUtils {
    // ReportBuilder class of cucumber-reporting library needs parameter as what data to read and how to generate report
    // Creates a ReportBuilder instance that knows what data to read and how to generate the report.
    // ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
     // - Holds report settings: project name, environment details, build number, classifications, and more.
     // List<String> jsonPaths - Contains paths to the JSON files produced by Cucumber. You can have multiple files if you have parallel execution.
    // 1️⃣ Collect all JSON files
    // 2️⃣ Configure report
    // 3️⃣ Generate report

    public static void generateReport(String cucumberJsonDir){
        try {
            File jsonDir = new File(cucumberJsonDir);
            // 1️⃣ Collect all JSON files
            Collection<File> jsonFiles = FileUtils.listFiles(
                    jsonDir,
                    new String[]{"json"}, //files ending with .json.
                    true // true → search all subdirectories inside jsonOutputPath
            );
            if (jsonFiles.isEmpty()) {
                System.out.println("⚠️ No Cucumber JSON files found. Skipping report generation.");
                return;
            }
        // ReportBuilder does NOT accept File objects. It expects file paths as Strings
            List<String> jsonPaths = new ArrayList<>();
            jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
            System.out.println("JSON files found: " + jsonFiles.size());
            jsonFiles.forEach(f -> System.out.println(f.getAbsolutePath()));

            // 2️⃣ Configure report
            Configuration config = new Configuration(new File("target/cucumber-reports"), "MyAPIAutomation");
            config.setBuildNumber("1.0.0"); // optional
            config.addClassifications("Environment", "QA"); // optional

            // 3️⃣ Generate report
            ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
            reportBuilder.generateReports();

            // ✅ PRINT REPORT LINK
            String reportPath = new File(
                    "target/cucumber-reports/cucumber-html-reports/overview-features.html"
            ).getAbsolutePath();

            System.out.println("\n===============================================");
            System.out.println("📊 CUCUMBER EXECUTION REPORT GENERATED");
            System.out.println("🔗 Open Report:");
            System.out.println("file://" + reportPath);
            System.out.println("===============================================\n");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("❌ Failed to generate report", e);
        }

    }
}
