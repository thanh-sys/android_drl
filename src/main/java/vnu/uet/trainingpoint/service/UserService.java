package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.User;
import vnu.uet.trainingpoint.model.dto.UserDTO;
import vnu.uet.trainingpoint.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repo;

    @Autowired
    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }

    public ResponseEntity<User> findByUsername(String username) {
        Optional<User> userOptional = repo.findById(username);
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404).build());
    }

    public ResponseEntity<User> add(User user) {
        if (!repo.existsById(user.getUsername())) {
            return new ResponseEntity<>(repo.save(user), HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<User> update(String username, UserDTO userDTO) {
        Optional<User> userOptional = repo.findById(username);
        return userOptional.map(user -> {
            user.setActive(userDTO.isActive());
            user.setPassword(userDTO.getPassword());
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
