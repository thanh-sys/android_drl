package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hcm.ptit.trainingpoint.enitty.Semester;

import java.util.List;
import java.util.Optional;

public interface SemesterRepository extends JpaRepository<Semester, Long> {

    Optional<Semester> findBySemesterNo(Integer semesterNo);
    
    @Query("SELECT s FROM Semester s ORDER BY s.semesterNo DESC")
    List<Semester> findTopByOrderBySemesterNoDesc();
    

}
