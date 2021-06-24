package br.com.zupedu.transactions.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
public class Institute {

    @Id
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @Deprecated
    Institute(){}

    public Institute(String name, String city, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
