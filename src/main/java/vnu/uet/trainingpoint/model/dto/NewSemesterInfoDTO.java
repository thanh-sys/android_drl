package vnu.uet.trainingpoint.model.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewSemesterInfoDTO {

    private String year;
    private String semesterIorII;
    private boolean exists;
    private int semesterNo;
    private int deadlineDay;


}
