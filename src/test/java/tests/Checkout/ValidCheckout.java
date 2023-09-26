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

public class ValidCheckout extends TestMain {

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
 //       Pages.productPage.addItemToTheCart();

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.clickCartBtn().pageTitle.shouldBe(Condition.visible);

        //Then

        Pages.cartPage.clickCheckoutButton();
        Pages.checkoutPage.pageTitle.shouldBe(Condition.visible);

        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();


        Pages.checkoutStepTwoPage.itemTotalPriceShouldBe("9.99");
        Pages.checkoutStepTwoPage.taxTotalPriceShouldBe("0.80");
        Pages.checkoutStepTwoPage.totalPriceShouldBe("10.79");
        Pages.checkoutStepTwoPage.clickFinishBtn();

        //And
        Pages.checkoutCompletePage.thankYouMessageShouldBeDisplayed();

    }

    @Test(description = "TC27: Podsumowanie zakupu - sprawdzenie danych dla wielu produktów")
    public void checkoutOverwiewShouldDisplayCorrectInformationMoreItems() {

        //When
//        Pages.productPage.addItemToTheCart(pageElements.getProductId(1))
//                .addItemToTheCart(pageElements.getProductId(2))
//                .addItemToTheCart(pageElements.getProductId(3));


        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(3);

        Pages.productPage.clickCartBtn().pageTitle.shouldBe(Condition.visible);
        // productPage = new ProductPage(driver);

        //Then

        Pages.cartPage.clickCheckoutButton();

        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();

        Pages.checkoutStepTwoPage.itemTotalPriceShouldBe("75.97");
        Pages.checkoutStepTwoPage.taxTotalPriceShouldBe("6.08");
        Pages.checkoutStepTwoPage.totalPriceShouldBe("82.05");
        Pages.checkoutStepTwoPage.clickFinishBtn();
//
//        //Then
        Pages.checkoutCompletePage.thankYouMessageShouldBeDisplayed();

    }
}
