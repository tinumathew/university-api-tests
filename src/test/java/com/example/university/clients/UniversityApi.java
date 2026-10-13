
package com.example.university.clients;

import com.example.university.config.ApiConfig;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public final class UniversityApi {

    private UniversityApi() {
        // Utility class
    }

    public static RequestSpecification request() {
        return RestAssured.given()
                .baseUri(ApiConfig.BASE_URL)
                .header(ApiConfig.AUTH_HEADER, ApiConfig.API_KEY);
    }

    public static String universityBody() {
        return """
                {
                  "UniversityID": 978,
                  "UniversityName": "University of Toronto",
                  "UniversityLocation": "Toronto, Ontario, Canada",
                  "UniversityFounded": 1965,
                  "KeyPeople": [
                    {
                      "name": "John Smith",
                      "age": 45,
                      "title": "President"
                    }
                  ]
                }
                """;
    }
}
