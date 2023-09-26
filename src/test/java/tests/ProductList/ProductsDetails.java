package tests.ProductList;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;



public class ProductsDetails extends TestMain {
    private Users standardUser;
    String productName;
    public void loginAsStandardUser() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));

    }
    @Test(description = "TC08: Lista produktów - wyświetl szczegóły produktów")
    public void viewProductDetail() {

        //When
        Pages.productPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Products"));

        //Then
        productName = Pages.productPage.clickElementWithText(Pages.productPage.elementsOnProductPage, "Sauce Labs Backpack").getProductName();
        Assert.assertEquals("Sauce Labs Backpack", productName);

    }

    @Test(description = "TC09: Lista produktów - wyświetl szczegóły produktów", dependsOnMethods = "viewProductDetail")

    public void viewProductDetailBackBtn() {
        //When
        Pages.productPage.clickBackBtn();

        //Then
        Pages.productPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Products"));

    }


}
