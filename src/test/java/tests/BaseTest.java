package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

public class BaseTest {

    @BeforeAll
    static void authorizationPage() {
        Configuration.baseUrl = "https://app.qase.io";
        Configuration.browserSize = "1920x1080";}
}
