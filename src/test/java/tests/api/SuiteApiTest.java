package tests.api;

import generators.ProjectGenerator;
import generators.SuiteGenerator;
import org.junit.jupiter.api.*;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.pojos.reqest.suite.CreateSuiteRequest;
import tests.api.pojos.response.suite.CreateSuiteResponse;
import tests.api.pojos.response.suite.DeleteSuiteResponse;
import tests.api.steps.ProjectSteps;
import tests.api.steps.SuiteSteps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("API")
@DisplayName("Suite API tests")
public class SuiteApiTest {
    CreateProjectRequest projectRq = ProjectGenerator.createProjectApi();

    @BeforeEach
    @DisplayName("Create project")
    public void precondition(){
        ProjectSteps.createProject(projectRq);
    }
    @Test
    @DisplayName("Create suite")
    public void suiteShouldBeCreated(){

        CreateSuiteRequest suiteRq = SuiteGenerator.createSuiteApi();
        CreateSuiteResponse suiteRs = SuiteSteps.createSuite(suiteRq, projectRq.getCode());

        assertThat(suiteRs)
                .isNotNull()
                .extracting(CreateSuiteResponse::isStatus)
                .isEqualTo(true);
    }

    @Test
    @DisplayName("Delete suite")
    public void suiteShouldBeDeleted(){

        CreateSuiteRequest suiteRq = SuiteGenerator.createSuiteApi();
        CreateSuiteResponse suiteRs = SuiteSteps.createSuite(suiteRq, projectRq.getCode());

        Integer suiteId = SuiteSteps.getSuiteId(projectRq.getCode());
        DeleteSuiteResponse delSuiteRs = SuiteSteps.deleteSuite(projectRq.getCode(),suiteId);

        assertThat(delSuiteRs)
                .isNotNull()
                .extracting(DeleteSuiteResponse::getResult)
                .extracting(Result::getId)
                .isEqualTo(suiteRs.getResult().getId());
    }

    @AfterEach
    @DisplayName("Delete project")
    void postondition(){
        ProjectSteps.deleteProject(projectRq.getCode());
    }
}

