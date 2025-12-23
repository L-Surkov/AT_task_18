package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import config.TestConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        TestConfig config = ConfigReader.INSTANCE.getConfig();

        MutableCapabilities caps = new MutableCapabilities();

        String browserstackUser = System.getProperty("browserstack.user");
        String browserstackKey = System.getProperty("browserstack.key");


        caps.setCapability("userName", browserstackUser);
        caps.setCapability("accessKey", browserstackKey);


        caps.setCapability("project", config.project());
        caps.setCapability("build", config.buildName());
        caps.setCapability("name", config.testName());


        caps.setCapability("deviceName", config.deviceName());
        caps.setCapability("osVersion", config.osVersion());


        caps.setCapability("app", config.app());
        caps.setCapability("appium:automationName", config.appiumAutomationName());

        try {
            return new RemoteWebDriver(
                    new URL("https://hub-cloud.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        }
    }
}
