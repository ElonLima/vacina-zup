package com.vacina.vacinabr.exception;

import java.util.Date;

public class ErrorDetails {

    private final Date timestamp;
    private final String messsage;
    private final String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.messsage = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMesssage() {
        return messsage;
    }

    public String getDetails() {
        return details;
    }
}
