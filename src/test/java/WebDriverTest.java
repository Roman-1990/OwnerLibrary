import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class WebDriverTest{
    @Test
    void testWebDriver() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();
        if (config.isRemote()) {
            Configuration.remote = config.getURL();

        }

        open("https://yandex.ru");
    }
}