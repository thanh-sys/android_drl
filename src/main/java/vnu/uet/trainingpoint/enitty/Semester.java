package vnu.uet.trainingpoint.enitty;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Semester {

    @Id
    @GeneratedValue
    private Long id;
    private Integer semesterNo;

    private LocalDate deadline;

    public Semester(Integer semesterNo, LocalDate deadline) {
        this.semesterNo = semesterNo;
        this.deadline = deadline;
    }
}
