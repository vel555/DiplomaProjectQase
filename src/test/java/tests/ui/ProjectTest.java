package tests.ui;

import generators.ProjectGenerator;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.steps.ProjectSteps;

import static generators.ProjectGenerator.createProjectApi;
import static tests.api.steps.LoginSteps.authInApp;

public class ProjectTest extends BaseTest {

    @Test
    @Story("Create a project")
    @Owner("Valentin")
    @DisplayName("Creation of Project with valid data")
    public void createProjectTest() {
        authInApp("cpofo@mailto.plus","+375297106340");
        projectPage.openProjectPage();
        projectPage.clickCreateNewProjectButton();
        CreateProjectRequest project = createProjectApi();
        projectPage.create(project);
        projectPage.projectPageIsOpened();

        ProjectGenerator.deleteProjectApi(project.getCode());
    }

    @Test
    @Owner("Valentin")
    @DisplayName("Deletion of the Project")
    public void DeleteProjectTest() {
        ProjectSteps.createProject(createProjectApi());
        loginPage.openLoginPage();
        authInApp("cpofo@mailto.plus", "+375297106340");
        projectPage.openProjectPage();
        projectPage.clicDots();
        projectPage.deleteButton();
        projectPage.deleteProject();
        projectPage.assertThatProjectDeleted();
    }
}
