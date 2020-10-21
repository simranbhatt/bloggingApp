package com.bloggingapp.servlets;

import com.bloggingapp.dto.BlogPostDTO;
import com.bloggingapp.services.BlogPostService;
import com.bloggingapp.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/blogaction")
public class BlogActionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        BlogPostService postService = ServiceFactory.getBlogPostService();
        if(session.getAttribute("username") == null) {
            resp.sendRedirect("index.jsp"); //if session has expired, return to the login page.
            return;
        }
        //if a user searches for a term, query the database by email or tag using the functions defined
        //in the BlogPostDAO class
        if(req.getParameter("searchButton") != null) {
            String searchTerm = req.getParameter("search");
            List<BlogPostDTO> posts = new ArrayList<>();
            if(searchTerm.contains("@")) {
                posts = postService.getPostsByEmail(searchTerm);
            }
            else {
                posts = postService.getPostsByTag(searchTerm);
            }
            session.setAttribute("searchResult", posts);
            resp.sendRedirect("search.jsp");

        }

        // if the user presses the delete button next to a post,
        // delete that post from the PensePosts database
        else if(req.getParameter("trashButton") != null) {
            int id = Integer.parseInt(req.getParameter("trashButton"));
            postService.deletePost(id);
            resp.sendRedirect("home.jsp");
        }
    }
}
