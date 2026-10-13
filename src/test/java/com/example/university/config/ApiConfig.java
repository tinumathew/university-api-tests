package com.example.university.config;

public class ApiConfig {
    private ApiConfig() {
        // Utility class
    }

    public static final String BASE_URL =
            System.getProperty("baseUrl", "http://127.0.0.1:4010");

    public static final String API_KEY =
            System.getProperty(
                    "apiKey",
                    "f3c84cbb-1f9a-4b87-bb5b-2d1691b24e1e"
            );

    public static final String AUTH_HEADER = "api_key";
}
