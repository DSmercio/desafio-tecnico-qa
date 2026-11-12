package tests;

import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseWebTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwagLabsE2ETest extends BaseWebTest {

    @Test
    public void deveExecutarFluxoE2EComSucesso() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Cenário 1: Login com sucesso e validação de redirecionamento
        loginPage.realizarLogin("standard_user", "secret_sauce");
        assertEquals("Products", productsPage.obterTituloPagina(),
                "Falha ao validar redirecionamento para a página de produtos!");

        // Cenário 2: Adição de produtos ao carrinho e validação do contador no ícone
        productsPage.adicionarProdutosAoCarrinho();
        assertEquals("2", productsPage.obterQuantidadeCarrinho(),
                "A quantidade de itens no badge do carrinho está incorreta!");

        // Cenário 3: Fluxo de Checkout Completo
        productsPage.irParaCarrinho();
        cartPage.avancarParaCheckout();

        checkoutPage.preencherDadosCheckout("Eduardo", "Mercio", "92410-000");
        checkoutPage.continuarCheckout();
        checkoutPage.finalizarCompra();

        // Validação da mensagem final de sucesso
        String mensagemSucesso = checkoutPage.obterMensagemSucesso();
        assertEquals("Thank you for your order!", mensagemSucesso,
                "A mensagem de confirmação do pedido não confere!");
    }
}