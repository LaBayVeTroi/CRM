package com.teko.domain;

import com.teko.proto.InvoiceHistoryTranfer;
import com.teko.proto.InvoiceHistoryTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "invoice_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceHistory {
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

    public static InvoiceHistory fromProto(InvoiceHistoryTranfer invoiceHistoryTranfer){
        return InvoiceHistory.builder()
                .id(invoiceHistoryTranfer.getId())
                .invoiceTitle(invoiceHistoryTranfer.getInvoiceTitle())
                .invoiceNumber(invoiceHistoryTranfer.getInvoiceNumber())
                .name(invoiceHistoryTranfer.getName())
                .email(invoiceHistoryTranfer.getEmail())
                .quantity(invoiceHistoryTranfer.getQuantity())
                .createdOn(new Date(invoiceHistoryTranfer.getCreatedOn()))
                .amountDue(new Date(invoiceHistoryTranfer.getAmountDue()))
                .amountPaid(new Date(invoiceHistoryTranfer.getAmountPaid()))
                .isEmailSent(invoiceHistoryTranfer.getIsEmailSent())
                .status(invoiceHistoryTranfer.getStatus())
                .details(invoiceHistoryTranfer.getDetails())
                .dueDate(new Date(invoiceHistoryTranfer.getDueDate()))
                .build();
    }

    public InvoiceHistoryTranfer toProto(){
        return InvoiceHistoryTranfer.newBuilder()
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
