package vnu.uet.trainingpoint.enitty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String username;
    private String password;
    private boolean active;
    private String roles;

    public User(String username, String password, boolean active, String roles) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public User(String username) {
        this.username = username;
        this.password = username;
        this.active = true;
        this.roles = "ROLE_STUDENT";
    }

    public User(String username, String roles) {
        this.username = username;
        this.password = username;
        this.active = true;
        this.roles = roles;
    }
}
