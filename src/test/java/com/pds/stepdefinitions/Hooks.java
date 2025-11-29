package com.pds.stepdefinitions;

import com.pds.userConstants.userConstants;
import com.pds.utils.RequestSpecUtils;
import io.cucumber.java.Before;

import java.util.HashMap;
import java.util.Map;

public class Hooks {

    @Before
    public void beforeScenario() {
        // Initialize GET RequestSpec
        RequestSpecUtils.getRequestSpecForGet();
        // Initialize POST RequestSpec
        RequestSpecUtils.getRequestSpecForPost();

        // ✅ Print all headers and confirmation
        System.out.println("ℹ\uFE0F Info: Global setup done - Base URL & Headers configured");
    }


}
