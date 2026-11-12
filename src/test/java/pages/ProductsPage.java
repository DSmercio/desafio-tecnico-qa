package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriverWait wait;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement btnAddToCartBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement btnAddToCartBikeLight;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartLink;

    public ProductsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public String obterTituloPagina() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void adicionarProdutosAoCarrinho() {
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartBackpack)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCartBikeLight)).click();
    }

    public String obterQuantidadeCarrinho() {
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.getText();
    }

    public void irParaCarrinho() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
}