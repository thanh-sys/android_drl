package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.trainingpoint.enitty.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

}
