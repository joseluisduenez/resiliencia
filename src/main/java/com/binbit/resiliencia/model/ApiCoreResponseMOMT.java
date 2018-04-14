package com.binbit.resiliencia.model;

public class ApiCoreResponseMOMT {
    private String status;
    private Integer statusCode;
    private String message;
  

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

 

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}