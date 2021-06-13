package vnu.uet.trainingpoint.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryPointDTO {

    private String year;
    private String semester;
    private String graded;
    private int totalPoint;
    private String status;

}
