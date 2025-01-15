package api;

import generators.ProjectGenerator;
import org.junit.jupiter.api.Test;
import pojos.project.CreateProjectRequest;
import pojos.project.response.project.CreateResponseProject;
import pojos.project.response.project.Result;
import steps.ProjectSteps;

import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectApiTest {

    @Test
    void projectShouldBeCreated(){
        CreateProjectRequest createProjectRq = ProjectGenerator.createProjectApi();
        CreateResponseProject createRsProject = ProjectSteps.createResponseProject(CreateProjectRequest);

        assertThat(createRsProject)
                .isNotNull()
                .extracting(CreateResponseProject::getResult)
                .extracting(Result::getCode)
                .isEqualTo(createProjectRq.getCode());
    }
}
