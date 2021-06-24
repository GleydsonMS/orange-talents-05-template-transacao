package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Card;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cartao {

    @JsonProperty
    private String id;
    @JsonProperty
    private String email;

    @Deprecated
    Cartao(){}

    @JsonCreator
    public Cartao(
            @JsonProperty("id") String id,
            @JsonProperty("email") String email) {
        this.id = id;
        this.email = email;
    }

    public Card toModel() {
        return new Card(id, email);
    }
}
