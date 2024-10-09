package hcm.ptit.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.EvaluationFormOfClassPresident;
import hcm.ptit.trainingpoint.model.dto.EvaluationFormOfClassPresidentDTO;
import hcm.ptit.trainingpoint.repository.EvaluationFormOfClassPresidentRepository;

@Service
public class EvaluationFormOfClassPresidentService {

    private EvaluationFormOfClassPresidentRepository repo;

    @Autowired
    public void setRepo(EvaluationFormOfClassPresidentRepository repo) {
        this.repo = repo;
    }


    public void save(EvaluationFormOfClassPresident evaluationFormOfClassPresident){
        repo.save(evaluationFormOfClassPresident);
    }

}
