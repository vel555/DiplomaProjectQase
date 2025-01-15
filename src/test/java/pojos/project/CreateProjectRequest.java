package pojos.project;

import groovy.transform.builder.Builder;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateProjectRequest {
    private String title;
    private String code;
    private String description;
    private String access;
    private String group;
}
