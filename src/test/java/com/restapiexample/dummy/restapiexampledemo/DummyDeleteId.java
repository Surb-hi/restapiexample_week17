package com.restapiexample.dummy.restapiexampledemo;

import com.restapiexample.dummy.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DummyDeleteId extends Testbase{
    @Test
    public void delateuser(){
        Response response=given()
                .pathParam("id", 1)
                .when()
                .delete("/delete/{id}");
        response.then().statusCode(200);
        System.out.println("Data is delated");
        response.prettyPrint();
    }
}
