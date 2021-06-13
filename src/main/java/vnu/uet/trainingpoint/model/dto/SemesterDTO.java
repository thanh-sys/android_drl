package vnu.uet.trainingpoint.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class SemesterDTO {

    private Integer semesterNo;
    private LocalDate deadline;

    public SemesterDTO(Integer semesterNo, LocalDate deadline) {
        this.semesterNo = semesterNo;
        this.deadline = deadline;
    }

    public SemesterDTO(Integer semesterNo) {
        this.semesterNo = semesterNo;
    }
}
