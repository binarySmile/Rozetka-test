package rozetka.test.core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static final String URL = "https://rozetka.com.ua";
    protected static Properties data;

    protected BaseTest() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeTest
    public void initialize() {
        data = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")
                + "\\src\\test\\resources\\data.properties")) {
            data.load(new InputStreamReader(fileInputStream, Charset.forName("UTF-8")));
        } catch (Exception ex) {
            throw new RuntimeException("Exception during the IO operation, details: "
                    + ex.getLocalizedMessage());
        }
    }

    @BeforeMethod
    public void init() {
        open(URL);
    }

    @AfterMethod
    public void dispose() {
        close();
    }

    protected String getCategoryOfProduct() {
        return data.getProperty("category");
    }

    protected String getTypeOfProduct() {
        return data.getProperty("type");
    }

    protected String getGeneralSort() {
        return data.getProperty("general_sort");
    }

    protected String getTypeOfSortedProducts() {
        return data.getProperty("type_sorted_products");
    }

    protected String getProductName() {
        return data.getProperty("product_name");
    }

    protected String getDescriptionOfStatus() {
        return data.getProperty("basket_status");
    }

    protected String getQuantityOfProduct() {
        return data.getProperty("quantity_product");
    }
}
