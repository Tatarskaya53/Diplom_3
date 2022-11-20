package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserAccountPageElements {
    WebDriver driver;

    public UserAccountPageElements(WebDriver driver) {

        this.driver = driver;
    }

    public final By constructorButton = By.xpath(".//p[text()='Конструктор']"); // кнопка "Конструктор"
    public final By stellarBurgersLogo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a"); // локатор логотипа
    public final By buttonLogOut = By.xpath(".//button[text()='Выход']"); // кнопка "Выход"

    @Step("Клик кнопки 'Конструктор' на странице пользователя")
    public UserAccountPageElements clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return this;
    }
    @Step("Клик логотипа 'StellarBurgers' на странице пользователя")
    public UserAccountPageElements clickStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
        return this;
    }

    @Step("Клик кнопки 'Выход' на странице пользователя")
    public UserAccountPageElements clickButtonLogOut() {
        driver.findElement(buttonLogOut).click();
        return this;
    }
}