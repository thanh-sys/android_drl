package vnu.uet.trainingpoint.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String fullName;
    private String email;
    private String address;
    private LocalDate birthday;
    private String country;
    private String className;
    private String username;

    public StudentDTO(String fullName, String address, LocalDate birthday, String country, String className, String username) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.country = country;
        this.className = className;
        this.username = username;
    }

    public StudentDTO(String fullName, String address, LocalDate birthday, String country, String className) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.country = country;
        this.className = className;
    }

}
