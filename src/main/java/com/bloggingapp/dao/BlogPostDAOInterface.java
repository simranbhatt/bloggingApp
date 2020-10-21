package com.bloggingapp.dao;

import com.bloggingapp.dto.BlogPostDTO;

import java.sql.SQLException;
import java.util.List;

public interface BlogPostDAOInterface {
    BlogPostDTO create(BlogPostDTO postDTO) throws SQLException;
    List<BlogPostDTO> findByEmail(String emailId) throws SQLException;
    List<BlogPostDTO> findByTag(String tag) throws SQLException;
    boolean deleteById(int id) throws SQLException;
}
