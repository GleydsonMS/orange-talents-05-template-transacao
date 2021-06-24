package br.com.zupedu.transactions.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Card {

    @Id
    private String id;

    @NotBlank
    private String email;

    @Deprecated
    Card(){}

    public Card(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
