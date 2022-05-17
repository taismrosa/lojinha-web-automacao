package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes web no modulo de produtos")
public class ProdutosTest {
    private WebDriver browser;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver31\\geckodriver.exe");
        this.browser = new FirefoxDriver();
        this.browser.manage().window().maximize();
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        this.browser.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @Test
    @DisplayName("Nao e permitido registrar produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        String toastText = new LoginPage(this.browser)
            .preencherUsuario("admin")
            .preencherSenha("admin")
            .submeterLogin()
            .adicionarProduto()
            .preencherNome("Nome do produto")
            .preencherValor("000")
            .preencherCores("preto,branco")
            .submeterCadastroComErro()
            .capturarMensagem();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastText);
    }

    @Test
    @DisplayName("Nao e permitido registrar produto com valor maior que R$ 7000,00")
    public void testNaoEPermitidoRegistrarProdutoComValorMaiorQueSeteMil() {
        String toastText = new LoginPage(this.browser)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Nome do produto")
                .preencherValor("700001")
                .preencherCores("branco")
                .submeterCadastroComErro()
                .capturarMensagem();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", toastText);
    }

    @Test
    @DisplayName("E permitido registrar produto com valor no limite de R$ 0,01")
    public void testEPermitidoRegistrarProdutoComValorDeUmCentavo() {
        String toastText = new LoginPage(this.browser)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Nome do produto")
                .preencherValor("001")
                .preencherCores("vermelho")
                .submeterCadastroComSucesso()
                .capturarMensagem();

        Assertions.assertEquals("Produto adicionado com sucesso", toastText);
    }

    @Test
    @DisplayName("E permitido registrar produto com valor no limite de R$ 7000,01")
    public void testEPermitidoRegistrarProdutoComValorDeSeteMil() {
        String toastText = new LoginPage(this.browser)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .submeterLogin()
                .adicionarProduto()
                .preencherNome("Nome do produto")
                .preencherValor("700000")
                .preencherCores("roxo")
                .submeterCadastroComSucesso()
                .capturarMensagem();

        Assertions.assertEquals("Produto adicionado com sucesso", toastText);
    }

    @AfterEach
    public void afterEach() {
        this.browser.quit();
    }
}
