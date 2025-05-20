package tests;

import com.google.j2objc.annotations.Property;
import io.qameta.allure.*;
import org.testng.annotations.Test;

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
        loginPage.open();
        loginPage.login(withAdminPermission());
        Thread.sleep(2000);
        productsPage.addToCard(0);
        productsPage.addToCard(2);
        productsPage.addToCard(3);
        productsPage.openCard();
        assertEquals(cartPage.getProductsNames().size(), 3);
    }
}

