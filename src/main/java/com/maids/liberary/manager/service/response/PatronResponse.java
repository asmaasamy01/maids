package com.maids.liberary.manager.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PatronResponse{

    public List<PatronObj> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<PatronObj> patrons) {
        this.patrons = patrons;
    }

    private List<PatronObj> patrons;
    @JsonProperty(value = "statusCode")
    private String statusCode;

    @JsonProperty(value = "statusDescription")
    private String description;

    public PatronResponse(List<PatronObj> patrons, String statusCode, String description) {
        this.patrons = patrons;
        this.statusCode = statusCode;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PatronResponse success(List<PatronObj> patrons){
        return new PatronResponse(patrons,"1","success");
    }
    public static PatronResponse fail(String status,String description){
        return new PatronResponse(null,status,description);
    }
}
