package tests.ProductList;

import Users.Users;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import config.TestMain;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Pages;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortingTest extends TestMain {
    private Users standardUser;
    @BeforeClass
    public void setup() {
        Pages.loginPage.login(standardUser);
        Pages.productPage.pageLogo.shouldBe(Condition.visible).shouldHave(Condition.text("Swag Labs"));

    }


    @Test(description = "TC10: Sortuj listę produktów według nazwy (od Z do A)")

    public void sortingByNameDescendingShouldBePossible() {

        //When
        Pages.productPage.selectSortingType("Name (Z to A)");
        List<String> actualDescending = Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(1)).texts();
        List<String> expectedDescending = Pages.productPage.productsName.texts();
        Collections.sort(expectedDescending, Comparator.reverseOrder());
        Assertions.assertThat(actualDescending).asList().isEqualTo(expectedDescending);

        //Then

    }

    @Test(description = "TC11: Sortuj listę produktów według nazwy (od A do Z)")
    public void sortingByNameAscendingShouldBePossible() {

        //When
        Pages.productPage.selectSortingType("Name (A to Z)");

        List<String> actualAscending = Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(1)).texts();
        List<String> expectedAscending = Pages.productPage.productsName.texts();
        Collections.sort(expectedAscending);
        Assertions.assertThat(actualAscending).asList().isEqualTo(expectedAscending);

    }

    @Test(description = "TC12: Sortuj listę produktów według ceny (od wysokiej do niskiej)")
    public void sortingByPriceDescendingShouldBePossible() throws InterruptedException {

        //When
        Pages.productPage.selectSortingType("Price (high to low)");
        List<String> actualDescending = Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(1)).texts();
        List<String> expectedDescending = Pages.productPage.productsName.texts();
        Collections.sort(expectedDescending, Comparator.reverseOrder());
        Assertions.assertThat(actualDescending).asList().isEqualTo(expectedDescending);


    }

    @Test(description = "TC13: Sortuj listę produktów według ceny (od niskiej do wysokiej)")
    public void sortingByPriceAscendingShouldBePossible() {

        //When
        Pages.productPage.selectSortingType("Price (low to high)");
        List<String> actualAscending = Pages.productPage.productsName.shouldHave(CollectionCondition.sizeGreaterThan(1)).texts();
        List<String> expectedAscending = Pages.productPage.productsName.texts();
        Collections.sort(expectedAscending);
        Assertions.assertThat(actualAscending).asList().isEqualTo(expectedAscending);

    }


}
