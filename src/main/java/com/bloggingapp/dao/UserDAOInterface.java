package com.bloggingapp.dao;

import com.bloggingapp.dto.UserDTO;
import java.sql.SQLException;

public interface UserDAOInterface {
    UserDTO create(UserDTO userDTO) throws SQLException;
    UserDTO findByEmail(String emailId) throws SQLException;

}
