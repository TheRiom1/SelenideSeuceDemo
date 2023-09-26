package tests.AddingToCart;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;


public class ContinueShopping extends TestMain {
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
    @Test(description = "TC19: Powrót do listy produktów")
    public void continueShopping() {

        //When
  //      Pages.productPage.addItemToTheCart(pageElements.getProductId(1));

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.clickCartBtn();

        //And

        Pages.cartPage.clickContinueShoppingBtn();


    }

    @Test(description = "TC20: Powrót do listy produktów", dependsOnMethods = "continueShopping")
    public void continueShoppingAddingFurtherProducts() {
       // Pages.productPage.addItemToTheCart(pageElements.getProductId(2));
        Pages.productPage.amountOfItemsInCartShouldBe(2);
        Pages.productPage.clickCartBtn();



    }
}
