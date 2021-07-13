import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebDriverConfigTest {
    @Test
    public void ConfigTest() {
        System.setProperty("webdriver.url", "https://yandex.ru");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.getURL().toString()).isEqualTo("https://yandex.ru");

        System.out.println(config.isRemote());
        System.out.println(config.getURL());
        System.out.println(config.getBrowser());
        System.out.println(config.getBrowserVersion());
    }

}
