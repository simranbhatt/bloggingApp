package com.bloggingapp.services;
import com.bloggingapp.dto.UserDTO;

public interface UserServiceInterface {

        UserDTO saveUser(UserDTO userDTO);
        UserDTO getUser(String emailId);

}
