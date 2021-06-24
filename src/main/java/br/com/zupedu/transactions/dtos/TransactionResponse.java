package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponse {

    private String id;
    private BigDecimal amount;
    private InstituteResponse institute;
    private CardResponse card;
    private LocalDateTime effectedIn;

    @Deprecated
    public TransactionResponse(){}

    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.institute = new InstituteResponse(transaction.getInstitute());
        this.card = new CardResponse(transaction.getCard());
        this.effectedIn = transaction.getEffectedIn();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public InstituteResponse getInstitute() {
        return institute;
    }

    public CardResponse getCard() {
        return card;
    }

    public LocalDateTime getEffectedIn() {
        return effectedIn;
    }
}
