package hcm.ptit.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import hcm.ptit.trainingpoint.config.CustomLoginSuccessHandler;
import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.MyUserDetails;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.HistoryPointDTO;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.model.dto.StudentDTO;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.StudentService;
import hcm.ptit.trainingpoint.service.UserService;

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

		System.out.println();
		List<EvaluationForm> evaluationForm = evaluationFormService
				.findByCriteria(new InputDTO(null, 205, null, null, user.getUsername(), null));

		if (evaluationForm.isEmpty()) {
			model.addAttribute("exists", false);
		} else {
			model.addAttribute("exists", true);
			model.addAttribute("evaluationForm", evaluationForm.get(0));
		}

		return "student/editForm";
	}

	@GetMapping("/student/studentPoint")
	public String studentPoint(Model model) {
		List<EvaluationForm> evaluationFormList = evaluationFormService
				.findByCriteria(new InputDTO(null, null, null, null, CustomLoginSuccessHandler.sessionUsername, null));
		System.out.println(CustomLoginSuccessHandler.sessionUsername);
		List<HistoryPointDTO> historyPointDTOS = new ArrayList<>();

		int totalPoint;

		String semester, graded, year, status, username;
		for (EvaluationForm e : evaluationFormList) {
			semester = e.getSemesterInYear();
			year = e.getYear();
			totalPoint = e.getTotalPoint();
			graded = e.getGraded();
			status = Status.getString(e.getStatus());
			username = e.getStudent().getUser().getUsername();
			historyPointDTOS.add(new HistoryPointDTO(year, semester, graded, totalPoint, status, username));
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

	@GetMapping("/student/studentList/{username}")
    public String viewForm(@PathVariable String username, Model model) {
        // phiếu điểm của sinh viên được chọn
        model.addAttribute("evaluation", evaluationFormService.findByCriteria(
                new InputDTO(null, 205,  null, null, username, null)
        ).get(0));
        System.out.println(model.getAttribute("evaluation"));
        return "student/review";
    }

	
    
}
