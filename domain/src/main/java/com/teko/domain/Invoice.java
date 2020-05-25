package com.teko.domain;

import com.teko.proto.InvoiceTranfer;
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

    public static Invoice fromProto(InvoiceTranfer invoiceTranfer){
        return Invoice.builder()
                .id(invoiceTranfer.getId())
                .invoiceTitle(invoiceTranfer.getInvoiceTitle())
                .invoiceNumber(invoiceTranfer.getInvoiceNumber())
                .name(invoiceTranfer.getName())
                .email(invoiceTranfer.getEmail())
                .quantity(invoiceTranfer.getQuantity())
                .createdOn(new Date(invoiceTranfer.getCreatedOn()))
                .amountDue(new Date(invoiceTranfer.getAmountDue()))
                .amountPaid(new Date(invoiceTranfer.getAmountPaid()))
                .isEmailSent(invoiceTranfer.getIsEmailSent())
                .status(invoiceTranfer.getStatus())
                .details(invoiceTranfer.getDetails())
                .dueDate(new Date(invoiceTranfer.getDueDate()))
                .build();
    }

    public InvoiceTranfer toProto(){
        return InvoiceTranfer.newBuilder()
                .setId(this.id)
                .setInvoiceTitle(this.invoiceTitle)
                .setInvoiceNumber(this.invoiceNumber)
                .setName(this.name)
                .setEmail(this.email)
                .setQuantity(this.quantity)
                .setCreatedOn(this.createdOn.getTime())
                .setAmountDue(this.amountDue.getTime())
                .setAmountPaid(this.amountPaid.getTime())
                .setIsEmailSent(this.isEmailSent)
                .setStatus(this.status)
                .setDetails(this.details)
                .setDueDate(this.dueDate.getTime())
                .build();
    }
}
