package com.teko.domain;

import com.teko.proto.AttachmentTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;

@Data
@Entity
@Table(name = "attachment")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
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
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "created_on")
    private Date createdOn;
    private File attachment;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToOne
    @JoinColumn(name = "`lead`")
    private Lead lead;

    @OneToOne
    @JoinColumn(name = "account")
    private Account account;

    @OneToOne
    @JoinColumn(name = "contact")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "opportunity")
    private Opportunity opportunity;

    @OneToOne
    @JoinColumn(name = "task")
    private Task task;

    @OneToOne
    @JoinColumn(name = "invoice")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "event")
    private Event event;

    public static Attachment fromProto(AttachmentTranfer attachmentTranfer){
        return Attachment.builder()
                .id(attachmentTranfer.getId())
                .account(Account.fromProto(attachmentTranfer.getAccount()))
                .attachment(new File(attachmentTranfer.getAttachment()))
                .contact(Contact.fromProto(attachmentTranfer.getContact()))
                .createdBy(User.fromProto(attachmentTranfer.getCreatedBy()))
                .createdOn(new Date(attachmentTranfer.getCreatedOn()))
                .event(Event.fromProto(attachmentTranfer.getEvent()))
                .fileName(attachmentTranfer.getFileName())
                .invoice(Invoice.fromProto(attachmentTranfer.getInvoice()))
                .lead(Lead.fromProto(attachmentTranfer.getLead()))
                .opportunity(Opportunity.fromProto(attachmentTranfer.getOppotunity()))
                .task(Task.fromProto(attachmentTranfer.getTask()))
                .build();
    }

    public AttachmentTranfer toProto(){
        return AttachmentTranfer.newBuilder()
                .setId(this.id)
                .setAccount(this.account.toProto())
                .setAttachment(this.attachment.getAbsolutePath())
                .setContact(this.contact.toProto())
                .setCreatedBy(this.createdBy.toProto())
                .setCreatedOn(this.createdOn.getTime())
                .setEvent(this.event.toProto())
                .setFileName(this.fileName)
                .setInvoice(this.invoice.toProto())
                .setLead(this.lead.toProto())
                .setOppotunity(this.opportunity.toProto())
                .setTask(this.task.toProto())
                .build();
    }
}
