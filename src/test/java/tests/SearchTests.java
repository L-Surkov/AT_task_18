package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class SearchTests extends TestBase {

    private SearchPage searchPage;

    @Test
    @Tag("SearchTests")
    @Description("Проверка поисковой строки и вывода релевантного значения в поиске")
    void successfulSearchTest() {
        searchPage = new SearchPage();  // Создаём после инициализации драйвера
        String searchTerm = "Appium";
        searchPage.openSearch();
        searchPage.typeSearch(searchTerm);
        searchPage.verifyResultsArePresent();
    }

    @Test
    @Tag("SearchTests")
    @Description("Проверка поисковой строки и открытия статьи при клике на результат")
    void searchAndOpenArticle() {
        searchPage = new SearchPage();
        String searchTerm = "RestApi";
        String expectedTitle = "REST";
        searchPage.openSearch();
        searchPage.typeSearch(searchTerm);
        searchPage.clickFirstResult();
        searchPage.verifyTitleIs(expectedTitle);
    }
}
