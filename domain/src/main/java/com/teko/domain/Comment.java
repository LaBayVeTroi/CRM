package com.teko.domain;

import com.teko.proto.CommentTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "comment")
@Data
public class Comment {
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
    private String comment;
    @Column(name = "commented_on")
    private Date commentedOn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commented_by")
    private User commentedBy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
    @OneToOne
    @JoinColumn(name = "`lead`")
    private Lead lead;
    @OneToOne
    @JoinColumn(name = "opportunity")
    private Opportunity opportunity;
    @ManyToOne
    @JoinColumn(name = "contact")
    private Contact contact;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @OneToOne
    @JoinColumn(name = "task")
    private Task task;
    @OneToOne
    @JoinColumn(name = "invoice")
    private Invoice invoice;
    @OneToOne
    @JoinColumn(name = "event")
    private Event event;

    public static Comment fromProto(CommentTranfer commentTranfer){
        return Comment.builder()
                .id(commentTranfer.getId())
                .comment(commentTranfer.getComment())
                .commentedOn(new Date(commentTranfer.getCommentedOn()))
                .commentedBy(User.fromProto(commentTranfer.getCommentedBy()))
                .account(Account.fromProto(commentTranfer.getAccoount()))
                .lead(Lead.fromProto(commentTranfer.getLead()))
                .opportunity(Opportunity.fromProto(commentTranfer.getOpportunity()))
                .contact(Contact.fromProto(commentTranfer.getContact()))
                .user(User.fromProto(commentTranfer.getUser()))
                .task(Task.fromProto(commentTranfer.getTask()))
                .invoice(Invoice.fromProto(commentTranfer.getInvoice()))
                .event(Event.fromProto(commentTranfer.getEvent()))
                .build();
    }

    public CommentTranfer toProto(){
        return CommentTranfer.newBuilder()
                .setId(this.id)
                .setComment(this.comment)
                .setCommentedOn(this.commentedOn.getTime())
                .setCommentedBy(this.commentedBy.toProto())
                .setAccoount(this.account.toProto())
                .setLead(this.lead.toProto())
                .setOpportunity(this.opportunity.toProto())
                .setContact(this.contact.toProto())
                .setUser(this.user.toProto())
                .setTask(this.task.toProto())
                .setInvoice(this.invoice.toProto())
                .setEvent(this.event.toProto())
                .build();
    }
}
