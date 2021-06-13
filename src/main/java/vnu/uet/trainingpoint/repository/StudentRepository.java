package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vnu.uet.trainingpoint.enitty.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    @Query(value = "select s from Student s where s.classes.name like %?1%" +
            "or s.classes.name like %?2%" +
            "or s.classes.name like %?3%" +
            "or s.classes.name like %?4%")
    List<Student> getListStudentCreatedForm(Integer year1, Integer year2, Integer year3, Integer year4);

    @Query(value = "select s from Student s where s.classes.name=?1")
    List<Student> findAllByClasses(String classes);

    @Query(value = "select s from Student  s where  s.user.username= ?1 ")
    Student findByUsername(String username);
}
