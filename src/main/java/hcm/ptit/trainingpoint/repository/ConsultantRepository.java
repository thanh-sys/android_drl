package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcm.ptit.trainingpoint.enitty.Consultant;

import java.util.Optional;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    Optional<Consultant> findByEmail(String email);
}
