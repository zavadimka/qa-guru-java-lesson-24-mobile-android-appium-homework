package screens.modules.getstarted;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class ThirdGettingStartScreen {

    private final SelenideElement primaryHeader = $(id("org.wikipedia.alpha:id/primaryTextView")),
            joinWikipedia = $(partialLinkText("Join Wikipedia"));
    private static final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final String primaryHeaderText = "Reading lists with sync";


    @Step("Verify Third Getting Started screen primary Header text")
    public ThirdGettingStartScreen primaryHeaderShouldContainText() {
        assertThat(primaryHeader.getText()).isEqualTo(primaryHeaderText);

        return this;
    }

    @Step("Click on the \"Join Wikipedia\" link and open Create an account screen")
    public void openCreateAnAccountScreen() {
        joinWikipedia.click();
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