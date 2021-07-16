package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${remote}.properties"
})

public interface WebConfig extends Config {

    @Key("webdriver.remote")
    boolean isRemote();

    @Key("webdriver.browser")
    String getBrowser();

    @Key("webdriver.browser.version")
    String getBrowserVersion();

    @Key("webdriver.url")
    String getURL();

    @Key("selenide.login")
    String selenideLogin();

    @Key("selenide.password")
    String selenidePassword();

}
