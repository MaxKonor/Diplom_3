package praktikum.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {


    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Булки']")
    private SelenideElement bunsSectionNameLink;

    @FindBy(how = How.XPATH, using = "//*[text()='Соусы']")
    private SelenideElement saucesSectionNameLink;

    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement ingredientsSectionNameLink;

    @FindBy(how = How.XPATH, using = "//img[@alt='Мини-салат Экзо-Плантаго']")
    private SelenideElement exoPlantagonSaladImage;

    @FindBy(how = How.XPATH, using = "//img[@alt='Соус Spicy-X']")
    private SelenideElement spicyXSauceImage;

    @FindBy(how = How.XPATH, using = "//img[@alt='Краторная булка N-200i']")
    private SelenideElement cardboardBunImage;

    @FindBy(how = How.XPATH, using =
            "//*[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Булки']")
    private SelenideElement selectedBunSection;

    @FindBy(how = How.XPATH, using =
            "//*[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Соусы']")
    private SelenideElement selectedSaucesSection;

    @FindBy(how = How.XPATH, using =
            "//*[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Начинки']")
    private SelenideElement selectedIngredientsSection;


    @Step("Нажать на кнопку 'Войти в аккаунт' на главой странице")
    public void clickToLoginButton() {
        loginButton.click();
    }

    @Step("Открыть раздел 'Начинки'")
    public void openIngredientSection() {
        ingredientsSectionNameLink.shouldBe(Condition.visible).click();
    }

    @Step("Открыть раздел 'Соусы'")
    public void openSaucesSection() {
        saucesSectionNameLink.shouldBe(Condition.visible).click();
    }

    @Step("Открыть раздел 'Булки'")
    public void openBunsSection() {
        spicyXSauceImage.scrollIntoView(true);
        bunsSectionNameLink.shouldBe(Condition.visible).click();
    }

    @Step("Скролл к элементу 'Мини-салат Экзо-Плантагон'")
    public void scrollToExoPlantagonSalad() {
        exoPlantagonSaladImage.scrollIntoView(true);
    }

    @Step("Скролл к элементу 'Соус Spicy-X'")
    public void scrollToSpicyXSauce() {
        spicyXSauceImage.scrollIntoView(true);
    }

    @Step("Скролл к элементу 'Картонная булка N-200i'")
    public void scrollToCardboardBun() {
        cardboardBunImage.scrollIntoView(true);
    }

    @Step("Проверить, что раздел 'Начинки' открылся")
    public boolean isIngredientsSectionOpen() {
        return selectedIngredientsSection.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Проверить, что раздел 'Соусы' открылся")
    public boolean isSaucesSectionOpen() {
        return selectedSaucesSection.shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Проверить, что раздел 'Булки' открылся")
    public boolean isBunsSectionOpen() {
        return selectedBunSection.isDisplayed();
    }

    @Step("Проверить, что кнопка 'Сделать заказ' отображается")
    public boolean isMakeOrderButtonDisplayed() {
        return makeOrderButton.shouldBe(Condition.visible).isDisplayed();
    }

}
