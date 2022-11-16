import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPageElements;
import pages.RegisterPageElements;

import static org.junit.Assert.assertEquals;

public class CreateUserTest extends BaseTest{

    @Test
    @DisplayName("Registration a user with valid data")
    public void registrationWithValidUserData() {
        LoginPageElements loginPage = new LoginPageElements(driver);
        RegisterPageElements registerPage = new RegisterPageElements(driver);
        driver.get(registerPage.REGISTER);
        registerPage
                .putUserName(user.getName())
                .putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();

        loginPage.waitLoadPage();
        assertEquals(LoginPageElements.LOGIN, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Registration a user with invalid data")
    public void registrationWithInvalidUserData() {
        RegisterPageElements registerPage = new RegisterPageElements(driver);
        driver.get(registerPage.REGISTER);
        user.setPassword("12345");
        registerPage
                .putUserName(user.getName())
                .putUserEmail(user.getEmail())
                .putUserPass(user.getPassword())
                .clickRegButton();

        assertEquals("������������ ������", registerPage.invalidPasswordErrorText());
    }
}
