package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.config.IMPLICIT_WAIT;
import static common.config.PLATFORM_AND_BROWSER;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction() {
        // приватный конструктор
    }

    public static synchronized WebDriver createDriver() {
        if (driver == null) {
            switch (PLATFORM_AND_BROWSER) {
                case "win_chrome":
                    System.setProperty("webdriver.chrome.driver",
                            "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver(); // Создаем новый экземпляр драйвера
                    break;
                default:
                    Assert.fail("Incorrect Platform or Browser " + PLATFORM_AND_BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Обнуляем драйвер для возможности повторного создания
        }
    }
}