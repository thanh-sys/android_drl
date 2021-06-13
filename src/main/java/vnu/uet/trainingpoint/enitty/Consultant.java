package vnu.uet.trainingpoint.enitty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Consultant {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String faculty;

    @OneToOne
    @JoinColumn
    private User user;

    public Consultant(String fullName, String faculty, User user) {
        this.fullName = fullName;
        this.email = user.getUsername() + "@vnu.edu.vn";
        this.faculty = faculty;
        this.user = user;
    }
}
