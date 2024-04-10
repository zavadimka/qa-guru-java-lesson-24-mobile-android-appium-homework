package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Owner("Dmitry Zavada")
@Feature("Wikipedia Mobile App testing with BrowserStack and Appium")
@Tags({@Tag("mobile_tests"), @Tag("rest_assured"), @Tag("appium")})
public class SearchTests extends TestBase {

    private static final SelenideElement searchInputClick = $(accessibilityId("Search Wikipedia")),
            searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            noResultsTitle = $(id("org.wikipedia.alpha:id/search_empty_text")),
            pageTitle = $(id("pcs-edit-section-title-description")),
            pageSectionHeader = $(className("android.widget.TextView"));
    private static final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    private static final String noResultsTitleText = "No results found",
            pageTitleText = "Software company based in India";

    @Test
    @DisplayName("Wikipedia Search testing: Check search results by query \"Appium\"")
    @Story("Open Wikipedia Mobile App, search for \"Appium\" and check that the results amount is greater than 0")
    @Severity(SeverityLevel.CRITICAL)
    void successfulSearchTest() {
        step("Make a search query", () -> {
            searchInputClick.click();
            searchInput.sendKeys("Appium");
        });
        step("Verify content found", () ->
                searchResults.shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Wikipedia Search testing: Get no search results by query \"asfhwqeruafhaaf\"")
    @Story("Open Wikipedia Mobile App, search for \"asfhwqeruafhaaf\" and check that the title \"No Results\" is visible")
    @Severity(SeverityLevel.CRITICAL)
    void successfulSearchTestWithNoResults() {
        step("Make a search query", () -> {
            searchInputClick.click();
            searchInput.sendKeys("asfhwqeruafhaaf");
        });
        step("Verify content found", () -> {
            noResultsTitle.shouldHave(text(noResultsTitleText));

        });

    }

    @Test
    @DisplayName("Wikipedia Mobile App testing with BrowserStack and Appium")
    @Story("Open Wikipedia Mobile App, search for \"Browserstack\", verify first search result, click on the link, verify the opened page")
    @Severity(SeverityLevel.CRITICAL)
    void successfulSearchTestWithOpeningLink() {
        step("Make a search query", () -> {
            searchInputClick.click();
            searchInput.sendKeys("Browserstack");
        });

        step("Verify content found", () -> {
            searchResults.shouldHave(sizeGreaterThan(0));
            searchResults.first().shouldHave(text("BrowserStack"));
            searchResults.first().click();

            pageTitle.shouldHave(text(pageTitleText));
            pageSectionHeader.shouldHave(text("History"));
        });
    }
}