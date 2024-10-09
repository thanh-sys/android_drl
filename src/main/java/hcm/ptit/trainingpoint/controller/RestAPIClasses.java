
package hcm.ptit.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hcm.ptit.trainingpoint.enitty.Classes;
import hcm.ptit.trainingpoint.model.dto.ClassesDTO;
import hcm.ptit.trainingpoint.service.ClassesService;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class RestAPIClasses {

    private ClassesService service;

    @Autowired
    public void setService(ClassesService service) {
        this.service = service;
    }

    @GetMapping("/getAllClass")
    public ResponseEntity<?> getAllClass() {
        return ResponseEntity.ok( service.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<ClassesDTO> find(@PathVariable String name) {
        return service.find(name);
    }

    @PostMapping("/add")
    public ResponseEntity<ClassesDTO> add(@RequestBody ClassesDTO classesDTO) {
        return service.add(classesDTO);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<ClassesDTO> update(@PathVariable String name, @RequestBody ClassesDTO classesDTO) {
        return service.update(name, classesDTO);
    }

    @DeleteMapping("/delete/{name}")
    ResponseEntity<ClassesDTO> delete(@PathVariable String name) {
        return service.delete(name);
    }
}
