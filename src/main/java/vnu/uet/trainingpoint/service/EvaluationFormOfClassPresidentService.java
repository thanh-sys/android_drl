package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.repository.EvaluationFormOfClassPresidentRepository;

@Service
public class EvaluationFormOfClassPresidentService {

    private EvaluationFormOfClassPresidentRepository repo;

    @Autowired
    public void setRepo(EvaluationFormOfClassPresidentRepository repo) {
        this.repo = repo;
    }
}
