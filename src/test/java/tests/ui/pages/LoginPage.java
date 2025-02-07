package tests.ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {

    @Step("Open Login Page")
    public void openLoginPage(){
        open("/login");
    }

    @Step("Input login {login}")
    public void inputLogin(String login){
        $("[name=email]").sendKeys(login);
    }

    @Step("Input pass: {pass}")
    public void inputPass(String pass){
        $("[name=password]").sendKeys(pass);
    }

    @Step("click submit")
    public void clickSignin(){
        $("span[class=CAunhU]").click();
    }

    @Step("successful Login")
    public void headerTextOnSuccessfulLogin(){
        $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    }
}
