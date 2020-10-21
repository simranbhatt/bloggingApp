package com.bloggingapp.services;
import com.bloggingapp.dao.BlogPostDAO;
import com.bloggingapp.dao.DAOFactory;
import com.bloggingapp.dto.BlogPostDTO;
import com.bloggingapp.dto.UserDTO;
import com.bloggingapp.services.BlogPostServiceInterface;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class BlogPostService implements BlogPostServiceInterface {

    BlogPostDAO postDAO = DAOFactory.getBlogPostDAO(); //getting instance of the BlogPostDAO class (as per the singleton pattern)
    @Override
    public BlogPostDTO savePost(BlogPostDTO postDTO) {
        try {
            BlogPostDTO dataTransferObject = postDAO.create(postDTO); //executing the "create" method from the BlogPostDAO class and collecting the object it returns
            return dataTransferObject;
        } catch(Exception e) {
            System.out.println("Unexpected post saving error");
        }
        return null;
    }

    public List<BlogPostDTO> getPostsByEmail(String email) {
        try {
            List<BlogPostDTO> PostList = postDAO.findByEmail(email);
            return PostList;
        } catch(Exception e) {
            System.out.println("Unexpected post retrieval error (search by email)");
        }
        return null;
    }

    public List<BlogPostDTO> getPostsByTag(String tag) {
        try {
            List<BlogPostDTO> PostList = postDAO.findByTag(tag);
            return PostList;
        } catch(Exception e) {
            System.out.println("Unexpected post retrieval error (search by tag)");
        }
        return null;
    }


    public boolean deletePost(int id) {
        try {
            return postDAO.deleteById(id);
        } catch (SQLException e) {
            System.out.println("SQL Error: could not delete post");
            e.printStackTrace();
        }
        return false;
    }

    /*main method for testing
    public static void main(String[] args) {

        BlogPostDTO testDTO = new BlogPostDTO();
        testDTO.setTitle("test");
        testDTO.setTag("test tag");
        testDTO.setEmail("email test");
        testDTO.setDescription("test description");
        testDTO.setTimestamp(LocalDateTime.now());
        testDTO.setUsername("user3");
        ServiceFactory.getBlogPostService().savePost(testDTO);
        System.out.println(testDTO.toString());
    }

     */

}
