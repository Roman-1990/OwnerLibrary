import com.codeborne.selenide.Configuration;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class WebDriverTest{
    @Test
    void testWebDriver() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.startMaximized = true;
        Configuration.browser = config.getBrowser();
        Configuration.browserVersion = config.getBrowserVersion();

        if(config.isRemote()) {
            String login = config.selenideLogin();
            String password = config.selenidePassword();
            String url = config.getURL();
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", login, password, url);
        }
        open("https://yandex.ru");
    }
}