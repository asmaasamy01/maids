package com.maids.liberary.manager.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookResponse {
    public List<BookObj> getBooks() {
        return books;
    }

    public void setBooks(List<BookObj> books) {
        this.books = books;
    }

    @JsonProperty(value = "books")
    private List<BookObj> books;
    @JsonProperty(value = "statusCode")
    private String statusCode;

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

    @JsonProperty(value = "statusDescription")
    private String description;

    public BookResponse(List<BookObj> books, String statusCode, String description) {
        this.books = books;
        this.statusCode = statusCode;
        this.description = description;
    }

    public static BookResponse success(List<BookObj> books){
        return new BookResponse(books,"1","success");
    }
    public static BookResponse fail(String status,String description){
        return new BookResponse(null,status,description);
    }
}
