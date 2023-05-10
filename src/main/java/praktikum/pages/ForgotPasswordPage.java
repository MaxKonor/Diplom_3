package praktikum.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    @FindBy(how = How.XPATH, using = "//*[@name='name']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Восстановить')]")
    private SelenideElement forgotPasswordLink;

    @FindBy(how = How.XPATH, using = "//*[@href='/login']")
    private SelenideElement loginLink;

    @Step("Нажать на ссылку 'Войти'")
    public void clickToLoginLink(){
        loginLink.click();
    }
}
