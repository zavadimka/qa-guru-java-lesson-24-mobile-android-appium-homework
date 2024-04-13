package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HomeScreen {

    private final SelenideElement mainToolbarWordmark = $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")),
            searchContainer = $(id("org.wikipedia.alpha:id/search_container")),
            searchInputTitle = $(androidUIAutomator("new UiSelector().text(\"Search Wikipedia\")"));

    private final String searchInputTitleText = "Search Wikipedia";


    @Step("Check that the main toolbar Wordmark is visible")
    public HomeScreen checkMainToolbarWordmarkVisibility() {
        assertThat(mainToolbarWordmark.isDisplayed()).isTrue();

        return this;
    }

    @Step("Check that the Search Container is visible and contains text \"Search Wikipedia\"")
    public HomeScreen checkSearchContainerVisibilityAndText() {
        assertThat(searchContainer.isDisplayed()).isTrue();
        assertThat(searchInputTitle.getText()).isEqualTo(searchInputTitleText);

        return this;
    }
}
