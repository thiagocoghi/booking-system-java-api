package com.seuprojeto.reservas.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReservaApiTest {

    @Test
    public void deveCriarReservaComSucesso() {
        String json = "{" +
            "\"cliente\": \"Thiago\"," +
            "\"recurso\": \"Quarto 101\"," +
            "\"dataInicio\": \"2025-10-10\"," +
            "\"dataFim\": \"2025-10-12\"" +
        "}";

        given()
            .contentType("application/json")
            .body(json)
        .when()
            .post("http://localhost:8080/reservas")
        .then()
            .statusCode(200)
            .body("cliente", equalTo("Thiago"));
    }
}