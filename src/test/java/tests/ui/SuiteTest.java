package tests.ui;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.pojos.reqest.suite.CreateSuiteRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.api.steps.LoginSteps.authInApp;


@Tag("UI")
@DisplayName("Suite UI tests")
public class SuiteTest extends BaseTest {

    @Test
    @Story("User can create a suite")
    @Owner("Valentin")
    @DisplayName("Creation of suite with valid letters as data")
    public void createSuiteTest() {
        authInApp("cpofo@mailto.plus","+375297106340");
        projectPage.openProjectPage();
        projectPage.projectPageIsOpened();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = ProjectGenerator.createProjectApi();
        projectPage.inputProjectName(project.getTitle());
        suitePage.clickCreateNewSuiteButton();
        suitePage.createNewSuite();
        CreateSuiteRequest suite = SuiteGenerator.createSuiteUI();
        String suiteName = suite.getTitle();
        suitePage.inputSuiteName(suiteName);
        suitePage.createSuite();
        assertEquals(suiteName, suitePage.receiveSuiteName(), "error!");

        ProjectGenerator.deleteProjectApi(project.getTitle().toUpperCase());
    }
}