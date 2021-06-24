package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Card;
import br.com.zupedu.transactions.entities.Institute;
import br.com.zupedu.transactions.entities.Transaction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TransactionEvent {

    @JsonProperty
    private String id;
    @JsonProperty
    private BigDecimal valor;
    @JsonProperty
    private Estabelecimento estabelecimento;
    @JsonProperty
    private Cartao cartao;
    @JsonProperty
    private String efetivadaEm;

    @Deprecated
    public TransactionEvent(){}

    @JsonCreator
    public TransactionEvent(
            @JsonProperty("id") String id,
            @JsonProperty("valor") BigDecimal valor,
            @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
            @JsonProperty("cartao") Cartao cartao,
            @JsonProperty("efetivadaEm") String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transaction toModel() {
        Card card = cartao.toModel();
        Institute institute = estabelecimento.toModel();
        return new Transaction(id, valor,institute, card, efetivadaEm);
    }
}
