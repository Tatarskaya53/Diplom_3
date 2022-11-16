import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPageElements;

public class SwitchIngredientsTest{

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Config.BASE_URL);
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
         driver.quit();
    }

    @Test
    @DisplayName("Switch constructor main buttons")
    public void switchConstructorMainButtonsTest() {
        MainPageElements mainPage = new MainPageElements(driver);
        mainPage.clickSauceButton();
        Assert.assertEquals("�����", mainPage.getActiveButtonText());
        mainPage.clickFillingButton();
        Assert.assertEquals("�������", mainPage.getActiveButtonText());
        mainPage.clickBunButton();
        Assert.assertEquals("�����", mainPage.getActiveButtonText());
    }
}
