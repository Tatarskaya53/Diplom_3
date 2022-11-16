import config.Config;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPageElements;
import pages.LoginPageElements;
import pages.MainPageElements;
import pages.RegisterPageElements;
import user.UserClient;


public class LoginUserTest extends BaseTest{

    @Before
    public void createUser(){
        UserClient userClient = new UserClient();
        userClient.createUniqueUser(user);
        System.out.println("UserCreated");
    }

    @Test
    @DisplayName("Enter a login page throw a reg button")
    public void loginThrowRegButtonTest(){
        MainPageElements mainPage = new MainPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        driver.get(Config.BASE_URL);
        mainPage.clickRegButton();
        loginPage.putUserEmail(user.getEmail())
                 .putUserPass(user.getPassword())
                 .clickRegButton();
        mainPage.waitLoadPage();
    }

    @Test
    @DisplayName("Enter a login page throw an account button")
    public void loginThrowAccountButtonTest(){
        MainPageElements mainPage = new MainPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        driver.get(Config.BASE_URL);
        mainPage.clickAccountButton();
        loginPage.putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();
        mainPage.waitLoadPage();
    }

    @Test
    @DisplayName("Enter a login page throw a reg page")
    public void loginFromRegisterPageTest(){
        MainPageElements mainPage = new MainPageElements(driver);
        RegisterPageElements registerPage = new RegisterPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        driver.get(registerPage.REGISTER);
        registerPage.clickEnterButton();
        loginPage.putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();
        mainPage.waitLoadPage();
    }

    @Test
    @DisplayName("Enter a login page throw a recovery password page")
    public void loginFromForgotPasswordPageTest(){
        MainPageElements mainPage = new MainPageElements(driver);
        LoginPageElements loginPage = new LoginPageElements(driver);
        ForgotPasswordPageElements forgotPasswordPage = new ForgotPasswordPageElements(driver);
        driver.get(forgotPasswordPage.FORGOT_PASSWORD);
        System.out.println(driver.getTitle());
        forgotPasswordPage.clickEnterButton();
        loginPage.putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();
        mainPage.waitLoadPage();
    }
}
