package br.com.zupedu.transactions.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    private String id;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Institute institute;

    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Card card;

    @NotNull
    private LocalDateTime effectedIn;

    @Deprecated
    Transaction(){}

    public Transaction(String id, BigDecimal amount, Institute institute, Card card, String effectedIn) {
        this.id = id;
        this.amount = amount;
        this.institute = institute;
        this.card = card;
        this.effectedIn = LocalDateTime.parse(effectedIn);
    }
}
