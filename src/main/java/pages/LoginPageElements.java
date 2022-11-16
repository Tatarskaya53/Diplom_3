package pages;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageElements {
    WebDriver driver;

    public LoginPageElements(WebDriver driver) {

        this.driver = driver;
    }

    public static final String LOGIN = Config.BASE_URL + "/login";

    public final By emailField = By.xpath(".//input[@name='name']"); // ���� ����� "Email"
    public final By passwordField = By.xpath(".//input[@name='������']"); // ���� ����� "������"
    public final By enterButton = By.xpath(".//button[text()='�����']"); // ������� "�����"
    public final By loginPageText = By.xpath(".//h2[text()='����']"); // ����� "����"


    public LoginPageElements putUserEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }

    public LoginPageElements putUserPass(String userPass) {
        driver.findElement(passwordField).sendKeys(userPass);
        return this;
    }
    public LoginPageElements clickRegButton() {
        driver.findElement(enterButton).click();
        return this;
    }

    public void waitLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginPageText));
    }

}
