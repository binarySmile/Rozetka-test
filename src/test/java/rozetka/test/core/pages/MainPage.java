package rozetka.test.core.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rozetka.test.core.BaseTest;

import java.util.List;

public class MainPage extends BaseTest {

    @FindBy(xpath = "//*[@id='m-main-ul']/li")
    private List <WebElement> catalogOfCategories;

    @FindBy(className = "pab-h1")
    private SelenideElement titlePage;

    @FindBy(xpath = "//*[@id='rz-search']/form//div/input")
    private SelenideElement searchInputField;

    public static void choiceOfElement(String type, List <WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            WebElement element = list.get(i);
            String text = element.getText();
            if (text.equalsIgnoreCase(type)) {
                element.click();
                break;
            }
        }
    }

    public void choiceOfCategory(String type) {
        choiceOfElement(type, catalogOfCategories);
    }

    public SelenideElement getTitlePage(String type) {
        return titlePage.shouldBe(Condition.exactText(type));
    }

    public void searchProduct(String productName) {
        searchInputField.val(productName).pressEnter();
    }
}

