package steps;

import pojos.project.CreateProjectRequest;
import pojos.project.response.project.CreateResponseProject;

import static apiSpecs.Specs.REQ_SPEC;
import static apiSpecs.Specs.RES_SPEC;
import static io.restassured.RestAssured.given;

public class ProjectSteps {
    public static CreateResponseProject createResponseProject (CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateResponseProject.class);
    }
}
