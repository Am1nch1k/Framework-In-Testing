import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;

public class App {
    public static void main( String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get("https://dzen.ru/?yredirect=true");
    }
}
