package modulos.produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

@DisplayName("Testes web no modulo de produtos")
public class ProdutosTest {

    @Test
    @DisplayName("Nao e permitido registrar produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver31\\geckodriver.exe");
        WebDriver browser = new FirefoxDriver();

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        browser.get("http://165.227.93.41/lojinha-web/v2/");

        browser.findElement(By.cssSelector("label[for='usuario']")).click();
        browser.findElement(By.id("usuario")).sendKeys("admin");
        browser.findElement(By.cssSelector("label[for='senha']")).click();
        browser.findElement(By.id("senha")).sendKeys("admin");
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        browser.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        browser.findElement(By.id("produtonome")).sendKeys("Nome do produto");
        browser.findElement(By.id("produtovalor")).sendKeys("000");
        browser.findElement(By.id("produtocores")).sendKeys("preto,branco");
        browser.findElement(By.cssSelector("button[type='submit']")).click();

        String toastText = browser.findElement(By.cssSelector(".toast")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastText);

        browser.quit();
    }
}
