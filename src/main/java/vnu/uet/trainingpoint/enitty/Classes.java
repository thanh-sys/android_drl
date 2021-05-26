package vnu.uet.trainingpoint.enitty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Classes {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Consultant consultant;

    public Classes(String name, Consultant consultant) {
        this.name = name;
        this.consultant = consultant;
    }
}
