package pages;
import Users.Users;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends Page{
    public SelenideElement usernameInput = $(By.id("user-name"));
    public SelenideElement passwordInput = $(By.id("password"));
    public SelenideElement loginButton = $(By.id("login-button"));
    public SelenideElement errorMessage = $(By.xpath(".//h3[@data-class='error']"));
    public SelenideElement logo = $(By.className("login_logo"));

    public ProductPage login(Users user) {
        logo.shouldBe(Condition.exist).shouldHave(Condition.text("Swag Labs"));
        usernameInput.shouldBe(Condition.enabled).setValue(user.getUsername());
        passwordInput.shouldBe(Condition.enabled).setValue(user.getPassword());
        loginButton.shouldBe(Condition.enabled).click();
        return new ProductPage();
    }


}
