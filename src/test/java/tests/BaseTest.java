package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import generators.ProjectGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import tests.ui.pages.LoginPage;
import tests.ui.pages.ProjectPage;
import tests.ui.pages.SuitePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected LoginPage loginPage = new LoginPage();
    protected ProjectPage projectsPage = new ProjectPage();
    protected SuitePage suitePage = new SuitePage();
    protected   ProjectGenerator projectGenerator = new ProjectGenerator();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pollingInterval = 200;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void afterEach(){
        closeWebDriver();
    }
}
