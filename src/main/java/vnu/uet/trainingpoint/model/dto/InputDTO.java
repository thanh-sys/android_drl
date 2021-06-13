package vnu.uet.trainingpoint.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vnu.uet.trainingpoint.model.Status;

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
