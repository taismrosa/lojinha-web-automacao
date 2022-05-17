package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductRegisterPage {
    private WebDriver browser;

    public ProductRegisterPage(WebDriver browser) {
        this.browser = browser;
    }

    public ProductRegisterPage preencherNome(String nome) {
        this.browser.findElement(By.id("produtonome")).sendKeys(nome);

        return this;
    }

    public ProductRegisterPage preencherValor(String valor) {
        this.browser.findElement(By.id("produtovalor")).sendKeys(valor);

        return this;
    }

    public ProductRegisterPage preencherCores(String cores) {
        this.browser.findElement(By.id("produtocores")).sendKeys(cores);

        return this;
    }

    public ProductsListPage submeterCadastroComErro() {
        this.browser.findElement(By.cssSelector("button[type='submit']")).click();

        return new ProductsListPage(this.browser);
    }

    public ProductEditPage submeterCadastroComSucesso() {
        this.browser.findElement(By.cssSelector("button[type='submit']")).click();

        return new ProductEditPage(this.browser);
    }
}
