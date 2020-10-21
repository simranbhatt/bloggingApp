package com.bloggingapp.dao;

import com.bloggingapp.db.DatabaseConnection;
import com.bloggingapp.dto.UserDTO;
import java.sql.*;

public class UserDAO implements UserDAOInterface {

    @Override
    public UserDTO create(UserDTO userDTO) {  //takes userDTO object and inserts values into the PENSEUSERS database
        Connection dbConnection = DatabaseConnection.getInstance();
        try {
            String firstName = userDTO.getFirstName();
            String lastName = userDTO.getLastName();
            String emailId = userDTO.getEmail();
            String password = userDTO.getPassword();
            int userID = userDTO.getUserID();
            String insert = "INSERT INTO PENSEUSERS (firstName, lastName, email, password, userID)" +
                    "VALUES (?,?,?,?,?)"; //values are set at lines 26-30
            //"prepared statements" allow user input variables to be inserted into the "insert" string
            //while avoiding SQL injection attacks
            PreparedStatement prep = dbConnection.prepareStatement(insert);
            //setting parameter values in the insert string
            prep.setString(1, firstName);
            prep.setString(2, lastName);
            prep.setString(3, emailId);
            prep.setString(4, password);
            prep.setInt(5, userID);
            prep.executeUpdate();
            return userDTO;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            dbConnection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserDTO findByEmail(String emailId) { //returns data transfer object containing details of
                                                    // the user having the given email address

        Connection dbConnection = DatabaseConnection.getInstance();
        try {
            UserDTO dataTransferObject = new UserDTO();
            String sqlRequest = "SELECT * FROM PENSEUSERS WHERE email = ?";
            PreparedStatement requestPrep = dbConnection.prepareStatement(sqlRequest);
            requestPrep.setString(1, emailId);
            ResultSet results = requestPrep.executeQuery(); //takes the result set
            while (results.next()) { //iterates through the result set, extracts individual items,
                                    // and sets them into a new user DTO
                dataTransferObject.setFirstName(results.getString("firstName"));
                dataTransferObject.setLastName(results.getString("lastName"));
                dataTransferObject.setEmail(results.getString("email"));
                dataTransferObject.setPassword(results.getString("password"));
                dataTransferObject.setUserID(results.getInt("userID"));
            }
            System.out.println(dataTransferObject.toString());
            return dataTransferObject;
        } catch(SQLException e) {
          e.printStackTrace();
        }
        try {
            dbConnection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

 /* main method for testing
    public static void main(String[] args) {
        UserDTO testDTO = new UserDTO();
        UserDAO testDAO = new UserDAO();
        testDTO.setFirstName("Joanna");
        testDTO.setLastName("Smith");
        testDTO.setEmail("john@blog.com");
        testDTO.setPassword("password");
        //testDTO.setUserID(123);
        testDAO.create(testDTO);
        testDAO.findByEmail("johfdlafn@blog.com");
    }
      */

}
