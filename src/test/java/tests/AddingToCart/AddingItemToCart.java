package tests.AddingToCart;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;

public class AddingItemToCart extends TestMain {
    private Users standardUser;

    private void setUpTest() {
        standardUser = new Users("standard_user", "secret_sauce");
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Products"));

    }

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTest();
    }
    @Test(description = "TC14: Dodawanie przedmiotu do koszyka")
    public void amountOfItemInCartShouldBeDisplayedProperly() {

        //When
        Pages.productPage.addItemToTheCart(Pages.productPage.getProductId(0));

        //Then
        Pages.productPage.amountOfItemsInCartShouldBe(1);
        Pages.productPage.checkAddItemToTheCartBehaviour(Pages.productPage.getProductIdRemove(0));


    }

    @Test(description = "TC15: Dodawanie kilku przedmiotów do koszyka", dependsOnMethods = "amountOfItemInCartShouldBeDisplayedProperly")

    public void addMoreItemsToTheCart() {
        Pages.productPage.addItemToTheCart(Pages.productPage.getProductId(1))
                .addItemToTheCart(Pages.productPage.getProductId(2));

        Pages.productPage.amountOfItemsInCartShouldBe(3);
    }

    @Test(description = "TC16: Usuwanie przedmiotu z koszyka", dependsOnMethods = {"amountOfItemInCartShouldBeDisplayedProperly", "addMoreItemsToTheCart"})
    public void removeItemFromTheCart() {

        Pages.productPage.checkAddItemToTheCartBehaviourClick(Pages.productPage.getProductIdRemove(0));
        Pages.productPage.amountOfItemsInCartShouldBe(2);

    }


}
