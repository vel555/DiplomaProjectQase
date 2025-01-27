package ui.tests;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui.pages.LoginPage;

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
        loginPage.clickSubmit();
        loginPage.successfulLogin();
    }

    @Test
    @Story("User cannot authorize to a project")
    @Owner("Valentin")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should not be loggedIn using empty login")
    void userShouldNotBeLoggedInUsingEmptyLogin() {
        loginPage.openLoginPage();
        loginPage.inputLogin("");
        loginPage.inputPassword("+375297106340");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    @Test
    @Story("User cannot authorize to a project")
    @Owner("Valentin")
    @DisplayName("User should not be logged in using empty password")
    void userShouldNotBeLoggedInUsingEmptyPass() {
        loginPage.openLoginPage();
        loginPage.inputLogin("cpofo@mailto.plus");
        loginPage.inputPassword("");
        loginPage.clickSignInButton();
        assertEquals("This field is required", loginPage.getErrorMessage(), "Something went wrong!");
    }

    static Stream<Arguments> qaAuthNegativeTest() {
        return Stream.of(
                Arguments.of("cpofo@mailto.plus", "", "This field is required"),
                Arguments.of("", "+375297106340", "This field is required")
        );
    }
    @MethodSource("qaAuthNegativeTest")
    @ParameterizedTest(name = " negative tests (empty pass or login)")
    @DisplayName("User should not be logged in using empty password or login")
    void qaAuthNegativeTest(String login, String password, String textOfExpectedMessage) {
        loginPage.openLoginPage();
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickSignInButton();
        String textOfActualMessage = loginPage.getErrorMessagesText();
        assertEquals(textOfExpectedMessage, textOfActualMessage, "Error, something went wrong!");
    }
}
