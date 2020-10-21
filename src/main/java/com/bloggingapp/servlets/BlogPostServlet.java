package com.bloggingapp.servlets;

import com.bloggingapp.dao.BlogPostDAO;
import com.bloggingapp.dao.DAOFactory;
import com.bloggingapp.dao.UserDAO;
import com.bloggingapp.dto.BlogPostDTO;
import com.bloggingapp.dto.UserDTO;
import com.bloggingapp.services.BlogPostService;
import com.bloggingapp.services.ServiceFactory;
import com.bloggingapp.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/makepost")
public class BlogPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); //get existing session
        BlogPostService postService = ServiceFactory.getBlogPostService(); //get instance of BlogPostService class from ServiceFactory
        if(session.getAttribute("username") == null) {
            resp.sendRedirect("index.jsp"); //if session has expired, return to the login page.
        }

        /*else if session is still valid:
        if the "Post!" button is pressed on create.jsp,
        set values of post DTO object from input fields. */
        else if(req.getParameter("postButton") != null) {
            BlogPostDTO BP_DTO = new BlogPostDTO();  //create BlogPostDTO (data transfer object)
            BP_DTO.setEmail((String) session.getAttribute("emailId"));
            BP_DTO.setTimestamp(LocalDateTime.now());
            BP_DTO.setTitle(req.getParameter("post_title"));
            BP_DTO.setTag(req.getParameter("post_tags"));
            BP_DTO.setDescription(req.getParameter("post_description"));
            session.setAttribute("postDTO", BP_DTO);
            postService.savePost(BP_DTO);//save the newly created post to the database
            resp.sendRedirect("view.jsp");
        }

    }
}
