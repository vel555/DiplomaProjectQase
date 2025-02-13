package tests.api.pojos.reqest.suite;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSuiteRequest{
    private String preconditions;
    private String parentId;
    private String description;
    private String title;
}

