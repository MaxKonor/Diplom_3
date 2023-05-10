package praktikum.user_data;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.config.AppConfig;
import praktikum.pages.LoginPage;
import praktikum.pages.RegisterPage;

import static com.codeborne.selenide.Selenide.page;
import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class User extends AppConfig {

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

    @Step("Получить токен пользователя с помощью API")
    public String getUserTokenUsingAPI() {
        String accessToken = "";
        ValidatableResponse response = given()
                .spec(getRequestSpec())
                .body(this)
                .when()
                .post(AUTHORISATION_PATH + "login")
                .then();
        if (response.extract().statusCode() == SC_OK) {
            accessToken = response.extract().path("accessToken");
        }
        return accessToken;
    }

    @Step("Удалить пользователя с помощью API")
    public void deleteUserUsingAPI() {
        String token = getUserTokenUsingAPI();
        given()
                .spec(getRequestSpec())
                .header("authorization", token)
                .when()
                .delete(AUTHORISATION_PATH + "user")
                .then();
    }

}
