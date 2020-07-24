package com.exam.employee.entity;

import com.exam.employee.validation.annotations.UniqueCin;
import com.exam.employee.validation.annotations.UniqueEmail;
import com.exam.employee.validation.annotations.UniqueTel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "employees")
@UniqueCin
@UniqueEmail
@UniqueTel
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;

    @Column
    @NotBlank(message = "champ obligatoire")
    @Size(min = 6, message = "6 charatères au minimum ")
    private String nom;

    @Column
    @NotBlank(message = "champ obligatoire")
    @Size(min = 4, message = "4 charatères au minimum ")
    private String cin;

    @Column
    @NotBlank(message = "champ obligatoire")
    @Size(min = 10, max = 10 ,message = "Tel invalid")
    private String tel;

    @Column
    @Email(message = "email invalid")
    @NotBlank(message = "champ obligatoire")
    private String email;


    private String mot_de_passe;

    @Transient
    private String confirmer_mot_de_passe;
    @Transient
    private Boolean used;
    @NotBlank(message = "champ obligatoire")
    private String grade;
    private double salaire;
    private String type;

    @ManyToOne
    private Departement departement;

    @ManyToOne(fetch= FetchType.EAGER)
    private Remuneration remuneration;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    //@JoinColumn(name="sous_jacents")
    private List<Employee> sous_jacents = new ArrayList<>();

    public Employee(long id)
    {
        this.id=id;
    }

}
