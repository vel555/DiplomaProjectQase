package api.steps;

import api.pojos.response.project.CreateProjectResponse;
import api.pojos.reqest.project.CreateProjectRequest;

import static api.apiSpecs.Specs.REQ_SPEC;
import static api.apiSpecs.Specs.RES_SPEC;
import static io.restassured.RestAssured.given;

public class ProjectSteps {
    public static CreateProjectResponse createProject (CreateProjectRequest projectRq){
        return given()
                .spec(REQ_SPEC)
                .body(projectRq)
                .post("/project")
                .then().spec(RES_SPEC)
                .extract().as(CreateProjectResponse.class);
    }
}
