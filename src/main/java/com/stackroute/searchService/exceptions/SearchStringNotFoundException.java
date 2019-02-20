package com.stackroute.searchService.exceptions;

public class SearchStringNotFoundException extends Exception{
    private String message;

    public SearchStringNotFoundException(){

    }
    public SearchStringNotFoundException(String message){
        super(message);
        this.message=message;
    }
}

