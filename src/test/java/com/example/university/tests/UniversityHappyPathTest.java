
package com.example.university.tests;

import com.example.university.clients.UniversityApi;
import com.example.university.listeners.ExtentReportListener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;
@Listeners(ExtentReportListener.class)
public class UniversityHappyPathTest {

    @Test(description = "GET university by name - success")
    @Description("Checks that GET /university returns HTTP 200")
    public void getUniversityByNameReturns200() {

        UniversityApi.request()
                .queryParam("universityName", "University of Toronto")
                .when()
                .get("/university")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }
    @Test(description = "POST university - success")
    @Step("Execute PUT request to update University")
    @Description("Checks that POST /university returns HTTP 201")
    public void createUniversityReturns201() {

        UniversityApi.request()
                .contentType("application/json")
                .body(UniversityApi.universityBody())
                .when()
                .post("/university")
                .then()
                .statusCode(201);
    }
    @Test(description = "DELETE university - success")
    @Description("Checks that DELETE /university returns HTTP 204")
    public void deleteUniversityReturns204() {

        UniversityApi.request()
                .queryParam("universityName", "University of Toronto")
                .when()
                .delete("/university")
                .then()
                .statusCode(204);
    }
    @Test(description = "GET university by ID - success")
    @Description("Checks that GET university by ID returns HTTP 200")
    public void getUniversityByIdReturns200() {

        UniversityApi.request()
                .pathParam("universityID", 978)
                .when()
                .get("/university{universityID}")
                .then()
                .statusCode(200);
    }
    @Test(description = "PUT university - success")
    @Description("Checks that PUT university returns HTTP 201")
    public void updateUniversityReturns201() {

        UniversityApi.request()
                .pathParam("universityID", 978)
                .contentType("application/json")
                .body(UniversityApi.universityBody())
                .when()
                .put("/university{universityID}")
                .then()
                .statusCode(201);
    }
    @Test(description = "GET all universities - success")
    @Description("Checks that GET /universities returns HTTP 200")
    public void getAllUniversitiesReturns200() {

        UniversityApi.request()
                .when()
                .get("/universities")
                .then()
                .statusCode(200);
    }
}
