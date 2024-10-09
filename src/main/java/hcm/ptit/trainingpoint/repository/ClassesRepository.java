package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hcm.ptit.trainingpoint.enitty.Classes;

import java.util.List;
import java.util.Optional;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

    Optional<Classes> getByName(String name);

    @Query("select c from Classes c where c.consultant.user.username=?1")
    Optional<Classes> findByUsernameConsultant(String username);
    
    @Query("select c from Classes c where c.consultant.user.username = ?1")
    List<Classes> findByUsernameConsultant1(String username);
    
    @Query("select c from Classes c where c.consultant.user.username = ?1")
    String findByUsernameConsultant2(String username);
}
