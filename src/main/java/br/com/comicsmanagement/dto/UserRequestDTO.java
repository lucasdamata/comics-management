package br.com.comicsmanagement.dto;

import br.com.comicsmanagement.model.User;
import br.com.comicsmanagement.repository.UserRepository;

import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserRequestDTO {
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty @Email
    private String email;
    @NotNull @NotEmpty @CPF
    private String cpf;
    @NotNull
    private LocalDate birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User convert() {
        return new User(name, email, cpf, birthday);
    }

    public User updated(Long id, UserRepository userRepository) {
        User user = userRepository.getById(id);
        user.setName(this.name);
        user.setCpf(this.cpf);
        user.setBirthday(this.birthday);
        user.setEmail(this.email);
        return user;
    }
}
