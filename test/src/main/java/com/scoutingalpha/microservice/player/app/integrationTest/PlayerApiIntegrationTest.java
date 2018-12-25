package com.scoutingalpha.microservice.player.app.integrationTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.ANY;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@Tag("Integration")
class PlayerApiIntegrationTest {
    @BeforeAll
    static void before() {
        RestAssured.baseURI = System.getProperty("baseURI");
        RestAssured.basePath = System.getProperty("basePath");
        RestAssured.port = Integer.parseInt(System.getProperty("port"));
    }

    @Test
    @DisplayName("Retrieve a player")
    public void getOnePlayer() {
        given().accept(ANY)
                .when()
                .get("/player/one")
                .then()
                .statusCode(200)
                .contentType(JSON)
//                .body("keys", is(instanceOf(List.class)))
                .body("fullName", is(instanceOf(String.class)));

    }
}
