package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Owner("Dmitry Zavada")
@Feature("Wikipedia Mobile App Getting Start testing")
@Tags({@Tag("mobile_tests"), @Tag("rest_assured"), @Tag("appium")})
public class WikiAppGettingStartedTests extends TestBase {

    @Test
    @DisplayName("Mobile Wikipedia Getting Started testing: Successful Get Started test")
    @Story("Mobile Wikipedia Getting Started Testing: Go through all four Screens and make checks on each Screen")
    @Severity(SeverityLevel.NORMAL)
    void successfulGetStartedTest() {
        step("First Getting Started screen testing then open Second screen", () -> {
            firstGettingStartScreen.secondaryHeaderShouldContainText()
                    .addDeutsch()
                    .deutschShouldBeVisibleOnTheFirstScreen()
                    .nextScreen();
        });

        step("Second Getting Started screen testing then open Third screen", () -> {
            secondGettingStartScreen.primaryHeaderShouldContainText()
                    .nextScreen();
        });

        step("Third Getting Started screen testing then open Forth screen", () -> { // todo open Create an account screen (Join Wikipedia link)
            thirdGettingStartScreen.primaryHeaderShouldContainText()
                    .nextScreen();
//                    .openCreateAnAccountScreen();
        });

        // Закомментировано, так как не знаю, как обратиться к ссылке Join Wikipedia на третьем экране

//        step("Create an account screen testing then return to the Third screen", () -> {
//            createAnAccountScreen.primaryHeaderShouldContainText()
//                    .previousScreen();
//        });
//
//        step("Check the Third Getting Started screen opening then open Fourth screen", () -> {
//            thirdGettingStartScreen.primaryHeaderShouldContainText()
//                    .nextScreen();
//        });

        step("Fourth Getting Started screen testing then open Home Screen", () -> {
            fourthGettingStartScreen.primaryHeaderShouldContainText()
                    .getStarted();
        });

        step("Check Home screen opening after the end of the Getting Started", () -> {
            homeScreen.checkMainToolbarWordmarkVisibility()
                    .checkSearchContainerVisibilityAndText();
        });
    }

    @Test
    @DisplayName("Mobile Wikipedia Getting Started testing: Skip Getting Started test")
    @Story("Click on the Skip button on the First Getting Started screen and make sure we are on the App Home screen")
    @Severity(SeverityLevel.NORMAL)
    void skipGettingStartedTest() {
        step("Click on the Skip button on the First Getting Started screen and make Home screen checks", () -> {
            firstGettingStartScreen.skipGettingStarted();
            homeScreen.checkMainToolbarWordmarkVisibility()
                    .checkSearchContainerVisibilityAndText();
        });
    }
}