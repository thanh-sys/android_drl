package hcm.ptit.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hcm.ptit.trainingpoint.enitty.User;
import hcm.ptit.trainingpoint.model.dto.UserDTO;
import hcm.ptit.trainingpoint.service.UserService;

@RestController
@RequestMapping("/user")
public class RestAPIUser {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        return service.add(user);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<User> update(@PathVariable String username, @RequestBody UserDTO userDTO) {
        return service.update(username, userDTO);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<User> delete(@PathVariable String username) {
        return service.delete(username);
    }
}
