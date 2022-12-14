package com.firstcode.first;

import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ValidaBody {

    @Test
    public void validaBody(){
        given()
                .when()
                .get("https://restapi.wcaquino.me/ola")
                .then()
                .statusCode(200)
                .body(Matchers.is("Ola Mundo!"))
        ;
    }
}
