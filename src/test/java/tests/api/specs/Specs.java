package tests.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class Specs {
    public static final RequestSpecification REQ_SPEC = with()
            .baseUri("https://api.qase.io")
            .basePath("/v1")
            .log().uri()
            .contentType(JSON)
            .header("Token","20f86833ab3793949b88f04a067c0ec368f0cf235a4977d51d5af279720fd55f");

    public static final ResponseSpecification RES_SPEC = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(SC_OK)
            .build();

}
