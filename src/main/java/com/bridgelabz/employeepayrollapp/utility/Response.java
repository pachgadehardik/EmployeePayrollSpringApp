package com.bridgelabz.employeepayrollapp.utility;

import lombok.Data;

public class Response {

    private int statusCode;
    private String reponseText;
    private Object obj;

    public Response(int statusCode, String reponseText) {
        this.statusCode = statusCode;
        this.reponseText = reponseText;
    }

    public Response(int statusCode, String reponseText, Object obj) {
        this.statusCode = statusCode;
        this.reponseText = reponseText;
        this.obj = obj;
    }


    @Override
    public String toString() {
        return "Response [statusCode=" + statusCode + ", reponseText=" + reponseText + ", obj=" + obj + "]";
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getReponseText() {
        return reponseText;
    }

    public void setReponseText(String reponseText) {
        this.reponseText = reponseText;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


}
