package hcm.ptit.trainingpoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.MyUserDetails;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.model.dto.OverViewThisSemesterDTO;
import hcm.ptit.trainingpoint.service.ClassesService;
import hcm.ptit.trainingpoint.service.ConsultantService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.StudentService;

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
                new InputDTO(null, 205, Status.PENDING_APPROVAL_OF_CONSULTANT,
                        null, null, classesService.findByUsernameConsultant(user.getUsername()).get().getName() )
        );

        model.addAttribute("classes", classesService.findByUsernameConsultant(user.getUsername()).get().getName());
        model.addAttribute("evaluationForms", evaluationForms);

        return "consultant/studentList";
    }
    
    
    @GetMapping("/consultant/classList")
    public String getClassList(Model model) {
    	 MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("list", classesService.findByUsernameConsultant1(user.getUsername()));
        return "consultant/form/classList";
    }
    
    
    @GetMapping("/consultant/studentList1/{classes}")
    public String getStudentList(Model model, @PathVariable String classes) {
    
    	 List<EvaluationForm> evaluationForms = evaluationFormService.findByCriteria(
                 new InputDTO(null, 205, null, null, null, classes)
         );
        List<OverViewThisSemesterDTO> students = new ArrayList<>();

        int totalPoint;
        String graded, username, fullName, status, position;
        for (EvaluationForm e : evaluationForms) {
        	if(e.getStudent().getUser().isActive()) {
            username = e.getStudent().getUser().getUsername();
            fullName = e.getStudent().getFullName();
            totalPoint = e.getTotalPoint();
            graded = e.getGraded();
            status = Status.getString(e.getStatus());
            position = e.getPosition();
            students.add(new OverViewThisSemesterDTO(username, fullName, graded, totalPoint, status, position));
        }
        }
        model.addAttribute("student", students);
        model.addAttribute("classes", classes); 
        return "consultant/form/studentList";
    }

    @GetMapping("/consultant/studentList/{username}")
    public String viewForm(@PathVariable String username, Model model) {
        // phiếu điểm của sinh viên được chọn
        model.addAttribute("evaluation", evaluationFormService.findByCriteria(
                new InputDTO(null, 205,  null, null, username, null)
        ).get(0));
        MyUserDetails userDetail = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("Usedetail cua nguoi dung hien tai: " + userDetail.toString());
        model.addAttribute("userDetail", userDetail);
        System.out.println(model.getAttribute("evaluation"));
        return "consultant/editForm";
    }

}
