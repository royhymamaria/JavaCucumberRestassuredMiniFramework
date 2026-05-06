package com.pds.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class ConfigLoader {

    private static Properties properties;
    private static final Logger LOGGER = Logger.getLogger(ConfigLoader.class.getName());

    /**
     * Loads config file for the given environment (DEV, QA, PROD)
     */
        public static void loadConfig (String env){

            LOGGER.info("🔍 Starting to load configuration for environment: " + env);
            try {

        properties = new Properties();
        String fileName = "config/" + env + ".properties";

        InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName);

        if (input == null) {
            throw new RuntimeException("❌ Config file not found: " + fileName);
        }

        properties.load(input);

                LOGGER.info("✅ Successfully loaded configuration file: " + fileName);

    } catch(Exception e){
                throw new RuntimeException("❌ Failed to load config for env: " + env, e);

            }
        }
    /**
     * Fetch value for a given key
     */
    public static String getConfig(String key) {
        String value = properties.getProperty(key);
        return value;
    }
}
