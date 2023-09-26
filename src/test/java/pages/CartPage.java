package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends Page {

    public SelenideElement checkoutButton = $(".checkout");
    
    public SelenideElement cartList = $(By.className("cart_list"));
    public SelenideElement cartItemNames = $(By.className("inventory_item_name"));
    public SelenideElement continueShoppingBtn = $(By.id("continue-shopping"));
    

        
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.shouldBe(Condition.enabled).click();
        return new CheckoutPage();
    }

        
    public ProductPage clickContinueShoppingBtn() {
        continueShoppingBtn.shouldBe(Condition.enabled).click();
        return new ProductPage();
    }
//
//    public List<String> getProductTitles() {
//        List<WebElement> elements =      s(cartItemNames, 10);
//
//        if (elements.isEmpty()) {
//            return Collections.emptyList(); // Zwraca pustą listę, jeśli nie znaleziono żadnych elementów
//        }
//
//        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
//    }

        
//    public List<WebElement> getProductWebElements() {
//        return       .findElements(By.className("cart_item"));
//    }

        
    public void verifyItemList() {
             cartList.shouldBe(Condition.visible);
    }

        
//    public DescriptionPage clickElementWithText(String targetText) {
//        List<WebElement> itemNameElements =       .findElements(By.cssSelector("div.inventory_item_name"));
//        for (WebElement element : itemNameElements) {
//
//            String itemName = element.getText();
//            if (itemName.equals(targetText)) {
//                element.click();
//                break;
//            }
//        }
//        return new DescriptionPage(      );
//
//    }

}
