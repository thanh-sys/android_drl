package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.EvaluationFormOfClassPresident;
import vnu.uet.trainingpoint.model.dto.EvaluationFormOfClassPresidentDTO;
import vnu.uet.trainingpoint.repository.EvaluationFormOfClassPresidentRepository;

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
