package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageElements {
    WebDriver driver;

    public MainPageElements(WebDriver driver) {

        this.driver = driver;
    }

    public final By mainPageText = By.xpath(".//h1[text()='Соберите бургер']"); // Хедер "Соберите бургер"
    public final By logInAccountButton = By.xpath(".//button[text()='Войти в аккаунт']"); // Кнопка "Войти в аккаунт"
    public final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']"); // Кнопка "Личный Кабинет"
    public final By bunButton = By.xpath("//*[@id='root']//*/div[1]/span"); // Кнопка "Булки"
    public final By sauceButton = By.xpath("//*[@id='root']//*/div[2]/span"); // Кнопка "Соусы"
    public final By fillingButton = By.xpath("//*[@id='root']//*/div[3]/span"); // Кнопка "Начинки"
    public final By activeButtonSelector = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span"); // Селектор активной кнопки


    public void waitLoadPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPageText));
    }

    public MainPageElements clickRegButton() {
        driver.findElement(logInAccountButton).click();
        return this;
    }

    public MainPageElements clickAccountButton() {
        driver.findElement(personalAccountButton).click();
        return this;
    }

    public MainPageElements clickBunButton() {
        driver.findElement(bunButton).click();
        return this;
    }

    public MainPageElements clickSauceButton() {
        driver.findElement(sauceButton).click();
        return this;
    }

    public MainPageElements clickFillingButton() {
        driver.findElement(fillingButton).click();
        return this;
    }

    public String getActiveButtonText() {
        String activeButtonText = driver.findElement(activeButtonSelector).getText();
        return activeButtonText;
    }

}