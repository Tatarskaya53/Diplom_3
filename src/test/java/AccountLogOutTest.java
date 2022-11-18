import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageElements;
import pages.MainPageElements;
import pages.UserAccountPageElements;
import user.UserClient;

public class AccountLogOutTest extends BaseTest {

    @Before
    @Step("Создание и регистрация произвольного пользователя, вход в аккаунт")
    public void createUser() {
        UserClient userClient = new UserClient();
        MainPageElements mainPage = new MainPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        userClient.createUniqueUser(user);
        System.out.println("UserCreated");
        driver.get(loginPage.LOGIN);
        loginPage.putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton()
                .waitLoadPage();
        mainPage.clickAccountButton();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Step("Выход из аккаунта")
    @Issue("BUG_Chrome")
    public void accountLogOutTest() {
        UserAccountPageElements userAccountPage = new UserAccountPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        userAccountPage.clickButtonLogOut();
        loginPage.waitLoadPage();
    }
}