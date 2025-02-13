package generators;

import com.github.javafaker.Faker;
import tests.api.pojos.reqest.suite.CreateSuiteRequest;

public class SuiteGenerator {
    static Faker faker = new Faker();
    CreateSuiteRequest createSuiteRq = SuiteGenerator.createSuiteApi();

    public static CreateSuiteRequest createSuiteApi() {
        return CreateSuiteRequest.builder()
                .title(faker.beer().name())
                .description(faker.chuckNorris().fact())
                .preconditions(faker.chuckNorris().fact())
                .build();
    }

    public static CreateSuiteRequest createSuiteUI() {
        return CreateSuiteRequest.builder()
                .title(faker.name().firstName())
                .description(faker.chuckNorris().fact())
                .preconditions(faker.chuckNorris().fact())
                .build();
    }

}

