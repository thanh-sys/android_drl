package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.model.dto.EvaluationFormDTO;
import vnu.uet.trainingpoint.service.EvaluationFormService;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationFormController {

    private EvaluationFormService service;

    @Autowired
    public void setService(EvaluationFormService service) {
        this.service = service;
    }

    @GetMapping("/full/{semesterNo}")
    public List<EvaluationFormDTO> getFullBySemester(@PathVariable Integer semesterNo){
        return service.getFullEvaluationFormBySemester(semesterNo);
    }
}
