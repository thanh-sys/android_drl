package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vnu.uet.trainingpoint.config.CustomLoginSuccessHandler;
import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.enitty.MyUserDetails;
import vnu.uet.trainingpoint.enitty.Student;
import vnu.uet.trainingpoint.model.Status;
import vnu.uet.trainingpoint.model.dto.HistoryPointDTO;
import vnu.uet.trainingpoint.model.dto.InputDTO;
import vnu.uet.trainingpoint.model.dto.StudentDTO;
import vnu.uet.trainingpoint.service.EvaluationFormService;
import vnu.uet.trainingpoint.service.StudentService;
import vnu.uet.trainingpoint.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    private UserService userService;

    private EvaluationFormService evaluationFormService;

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
        this.evaluationFormService = evaluationFormService;
    }

    @GetMapping("/student")
    public String studentHomePage() {
        return "student/studentIndex";
    }

    @GetMapping("/student/editForm")
    public String editForm(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<EvaluationForm> evaluationForm = evaluationFormService.findByCriteria(
                new InputDTO(null, 194, null, null, user.getUsername(), null)
        );

        if(evaluationForm.isEmpty()){
            model.addAttribute("exists", false);
        }else{
            model.addAttribute("exists", true);
            model.addAttribute("evaluationForm", evaluationForm.get(0));
        }

        return "student/editForm";
    }

    @GetMapping("/student/studentPoint")
    public String studentPoint(Model model) {
        List<EvaluationForm> evaluationFormList = evaluationFormService.findByCriteria(
                new InputDTO(null, null, null,
                        null, CustomLoginSuccessHandler.sessionUsername, null)
        );

        List<HistoryPointDTO> historyPointDTOS = new ArrayList<>();

        int totalPoint;
        String semester, graded, year, status;
        for (EvaluationForm e : evaluationFormList) {
            semester = e.getSemesterInYear();
            year = e.getYear();
            totalPoint = e.getTotalPoint();
            graded = e.getGraded();
            status = Status.getString(e.getStatus());
            historyPointDTOS.add(new HistoryPointDTO(year, semester, graded, totalPoint, status));
        }
        model.addAttribute("listEvaluation", historyPointDTOS);
        return "student/studentPoint";
    }

    @PostMapping("/saveStudent")
    public String saveEmployee(@ModelAttribute("student") Student studentFake) {
        Student student = studentService.findUserById(studentFake.getId());
        student.setFullName(studentFake.getFullName());
        student.setEmail(studentFake.getEmail());
//        student.setClasses(studentFake.getClasses());
//        student.setUser;
        student.setCountry(studentFake.getCountry());
        student.setAddress(studentFake.getAddress());
        studentService.save(student);
        return "redirect:/admin/studentInfo";
    }
}
