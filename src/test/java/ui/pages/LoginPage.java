package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


//@Step("Input login {login}")
    //public void inputLogin(String login){
      //  $("[name=email]").sendKeys(login);
   // }

    //@Step("Input pass: {pass}")
   // public void inputPass(String pass){
       // $("[name=password]").sendKeys(pass);
   // }

   // @Step("click submit")
    //public void clickSignin(){
      //  $("span[class=CAunhU]").click();
   // }

   // @Step("successful Login")
   // public void headerTextOnSuccessfulLogin(){
      //  $("h1[class=uA6zAY]").shouldHave(text("Projects"));
    //}
   public class LoginPage extends BasePage {
    private final SelenideElement LOGIN_INPUT = $("[name=email]");
    private final SelenideElement PASSWORD_INPUT = $("[name=password]");
    private final SelenideElement SIGN_IN_BUTTON = $("span[class=CAunhU]");
    private final ElementsCollection ERROR_MESSAGE = $$x("//small[@class = 'f75Cb_']");
    private final SelenideElement PROJECTS_TEXT = $("h1[class=uA6zAY]");


    @Step("Open login Page")
    public void openLoginPage() {
        open("/login");
    }

    @Step("Input login {login}")
    public void inputLogin(String login) {
        LOGIN_INPUT.sendKeys(login);
    }

    @Step("Input password: {password}")
    public void inputPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
    }

    @Step("Click submit")
    public void clickSubmit() {
        PASSWORD_INPUT.submit();
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        SIGN_IN_BUTTON.click();
    }

    @Step("Successful log in")
    public void successfulLogin() {
        PROJECTS_TEXT.shouldHave(text("Projects"));
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return ERROR_MESSAGE.get(0).getText();
    }

    @Step("Get error message")
    public String getErrorMessagesText() {
        return ERROR_MESSAGE.get(0).getText();
    }



}




