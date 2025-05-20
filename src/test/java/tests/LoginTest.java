package tests;

import com.google.j2objc.annotations.Property;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина Интернет-магазина")
    @Feature("Юридические лица")
    @Story("QQQ")
    @Severity(SeverityLevel.BLOCKER)
    @Property("Приоритетность исправления")
    @Owner("Marina Bushmakina, marina@bushmakina.ru")
    @TmsLink("Saucedemo")
    @Issue("1")
    @Test(description = "проверка верной авторизации")
    public void correctLogin() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productsPage.titleIsDisplayed());
        assertEquals(productsPage.getTitle(), "Products");
    }


    @DataProvider(name = "incorrectLoginDate")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "123", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Модуль логина Интернет-магазина")
    @Feature("Юридические лица")
    @Story("QQQ")
    @Severity(SeverityLevel.BLOCKER)
    @Property("Приоритетность исправления")
    @Owner("Marina Bushmakina, marina@bushmakina.ru")
    @TmsLink("Saucedemo")
    @Issue("1")
    @Test(dataProvider = "incorrectLoginDate", description = "проверка невалидных данных входа")
    public void incorrectLoginDate(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.fillLoginInput(user);
        loginPage.fillPasswordInput(pass);
        loginPage.clickSubmitBtn();
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
