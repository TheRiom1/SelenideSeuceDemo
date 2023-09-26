package pages;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.valueOf;

public class ProductPage extends Page {

    public SelenideElement sortSelectedList = $(By.cssSelector(".product_sort_container"));
    public ElementsCollection productsName = $$(By.className("inventory_item_name"));
    public SelenideElement addBackPackToCartButton = $(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
    public SelenideElement addBikeToCartButton = $(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
    public SelenideElement cartButton = $(By.cssSelector(".shopping_cart_link"));




    public ElementsCollection productPrices = $$(By.className("inventory_item_price"));
    public ElementsCollection elementsOnProductPage = $$(By.className("inventory_item_description"));
    public ElementsCollection addToCartBtns = $$(By.className("btn_inventory"));

    public SelenideElement backButton = $(By.className("inventory_details_back_button"));
    public SelenideElement shoppingCartItemsAmount = $(By.className("shopping_cart_badge"));


    public void selectSortingType(String sortingType) {
        Select select = new Select(sortSelectedList);
        select.selectByVisibleText(sortingType);

    }

    public DescriptionPage clickElementWithText(List<SelenideElement> elements, String targetText) {
        for (SelenideElement element : elements) {
            SelenideElement itemNameElement = element.$(By.cssSelector("div.inventory_item_name"));
            String itemName = itemNameElement.getText();
            if (itemName.equals(targetText)) {
                itemNameElement.click();
                break; // Przerwij pętlę, gdy element zostanie znaleziony
            }
        }
        return new DescriptionPage();
    }

   
    public ProductPage addItemToTheCart( String targetElementId) {
        addToCartBtns.shouldHave(CollectionCondition.sizeGreaterThan(0)).filterBy(Condition.id(targetElementId))
                .shouldHave(CollectionCondition.sizeGreaterThan(0)).get(0).shouldBe(Condition.enabled).click();
        return this;
    }

  
    public void checkAddItemToTheCartBehaviour( String targetElementId) {
        SelenideElement btnAfterAddingToCart = $(By.id(targetElementId));
        Assert.assertEquals(btnAfterAddingToCart.shouldBe(Condition.visible).getText(), "Remove");

    }


    
    public void checkAddItemToTheCartBehaviourClick( String targetElementId) {
        SelenideElement btnAfterAddingToCart = $(By.id(targetElementId));
        btnAfterAddingToCart.shouldBe(Condition.enabled).click();
    }

   
    public void productShouldBeSortedDescending (List<String> received) {
        //  received = getProductTitles();
        List<String> sorted = received.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(sorted, received);

    }
  
    public void productShouldBeSortedAscendingPrices (List<String> received) {
        //  received = getProductTitles();
        //List<String> sorted = received.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Double> receivedPrices = received.stream()
                .map(price -> Double.parseDouble(price.replace("$", ""))).collect(Collectors.toList());;
        // Zamień na Double
        List<Double> sortedPrices = receivedPrices.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        Assert.assertEquals(sortedPrices, receivedPrices);

    }

    
    public void productShouldBeSortedDescendingPrices (List<String> received) {
        //  received = getProductTitles();
        //List<String> sorted = received.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Double> receivedPrices = received.stream()
                .map(price -> Double.parseDouble(price.replace("$", ""))).collect(Collectors.toList());;
        // Zamień na Double
        List<Double> sortedPrices = receivedPrices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(sortedPrices, receivedPrices);

    }

    
    public void productShouldBeSortedAscending(List<String> received) {

        List<String> sorted = received.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        Assert.assertEquals(sorted, received);

    }

    
    public CartPage clickCartBtn () {
        cartButton.shouldBe(Condition.enabled).click();
        return new CartPage();

    }
    
    public void clickBackBtn () {
        backButton.shouldBe(Condition.enabled).click();

    }
   
    public void amountOfItemsInCartShouldBe (int amountOfItemsInCart) {
        Assert.assertEquals(shoppingCartItemsAmount.shouldBe(Condition.visible).getText(), valueOf(amountOfItemsInCart));

    }

     
    public void clickAddBackpackToCartBtn() {
          addBackPackToCartButton.shouldBe(Condition.enabled).click();
    }
     
    public void clickAddBikeLightToCartBtn() {
          addBikeToCartButton.shouldBe(Condition.enabled).click();
    }




}
