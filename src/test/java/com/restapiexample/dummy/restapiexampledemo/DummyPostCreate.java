package com.restapiexample.dummy.restapiexampledemo;

import com.restapiexample.dummy.model.EmployeePojo;
import com.restapiexample.dummy.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DummyPostCreate extends Testbase {
    @Test
    public void postcreated() {
        EmployeePojo employeePojo = new EmployeePojo();
        employeePojo.setName("test");
        employeePojo.setSalary(123);
        employeePojo.setAge(23);
        employeePojo.setId(25);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(employeePojo)
                .when()
                .post("/create");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
