package com.example.crm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interactions", schema = "public")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String reason;

    @Column(length = 20)
    private Boolean completed;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

    public Interaction(String reason){
        this.completed = true;
        this.date = new Date();
        //TODO: the below should come from the request
        this.customer = new Customer();
        this.employee = new Employee();
    }

    public String getReason() { return this.reason; }
}
