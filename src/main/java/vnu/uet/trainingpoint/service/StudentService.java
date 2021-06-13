package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.Classes;
import vnu.uet.trainingpoint.enitty.Student;
import vnu.uet.trainingpoint.enitty.User;
import vnu.uet.trainingpoint.model.dto.StudentDTO;
import vnu.uet.trainingpoint.repository.ClassesRepository;
import vnu.uet.trainingpoint.repository.StudentRepository;
import vnu.uet.trainingpoint.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    private ClassesRepository classesRepository;

    private UserRepository userRepository;

    @Autowired
    public void setClassesRepository(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findAllByClasses(String classes) {
        return studentRepository.findAllByClasses(classes);
    }

    public Student findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    public Student findUserById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public ResponseEntity<StudentDTO> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student
                -> new ResponseEntity<>(
                new StudentDTO(
                        student.getFullName(),
                        student.getEmail(),
                        student.getAddress(),
                        student.getBirthday(),
                        student.getCountry(),
                        student.getClasses().getName(),
                        student.getUser().getUsername()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //tìm thấy trả về StudentDTO, status=200, còn không thì trả về not fond

    }

    public ResponseEntity<StudentDTO> add(StudentDTO studentDTO) {
        // nếu sinh viên chưa tồn tại trong DB mới lưu
        if (!studentRepository.findByEmail(studentDTO.getUsername() + "@vnu.edu.vn").isPresent()) {
            User user = new User(studentDTO.getUsername());
            userRepository.save(user);
            Student student = new Student();
            student.setFullName(studentDTO.getFullName());
            student.setAddress(studentDTO.getAddress());
            student.setCountry(studentDTO.getCountry());
            student.setEmail(studentDTO.getUsername() + "@vnu.edu.vn");
            student.setBirthday(studentDTO.getBirthday());
            student.setUser(user);
            Optional<Classes> classesOptional = classesRepository.getByName(studentDTO.getClassName());
            classesOptional.ifPresent(student::setClasses); //nếu class tồn tại, add vào class
            studentRepository.save(student);
            return new ResponseEntity<>(
                    new StudentDTO(
                            student.getFullName(),
                            student.getEmail(),
                            student.getAddress(),
                            student.getBirthday(),
                            student.getCountry(),
                            student.getClasses().getName(),
                            student.getUser().getUsername()
                    ), HttpStatus.OK);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<StudentDTO> update(Long id, StudentDTO studentDTO) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student -> {
            student.setAddress(studentDTO.getAddress());
            student.setBirthday(studentDTO.getBirthday());
            student.setCountry(studentDTO.getCountry());
            student.setFullName(studentDTO.getFullName());
            if (studentDTO.getClassName() != null) {
                // nếu thông tin classes từ DTO mà tìm ra lớp đấy trong DB-> đổi tên lớp cho SV
                Classes classes = classesRepository.getByName(studentDTO.getClassName()).get();
                if (classes.getName() != null) {
                    student.setClasses(classes);
                }
            }
            // nếu có nhập username
            // nếu username chưa tồn tại trong DB
            if (!userRepository.existsById(studentDTO.getUsername()) && studentDTO.getUsername() != null) {
//                    userRepository.delete(student.getUser());// xóa user cũ
                User user = new User(studentDTO.getUsername());
                userRepository.save(user);//thêm user mới
                student.setUser(user);
                student.setEmail(user.getUsername() + "@vnu.edu.vn");
            }
            studentRepository.save(student);
            return new ResponseEntity<>(
                    new StudentDTO(
                            student.getFullName(),
                            student.getEmail(),
                            student.getAddress(),
                            student.getBirthday(),
                            student.getCountry(),
                            student.getClasses().getName(),
                            student.getUser().getUsername()
                    ), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<StudentDTO> delete(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student -> {
            studentRepository.delete(student);
            userRepository.delete(userRepository.getById(student.getUser().getUsername()));
            return new ResponseEntity<>(
                    new StudentDTO(
                            student.getFullName(),
                            student.getEmail(),
                            student.getAddress(),
                            student.getBirthday(),
                            student.getCountry(),
                            student.getClasses().getName(),
                            student.getUser().getUsername()
                    ), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
