package rozetka.test.core.tests;

import org.testng.annotations.Test;
import rozetka.test.core.BaseTest;
import rozetka.test.core.pages.CategoryPage;
import rozetka.test.core.pages.MainPage;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ProductSortingTest extends BaseTest {

    @Test
    public void searchProduct() {
        MainPage mainPage = page(MainPage.class);
        mainPage.choiceOfCategory(getCategoryOfProduct());
        assertTrue(mainPage.getTitlePage(getCategoryOfProduct()).isDisplayed());
        CategoryPage categoryPage = page(CategoryPage.class);
        categoryPage.choiceTypeOfProduct(getTypeOfProduct());
        assertTrue(categoryPage.getTitlePageName(getTypeOfProduct()).isDisplayed());
        categoryPage.choiceGeneralSorting(getGeneralSort());
        assertTrue(categoryPage.getTitlePageOfSortingProducts(getTypeOfSortedProducts()).isDisplayed());
    }
}
