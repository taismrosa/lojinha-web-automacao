package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductEditPage {
    private WebDriver browser;

    public ProductEditPage(WebDriver browser) {
        this.browser = browser;
    }

    public String capturarMensagem() {
        return this.browser.findElement(By.cssSelector(".toast")).getText();
    }
}
