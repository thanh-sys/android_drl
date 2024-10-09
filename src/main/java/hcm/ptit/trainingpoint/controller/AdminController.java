package hcm.ptit.trainingpoint.controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hcm.ptit.trainingpoint.enitty.Classes;
import hcm.ptit.trainingpoint.enitty.Consultant;
import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.Semester;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.enitty.User;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.ConsultantDTO;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.model.dto.NewSemesterInfoDTO;
import hcm.ptit.trainingpoint.model.dto.OverViewThisSemesterDTO;
import hcm.ptit.trainingpoint.repository.SemesterRepository;
import hcm.ptit.trainingpoint.service.ClassesService;
import hcm.ptit.trainingpoint.service.ConsultantService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.SemesterService;
import hcm.ptit.trainingpoint.service.StudentService;
import hcm.ptit.trainingpoint.service.UserService;

@Controller
public class AdminController {
	private SemesterRepository semesterRepository;
	
	private ClassesService classesService;

	private EvaluationFormService evaluationFormService;

	private StudentService studentService;

	private ConsultantService consultantService;
	
	private UserService userService;

	private SemesterService semesterService;

	
	@Autowired
	public void setSemesterService(SemesterService semesterService) {
		this.semesterService = semesterService;
	}
	
	@Autowired
	public void setSemesterRepository(SemesterRepository semesterRepository) {
		this.semesterRepository = semesterRepository;
	}

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

	// @Autowired
	// public void setUserService(UserService userService) {
	// this.userService = userService;
	// }

	@Autowired
	public void setConsultantService(ConsultantService consultantService) {
		this.consultantService = consultantService;
	}
	
	@Autowired
	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	@GetMapping("/admin")
	public String getAdmin(Model model) {
		return "admin/adminIndex";
	}

	@GetMapping("/admin/classList")
	public String getClassList(Model model) {
		model.addAttribute("list", classesService.findAll());
		return "admin/form/classList";
	}
	
	@GetMapping("/admin/classlist/delete/{id}")
	public String deleteClass(Model model,@PathVariable String classes) {
		classesService.delete(classes);
		return "admin/form/classList";
	}


	@GetMapping("/admin/studentList/{classes}")
	public String getStudentList(Model model, @PathVariable String classes) {
		List<Semester> semesters = semesterRepository.findTopByOrderBySemesterNoDesc();
//		if (!semesters.isEmpty()) {
		    Semester semester = semesters.get(0);
//		    System.out.println("Semester No: " + semester.getSemesterNo());
//		} else {s
//		    System.out.println("No semesters found.");
//		}
		List<EvaluationForm> evaluationForms = evaluationFormService
				.findByCriteria(new InputDTO(null,semester.getSemesterNo(),null, null, null, classes));

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
		return "admin/form/studentList";
	}

//    @GetMapping("/admin/studentList/{classes}/{studentID}")
//    public String viewStudentForm(@PathVariable String classes, @PathVariable String studentID, Model model) {
//        return "admin/form/viewForm";
//    }

