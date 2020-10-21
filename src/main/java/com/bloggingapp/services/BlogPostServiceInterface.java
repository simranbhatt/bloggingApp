 package com.bloggingapp.services;
import com.bloggingapp.dao.BlogPostDAO;
import com.bloggingapp.dto.BlogPostDTO;

    public interface BlogPostServiceInterface {

        BlogPostDTO savePost(BlogPostDTO userDTO);

    }

