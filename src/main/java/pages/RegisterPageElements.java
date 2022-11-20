package pages;

import config.Config;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageElements {

    WebDriver driver;

    public RegisterPageElements(WebDriver driver) {

        this.driver = driver;
    }

    public static final String REGISTER = Config.BASE_URL + "/register";

    public final By nameField = By.xpath(".//fieldset[1]//input[@name='name']"); // Поле ввода "Имя"
    public final By emailField = By.xpath(".//fieldset[2]//input[@name='name']"); // Поле ввода "Email"
    public final By passwordField = By.xpath(".//input[@name='Пароль']"); // Поле ввода "Пароль"
    public final By regButton = By.xpath(".//button[text()='Зарегистрироваться']"); // Кнопка "Зарегистрироваться"
    public final By invalidPasswordError = By.xpath(".//p[text()='Некорректный пароль']");  // Локатор ошибки "Некорректный пароль"
    public final By enterButton = By.xpath(".//a[text()='Войти']"); // Кнопка "Войти" (внизу страницы)

    @Step("Ввод имени пользователя в поле 'Имя' на странице регистрации")
    public RegisterPageElements putUserName(String userName) {
        driver.findElement(nameField).sendKeys(userName);
        return this;
    }
    @Step("Ввод email в поле 'Email' на странице регистрации")
    public RegisterPageElements putUserEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }
    @Step("Ввод пароля в поле 'Пароль' на странице регистрации")
    public RegisterPageElements putUserPass(String userPass) {
        driver.findElement(passwordField).sendKeys(userPass);
        return this;
    }
    @Step("Клик кнопки 'Зарегистрироваться' на странице регистрации")
    public RegisterPageElements clickRegButton() {
        driver.findElement(regButton).click();
        return this;
    }
    @Step("Получение текста при вводе некорректоного пароля")
    public String invalidPasswordErrorText() {
        String errorText = driver.findElement(invalidPasswordError).getText();
        return errorText;
    }
    @Step("Клик кнопки 'Войти' (внизу страницы регистрации)")
    public RegisterPageElements clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }

}