package praktikum.yandex;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.AppConfig;
import praktikum.pages.HeaderPage;
import praktikum.pages.LoginPage;
import praktikum.pages.UserAccount;
import praktikum.user_data.RandomGenerator;
import praktikum.user_data.User;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class UserAccountYandexTest extends BaseYandexTest {

    UserAccount userAccount = page(UserAccount.class);
    LoginPage loginPage = page(LoginPage.class);
    HeaderPage header = page(HeaderPage.class);
    RandomGenerator random = new RandomGenerator();
    User user = new User(random.String(), random.Email(), random.String());


    @Before
    public void setUp() throws InterruptedException {
        open(AppConfig.URL_REGISTER);
        user.RegistrationUser();
        open(AppConfig.URL_LOGIN);
        user.LogInUser();
        header.clickToAccountButton();
    }

    @After
    public void tearDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void openUserAccount() {
        boolean isPersonalAreaElementDisplayed = userAccount.isExitButtonDisplayed();
        Assert.assertTrue(isPersonalAreaElementDisplayed);
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void exitFromUserAccount() throws InterruptedException {
        userAccount.clickToExitButton();
        boolean isExitSuccess = loginPage.isLogInHeaderDisplayed();
        Assert.assertTrue(isExitSuccess);
    }

    @Test
    @DisplayName("Перейти в конструктор бургеров из лого Stellar Burgers")
    public void switchFromAccountToConstructorByLogo() {
        header.clickToLogo();
        Assert.assertTrue(header.isConstructorButtonEnabled());
    }

    @Test
    @DisplayName("Перейти в конструктор бургеров по кнопке Конструктор")
    public void switchFromAccountToConstructorByConstructorButton() {
        header.clickToConstructorButton();
        Assert.assertTrue(header.isConstructorButtonEnabled());
    }
}
