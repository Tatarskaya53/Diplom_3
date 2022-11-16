import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPageElements;
import pages.MainPageElements;
import pages.UserAccountPageElements;
import user.UserClient;

public class TransferFromUserAccountTest extends BaseTest{

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
    @DisplayName("Transfer from a user account to a main page by clicking a constructor button")
    public void clickConstructorButton() {
        UserAccountPageElements userAccountPage = new UserAccountPageElements(driver);
        MainPageElements mainPage = new MainPageElements(driver);
        userAccountPage.clickConstructorButton();
        mainPage.waitLoadPage();
    }

    @Test
    @DisplayName("Transfer from a user account to a main page by clicking a main logo")
    public void clickMainLogo() {
        UserAccountPageElements userAccountPage = new UserAccountPageElements(driver);
        MainPageElements mainPage = new MainPageElements(driver);
        userAccountPage.clickStellarBurgersLogo();
        mainPage.waitLoadPage();
    }
}
