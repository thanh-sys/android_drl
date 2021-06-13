package vnu.uet.trainingpoint.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vnu.uet.trainingpoint.model.dto.NewSemesterInfoDTO;
import vnu.uet.trainingpoint.model.dto.SemesterDTO;
import vnu.uet.trainingpoint.service.SemesterService;

import java.time.LocalDate;

@Controller
public class SemesterController {

    SemesterService semesterService;

    @Autowired
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @PostMapping("/saveNewSemester")
    public String saveNewSemester(@ModelAttribute("newSemesterInfoDTO") NewSemesterInfoDTO data){
        System.out.println(data);
        LocalDate now=LocalDate.now();
        semesterService.add(new SemesterDTO(data.getSemesterNo(), now.plusDays(data.getDeadlineDay())));
        System.setProperty("cache.deadline", semesterService.getDeadline(data.getSemesterNo()));
        //save
        return "redirect:/admin/evaluationSession";
    }
}
