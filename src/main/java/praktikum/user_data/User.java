package praktikum.user_data;

import io.qameta.allure.Step;
import praktikum.pages.LoginPage;
import praktikum.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.page;

public class User {

    LoginPage loginPage = page(LoginPage.class);
    RegisterPage registerPage = page(RegisterPage.class);

    public String userName;
    public String userEmail;
    public String userPassword;

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Step("Регистрация пользователя")
    public void RegistrationUser() {
        Credentials credentials = new Credentials(userName, userEmail, userPassword);
        registerPage.setUserNameField(credentials.userName);
        registerPage.setUserEmailField(credentials.userEmail);
        registerPage.setUserPasswordField(credentials.userPassword);
        registerPage.clickToRegisterButton();
    }

    @Step("Авторизация пользователя")
    public void LogInUser() {
        Credentials credentials = new Credentials(userName, userEmail, userPassword);
        loginPage.setEmailField(credentials.userEmail);
        loginPage.setPasswordField(credentials.userPassword);
        loginPage.clickToLoginButton();

    }
}
