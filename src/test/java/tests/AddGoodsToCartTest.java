package tests;

import com.google.j2objc.annotations.Property;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static enums.DepartmentNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина Интернет-магазина")
    @Feature("Юридические лица")
    @Story("QQQ")
    @Severity(SeverityLevel.BLOCKER)
    @Property("Приоритетность исправления")
    @Owner("Marina Bushmakina, marina@bushmakina.ru")
    @TmsLink("Saucedemo")
    @Issue("1")
    @Test(description = "Проверка добавления товаров в корзину")
    public void AddToCardTest() throws InterruptedException {
        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());

        Thread.sleep(2000);
        productsPage
                .addToCard(0)
                .addToCard(1)
                .addToCard(2);
        productsPage
                .openCard();
        assertEquals(cartPage.getProductsNames().size(), 3);
        // assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        // assertFalse(cartPage.getProductsNames().isEmpty());
    }
}

