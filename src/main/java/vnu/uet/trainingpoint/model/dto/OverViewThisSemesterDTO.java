package vnu.uet.trainingpoint.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OverViewThisSemesterDTO {

    private String username;
    private String fullName;
    private String graded;
    private int totalPoint;
    private String status;
    private String position;

}
