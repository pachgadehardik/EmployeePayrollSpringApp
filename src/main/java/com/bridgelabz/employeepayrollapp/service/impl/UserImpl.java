package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.UserDTO;
import com.bridgelabz.employeepayrollapp.excpetions.EmployeeException;
import com.bridgelabz.employeepayrollapp.model.User;
import com.bridgelabz.employeepayrollapp.repository.UserRepository;
import com.bridgelabz.employeepayrollapp.service.IUser;
import com.bridgelabz.employeepayrollapp.utility.IMessage;
import com.bridgelabz.employeepayrollapp.utility.Response;
import com.bridgelabz.employeepayrollapp.utility.TokenHelper;

/**
 * @author hardi
 * Service Class for the User to log in the application
 */
@Service
public class UserImpl implements IUser {

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private Environment environment;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper ModelMapper;

    /**
     * Login the user and checked whether it exists in DB
     */
    @Override
    public Response loginUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findUserByUserNameandUserPassword(userDTO.getUserName(),
                userDTO.getUserPassword());

//		ModelMapper.map(userDTO,User.class);
        if (!user.isPresent()) {
            throw new EmployeeException(HttpStatus.BAD_REQUEST.value(), IMessage.USER_NOT_EXIST);
        }
        User userObj = user.get();
        String tokenString = tokenHelper.createJWT(userObj.getId().toString(), environment.getProperty("token.issuer"),
                environment.getProperty("token.subject"), Long.parseLong(environment.getProperty("token.expirationTime")));
        return new Response(HttpStatus.OK.value(), HttpStatus.OK.name(), tokenString);
    }

}
