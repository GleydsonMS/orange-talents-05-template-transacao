package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Institute;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Estabelecimento {

    @JsonProperty
    private String nome;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String endereco;

    @Deprecated
    public Estabelecimento(){}

    @JsonCreator
    public Estabelecimento(
            @JsonProperty("nome") String nome,
            @JsonProperty("cidade") String cidade,
            @JsonProperty("endereco") String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Institute toModel() {
        return new Institute(nome, cidade, endereco);
    }
}
