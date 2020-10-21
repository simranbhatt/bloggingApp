package com.bloggingapp.dao;

import com.bloggingapp.db.DatabaseConnection;
import com.bloggingapp.dto.BlogPostDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BlogPostDAO implements BlogPostDAOInterface {
    @Override
    public BlogPostDTO create(BlogPostDTO postDTO) {
        try {
        Connection dbConnection = DatabaseConnection.getInstance();
        int postID = postDTO.getPostID();
        String postTitle = postDTO.getTitle();
        String email = postDTO.getEmail();
        String tags = postDTO.getTag();
        String postDescription = postDTO.getDescription();
        LocalDateTime timestamp = postDTO.getTimestamp();
        String formattedTimestamp;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); //inbuilt class to convert LocalDateTime to String
            formattedTimestamp = timestamp.format(formatter); //conversion using DateTimeFormatter class
        } catch(NullPointerException e) {
            formattedTimestamp = "No time available";
        }
            String insert = "INSERT INTO PENSEPOSTS (email, title, timestamp, tag, description)" +
                "VALUES (?,?,?,?,?)";
        //"prepared statements" allow user input variables to be inserted into the "insert" string
        //while avoiding SQL injection attacks
        PreparedStatement prep = dbConnection.prepareStatement(insert);
        //setting parameter values in the insert string
        prep.setString(1, email);
        prep.setString(2, postTitle);
        prep.setString(3, formattedTimestamp);
        prep.setString(4, tags);
        prep.setString(5, postDescription);
        prep.executeUpdate();
        return postDTO;
    } catch(SQLException e) {
            System.out.println("Error: Could not update PensePosts Database");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BlogPostDTO> findByEmail(String emailId) throws SQLException {
        try {
            Connection dbConnection = DatabaseConnection.getInstance();
            String find = "SELECT * FROM PENSEPOSTS WHERE EMAIL = ?";
            PreparedStatement prep = dbConnection.prepareStatement(find);
            prep.setString(1, emailId);
            ResultSet posts = prep.executeQuery(); //result set of all posts connected to the given tag
            List<BlogPostDTO> PostsPerEmail = new ArrayList<>();
            while(posts.next()) { //getting each post from the result set
                BlogPostDTO currentDTO = new BlogPostDTO(); //creating a new DTO each time, to add to the list
                currentDTO.setPostID(posts.getInt("postID"));

                //getting timestamp from the DB in String format and converting it to LocalDateTime format
                String timestampString = posts.getString("timestamp");
                if(!timestampString.equals("No time available")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime timestamp = LocalDateTime.parse(timestampString, formatter); //converting String to LocalDateTime
                    currentDTO.setTimestamp(timestamp);
                }

                currentDTO.setTitle(posts.getString("title"));
                currentDTO.setTag(posts.getString("tag"));
                currentDTO.setEmail(emailId);
                currentDTO.setDescription(posts.getString("description"));
                PostsPerEmail.add(currentDTO); //putting each post into the array list of posts
            }
            return PostsPerEmail;
        } catch(SQLException e) {
            System.out.println("SQL Error: Could not retrieve posts for given email");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BlogPostDTO> findByTag(String tag) throws SQLException {
        try {
            Connection dbConnection = DatabaseConnection.getInstance();
            String find = "SELECT * FROM PENSEPOSTS WHERE tag LIKE ?"; //select posts that contain the given tag among all tags
            PreparedStatement prep = dbConnection.prepareStatement(find);
            prep.setString(1, "%" + tag + "%"); //parameter for "find" string
            ResultSet taggedposts = prep.executeQuery(); //result set of all posts connected to the given email address
            List<BlogPostDTO> PostsPerTag = new ArrayList<>();
            while(taggedposts.next()) { //getting each post from the result set
                BlogPostDTO currentDTO = new BlogPostDTO(); //creating a new DTO each time, to add to the list
                currentDTO.setPostID(taggedposts.getInt("postID"));

                //getting timestamp from the DB in String format and converting it to LocalDateTime format
                String timestampString = taggedposts.getString("timestamp");
                if(!timestampString.equals("No time available")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    LocalDateTime timestamp = LocalDateTime.parse(timestampString, formatter); //converting String to LocalDateTime
                    currentDTO.setTimestamp(timestamp);
                }

                currentDTO.setTitle(taggedposts.getString("title"));
                currentDTO.setTag(taggedposts.getString("tag"));
                currentDTO.setEmail(taggedposts.getString("email"));
                currentDTO.setDescription(taggedposts.getString("description"));
                PostsPerTag.add(currentDTO); //putting each post into the array list of posts
            }
            return PostsPerTag;
        } catch(SQLException e) {
            System.out.println("SQL Error: Could not retrieve posts for given tag");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        try {
            Connection dbConnection = DatabaseConnection.getInstance();
            String delete = "DELETE FROM PENSEPOSTS WHERE PostID=?";
            PreparedStatement prep = dbConnection.prepareStatement(delete);
            prep.setInt(1, id);
            prep.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println("SQL Error: Could not delete post");
            e.printStackTrace();
        }
        return false;
    }

    /* main method for testing
    public static void main(String[] args) throws SQLException {
        BlogPostDTO testDTO = new BlogPostDTO();
        BlogPostDAO testDAO = new BlogPostDAO();
        testDTO.setTitle("title");
        testDTO.setTimestamp(LocalDateTime.now());
        testDTO.setTag("hello");
        testDTO.setEmail("email");
        testDAO.create(testDTO);
        System.out.println(testDTO.toString());
        List<BlogPostDTO> list = testDAO.findByTag("poetry");
        if(!list.isEmpty()) {
            System.out.println(list.toString());
        }
        System.out.println(testDAO.deleteById(5));
    }

     */



}

