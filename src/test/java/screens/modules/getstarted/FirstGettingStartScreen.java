package screens.modules.getstarted;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FirstGettingStartScreen {

    private final SelenideElement secondaryHeader = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            addOrEditLanguagesButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            addLanguageButton = $(androidUIAutomator("new UiSelector().text(\"Add language\")")),
            chooseGermanLanguage = $(androidUIAutomator("new UiSelector().text(\"Deutsch\")")),
            checkGermanLanguage = $(androidUIAutomator("new UiSelector().text(\"2.\t\tDeutsch\")")),
            backArrowButton = $(accessibilityId("Navigate up"));
    private final String secondaryHeaderText = "We’ve found the following on your device:",
            checkGermanLanguageText = "2.\t\tDeutsch";


    @Step("Verify First Getting Started screen secondary Header text")
    public FirstGettingStartScreen secondaryHeaderShouldContainText() {
        assertThat(secondaryHeader.getText()).isEqualTo(secondaryHeaderText);

        return this;
    }

    @Step("Add Deutsch and return to the First Getting Started screen")
    public FirstGettingStartScreen addDeutsch() {
        addOrEditLanguagesButton.click();
        addLanguageButton.click();
        chooseGermanLanguage.click();
        backArrowButton.click();

        return this;
    }

    @Step("Check Deutsch visibility on the First Getting Started screen")
    public FirstGettingStartScreen deutschShouldBeVisibleOnTheFirstScreen() {
        assertThat(checkGermanLanguage.getText()).isEqualTo(checkGermanLanguageText);

        return this;
    }

    @Step("Click the Continue button")
    public void nextScreen() {
        continueButton.click();
    }

    @Step("Click the Skip button")
    public void skipGettingStarted() {
        skipButton.click();
    }
}
