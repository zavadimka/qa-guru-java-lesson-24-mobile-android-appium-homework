package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/virtual_device.properties"
})
public interface LocalDriverConfig extends Config {

    @Key("device.name")
    String getDeviceName();

    @Key("device.os_version")
    String getDeviceOsVersion();

    @Key("app.version")
    String getAppVersion();

    @Key("app.url")
    String getAppUrl();

    @Key("app.package")
    String getAppPackage();

    @Key("app.activity")
    String getAppActivity();

    @Key("app.wait_activity")
    String getAppWaitActivity();
}
