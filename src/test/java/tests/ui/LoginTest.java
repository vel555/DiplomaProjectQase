package tests.ui;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.BaseTest;
import tests.ui.pages.LoginPage;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @Owner("Valentin")
    public void loginSuccessfulTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        loginPage.openLoginPage();
        loginPage.inputLogin("cpofo@mailto.plus");
        loginPage.inputPassword("+375297106340");
        loginPage.clickSignInButton();
        loginPage.successfulLogin();
    }

    static Stream<Arguments> negativeDataEntryDuringAuthorization() {
        return Stream.of(
                Arguments.of("cpofo@mailto.plus", "", "This field is required"),
                Arguments.of("", "+375297106340", "This field is required")
        );
    }

    @MethodSource("negativeDataEntryDuringAuthorization")
    @ParameterizedTest(name = "Qaseio negative tests  (empty password or login)")
    @DisplayName("User does not enter login or password during authorization")
    void negativeDataEntryDuringAuthorization(String login, String password, String textOfExpectedMessage) {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSignInButton();
        String textOfActualMessage = loginPage.getErrorMessagesText();
        assertEquals(textOfExpectedMessage, textOfActualMessage, "Error, something went wrong!");
    }
}
