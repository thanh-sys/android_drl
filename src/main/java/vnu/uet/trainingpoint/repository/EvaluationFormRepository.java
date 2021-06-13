package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import vnu.uet.trainingpoint.enitty.EvaluationForm;

import java.util.List;
import java.util.Optional;

public interface EvaluationFormRepository extends JpaRepository<EvaluationForm, Long>,
        JpaSpecificationExecutor<EvaluationForm> {

    @Query(value = "select e from EvaluationForm  e where e.student.user.username= ?1 " +
            "and e.semester.semesterNo= ?2")
    Optional<EvaluationForm> findByUsernameAndSemester(String username, Integer semesterNo);


    @Query(value = "select e from EvaluationForm e where e.semester.semesterNo = ?1")
    List<EvaluationForm> getListBySemester(Integer semesterNo);
}
