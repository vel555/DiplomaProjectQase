package tests.api;

import generators.ProjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.pojos.reqest.project.delete.DeleteProjectResponse;
import tests.api.pojos.response.project.CreateProjectResponse;
import tests.api.pojos.response.project.Result;
import tests.api.steps.ProjectSteps;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ProjectApiTest {

    @Test
    @DisplayName("Project is created")
    void projectShouldBeCreated(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateProjectResponse createProjectRs = ProjectSteps.createProject(createProjectRq);

        assertThat(createProjectRs)
                .isNotNull()
                .extracting(CreateProjectResponse::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());

        ProjectGenerator.deleteProjectApi(createProjectRq.getCode());
    }
    @Test
    @DisplayName("Project should be deleted")
    void projectShouldBeDeleted(){
        CreateProjectRequest projectToDel = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectToDel);
        DeleteProjectResponse deleteProjectResponse = ProjectSteps.deleteProject(projectToDel.getCode());

        assertThat(deleteProjectResponse)
                .extracting(DeleteProjectResponse::isStatus)
                .isEqualTo(true);
    }
}

