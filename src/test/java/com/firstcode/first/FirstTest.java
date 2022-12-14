package com.firstcode.first;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertThat;


public class FirstTest {
    @Test
    public void firstTest(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        Assert.assertTrue(response.getBody().asString().equals("Ola Mundo!"));
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void rest_Assured(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);

        RestAssured.get("https://restapi.wcaquino.me/ola").then().statusCode(200);
    }

    @Test
    public void hancrest(){
        assertThat("Maria", Matchers.is("Maria"));
        assertThat(150, Matchers.is(150));
        assertThat(150, Matchers.isA(Integer.class));
        assertThat(150d, Matchers.isA(Double.class));

        List<Integer> pares = Arrays.asList(2,4,6,8,10);
        assertThat(pares, Matchers.hasSize(5));
        assertThat(pares, Matchers.contains(2,4,6,8,10));
        assertThat(pares, Matchers.hasItems(2,8,10));
    }
}
