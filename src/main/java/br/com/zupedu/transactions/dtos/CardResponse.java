package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Card;

public class CardResponse {

    private String id;
    private String email;

    @Deprecated
    public CardResponse() {}

    public CardResponse(Card card) {
        this.id = card.getId();
        this.email = card.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
