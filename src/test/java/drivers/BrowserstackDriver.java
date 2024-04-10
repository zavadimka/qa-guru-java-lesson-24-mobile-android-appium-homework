package drivers;

import com.codeborne.selenide.WebDriverProvider;

import config.BrowserstackDriverConfig;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static BrowserstackDriverConfig browserstackDriverConfig = ConfigFactory.create(BrowserstackDriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserstackDriverConfig.getUserName());
        caps.setCapability("browserstack.key", browserstackDriverConfig.getAccessKey());

        caps.setCapability("app", browserstackDriverConfig.getAppUrl());

        caps.setCapability("project", browserstackDriverConfig.getProjectName());
        caps.setCapability("build", browserstackDriverConfig.getBuildName());
        caps.setCapability("name", browserstackDriverConfig.getTestName());


        caps.setCapability("device", browserstackDriverConfig.getDeviceName());
        caps.setCapability("os_version", browserstackDriverConfig.getDeviceOsVersion());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackDriverConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
