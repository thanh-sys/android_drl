package hcm.ptit.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.Semester;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.model.dto.sdi.ClientSdi;
import hcm.ptit.trainingpoint.service.ClientService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.repository.EvaluationFormRepository;
import hcm.ptit.trainingpoint.repository.SemesterRepository;
import hcm.ptit.trainingpoint.repository.StudentRepository;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @Autowired
    private EvaluationFormService evaluationFormService;


    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private EvaluationFormRepository evaluationFormRepository;
    
    @Autowired
    private SemesterRepository semesterRepository;


    @PostMapping("/create")
    public String create(Model model) {
        // Lấy danh sách tất cả sinh viên từ cơ sở dữ liệu
    	List<Semester> semesters = semesterRepository.findTopByOrderBySemesterNoDesc();
//		if (!semesters.isEmpty()) {
		    Semester semester = semesters.get(0);
//		    System.out.println("Semester No: " + semester.getSemesterNo());
//		} else {s
//		    System.out.println("No semesters found.");
//		}
		List<EvaluationForm> evaluationForms = evaluationFormService
				.findByCriteria(new InputDTO(null,semester.getSemesterNo(),null, null, null,null));
        List<Student> students = studentRepository.findAll();

        // Gửi email đến tất cả sinh viên
        for (EvaluationForm evaluationForm : evaluationForms) {
        	if(evaluationForm.getStatus() == Status.NEED_STUDENT_FILL) {
            ClientSdi sdi = new ClientSdi();
            sdi.setName(evaluationForm.getStudent().getFullName());
            sdi.setEmail(evaluationForm.getStudent().getEmail());
            sdi.setUsername(evaluationForm.getStudent().getUser().getUsername());

            // Gửi email cho từng sinh viên 
            clientService.create(sdi);}
        }

        // Thông báo email đã gửi thành công
        model.addAttribute("message", "Email đã được gửi thành công!");

        // Trả về trang adminIndex
        return "redirect:/admin";
    }
}