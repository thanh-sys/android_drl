package vnu.uet.trainingpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import vnu.uet.trainingpoint.config.CustomLoginSuccessHandler;
import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.enitty.MyUserDetails;
import vnu.uet.trainingpoint.enitty.Student;
import vnu.uet.trainingpoint.model.Status;
import vnu.uet.trainingpoint.model.dto.HistoryPointDTO;
import vnu.uet.trainingpoint.model.dto.InputDTO;
import vnu.uet.trainingpoint.service.ClassesService;
import vnu.uet.trainingpoint.service.EvaluationFormService;
import vnu.uet.trainingpoint.service.StudentService;

@Controller
public class MonitorController {

    private StudentService studentService;

    private ClassesService classesService;

    private EvaluationFormService evaluationFormService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    @Autowired
    public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
        this.evaluationFormService = evaluationFormService;
    }

    @GetMapping("/monitor")
    public String monitorHomePage() {
        return "monitor/monitorIndex";
    }

    @GetMapping("/monitor/editForm")
    public String editForm(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        List<EvaluationForm> evaluationForm = evaluationFormService.findByCriteria(
                new InputDTO(null, 194, null, null, user.getUsername(), null)
        );

        if(evaluationForm.isEmpty()){
            model.addAttribute("exists", false);
        }else{
            model.addAttribute("exists", true);
            model.addAttribute("evaluationForm", evaluationForm.get(0));
        }
        return "monitor/editPointOfMyself";
    }

    @GetMapping("/monitor/studentPoint")
    public String studentPoint(Model model) {
        List<EvaluationForm> evaluationFormList = evaluationFormService.findByCriteria(
                new InputDTO(null, null, null, null,
                        CustomLoginSuccessHandler.sessionUsername, null)
        );

        List<HistoryPointDTO> historyPointDTOS = new ArrayList<>();

        int semesterNo, startYear, endYear, totalPoint;
        String semester, graded, year, status;
        for (EvaluationForm e : evaluationFormList) {
            semesterNo = e.getSemester().getSemesterNo();
            semester = semesterNo % 3 != 1 ? "I" : "II";
            startYear = semesterNo / 3 + 1956;
            endYear = startYear + 1;
            year = startYear + " - " + endYear;
            totalPoint = e.getTotalPoint();
            if (totalPoint >= 90) {
                graded = "Xuất sắc";
            } else if (totalPoint >= 80 && totalPoint < 90) {
                graded = "Giỏi";
            } else if (totalPoint >= 65 && totalPoint < 80) {
                graded = "Khá";
            } else if (totalPoint >= 50 && totalPoint < 65) {
                graded = "Trung Bình";
            } else if (totalPoint >= 35 && totalPoint < 50) {
                graded = "Yếu";
            } else {
                graded = "Kém";
            }
            status = Status.getString(e.getStatus());
            historyPointDTOS.add(new HistoryPointDTO(year, semester, graded, totalPoint, status));
        }
        model.addAttribute("listEvaluationOfMonitor", historyPointDTOS);
        return "monitor/studentPoint";
    }

    @GetMapping("/monitor/classList")
    public String getClassList(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<EvaluationForm> evaluationForms= evaluationFormService.findByCriteria(
                new InputDTO(null, 194, Status.PENDING_APPROVAL_OF_CLASS_PRESIDENT, null,
                        null, studentService.findByUsername(user.getUsername()).getClasses().getName())
        );
        model.addAttribute("evaluationForms", evaluationForms);
        return "monitor/classList";
    }

    @GetMapping("/monitor/classList/edit/{username}")
    public String editStudentPoint(@PathVariable String username, Model model) {

        model.addAttribute("evaluation", evaluationFormService.findByCriteria(
                new InputDTO(null, 194, null, null, username, null)
        ).get(0));

        return "monitor/editForm";
    }
}
