package com.bloggingapp.services;

import com.bloggingapp.dao.DAOFactory;
import com.bloggingapp.dao.UserDAO;
import com.bloggingapp.dto.UserDTO;

public class UserService implements UserServiceInterface {

    UserDAO userDAO = DAOFactory.getUserDAO();

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        try {
            UserDTO dataTransferObject = userDAO.create(userDTO);
            return dataTransferObject;
        } catch(Exception e) {
            System.out.println("Unexpected registration error");
        }
        return null;
    }

    @Override
    public UserDTO getUser(String emailId) {
        try {
            UserDTO dataTransferObject = userDAO.findByEmail(emailId);
            return dataTransferObject;
        } catch(Exception e) {
            System.out.println("Unexpected search error");
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
