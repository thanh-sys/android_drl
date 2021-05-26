package vnu.uet.trainingpoint.enitty;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Semester {

    @Id
    @GeneratedValue
    private Long id;
    private Integer semesterNo;

    public Semester(Integer semesterNo) {
        this.semesterNo = semesterNo;
    }
}
