package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.UserDTO;
import com.bridgelabz.employeepayrollapp.utility.Response;

public interface IUser {

    Response loginUser(UserDTO userDTO);

}
