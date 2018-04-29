package rozetka.test.core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

    @FindBy(xpath = "//*[@id='content-inner-block']//div/h1")
    private SelenideElement titleProduct;

    @FindBy(xpath = "//*[@id='price_container']//button")
    private SelenideElement buyButton;

    @FindBy(xpath = "//*[@id='cart-popup']//div/h2")
    private SelenideElement descriptionOfBasketStatus;

    @FindBy(className = "cart-check-wrap")
    private SelenideElement basketCleaningButton;

    @FindBy(xpath = "//*[@class='cart-i-delete']/a[@name='delete']")
    private SelenideElement confirmationOfCleaningButton;

    @FindBy(xpath = "//*[@id='drop-block']/h2")
    private SelenideElement basketState;

    public SelenideElement getTitleProduct(String productName) {
        return titleProduct.shouldBe(Condition.exactText(productName));
    }

    public void addProductToBasket() {
        buyButton.click();
    }

    public SelenideElement getBasketStatus(String descriptionOfStatus) {
        return descriptionOfBasketStatus.shouldBe(Condition.exactText(descriptionOfStatus));
    }

    public void cleaningBasket() {
        basketCleaningButton.click();
        confirmationOfCleaningButton.click();
    }

    public SelenideElement getBasketStateResult(String status) {
        return basketState.shouldBe(Condition.text(status));
    }
}
