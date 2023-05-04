package praktikum.extentions;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static final String YANDEX_BROWSER_PATH = "C:\\Users\\Администратор\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

    public static void initWebDriver() {
        //System.setProperty("browser","yandex"); //запуск локально Chrome// или yandex или ("browser","chrome")
        String browser = System.getProperty("browser"); //запуск через терминал mvn clean test -Dbrowser=yandex
                                                                         // или mvn clean test -Dbrowser=chrome

        if (browser.equals("yandex")){
            createYandexDriver();
        }
    }

    private static void createYandexDriver() {
        System.setProperty("webdriver.chrome.driver",  "src/main/resources/chromedriver.exe");
        Configuration.browserBinary = YANDEX_BROWSER_PATH;
    }
}
