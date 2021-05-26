package vnu.uet.trainingpoint.enitty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String address;
    private LocalDate birthday;
    private String country;

    @JoinColumn //default create FK: user_id
    @OneToOne
    private User user;

    @ManyToOne
    @JoinColumn
    private Classes classes;

    public Student() {

    }

    public Student(String fullName,
                   String address,
                   LocalDate birthday,
                   String country,
                   User user,
                   Classes classes) {
        this.fullName = fullName;
        this.email = user.getUsername() + "@vnu.edu.vn";
        this.address = address;
        this.birthday = birthday;
        this.country = country;
        this.user = user;
        this.classes = classes;
    }

}
