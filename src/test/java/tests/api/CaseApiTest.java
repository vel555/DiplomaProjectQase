package tests.api;

import generators.CaseGenerator;
import generators.ProjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.api.pojos.reqest.cases.CreateCaseRequest;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.pojos.response.cases.CreateCaseResponse;
import tests.api.pojos.response.cases.DeleteCaseResponse;
import tests.api.steps.CaseSteps;
import tests.api.steps.ProjectSteps;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Api")
public class CaseApiTest {

    @Test
    @DisplayName("Case should be created")
    void caseShouldBeCreated() {
        CreateProjectRequest projectRq = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectRq);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CreateCaseResponse createCaseRs = CaseSteps.createCase(createCaseRq, projectRq.getCode());

        assertThat(createCaseRs)
                .isNotNull()
                .extracting(CreateCaseResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectRq.getCode());
    }

    @Test
    @DisplayName("Case should be deleted")
    void caseShouldBeDeleted(){
        CreateProjectRequest projectRq = ProjectGenerator.createProjectApi();
        ProjectSteps.createProject(projectRq);

        CreateCaseRequest createCaseRq = CaseGenerator.createCaseApi();
        CaseSteps.createCase(createCaseRq, projectRq.getCode());

        DeleteCaseResponse deleteCaseResponse = CaseSteps.deleteCase(projectRq.getCode(), "1");
        assertThat(deleteCaseResponse)
                .extracting(DeleteCaseResponse::isStatus)
                .isEqualTo(true);

        ProjectGenerator.deleteProjectApi(projectRq.getCode());
    }
}
