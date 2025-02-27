package tests.ui;

import generators.CaseGenerator;
import generators.ProjectGenerator;
import generators.SuiteGenerator;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.reqest.cases.CreateCaseRequest;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.pojos.reqest.suite.CreateSuiteRequest;

import static tests.api.steps.LoginSteps.authInApp;

public class CaseTest extends BaseTest {

    @Test
    @Story("User can create a case")
    @Owner("Valentin")
    @DisplayName("Creation of case with valid random data")
    public void createCaseWithRandomDataTest() {
        projectPage.openLoginPage();
        authInApp("cpofo@mailto.plus","+375297106340");
        projectPage.projectPageIsOpened();
        projectPage.createNewProject();
        CreateProjectRequest project = ProjectGenerator.createProjectApi();
        projectPage.createProject();
        suitePage.createNewSuite();
        CreateSuiteRequest suite = SuiteGenerator.createSuiteApi();
        String suiteName = suite.getTitle();
        suitePage.inputSuiteName(suiteName);
        suitePage.createSuite();
        casePage.createNewCase();
        CreateCaseRequest caseTest = CaseGenerator.createCaseApi();
        String caseName = caseTest.getTitle();
        casePage.inputCaseName(caseName);
        casePage.createCase();
        Assertions.assertEquals(caseName, casePage.receiveCaseName(), "error!");
        ProjectGenerator.deleteProjectApi(project.getTitle().toUpperCase());
    }
}
