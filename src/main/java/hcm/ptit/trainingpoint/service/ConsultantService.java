package hcm.ptit.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.Consultant;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.enitty.User;
import hcm.ptit.trainingpoint.model.dto.ClassesDTO;
import hcm.ptit.trainingpoint.model.dto.ConsultantDTO;
import hcm.ptit.trainingpoint.repository.ConsultantRepository;
import hcm.ptit.trainingpoint.repository.UserRepository;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultantService {

	private ConsultantRepository consultantRepository;

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setConsultantRepository(ConsultantRepository consultantRepository) {
		this.consultantRepository = consultantRepository;
	}

	public List<Consultant> findAll() {
		return consultantRepository.findAll();
	}

	public String getNameByUsername(String username) {
		return consultantRepository.findByEmail(username + "@student.ptithcm.edu.vn").get().getFullName();
	}

	public String getFacultyByUsername(String username) {
		return consultantRepository.findByEmail(username + "@student.ptithcm.edu.vn").get().getFaculty();
	}

	public Consultant findById(Long id) {
		Optional<Consultant> consultantOptional = consultantRepository.findById(id);
		return consultantOptional.orElse(null);
	}

	public ResponseEntity<ConsultantDTO> find(Long id) {
		Optional<Consultant> consultantOptional = consultantRepository.findById(id);
		return consultantOptional
				.map(consultant -> new ResponseEntity<>(new ConsultantDTO(consultant.getFullName(),
						consultant.getFaculty(), consultant.getUser().getUsername()), HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<ConsultantDTO> add(ConsultantDTO consultantDTO) {

		if (!consultantRepository.findByEmail(consultantDTO.getUsername() + "@student.ptithcm.edu.vn").isPresent()) {
			// kiểm tra tồn tại trong DB chưa?
			// nếu chưa thì tạo tài khoản và consultant và lưu vào DB
			User user = new User(consultantDTO.getUsername(), "ROLE_CONSULTANT");
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			Consultant consultant = new Consultant(consultantDTO.getFullName(), consultantDTO.getFaculty(), user);
			consultantRepository.save(consultant);
			return new ResponseEntity<>(new ConsultantDTO(consultant.getFullName(), consultant.getFaculty(),
					consultant.getUser().getUsername()), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ConsultantDTO> update(Long id, ConsultantDTO consultantDTO) {
		Optional<Consultant> consultantOptional = consultantRepository.findById(id);
		return consultantOptional.map(consultant -> {
			consultant.setFullName(consultantDTO.getFullName());
			consultant.setFaculty(consultantDTO.getFaculty());
			Optional<User> userOptional = userRepository.findById(consultantDTO.getUsername());
			// nếu có nhập username
			// nếu username chưa tồn tại trong DB
			if (!userRepository.existsById(consultantDTO.getUsername())) {
//                    userRepository.delete(student.getUser());// xóa user cũ
				User user = new User(consultantDTO.getUsername(), "ROLE_CONSULTANT");
				userRepository.save(user);// thêm user mới
				consultant.setUser(user);
				consultant.setEmail(user.getUsername() + "@student.ptithcm.edu.vn");
			}
			consultantRepository.save(consultant);
			return new ResponseEntity<>(new ConsultantDTO(consultant.getFullName(), consultant.getFaculty(),
					consultant.getUser().getUsername()), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public ResponseEntity<ConsultantDTO> delete(Long id) {
		Optional<Consultant> consultantOptional = consultantRepository.findById(id);
		return consultantOptional.map(consultant -> {
			consultantRepository.delete(consultant);
			userRepository.delete(consultant.getUser());
			return new ResponseEntity<>(new ConsultantDTO(consultant.getFullName(), consultant.getFaculty(),
					consultant.getUser().getUsername()), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
