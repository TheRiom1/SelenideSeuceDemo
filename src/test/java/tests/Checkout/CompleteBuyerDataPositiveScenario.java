package tests.Checkout;

import Users.Users;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;

import config.TestMain;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;


public class CompleteBuyerDataPositiveScenario extends TestMain {
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


    @Test(description = "TC21: Przejście do okna realizacji zakupu")
    public void clickCheckoutButton() {

        //When
     //   Pages.productPage.addItemToTheCart(Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(0)).get(1).shouldBe(Condition.enabled).click());

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.clickCartBtn();
        Pages.cartPage.pageTitle.shouldBe(Condition.visible);
        // productPage = new ProductPage(driver);

        //Then

        Pages.cartPage.checkoutButton.shouldBe(Condition.enabled).click();


    }

    @Test(description = "TC22: Wprowadzanie pełnych danych kupującego", dependsOnMethods = "clickCheckoutButton")
    public void enterBuyerData() {

        //Podejście fluent
        //And
        Pages.checkoutPage.enterFirstName("TestName")
                .enterLastName("TestSurname")
                .enterZipCode("PL2 ENZ")
                .clickContinueBtn();
        Pages.checkoutStepTwoPage.pageTitle.shouldBe(Condition.visible);

    }


}
