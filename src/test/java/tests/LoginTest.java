package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginSuccessfulTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("cpofo@mailto.plus");
        loginPage.inputPass("+375297106340");
        loginPage.clickSignin();
        loginPage.headerTextOnSuccessfulLogin();
    }
}
