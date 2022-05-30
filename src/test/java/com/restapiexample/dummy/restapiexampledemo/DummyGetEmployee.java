package com.restapiexample.dummy.restapiexampledemo;

import com.restapiexample.dummy.testbase.Testbase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class DummyGetEmployee extends Testbase {
    @Test
    public void test001() {
        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();

        //total records are 24
        List<Object> totalrecords = response.then().extract().path("data");
        System.out.println("Total records value is : " +totalrecords.size());

        //data[23].id = 24
        int dataid = response.then().extract().path("data[23].id");
        System.out.println("Data id value is : " +dataid );

        // data[23].employee_name = “Doris Wilder”
        String employee_name = response.then().extract().path("data[23].employee_name");
        System.out.println("Employee name value is : " +employee_name);

        //message = “Successfully! All records has been fetched.”
        String message = response.then().extract().path("message");
        System.out.println("Message value is : " +message );

        //status = success
       String status = response.then().extract().path("status");
        System.out.println("Status value is : " +status );

        // id = 3 has employee_salary = 86000
       int employee_salary= response.then().extract().path("data[2].employee_salary");
        System.out.println("Employee_salary value is : " + employee_salary);

        //id = 6 has employee_age = 61
        int employee_age = response.then().extract().path("data[5].employee_age");
        System.out.println("Employee_age value is : " +employee_age);

        //id = 11 has employee_name = Jena Gaines
        String employee_name1 = response.then().extract().path("data[10].employee_name");
        System.out.println("Employee_name value is : " + employee_name1);

    }
    @Test
    public void test002() {
        Response response = given()
                .pathParam("id",1)
                .when()
                .get("/employee/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}