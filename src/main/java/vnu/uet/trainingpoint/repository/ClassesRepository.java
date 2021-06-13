package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vnu.uet.trainingpoint.enitty.Classes;

import java.util.Optional;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

    Optional<Classes> getByName(String name);

    @Query("select c from Classes c where c.consultant.user.username=?1")
    Optional<Classes> findByUsernameConsultant(String username);
}
