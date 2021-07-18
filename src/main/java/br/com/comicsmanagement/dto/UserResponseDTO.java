package br.com.comicsmanagement.dto;

import br.com.comicsmanagement.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthday;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.birthday = user.getBirthday();
    }

    public static List<UserResponseDTO> convert(List<User> users) {
        return users.stream().map(UserResponseDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
