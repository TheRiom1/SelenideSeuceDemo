package tests.AddingToCart;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;


public class CartList extends TestMain {
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
    @Test (description = "TC17: Wyświetlanie listy przedmiotów w koszyku")
    public void viewCartList() {

        //Given

        //When
   //     Pages.productPage.addItemToTheCart(pageElements.getProductId(1));

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);

        Pages.productPage.clickCartBtn().pageTitle.shouldBe(Condition.visible);
        // productPage = new ProductPage(driver);

        //Then

    }

    @Test(description = "TC18: Wyświetlanie szczegóły przedmiotu znajdującego się w koszyku", dependsOnMethods = "viewCartList")
    public void viewItemDetailsCartPage() {

        Pages.cartPage.verifyItemList();
        //String titleToCheck = pageElements.getProductsNames(1);

       // Assert.assertTrue(cartPage.getProductTitles().contains(titleToCheck), "Tytuł " + titleToCheck + " nie znajduje się na liście.");

       // Pages.cartPage.clickElementWithText( titleToCheck);

    }


}
