package com.maids.liberary.manager.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatronObj {
    @JsonProperty(value = "patronId")
    private int id;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "dial")
    private String dial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty(value = "address")
    private String address;
}
