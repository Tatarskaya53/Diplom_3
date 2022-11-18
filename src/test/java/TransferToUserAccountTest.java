import config.Config;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageElements;
import pages.MainPageElements;
import user.UserClient;


public class TransferToUserAccountTest extends BaseTest {
    @Before
    @Step("Создание пользователя")
    public void createUser() {
        UserClient userClient = new UserClient();
        userClient.createUniqueUser(user);
        System.out.println("UserCreated");
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы")
    @Step("Переход в личный кабинет")
    public void transferToUserAccountTest() {
        MainPageElements mainPage = new MainPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        driver.get(Config.BASE_URL);
        mainPage.clickAccountButton();
        loginPage.putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();
        mainPage.waitLoadPage();
    }
}