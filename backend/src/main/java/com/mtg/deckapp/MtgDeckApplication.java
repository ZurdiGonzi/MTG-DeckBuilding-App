package com.mtg.deckapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MtgDeckApplication {

    public static void main(String[] args) {
        loadEnv();
        SpringApplication.run(MtgDeckApplication.class, args);
    }

    private static void loadEnv() {
        java.nio.file.Path envPath = java.nio.file.Paths.get(".env");
        if (!java.nio.file.Files.exists(envPath)) {
            envPath = java.nio.file.Paths.get("../.env");
        }
        if (java.nio.file.Files.exists(envPath)) {
            try {
                java.util.List<String> lines = java.nio.file.Files.readAllLines(envPath);
                for (String line : lines) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#")) {
                        continue;
                    }
                    int eqIndex = line.indexOf('=');
                    if (eqIndex > 0) {
                        String key = line.substring(0, eqIndex).trim();
                        String value = line.substring(eqIndex + 1).trim();
                        if (value.startsWith("\"") && value.endsWith("\"")) {
                            value = value.substring(1, value.length() - 1);
                        } else if (value.startsWith("'") && value.endsWith("'")) {
                            value = value.substring(1, value.length() - 1);
                        }
                        if (System.getProperty(key) == null && System.getenv(key) == null) {
                            System.setProperty(key, value);
                        }
                    }
                }
            } catch (java.io.IOException e) {
                System.err.println("Error loading .env file: " + e.getMessage());
            }
        }
    }

}
