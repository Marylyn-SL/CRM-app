package com.example.crm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees", schema = "public")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String username;

    @Column(length = 250)
    private String password;

    @Column(length = 100)
    private final String role = "EMPLOYEE";

//    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
//    private Set<Interaction> interactions;

    public String getUsername() {return this.username;}
    public String getPassword() {return this.password;}
    public String getRole() {return this.role;}
    public Long getId(){return id;}
}
