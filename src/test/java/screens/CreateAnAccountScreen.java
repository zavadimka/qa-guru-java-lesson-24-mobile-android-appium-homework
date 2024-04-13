package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateAnAccountScreen {

    private final SelenideElement primaryHeader = $(androidUIAutomator("new UiSelector().text(\"Create an account\")"));
    private static final SelenideElement backArrowButton = $(accessibilityId("Navigate up"));
    private final String primaryHeaderText = "Create an account";


    @Step("Verify Create an account screen primary Header text")
    public CreateAnAccountScreen primaryHeaderShouldContainText() {
        assertThat(primaryHeader.getText()).isEqualTo(primaryHeaderText);

        return this;
    }

    @Step("Click the Back arrow button")
    public void previousScreen() {
        backArrowButton.click();
    }
}
