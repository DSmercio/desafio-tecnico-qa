package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public Response cadastrarProduto(String jsonBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("/products/add");
    }
}