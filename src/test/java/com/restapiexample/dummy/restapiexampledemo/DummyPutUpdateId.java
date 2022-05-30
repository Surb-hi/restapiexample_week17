package com.restapiexample.dummy.restapiexampledemo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DummyPutUpdateId extends Testbase {
    @Test
    public void putupdated() {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setId(21);
        employeePojo.setEmployee_name("dhyani");
        employeePojo.setEmployee_salary(50000);
        employeePojo.setEmployee_age(30);
        employeePojo.setProfile_image("");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(employeePojo)
                .pathParam("id", 21)
                .when()
                .put("/update/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}