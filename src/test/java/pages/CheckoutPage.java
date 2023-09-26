package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends Page {
    public SelenideElement fistNameInput = $("#first-name");
    public SelenideElement lastNameInput = $("#last-name");
    public SelenideElement zipCodeInput = $("#postal-code");
    public SelenideElement continueBtn = $("#continue");
    public SelenideElement errorMessage = $(By.className("error-message-container"));

           
    public void errorMessageShouldBe(String expectedText) {
        errorMessage.shouldBe(Condition.visible).shouldHave(Condition.text("Error: " + expectedText));
    }

    public CheckoutPage enterFirstName(String firstName) {
        fistNameInput.shouldBe(Condition.enabled).sendKeys(firstName);
        return new CheckoutPage();
    }
           
    public CheckoutPage enterLastName(String lastname) {
        lastNameInput.shouldBe(Condition.enabled).sendKeys(lastname);
        return new CheckoutPage();
    }
           
    public CheckoutPage enterZipCode(String zipcode) {
        zipCodeInput.shouldBe(Condition.enabled).sendKeys(zipcode);
        return new CheckoutPage();
    }
           
    public CheckoutStepTwoPage clickContinueBtn() {
        continueBtn.shouldBe(Condition.enabled).click();
        return new CheckoutStepTwoPage();
    }
}
