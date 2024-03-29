package com.example.crm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interactions", schema = "public")
public class Interaction {
    public String getReason() {
        return reason;
    }

    public Boolean getCompleted() {
        return completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String reason;

    @Column(length = 20)
    private Boolean completed;

    @Column
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date date;

    public void setCustomer(Customer customer){this.customer = customer;}
    public void setEmployee(Employee employee){this.employee = employee;}

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "employeeid")
    private Employee employee;
}
