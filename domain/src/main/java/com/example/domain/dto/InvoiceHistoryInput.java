package com.example.domain.dto;

import com.example.domain.InvoiceHistory;

import javax.persistence.Column;
import java.sql.Date;

public class InvoiceHistoryInput implements Input<InvoiceHistory> {

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
    private String status;
    private String details;
    private Date dueDate;

    @Override
    public InvoiceHistory mapper() {
        return InvoiceHistory.builder()
                .amountDue(this.amountDue)
                .amountPaid(this.amountPaid)
                .createdOn(this.createdOn)
                .currency(this.currency)
                .details(this.details)
                .dueDate(this.dueDate)
                .email(this.email)
                .invoiceNumber(this.invoiceNumber)
                .invoiceTitle(this.invoiceTitle)
                .isEmailSent(this.isEmailSent)
                .name(this.name)
                .phone(this.phone)
                .quantity(this.quantity)
                .rate(this.rate)
                .status(this.status)
                .totalAmount(this.totalAmount)
                .build();
    }
}
