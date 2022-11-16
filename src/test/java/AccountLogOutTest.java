import io.qameta.allure.Issue;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageElements;
import pages.MainPageElements;
import pages.UserAccountPageElements;
import user.UserClient;

public class AccountLogOutTest extends BaseTest {

    @Before
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
    @DisplayName("Creating an order")
    @Issue("BUG_Chrome")
    public void accountLogOutTest() {
        UserAccountPageElements userAccountPage = new UserAccountPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        userAccountPage.clickButtonLogOut();
        loginPage.waitLoadPage();
    }
}
