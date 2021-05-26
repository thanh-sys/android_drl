package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vnu.uet.trainingpoint.model.dto.ClassesDTO;
import vnu.uet.trainingpoint.service.ClassesService;

@RestController
@RequestMapping("/classes")
public class ClassesController {

    private ClassesService service;

    @Autowired
    public void setService(ClassesService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ClassesDTO> find(@PathVariable String name){
        return service.find(name);
    }

    @PostMapping("/add")
    public ResponseEntity<ClassesDTO> add(@RequestBody ClassesDTO classesDTO){
        return service.add(classesDTO);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<ClassesDTO> update(@PathVariable String name, @RequestBody ClassesDTO classesDTO){
        return service.update(name, classesDTO);
    }

    @DeleteMapping("/delete/{name}")
    ResponseEntity<ClassesDTO> delete(@PathVariable String name){
        return service.delete(name);
    }
}
