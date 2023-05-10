package praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[@name='Пароль']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@href='/register']")
    private SelenideElement registerPageLink;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement forgotPasswordLink;

    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement logInHeader;

    @Step("Нажать на кнопку 'Войти' на странице авторизации")
    public void clickToLoginButton() {
        loginButton.click();
    }

    @Step("Нажать на ссылку 'Зарегистрироваться' на странице авторизации")
    public void clickToRegisterPageLink() {
        registerPageLink.shouldBe(Condition.visible).click();
    }

    @Step("Нажать на ссылку'Восстановить пароль'")
    public void clickToForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    @Step("Установить значение поля с нуля")
    public void setFieldValueFromScratch(SelenideElement field, String value) {
        field.sendKeys(Keys.CONTROL + "A");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
    }

    @Step("Ввести почту пользователя в поле 'Email'")
    public void setEmailField(String email) {
        setFieldValueFromScratch(emailField, email);

    }

    @Step("Ввести пароль пользователя в поле 'Пароль'")
    public void setPasswordField(String password) {
        setFieldValueFromScratch(passwordField, password);
    }

    @Step("Заголовок 'Регистрация' отображается на странице")
    public boolean isLogInHeaderDisplayed() {
        return logInHeader.shouldBe(Condition.visible).isDisplayed();
    }
}
