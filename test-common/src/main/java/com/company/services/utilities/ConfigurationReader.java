package com.company.services.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// TODO: FIS не может найти config.properties file

public final class ConfigurationReader {

    private final Properties properties;

    private ConfigurationReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("/src/main/resources/config/config.properties"));
//            properties.load(this.getClass().getClassLoader().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            System.err.println("File upload failed");
            e.printStackTrace();
        }
    }

    private static class Holder {
        private static final ConfigurationReader instance = valueOf();
    }

    private static ConfigurationReader valueOf() {
        return new ConfigurationReader();
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static ConfigurationReader getInstance() {
        return Holder.instance;
    }
}