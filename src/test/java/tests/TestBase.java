package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
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

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10_000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

//        Attach.screenshotAs("Last screenshot"); // todo fix
        Attach.pageSource();
        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}
