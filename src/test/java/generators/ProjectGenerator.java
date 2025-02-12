package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.reqest.project.CreateProjectRequest;
import tests.api.steps.ProjectSteps;


public class ProjectGenerator {

    static Faker faker = new Faker();

            public static CreateProjectRequest createProjectApi(){
        return CreateProjectRequest.builder()
                .title(faker.name().firstName())
                .code(faker.name().firstName().toUpperCase())
                .description(faker.chuckNorris().fact())
                .access("all")
                .build();

            }

    public static void deleteProjectApi(String code){
        ProjectSteps.deleteProject(code);
    }
}

