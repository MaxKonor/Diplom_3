package praktikum;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class BaseYandexTest {
    @Before
    public void initYandex() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.browserBinary = "C:/Users/Администратор/AppData/Local/Yandex/YandexBrowser/Application/browser.exe";
    }
}
