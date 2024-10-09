package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcm.ptit.trainingpoint.enitty.StudentQuestion;

import java.util.Optional;


public interface StudentQuestionRepository extends JpaRepository<StudentQuestion,Integer> {
	Optional<StudentQuestion> findByEvidenceImageUrl1(String evidenceImageUrl1); 
}