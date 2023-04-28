package praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = "//fieldset[1]/div/div/input")
    private SelenideElement userNameField;

    @FindBy(how = How.XPATH, using = "//fieldset[2]/div/div/input")
    private SelenideElement userEmailField;

    @FindBy(how = How.XPATH, using = "//fieldset[3]/div/div/input")
    private SelenideElement userPasswordField;

    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement invalidPasswordError;

    @FindBy(how = How.XPATH, using = "//*[@href='/login']")
    private SelenideElement loginLink;

    @FindBy(how = How.XPATH, using = "//h2[text()='Регистрация']")
    private SelenideElement registerHeader;

    @Step("Нажать на кнопку 'Регистрация'")
    public void clickToRegisterButton() {
        registerButton.click();
    }

    @Step("Нажать на ссылку 'Войти'")
    public void clickToLoginLink(){
        loginLink.click();
    }

    @Step("Ввести имя пользователя")
    public void setUserNameField(String userName) {
        userNameField.shouldBe(Condition.visible).setValue(userName);
    }

    @Step("Ввести почту пользователя")
    public void setUserEmailField(String userEmail) {
        userEmailField.shouldBe(Condition.visible).setValue(userEmail);
    }

    @Step("Ввести пароль пользователя")
    public void setUserPasswordField(String userPassword) {
        userPasswordField.shouldBe(Condition.visible).setValue(userPassword);
    }

    @Step("Проверить, что сообщение об ошибке регистрации отображается")
    public boolean isPasswordErrorDisplayed() {
        return invalidPasswordError.shouldBe(Condition.visible).isDisplayed();
    }
}
