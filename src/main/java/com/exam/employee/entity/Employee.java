package com.exam.employee.entity;

import com.exam.employee.validation.UniqueCin;
import com.exam.employee.validation.UniqueEmail;
import com.exam.employee.validation.UniqueTel;
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
    private short id;

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

    @NotNull(message = "champ obligatoire")
    private double salaire;

    @Column
    private double chiffre_affaire;

    @Column
    private boolean is_admin;

    @ManyToOne
    private Departement departement;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="employee_id" )
    private List<Remuneration> remunerations;

    @ManyToOne(cascade={CascadeType.MERGE} )
    @JoinColumn(name="manager_id")
    private Employee manager;

    @OneToMany(mappedBy="manager")
    private List<Employee> sous_jacents = new ArrayList<>();

    public Employee(short id)
    {
        this.id=id;
    }

}
