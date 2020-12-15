package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDTO {

    @NotNull
    private String userName;
    @NotNull
    private String userPassword;

}
