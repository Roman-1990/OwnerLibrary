import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverTest {
    WebDriver driver;

    @BeforeEach
    public void initProperties() {

        WebConfig config = ConfigFactory
                .create(WebConfig.class, System.getProperties());
        initWebDriver(config);

        System.out.println(config.isRemote());
        System.out.println(config.getURL());
        System.out.println(config.getBrowser());
        System.out.println(config.getBrowserVersion());
    }

    @Test
    public void testWebDriver() {
        driver.get("https://yandex.ru");
        driver.quit();
    }

    private void initWebDriver(WebConfig config) {
        if (config.isRemote()) {
            DesiredCapabilities capabilities;

            switch (config.getBrowser()) {

                case FIREFOX: {
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                case CHROME: {
                    capabilities = DesiredCapabilities.chrome();
                    break;
                }

                default: {
                    capabilities = DesiredCapabilities.chrome();
                }
            }
            capabilities.setCapability("webdriver.browser.version", config.getBrowserVersion());
            driver = new RemoteWebDriver(config.getURL(), capabilities);
        } else {
            driver = new ChromeDriver();
        }

    }
}