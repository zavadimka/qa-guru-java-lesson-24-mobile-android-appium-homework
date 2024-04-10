package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/user_data.properties",
        "classpath:config/device.properties",
        "classpath:config/project.properties"
})
public interface BrowserstackDriverConfig extends Config {

    @Key("browserstack.user")
    String getUserName();

    @Key("browserstack.key")
    String getAccessKey();

    @Key("browserstack.app")
    String getAppUrl();

    @Key("browserstack.device")
    String getDeviceName();

    @Key("browserstack.os_version")
    String getDeviceOsVersion();

    @Key("browserstack.project")
    String getProjectName();

    @Key("browserstack.build")
    String getBuildName();

    @Key("browserstack.name")
    String getTestName();

    @Key("browserstack.remote_url")
    String getRemoteUrl();
}
