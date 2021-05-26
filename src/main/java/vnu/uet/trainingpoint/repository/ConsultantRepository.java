package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.trainingpoint.enitty.Consultant;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmail(String email);
}
