import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import user.User;
import user.UserClient;
import user.UserCredentials;

public class BaseTest {
    WebDriver driver;

    User user;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\mts49\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
        user = User.createRandomUser();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.quit();
        try {
            UserClient userClient = new UserClient();
            UserCredentials credentials = UserCredentials.from(user);
            userClient.deleteUser(user, credentials);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

