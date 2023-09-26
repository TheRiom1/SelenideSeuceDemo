package tests.Checkout;

import Users.Users;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import config.TestMain;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;


import java.util.List;

public class CheckoutCompletePageBackHomeBtn extends TestMain {
    private Users standardUser;
    String productName;
    public void loginAsStandardUser() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));

    }
    @Override
    @BeforeClass
    public void beforeClass() throws Exception {
        super.beforeClass();
        loginAsStandardUser();
    }
    @Test(description = "TC26: Podsumowanie zakupu - sprawdzenie danych produktów")
    public void checkoutOverwiewShouldDisplayCorrectInformationOneItem() {


        //When
        Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(0)).get(1);

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.cartButton.shouldBe(Condition.enabled).click();
        Pages.cartPage.pageTitle.shouldBe(Condition.visible);

        Pages.cartPage.clickCheckoutButton();
        Pages.checkoutPage.pageTitle.shouldBe(Condition.visible);

        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();

        Pages.checkoutStepTwoPage.pageTitle.shouldBe(Condition.visible);
        Pages.checkoutStepTwoPage.itemTotalPriceShouldBe("9.99");
        Pages.checkoutStepTwoPage.taxTotalPriceShouldBe("0.80");
        Pages.checkoutStepTwoPage.totalPriceShouldBe("10.79");
        Pages.checkoutStepTwoPage.clickFinishBtn();

        //And
        Pages.checkoutCompletePage.thankYouMessageShouldBeDisplayed();
        Pages.checkoutCompletePage.clickHomeBtn();
        Pages.productPage.pageTitle.shouldBe(Condition.visible);
        Pages.productPage.cartButton.shouldBe(Condition.enabled).click();

    }
}
