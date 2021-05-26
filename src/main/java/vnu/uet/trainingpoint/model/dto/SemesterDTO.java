package vnu.uet.trainingpoint.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SemesterDTO {

    private Integer semesterNo;

    public SemesterDTO(Integer semesterNo) {
        this.semesterNo = semesterNo;
    }
}
