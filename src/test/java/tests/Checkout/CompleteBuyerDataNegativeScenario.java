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


public class CompleteBuyerDataNegativeScenario extends TestMain {
    private String firstName = "TestName";
    private String lastName = "TestSurname";
    private String zipCode = "PL2 ENZ";


    private Users standardUser;
    String productName;
    public void loginAsStandardUser() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));


//        //When
//        Pages.productPage.addItemToTheCart(pageElements.getProductId(1));
//
//        //Then
//        productPage.amountOfItemsInCartShouldBe(1);
//
//        String pageTitle = productPage.clickCartBtn().getPageTitle();
//        // productPage = new ProductPage(driver);
//
//        //Then
//        Assert.assertEquals(pageElements.getCartPageTitle(), pageTitle);
//        cartPage = new CartPage(driver);
//        checkoutPage = cartPage.clickCheckoutButton();

    }
    @Override
    @BeforeClass
    public void beforeClass() throws Exception {
        super.beforeClass();
        loginAsStandardUser();
    }



    @Test(description = "TC23: Wprowadzanie niekompletnych danych kupującego - brak kodu pocztowego")
    public void enterBuyerDataNegativeScenarioZipCode() {

        //Podejście fluent
        //And
        Pages.checkoutPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterZipCode("")
                .clickContinueBtn();

        Pages.checkoutPage.errorMessageShouldBe("Postal Code is required");

    }

    @Test(description = "TC24: Wprowadzanie niekompletnych danych kupującego - brak nazwiska")
    public void enterBuyerDataNegativeScenarioLastName() {

        //Podejście fluent
        //And
        Pages.checkoutPage.enterFirstName(firstName)
                .enterLastName("")
                .enterZipCode(zipCode)
                .clickContinueBtn();

        Pages.checkoutPage.errorMessageShouldBe("Last Name is required");

    }

    @Test(description = "TC25: Wprowadzanie niekompletnych danych kupującego - brak imienia")

    public void enterBuyerDataNegativeScenarioFirstName() {

        //Podejście fluent
        //And
        Pages.checkoutPage.enterFirstName("")
                .enterLastName(lastName)
                .enterZipCode(zipCode)
                .clickContinueBtn();

        Pages.checkoutPage.errorMessageShouldBe("First Name is required");

    }

}
