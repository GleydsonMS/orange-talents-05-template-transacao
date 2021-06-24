package br.com.zupedu.transactions.dtos;

import br.com.zupedu.transactions.entities.Institute;

public class InstituteResponse {

    private String name;
    private String city;
    private String address;

    @Deprecated
    public InstituteResponse() {}

    public InstituteResponse(Institute institute) {
        this.name = institute.getName();
        this.city= institute.getCity();
        this.address = institute.getAddress();
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
