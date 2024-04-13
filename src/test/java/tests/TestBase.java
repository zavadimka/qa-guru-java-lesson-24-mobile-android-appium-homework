package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.CreateAnAccountScreen;
import screens.HomeScreen;
import screens.modules.getstarted.FirstGettingStartScreen;
import screens.modules.getstarted.FourthGettingStartScreen;
import screens.modules.getstarted.SecondGettingStartScreen;
import screens.modules.getstarted.ThirdGettingStartScreen;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    FirstGettingStartScreen firstGettingStartScreen = new FirstGettingStartScreen();
    SecondGettingStartScreen secondGettingStartScreen = new SecondGettingStartScreen();
    ThirdGettingStartScreen thirdGettingStartScreen = new ThirdGettingStartScreen();
    FourthGettingStartScreen fourthGettingStartScreen = new FourthGettingStartScreen();
    HomeScreen homeScreen = new HomeScreen();
    CreateAnAccountScreen createAnAccountScreen = new CreateAnAccountScreen();

    static String driver;

    @BeforeAll
    static void beforeAll() {
        driver = getWebDriverDestination();

        switch (driver) {
            case "browserstack" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "virtual_device" -> Configuration.browser = LocalDriver.class.getName();
        }

        Configuration.browserSize = null;
        Configuration.timeout = 30_000;

        printDeviceDriverInfo();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();

        Attach.pageSource();
        if (driver.equals("browserstack")){
//            Attach.screenshotAs("Last screenshot"); // todo fix
            closeWebDriver();
            Attach.addVideo(sessionId);
        } else {
            Attach.screenshotAs("screenshot");
            closeWebDriver();
        }
    }

    private static String getWebDriverDestination() {
        String driver = System.getProperty("driver", "browserstack");
        System.setProperty("driver", driver);

        return driver;
    }

    public static void printDeviceDriverInfo() {
        System.out.println("The test is run on " + driver);
    }
}
