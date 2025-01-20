package generators;

import com.github.javafaker.Faker;
import api.pojos.reqest.project.CreateProjectRequest;


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
}
