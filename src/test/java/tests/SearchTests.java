package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import config.ConfigReader;
import config.TestConfig;

public class SearchTests extends TestBase {

    private SearchPage searchPage;

    @Test
    @Tag("SearchTests")
    void successfulSearchTest() {
        searchPage = new SearchPage();  // Создаём после инициализации драйвера
        String searchTerm = "Appium";
        searchPage.openSearch();
        searchPage.typeSearch(searchTerm);
        searchPage.verifyResultsArePresent();
    }

    @Test
    @Tag("SearchTests")
    void searchAndOpenArticle() {
        searchPage = new SearchPage();  // Создаём после инициализации драйвера
        String searchTerm = "RestApi";
        String expectedTitle = "REST";
        searchPage.openSearch();
        searchPage.typeSearch(searchTerm);
        searchPage.clickFirstResult();
        searchPage.verifyTitleIs(expectedTitle);
    }
}
