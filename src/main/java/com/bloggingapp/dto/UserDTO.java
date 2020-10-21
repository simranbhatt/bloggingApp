package com.bloggingapp.dto;

public class UserDTO {
    private int userID = 0;
    private String email = "", password = "", firstName = "", lastName = "", username = "";

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

   public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userID +
                ", emailId='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    /*
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(1);
        userDTO.setEmail("dummy@dummy.com");
        userDTO.setPassword("password");
        System.out.println(userDTO);
    }
     */
}
