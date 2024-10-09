package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcm.ptit.trainingpoint.enitty.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

}
