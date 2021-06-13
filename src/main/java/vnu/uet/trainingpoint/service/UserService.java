package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.User;
import vnu.uet.trainingpoint.model.dto.UserDTO;
import vnu.uet.trainingpoint.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public ResponseEntity<User> findByUsername(String username) {
        Optional<User> userOptional = repo.findById(username);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }

    public ResponseEntity<User> add(User user) {
        if (!repo.existsById(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<User> update(String username, UserDTO userDTO) {
        Optional<User> userOptional = repo.findById(username);
        return userOptional.map(user -> {
            user.setActive(userDTO.isActive());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setRoles(userDTO.getRoles());
            return new ResponseEntity<>(repo.save(user), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<User> delete(String username) {
        Optional<User> userOptional = repo.findById(username);
        return userOptional.map(user -> {
            repo.delete(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
