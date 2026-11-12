package utils;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://dummyjson.com";
        // Configurações globais de logs se houver falha
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}