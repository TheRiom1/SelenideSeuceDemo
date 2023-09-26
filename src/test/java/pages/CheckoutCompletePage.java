package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage extends Page{

    public SelenideElement thankYouMessage = $("h2");


    public SelenideElement backHomeBtn = $(By.name("back-to-products"));

           
    public void thankYouMessageShouldBeDisplayed() {
        Assert.assertEquals(thankYouMessage.shouldBe(Condition.visible).getText(), "Thank you for your order!");
    }

           
    public ProductPage clickHomeBtn() {
        backHomeBtn.shouldBe(Condition.enabled).click();
        return new ProductPage();
    }
}
