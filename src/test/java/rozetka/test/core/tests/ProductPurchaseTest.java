package rozetka.test.core.tests;

import org.testng.annotations.Test;
import rozetka.test.core.BaseTest;
import rozetka.test.core.pages.MainPage;
import rozetka.test.core.pages.ProductPage;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ProductPurchaseTest extends BaseTest {

    @Test
    public void selectionAndCancellationOfProductPurchase() {
        MainPage mainPage = page(MainPage.class);
        mainPage.searchProduct(getProductName());
        ProductPage productPage = page(ProductPage.class);
        assertTrue(productPage.getTitleProduct(getProductName()).isDisplayed());
        productPage.addProductToBasket();
        assertTrue(productPage.getBasketStatus(getDescriptionOfStatus()).isDisplayed());
        productPage.cleaningBasket();
        assertTrue(productPage.getBasketStateResult(getBasketStatus()).isDisplayed());
    }
}
