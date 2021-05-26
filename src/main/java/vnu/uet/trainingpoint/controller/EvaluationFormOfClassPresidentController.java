package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vnu.uet.trainingpoint.service.EvaluationFormOfClassPresidentService;

@RestController
public class EvaluationFormOfClassPresidentController {

    private EvaluationFormOfClassPresidentService service;

    @Autowired
    public void setService(EvaluationFormOfClassPresidentService service) {
        this.service = service;
    }

}
