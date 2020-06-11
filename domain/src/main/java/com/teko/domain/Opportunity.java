package com.teko.domain;

import com.teko.proto.OpportunityTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "opportunity")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Opportunity {
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
    private String name;
    private String stage;
    private String currency;
    private Integer amount;
    private String source;
    private Integer probability;
    @Column(name = "close_on")
    private Date closedOn;
    @Column(length = 512)
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "in_active")
    private boolean inActive;

    public static Opportunity fromProto(OpportunityTranfer opportunityTranfer){
        return Opportunity.builder()
                .id(opportunityTranfer.getId())
                .name(opportunityTranfer.getName())
                .stage(opportunityTranfer.getStage())
                .currency(opportunityTranfer.getCurrency())
                .amount(opportunityTranfer.getAmount())
                .source(opportunityTranfer.getSource())
                .probability(opportunityTranfer.getProbability())
                .closedOn(new Date(opportunityTranfer.getClosedOn()))
                .description(opportunityTranfer.getDescription())
                .createdOn(new Date(opportunityTranfer.getCreatedOn()))
                .inActive(opportunityTranfer.getInActive())
                .build();
    }

    public OpportunityTranfer toProto(){
        return OpportunityTranfer.newBuilder()
                .setId(this.id)
                .setName(this.name)
                .setStage(this.stage)
                .setCurrency(this.currency)
                .setAmount(this.amount)
                .setSource(this.source)
                .setProbability(this.probability)
                .setClosedOn(this.closedOn.getTime())
                .setDescription(this.description)
                .setCreatedOn(this.createdOn.getTime())
                .setInActive(this.inActive)
                .build();
    }
}
