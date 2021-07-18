package br.com.comicsmanagement.controller;

import br.com.comicsmanagement.dto.UserRequestDTO;
import br.com.comicsmanagement.dto.UserResponseDTO;
import br.com.comicsmanagement.model.User;
import br.com.comicsmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/users"))
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserResponseDTO> findAll(String filter) {
        if (filter == null) {
            List<User> users = userRepository.findAll();
            return UserResponseDTO.convert(users);
        } else {
            List<User> users = userRepository.findByName(filter);
            return UserResponseDTO.convert(users);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestDTO userRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        User user = userRequestDTO.convert();
        userRepository.save(user);

        URI uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserResponseDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findOne(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new UserResponseDTO(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody @Valid UserRequestDTO userRequestDTO) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = userRequestDTO.updated(id, userRepository);
            return ResponseEntity.ok(new UserResponseDTO(user));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
