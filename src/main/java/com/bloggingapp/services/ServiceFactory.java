package com.bloggingapp.services;

public class ServiceFactory {

    private static UserService userService = new UserService();
    private static BlogPostService blogPostService = new BlogPostService();

    public static UserService getUserService() {
        return userService;
    }

    public static BlogPostService getBlogPostService() {
        return blogPostService;
    }

}
