package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vnu.uet.trainingpoint.model.dto.ConsultantDTO;
import vnu.uet.trainingpoint.service.ConsultantService;

@RestController
@RequestMapping("/consultant")
public class RestAPIConsultant {

    private ConsultantService service;

    @Autowired
    public void setService(ConsultantService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultantDTO> find(@PathVariable Long id) {
        return service.find(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ConsultantDTO> add(@RequestBody ConsultantDTO consultantDTO) {
        return service.add(consultantDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ConsultantDTO> update(@PathVariable Long id, @RequestBody ConsultantDTO consultantDTO) {
        return service.update(id, consultantDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ConsultantDTO> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
