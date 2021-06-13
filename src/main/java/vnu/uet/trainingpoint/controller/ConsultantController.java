package vnu.uet.trainingpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.enitty.MyUserDetails;
import vnu.uet.trainingpoint.enitty.Student;
import vnu.uet.trainingpoint.model.Status;
import vnu.uet.trainingpoint.model.dto.InputDTO;
import vnu.uet.trainingpoint.service.ClassesService;
import vnu.uet.trainingpoint.service.ConsultantService;
import vnu.uet.trainingpoint.service.EvaluationFormService;
import vnu.uet.trainingpoint.service.StudentService;

@Controller
public class ConsultantController {

    private ClassesService classesService;

    private StudentService studentService;

    private ConsultantService consultantService;

    private EvaluationFormService evaluationFormService;

    @Autowired
    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
        this.evaluationFormService = evaluationFormService;
    }

    @GetMapping("/consultant")
    public String getConsultantHomePage() {
        return "consultant/consultantIndex";
    }

    @GetMapping("/consultant/studentList")
    public String getConsultantStudentList(Model model) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // danh sách theo lớp mà cố vấn đó cố vấn, kỳ hiện tại, status= chờ cố vấn duyệt
        List<EvaluationForm> evaluationForms= evaluationFormService.findByCriteria(
                new InputDTO(null, 194, Status.PENDING_APPROVAL_OF_CONSULTANT,
                        null, null, classesService.findByUsernameConsultant(user.getUsername()).get().getName() )
        );

        model.addAttribute("classes", classesService.findByUsernameConsultant(user.getUsername()).get().getName());
        model.addAttribute("evaluationForms", evaluationForms);

        return "consultant/studentList";
    }

    @GetMapping("/consultant/studentList/{username}")
    public String viewForm(@PathVariable String username, Model model) {
        // phiếu điểm của sinh viên được chọn
        model.addAttribute("evaluation", evaluationFormService.findByCriteria(
                new InputDTO(null, 194,  null, null, username, null)
        ).get(0));
        System.out.println(model.getAttribute("evaluation"));
        return "consultant/editForm";
    }

}
