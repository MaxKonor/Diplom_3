package praktikum;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.config.AppConfig;
import praktikum.extentions.WebDriverFactory;
import praktikum.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BurgerConstructorTest{

    MainPage mainPage = page(MainPage.class);

    @Before
    public void setUp()  {
        WebDriverFactory.initWebDriver();
        open(AppConfig.URL_MAIN);
    }

    @After
    public void tearDown() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }

    @Test
    @DisplayName("Открыть раздел 'Начинки' по клику на название раздела")
    public void openIngredientsSectionFromSectionNameLink() {
        mainPage.openIngredientSection();
        Assert.assertTrue(mainPage.isIngredientsSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Начинки' по скроллу к элементу")
    public void openIngredientsSectionByScrollToIngredientImage() {
        mainPage.scrollToExoPlantagonSalad();
        Assert.assertTrue(mainPage.isIngredientsSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Соусы' по клику на название раздела")
    public void openSaucesSectionFromSectionNameLink(){
        mainPage.openSaucesSection();
        Assert.assertTrue(mainPage.isSaucesSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Соусы' по скроллу к элементу")
    public void openSaucesSectionByScrollToSauceImage() {
        mainPage.scrollToSpicyXSauce();
        Assert.assertTrue(mainPage.isSaucesSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Булки' по клику на название раздела")
    public void openBunsSectionFromSectionNameLink(){
        mainPage.openIngredientSection();
        mainPage.openBunsSection();
        Assert.assertTrue(mainPage.isBunsSectionOpen());
    }

    @Test
    @DisplayName("Открыть раздел 'Булки' по скроллу к элементу")
    public void openBunsSectionByScrollToBunsImage() {
        mainPage.scrollToCardboardBun();
        Assert.assertTrue(mainPage.isBunsSectionOpen());
    }
}
