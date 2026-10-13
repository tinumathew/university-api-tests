
package com.example.university.tests;

import com.example.university.clients.UniversityApi;
import com.example.university.listeners.ExtentReportListener;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ExtentReportListener.class)
public class UniversityNegativeTest {

    @Test(description = "Invalid URL path - 404")
    @Description("Checks that an unknown URL path returns HTTP 404")
    public void invalidPathReturns404() {

        UniversityApi.request()
                .when()
                .get("/universit")
                .then()
                .statusCode(404);
    }

    @Test(description = "Missing required query parameter")
    @Description("Checks the response when universityName is omitted")
    public void missingUniversityNameParameter() {

        UniversityApi.request()
                .when()
                .delete("/university")
                .then()
                .statusCode(422);
    }
    @Test(description = "Missing API key - unauthorized")
    @Description("Checks authentication behavior without the api_key header")
    public void missingApiKeyReturns401() {

        io.restassured.RestAssured.given()
                .when()
                .get("http://127.0.0.1:4010/universities")
                .then()
                .statusCode(401);
    }

    @Test(description = "Query parameter with URL encoding disabled")
    @Description("Demonstrates a request with a raw query string")
    public void unencodedQueryParameter() {

        UniversityApi.request()
                .urlEncodingEnabled(false)
                .queryParam("universityName", "University_of_Toronto")
                .when()
                .get("/universities")
                .then()
                .statusCode(200);
    }


    @Test(description = "Missing Auth")
    public void missingAuthReturns404() {

        UniversityApi.request().given()
                .queryParam("__server","https://zafin-interview.io/api")
                .when()
                .get("/universities")
                .then()
                .statusCode(404);
    }


}
