package hcm.ptit.trainingpoint.controller;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcm.ptit.trainingpoint.config.CustomLoginSuccessHandler;
import hcm.ptit.trainingpoint.enitty.Classes;
import hcm.ptit.trainingpoint.enitty.Consultant;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.enitty.User;
import hcm.ptit.trainingpoint.model.dto.ConsultantDTO;
import hcm.ptit.trainingpoint.model.dto.StudentDTO;
import hcm.ptit.trainingpoint.service.ClassesService;
import hcm.ptit.trainingpoint.service.ConsultantService;
import hcm.ptit.trainingpoint.service.SemesterService;
import hcm.ptit.trainingpoint.service.StudentService;
import hcm.ptit.trainingpoint.service.UserService;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
//	private UserService userService;

	private ClassesService classesService;

	private StudentService studentService;
	
	private ConsultantService consultantService;

	@Autowired
	public void setConsultanService(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}

	@Autowired
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}
	
	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService ;
	}

	@GetMapping(value = { "/login", "/" })
	public String showLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "account/login";
		}
		return "redirect:/";
	}

	@GetMapping("/register/consultantRegister")
	public String getRegister() {
		return "account/consultantRegister";
	}

	@PostMapping("/register/consultantRegister")
	public String registerUser(@RequestParam String email, @RequestParam String fullName, @RequestParam String faculty,
			RedirectAttributes redirectAttributes) {

		String[] parts = email.split("@");
		String username = parts[0];

//			User userConsultant1 = new User(username, "ROLE_CONSULTANT");
		ConsultantDTO consultant1 = new ConsultantDTO(fullName, faculty, username);

		try {
//				userService.add(userConsultant1); // Ensure this method handles validation and saving
			consultantService.add(consultant1);
			redirectAttributes.addFlashAttribute("message", "Đăng ký thành công!");
		} catch (Exception e) {
			System.out.print(consultant1.getFullName());
			System.out.print(consultant1.getFaculty());
			System.out.print(consultant1.getUsername());
			redirectAttributes.addFlashAttribute("error", "Đăng ký thất bại: " + e.getMessage());
		}

		return "redirect:/admin/userInfo"; // Redirect to login page or wherever suitable

	}

	@GetMapping("/register/studentRegister")
	public String showStudentRegister(Model model) {
		List<Classes> classes = classesService.findAll();
		model.addAttribute("classes", classes);
		return "account/studentRegister";
	}

	@PostMapping("/register/studentRegister")
	public String studentRegister(@RequestParam String address, @RequestParam String birthdate,
			@RequestParam String birthplace, @RequestParam String email, @RequestParam String fullName,
			@RequestParam String classes, @RequestParam String role,RedirectAttributes redirectAttributes) {

		String[] parts = email.split("@");
		String username = parts[0];
		StudentDTO student1 = new StudentDTO(fullName, email, address, LocalDate.parse(birthdate), birthplace, classes, username,role);


		try {
//				userService.add(userConsultant1); // Ensure this method handles validation and saving
			studentService.add(student1);
			redirectAttributes.addFlashAttribute("message", "Đăng ký thành công!");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "Đăng ký thất bại: " + e.getMessage());
		}

		return "redirect:/admin/userInfo"; // Redirect to login page or wherever suitable

	}
	
	@GetMapping("/register/studentRegisterByExcel")
	public String showStudentRegisterByExcel(Model model) {
		List<Classes> classes = classesService.findAll();
		model.addAttribute("classes", classes);
		return "account/studentRegisterByExcel";
	}
	
	@PostMapping("/register/studentRegisterByExcel")
	public String studentRegister(@RequestParam("file")MultipartFile file) {
		studentService.addByExcel(file);
		return "redirect:/admin/userInfo"; // Redirect to login page or wherever suitable

	}
	

}
