package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DescriptionPage extends Page {
    public SelenideElement productName = $(By.className("inventory_details_name"));
    public SelenideElement backBtn = $(By.className("inventory_details_back_button"));


    public String getProductName() {
        String pageTitle = productName.shouldBe(Condition.visible).getText();
        return pageTitle;
    }


//
//    public SelenideElement sortSelectedList = By.className("product_sort_container");
//    public SelenideElement products = By.className("inventory_item");
//    public List<WebElement> elementsOnProductPage = driver.findElements(By.className("inventory_item_description"));
//    public SelenideElement addBackPackToCartButton = By.id ("add-to-cart-sauce-labs-backpack");
//    public SelenideElement addBikeToCartButton = By.id ("add-to-cart-sauce-labs-bike-light");
//    public SelenideElement cartButton = By.className("shopping_cart_link");
//    public SelenideElement shoppingCartItemsAmount = By.className("shopping_cart_badge");
}
