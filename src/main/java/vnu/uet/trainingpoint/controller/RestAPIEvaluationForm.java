package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vnu.uet.trainingpoint.config.CustomLoginSuccessHandler;
import vnu.uet.trainingpoint.model.dto.EvaluationFormDTO;
import vnu.uet.trainingpoint.model.dto.InputDTO;
import vnu.uet.trainingpoint.service.EvaluationFormService;
import vnu.uet.trainingpoint.util.JwtUtil;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class RestAPIEvaluationForm {

    @Autowired
    private JwtUtil jwtTokenUtil;

    private EvaluationFormService evaluationFormService;

    private static String username;

    @Autowired
    public void setService(EvaluationFormService service) {
        this.evaluationFormService = service;
    }

//    @GetMapping("/full/{semesterNo}")
//    public List<EvaluationFormDTO> getFullBySemester(@PathVariable Integer semesterNo) {
//        return evaluationFormService.getFullEvaluationFormBySemester(semesterNo);
//    }

//    @GetMapping("/{semesterNo}/{username}")
//    public ResponseEntity<EvaluationFormDTO> find(@PathVariable String username, @PathVariable Integer semesterNo) {
//
//        RestAPIEvaluationForm.username = jwtTokenUtil.extractUsername(CustomLoginSuccessHandler.jwt);
//        System.out.println(RestAPIEvaluationForm.username);
//        return evaluationFormService.find(username, semesterNo);
//    }

//    @PutMapping("/update/{semesterNo}/{username}")
//    public ResponseEntity<EvaluationFormDTO> update(@PathVariable String username, @PathVariable Integer semesterNo,
//                                                    @RequestBody EvaluationFormDTO evaluationFormDTO) {
//        return evaluationFormService.update(username, semesterNo, evaluationFormDTO);
//    }

//    @GetMapping("/findOverView")
//    public ResponseEntity<TotalPointDTO> findTotalPoint(@RequestParam String username, Integer semester){
//        return service.findTotalPoint(username, semester);
//    }

    @PostMapping("/dynamic")
    public List<InputDTO> findTargetIsInputDTO(@RequestBody InputDTO inputDTO) {
        return evaluationFormService.findTargetIsInputDTO(inputDTO);
    }
}
