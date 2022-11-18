package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPageElements {
    WebDriver driver;

    public ForgotPasswordPageElements(WebDriver driver) {

        this.driver = driver;
    }

    public static final String FORGOT_PASSWORD = Config.BASE_URL + "/forgot-password";

    public final By enterButton = By.xpath(".//a[text()='Войти']"); // Активная строка "Войти"

    public ForgotPasswordPageElements clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }
}