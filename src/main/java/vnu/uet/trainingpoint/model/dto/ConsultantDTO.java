package vnu.uet.trainingpoint.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultantDTO {

    private String fullName;
    private String faculty;
    private String username;
}
