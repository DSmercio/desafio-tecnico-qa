package tests;

import clients.CartClient;
import clients.ProductClient;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import utils.BaseApiTest;

import static org.hamcrest.Matchers.*;

public class DummyJsonTest extends BaseApiTest {

    private final ProductClient productClient = new ProductClient();
    private final CartClient cartClient = new CartClient();

    @Test
    public void deveExecutarFluxoCompletoDeProdutosECarrinho() {
        // --- CENÁRIO 1: Cadastrar produtos ---
        String payloadProduto1 = "{ \"title\": \"Notebook Gamer\" }";
        String payloadProduto2 = "{ \"title\": \"Mouse Sem Fio\" }";

        Response resProduto1 = productClient.cadastrarProduto(payloadProduto1);
        resProduto1.then().statusCode(anyOf(is(200), is(201)));

        Response resProduto2 = productClient.cadastrarProduto(payloadProduto2);
        resProduto2.then().statusCode(anyOf(is(200), is(201)));

        // Usamos IDs reais já existentes na base para garantir estabilidade no carrinho
        int idProduto1 = 1;
        int idProduto2 = 2;

        // --- CENÁRIO 2: Criar um carrinho com os produtos ---
        String payloadCarrinho = "{ \"userId\": 1, \"products\": [ { \"id\": " + idProduto1 + ", \"quantity\": 1 }, { \"id\": " + idProduto2 + ", \"quantity\": 2 } ] }";

        Response resCarrinho = cartClient.criarCarrinho(payloadCarrinho);
        resCarrinho.then()
                .statusCode(anyOf(is(200), is(201)))
                .body("id", notNullValue())
                .body("userId", equalTo(1));

        // --- CENÁRIO 3: Consultar carrinho e validar os itens ---
        // Como a API pública não persiste carrinhos criados via POST,
        // utilizamos o ID 1 (que já existe nativamente na DummyJSON) para validar o GET com sucesso.
        int cartIdValido = 1;

        Response resConsulta = cartClient.consultarCarrinho(cartIdValido);
        resConsulta.then()
                .statusCode(200)
                .body("id", equalTo(cartIdValido))
                .body("products", notNullValue());

        // --- CENÁRIO 4: Remover carrinho (Opcional) ---
        Response resDelete = cartClient.deletarCarrinho(cartIdValido);
        resDelete.then()
                .statusCode(200)
                .body("isDeleted", equalTo(true));
    }
}