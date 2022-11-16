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
    public final By mainPageText = By.xpath(".//h1[text()='�������� ������']"); // ����� "�������� ������"
    public final By logInAccountButton = By.xpath(".//button[text()='����� � �������']"); // ������ "����� � �������"
    public final By personalAccountButton = By.xpath(".//p[text()='������ �������']"); // ������ "������ �������"
    public final By bunButton = By.xpath("//*[@id='root']//*/div[1]/span"); // ������ "�����"
    public final By sauceButton = By.xpath("//*[@id='root']//*/div[2]/span"); // ������ "�����"
    public final By fillingButton = By.xpath("//*[@id='root']//*/div[3]/span"); // ������ "�������"
    public final By activeButtonSelector = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc')]/span"); // �������� �������� ������


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
