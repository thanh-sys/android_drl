package hcm.ptit.trainingpoint.model.dto;

import hcm.ptit.trainingpoint.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InputDTO {

    private String name;
    private Integer semester;
    private Status status;
    private Integer totalPoint;
    private String username;
    private String classes;
}
