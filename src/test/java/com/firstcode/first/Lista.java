package com.firstcode.first;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Lista {
    @Test
    public void lista(){
        given()
                .when()
                .get("https://restapi.wcaquino.me/users/3")
                .then()
                .statusCode(200)
                .body("name", containsString("Ana"))
                .body("filhos", hasSize(2))
                .body("filhos[0].name", is("Zezinho"))
        ;
    }

    @Test
    public void listaRaiz(){
        given()
                .when()
                .get("https://restapi.wcaquino.me/users/")
                .then()
                .statusCode(200)
                .body("", hasSize(3))
                .body("name", hasItems("João da Silva", "Maria Joaquina", "Ana Júlia"))
                .body("age[0]", is(30) )
                ;
    }

    @Test
    public void verificacaoAvancada(){
        given()
                .when()
                .get("https://restapi.wcaquino.me/users/")
                .then()
                .statusCode(200)
                .body("", hasSize(3))
                .body("age.findAll{it <= 25}.size()", is(2))              // dois valores sao menores que 25
                .body("age.findAll{it <= 25 && it > 20}.size()", is(1))   // apenas uma idade condiz com essa condicao
                ;
    }
}
