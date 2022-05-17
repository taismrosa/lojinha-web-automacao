package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public LoginPage preencherUsuario(String usuario) {
        this.browser.findElement(By.cssSelector("label[for='usuario']")).click();
        this.browser.findElement(By.id("usuario")).sendKeys(usuario);

        return this;
    }

    public LoginPage preencherSenha(String senha) {
        this.browser.findElement(By.cssSelector("label[for='senha']")).click();
        this.browser.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ProductsListPage submeterLogin() {
        this.browser.findElement(By.cssSelector("button[type='submit']")).click();

        return new ProductsListPage(this.browser);
    }
}
