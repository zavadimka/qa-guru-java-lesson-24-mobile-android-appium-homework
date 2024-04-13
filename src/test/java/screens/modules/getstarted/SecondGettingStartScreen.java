package screens.modules.getstarted;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SecondGettingStartScreen {

    private final SelenideElement primaryHeader = $(id("org.wikipedia.alpha:id/primaryTextView")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final String primaryHeaderText = "New ways to explore";


    @Step("Verify Second Getting Started screen primary Header text")
    public SecondGettingStartScreen primaryHeaderShouldContainText() {
        assertThat(primaryHeader.getText()).isEqualTo(primaryHeaderText);

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
