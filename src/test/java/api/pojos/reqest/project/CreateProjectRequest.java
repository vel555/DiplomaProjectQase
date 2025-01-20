package api.pojos.reqest.project;


import lombok.AllArgsConstructor;
import lombok.Builder;
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
