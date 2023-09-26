package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutStepTwoPage extends Page{


    public SelenideElement itemTotalLabel = $(By.className("summary_subtotal_label"));
    public SelenideElement taxTotalLabel = $(By.className("summary_tax_label"));
    public SelenideElement totalLabel = $(By.className("summary_total_label"));
    public SelenideElement finishButton = $(By.name("finish"));

    public SelenideElement cancelButton = $(By.className("cart_cancel_link"));

           
    public CheckoutCompletePage clickFinishBtn() {
        finishButton.shouldBe(Condition.enabled).click();
        return new CheckoutCompletePage();
    }

           
    public ProductPage clickCancelBtn() {
        cancelButton.shouldBe(Condition.enabled).click();
        return new ProductPage();
    }

           
    public void itemTotalPriceShouldBe(String expectedPrice) {
        Assert.assertTrue(itemTotalLabel.shouldBe(Condition.visible).getText().contains(expectedPrice));
    }

           
    public void taxTotalPriceShouldBe(String expectedPrice) {
        Assert.assertTrue(taxTotalLabel.shouldBe(Condition.visible).getText().contains(expectedPrice));
    }
           
    public void totalPriceShouldBe(String expectedPrice) {
        Assert.assertTrue(totalLabel.shouldBe(Condition.visible).getText().contains(expectedPrice));
    }
    
}
