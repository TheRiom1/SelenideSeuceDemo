package tests.LoginAndLogout;
import Users.Users;


import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import config.TestMain;
import org.testng.annotations.Test;
import pages.Pages;

public class ValidLoginTest extends TestMain {
    private Users standardUser;

    private void setUpTestUsers() {
        standardUser = new Users("standard_user", "secret_sauce");

    }

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws Exception{
        super.beforeClass();
        setUpTestUsers();
    }
    @Test
    public void validLoginTest() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));
        Pages.productPage.pageTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Products"));
    }


}
