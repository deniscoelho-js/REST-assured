package com.firstcode.first;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Usuarios {
    @Test
    public void usuariosAPIGiven(){
        given()
                .when()
                .get("https://restapi.wcaquino.me/users/1")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("name", containsString("João"))
                .body("age", is(30))
                ;
    }

    @Test
    public void usuarioAPIResponse(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/users/1");

        Assert.assertEquals(new Integer(1), response.path("id"));
    }
}
