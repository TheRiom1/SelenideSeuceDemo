package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class Page {

    public SelenideElement pageLogo = $(By.className("app_logo"));

    public SelenideElement pageTitle = $(("div.header_secondary_container span.title"));



    private String productsPageTitle = "Products";
    private String cartPageTitle = "Your Cart";

    private String checkoutPageTitle = "Checkout: Your Information";

    private String checkoutStepTwoTitle = "Checkout: Overview";
    private List<String> productsList = Arrays.asList("add-to-cart-sauce-labs-backpack", "add-to-cart-sauce-labs-bike-light", "add-to-cart-sauce-labs-bolt-t-shirt",
            "add-to-cart-sauce-labs-fleece-jacket", "add-to-cart-sauce-labs-onesie", "add-to-cart-test.allthethings()-t-shirt-(red)");
    private List<String> productsListAfterAddingToTheCart = Arrays.asList("remove-sauce-labs-backpack", "remove-sauce-labs-bike-light",
            "remove-sauce-labs-bolt-t-shirt", "remove-sauce-labs-fleece-jacket", "remove-sauce-labs-onesie",
            "remove-test.allthethings()-t-shirt-(red)");

    private List<String> productsNamesList = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)");

    public String getProductId(int position) {
        return productsList.get(position);
    }

    public String getProductIdRemove(int position) {
        return productsListAfterAddingToTheCart.get(position);
    }


}
