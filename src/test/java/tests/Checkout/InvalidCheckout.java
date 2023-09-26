package tests.Checkout;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;

import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;


public class InvalidCheckout extends TestMain {
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
    @Test(description = "TC28: Podsumowanie zakupu - brak towarów w koszyku")
    public void checkoutWithoutItemsInTheCart() {

        Pages.productPage.clickCartBtn();
        Pages.cartPage.pageTitle.shouldBe(Condition.visible);

        //Then

       Pages.cartPage.clickCheckoutButton();

        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();


        Pages.checkoutStepTwoPage.itemTotalPriceShouldBe("0");
        Pages.checkoutStepTwoPage.taxTotalPriceShouldBe("0.00");
        Pages.checkoutStepTwoPage.totalPriceShouldBe("0.00");
        Pages.checkoutStepTwoPage.clickFinishBtn();

        //Then
        Pages.checkoutCompletePage.thankYouMessageShouldBeDisplayed();

    }

    @Test(description = "TC29: Podsumowanie zakupu - cancel button")
    public void checkoutClickCancelButton() {

        //When
 //       Pages.productPage.addItemToTheCart();

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.clickCartBtn().pageTitle.shouldBe(Condition.visible);

        //Then
        Pages.cartPage.clickCheckoutButton();

        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();



        Pages.checkoutStepTwoPage.itemTotalPriceShouldBe("9.99");
        Pages.checkoutStepTwoPage.taxTotalPriceShouldBe("0.80");
        Pages.checkoutStepTwoPage.totalPriceShouldBe("10.79");
        Pages.checkoutStepTwoPage.clickCancelBtn().pageTitle.shouldBe(Condition.visible);

        //And

    }
}