	@GetMapping("/admin/evaluationSession")
	public String getEvaluationSession(Model model) {
		LocalDate localDate = LocalDate.now();
		int year = localDate.getYear();
		int month = localDate.getMonthValue();
		int semesterNoInYear = 1;
		// khóa năm năm học học kỳ 1 học kỳ 2 học kỳ hè
		// 62 QH2017 2017-2018 184 185 186
		// 1 QH1956 1956-1957 1 2 3
		// n QH<1956+n-1> 1956+n-1 - 1956+n 3(n-1)+1 3(n-1)+2 3(n-1)+3
		// học kỳ 184 thì SV các khóa sau vẫn còn điền được điểm rèn luyện: K62, 61, 60,
		// 59
		// 184%3= 1 184/3=61 ( học kỳ 1)
		// 185%3= 2 185/3=61 ( học kỳ 2)
		// 186%3= 0 186/3=62 ( học kỳ 3)
		if (month > 3 && month < 8) { // nếu tạo đợt đánh giá trong khoảng thời gian từ tháng 3 đến tháng 8 thì là học
										// kỳ 2
			semesterNoInYear = 2;
		}
		String yearString;
		if (semesterNoInYear == 2) {
			int temp = year - 1;
			yearString = temp + " - " + year;
		} else {
			int temp = year + 1;
			yearString = year + " - " + temp;
		}
		// 2017-2018 2018-2019
		// 185 187
		// học kỳ II học kỳ I
		// lấy mốc là năm 2018 vd là tháng 3->8 thì đang lấy phiếu điểm rèn luyện cho
		// học kỳ 2
		// (2018-1956)*3 186
		// (year-1956)*3-1 (year-1956)*3+1
		int semesterNo = semesterNoInYear == 2 ? (year - 1956) * 3 - 1 : (year - 1956) * 3 + 1;
		boolean flag = false;
		if (semesterService.findBySemesterNo(semesterNo).isPresent()) {
			flag = true;
		}
		NewSemesterInfoDTO newSemesterInfoDTO = new NewSemesterInfoDTO(yearString, semesterNoInYear == 2 ? "II" : "I",
				flag, semesterNo, 20);

		model.addAttribute("newSemesterInfoDTO", newSemesterInfoDTO);
		return "admin/session/evaluationSession";
	}

	@GetMapping("/admin/studentInfo")
	public String getStudentInfo(Model model) {
		model.addAttribute("list", studentService.findAll()); // List<Student>
		return "admin/info/studentInfoList";
	}

	@GetMapping("/admin/studentDetailInfo/{id}")
	public String getStudentDetailInfo(@PathVariable long id, Model model) {
		Student student = studentService.findUserById(id);
		model.addAttribute("student", student); // Student
		return "admin/info/studentDetailInfo";
	}

	@GetMapping("/admin/userInfo")
	public String getUserInfo(Model model) {
		model.addAttribute("list", userService.findAll());
		return "admin/info/userInfoList";
	}

	@GetMapping("/admin/userDetailInfo/{username}")
	public String getUserDetailInfo(@PathVariable String username, Model model) {
		User user = userService.findUserByUsername(username);
		model.addAttribute("user", user); // Student
		return "admin/info/userDetailInfo";
	}
	
	

	@GetMapping("/admin/statistical/all")
    public String getStatisticalAllStudent() {
        return "admin/statistical/allClassStudent";}
	
	@GetMapping("/admin/add/addClass")
	public String showFormAddClass(Model model) {
		 int currentYear = Year.now().getValue();
		    List<Integer> years = IntStream.rangeClosed(currentYear - 5, currentYear + 5)
		                                   .boxed()
		                                   .collect(Collectors.toList());

		    // Add years to the model
		    model.addAttribute("years", years);
		    
		    // Add list of advisors from the database
		    List<Consultant> consultants = consultantService.findAll();
		    model.addAttribute("consultants", consultants);
		return "admin/add/addClass";
	}
	
	@PostMapping("admin/add/addClass")
	public String addClass(@RequestParam String year, @RequestParam String major, @RequestParam String consultant,@RequestParam String classType,
			RedirectAttributes redirectAttributes) {
			Consultant consultant1=consultantService.findById(Long.valueOf(consultant));
			
			String className=classType+year.substring(year.length()-2)+major;
			
		   Classes classes1 = new Classes(className, consultant1);	

		   classesService.add(classes1);
		return "redirect:/admin/add/addClass"; // Redirect to login page or wherever suitable

	}

	@PostMapping("/saveUser")
	public String saveEmployee(@ModelAttribute("user") User userFake) {
		User user = userService.findUserByUsername(userFake.getUsername());
		user.setActive(userFake.isActive());
		user.setPassword(userFake.getPassword());
//            user.setClasses(userFake.getClasses());
//            user.setUser;
		user.setRoles(userFake.getRoles());
		
		userService.save(user);
		return "redirect:/admin/userInfo";

	}
}
