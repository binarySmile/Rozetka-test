package rozetka.test.core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static rozetka.test.core.pages.MainPage.choiceOfElement;

public class CategoryPage {

    @FindBy(xpath = "//*[@id='content-inner-block']//div/p/a")
    private List <WebElement> typeOfProduct;

    @FindBy(className = "title-page")
    private SelenideElement pageName;

    @FindBy(xpath = "//*[@class='arrow-link-inner']")
    private List <WebElement> generalSortingLinks;

    @FindBy(xpath = "//*[@id='title_page']//h1")
    private SelenideElement titlePageOfSortingProducts;

    public void choiceTypeOfProduct(String type) {
        choiceOfElement(type, typeOfProduct);
    }

    public SelenideElement getTitlePageName(String type) {
        return pageName.shouldBe(Condition.text(type));
    }

    public void choiceGeneralSorting(String generalSort) {
        choiceOfElement(generalSort, generalSortingLinks);
    }

    public SelenideElement getTitlePageOfSortingProducts(String typeOfSortedProducts) {
        return titlePageOfSortingProducts.shouldBe(Condition.text(typeOfSortedProducts));
    }
}
