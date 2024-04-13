package screens.modules.getstarted;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.partialLinkText;

public class FourthGettingStartScreen {

    private final SelenideElement primaryHeader = $(id("org.wikipedia.alpha:id/primaryTextView")),
            termsOfUse = $(partialLinkText("terms of use"));
    private static final SelenideElement getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    private final String primaryHeaderText = "Data & Privacy";


    @Step("Verify Fourth Getting Started screen primary Header text")
    public FourthGettingStartScreen primaryHeaderShouldContainText() {
        assertThat(primaryHeader.getText()).isEqualTo(primaryHeaderText);

        return this;
    }

    @Step("Click the Get Started button")
    public void getStarted() {
        getStartedButton.click();
    }
}
