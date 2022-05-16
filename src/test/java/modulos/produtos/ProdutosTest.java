package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@DisplayName("Testes web no modulo de produtos")
public class ProdutosTest {

    @Test
    @DisplayName("Nao e permitido registrar produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver31\\geckodriver.exe");
        WebDriver browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get("http://165.227.93.41/lojinha-web/v2/");
    }
}
