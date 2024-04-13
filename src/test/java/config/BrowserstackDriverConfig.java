package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserstackDriverConfig extends Config {

    @Key("browserstack.user")
    String getUserName();

    @Key("browserstack.key")
    String getAccessKey();

    @Key("browserstack.app_url")
    String getAppUrl();

    @Key("browserstack.device")
    String getDeviceName();

    @Key("browserstack.os_version")
    String getDeviceOsVersion();

    @Key("browserstack.project_name")
    String getProjectName();

    @Key("browserstack.build_name")
    String getBuildName();

    @Key("browserstack.test_name")
    String getTestName();

    @Key("browserstack.remote_url")
    String getRemoteUrl();
}
