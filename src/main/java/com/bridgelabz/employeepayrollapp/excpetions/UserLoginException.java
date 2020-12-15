package com.bridgelabz.employeepayrollapp.excpetions;

public class UserLoginException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 507347231520004850L;

    private int statusCode;

    public UserLoginException(String msg, int statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }


}
