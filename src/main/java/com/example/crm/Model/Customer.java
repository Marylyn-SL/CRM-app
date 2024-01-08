package com.example.crm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers", schema = "public")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private Boolean isCustomer;

    @Column
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date isCustomerDate;

    @Column
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date lastContact;

    @Column
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date stopDate;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Interaction> interactions;

    public String getEmail() {
        return email;
    }
}
