package tests.ProductList;

import Users.Users;
import com.codeborne.selenide.Condition;
import config.TestMain;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;


public class ViewProductList extends TestMain {
    private Users standardUser;
    @BeforeClass
    public void setup() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));

    }
    @Test(description = "TC07: Lista produktów - wyświetl listę produktów")
    public void viewProductsList() {


    }


}
