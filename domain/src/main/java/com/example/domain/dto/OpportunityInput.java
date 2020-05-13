package com.example.domain.dto;

import com.example.domain.Opportunity;

import java.sql.Date;

public class OpportunityInput implements Input<Opportunity> {

    private String name;
    private String stage;
    private String currency;
    private Integer amount;
    private String source;
    private Integer probability;
    private Date closedOn;
    private String description;
    private Date createdOn;
    private boolean inActive;

    @Override
    public Opportunity mapper() {
        return Opportunity.builder()
                .amount(this.amount)
                .closedOn(this.closedOn)
                .createdOn(this.createdOn)
                .currency(this.currency)
                .description(this.description)
                .inActive(this.inActive)
                .probability(this.probability)
                .name(this.name)
                .source(this.source)
                .stage(this.stage)
                .build();
    }
}
