package clients;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CartClient {

    public Response criarCarrinho(String jsonBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("/carts/add");
    }

    public Response consultarCarrinho(int cartId) {
        return given()
                .when()
                .get("/carts/" + cartId);
    }

    public Response deletarCarrinho(int cartId) {
        return given()
                .when()
                .delete("/carts/" + cartId);
    }
}