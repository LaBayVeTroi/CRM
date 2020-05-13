package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "invoice")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "invoice_title")
    private String invoiceTitle;
    @Column(name = "invoice_number")
    private String invoiceNumber;
    private String name;
    private String email;
    private Integer quantity;
    private Integer rate;
    @Column(name = "total_amount")
    private Integer totalAmount;
    private String currency;
    private String phone;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "amount_due")
    private Date amountDue;
    @Column(name = "amount_paid")
    private Date amountPaid;
    @Column(name = "is_email_sent")
    private boolean isEmailSent;
    @Column(length = 512)
    private String status;
    @Column(length = 512)
    private String details;
    @Column(name = "due_date")
    private Date dueDate;
}
