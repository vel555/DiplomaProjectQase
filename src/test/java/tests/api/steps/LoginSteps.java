package tests.api.steps;

import io.qameta.allure.Step;
import tests.ui.pages.LoginPage;

public class LoginSteps {

    static LoginPage loginPage = new LoginPage();

    @Step("Authorised")
    public static void authInApp(String login, String password){
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSignInButton();
    }

}
