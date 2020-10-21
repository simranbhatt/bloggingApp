package com.bloggingapp.dao;
//single instances of the UserDAO and PostDAO classes that can be used by other classes
public class DAOFactory {

    private static UserDAO userDAO = new UserDAO();
    private static BlogPostDAO blogPostDAO = new BlogPostDAO();

    public static UserDAO getUserDAO() {
        return userDAO;
    }


    public static BlogPostDAO getBlogPostDAO() {
        return blogPostDAO;
    }

}
