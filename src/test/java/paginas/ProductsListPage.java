package paginas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage {
    private WebDriver browser;

    public ProductsListPage(WebDriver browser) {
        this.browser = browser;
    }

    public ProductRegisterPage adicionarProduto() {
        this.browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        return new ProductRegisterPage(this.browser);
    }

    public String capturarMensagem() {
        return this.browser.findElement(By.cssSelector(".toast")).getText();
    }
}
