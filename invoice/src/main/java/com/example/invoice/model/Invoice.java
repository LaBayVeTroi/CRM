package com.example.invoice.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "invoice")
@Data
public class Invoice {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    private String invoiceTitle;
    private String invoiceNumber;
    private String name;
    private String email;
    private Integer quantity;
    private Integer rate;
    private Integer totalAmount;
    private String currency;
    private String phone;
    private Date createdOn;
    private Date amountDue;
    private Date amountPaid;
    private boolean isEmailSent;
    @Column(length = 512)
    private String status;
    @Column(length = 512)
    private String details;
    private Date dueDate;
}
