package praktikum.chrom;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.AppConfig;
import praktikum.pages.*;
import praktikum.user_data.RandomGenerator;
import praktikum.user_data.User;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class UserLogInTest {

    HeaderPage header = page(HeaderPage.class);
    MainPage mainPage = page(MainPage.class);
    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);
    ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

    RandomGenerator random = new RandomGenerator();
    User user = new User(random.String(), random.Email(), random.String());

    @Before
    public void setUp() {
        open(AppConfig.URL_REGISTER);
        user.RegistrationUser();
    }

    @After
    public void tearDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void userLogInFromMainPageLogInButton() {
        open(AppConfig.URL_MAIN);
        mainPage.clickToLoginButton();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void userLogInFromHeaderUserAccountButton() {
        open(AppConfig.URL_MAIN);
        header.clickToAccountButton();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void userLogInFromRegisterPage() {
        open(AppConfig.URL_REGISTER);
        registerPage.clickToLoginLink();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void userLogInFromForgotPasswordPage() {
        open(AppConfig.URL_LOGIN);
        loginPage.clickToForgotPasswordLink();
        forgotPasswordPage.clickToLoginLink();
        user.LogInUser();
        Assert.assertTrue(mainPage.isMakeOrderButtonDisplayed());
    }

}
