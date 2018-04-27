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
    private SelenideElement basketStatus;

    @FindBy(xpath = "//*[@id='cart-popup']//div/input")
    private SelenideElement quantityInputField;

    @FindBy(xpath = "//*[@id='drop-block']/h2")
    private SelenideElement basketStateResult;

    public SelenideElement getTitleProduct(String productName) {
        return titleProduct.shouldBe(Condition.exactText(productName));
    }

    public void addProductToBasket() {
        buyButton.click();
    }

    public SelenideElement getBasketStatus(String descriptionOfStatus) {
        return basketStatus.shouldBe(Condition.exactText(descriptionOfStatus));
    }

    public void quantityProductSelection(String quantity) {
        quantityInputField.clear();
        quantityInputField.val(quantity).pressEnter();
    }

    public SelenideElement getBasketStateResult() {
        return basketStateResult;
    }
}
