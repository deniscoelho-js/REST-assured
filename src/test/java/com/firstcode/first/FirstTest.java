package com.firstcode.first;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;


public class FirstTest {
    @Test
    public void firstTest(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void Rest_Assured(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertEquals(200, response.statusCode());


    }
}
