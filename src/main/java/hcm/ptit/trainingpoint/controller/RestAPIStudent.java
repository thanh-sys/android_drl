package hcm.ptit.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.dto.StudentDTO;
import hcm.ptit.trainingpoint.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class RestAPIStudent {

    private StudentService service;

    @Autowired
    public void setService(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentDTO> add(@RequestBody StudentDTO studentDTO) {
        return service.add(studentDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return service.update(id, studentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @GetMapping("/listStudent/{classes}")
    public List<Student> getAllStudentByClass(@PathVariable String classes) {
        return service.findAllByClasses(classes);
    }
}
