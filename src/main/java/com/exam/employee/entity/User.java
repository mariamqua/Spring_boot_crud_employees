package com.exam.employee.entity;


import com.exam.employee.validation.annotations.FieldMatch;
import com.exam.employee.validation.annotations.PasswordValidator;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
@Entity
@ToString
@Table(name="users")
@FieldMatch(password = "password", Confpassword = "confPassword",
        message = "Le mot de passe et confirmer mot de passe doivent correspondre")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="lastname", nullable = false)
    private String lastname;

    @Column(name="firstname", nullable = false)
    private String firstname;

    @Email(message = "email invalid")
    @NotBlank
    @Column(name="email", nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min=5, message = "minimum 5 lettre")
    @Column(name="username", nullable = false)
    private String username;

    @NotBlank
    @PasswordValidator(message = "Le mot de passe est invalide, doit contenir 8 caractères" +
            " ou plus, doit contenir au moins 1 (minuscule, majuscule," +
            "caractère spécial, chiffre)")
    @Column(name="password", nullable = false)
    private String password;

    @NotBlank
    @Transient
    private String confPassword;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public User(long id) {
        this.id=id;
    }
}
