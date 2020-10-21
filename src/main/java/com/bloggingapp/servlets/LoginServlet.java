package com.bloggingapp.servlets;

import com.bloggingapp.dao.DAOFactory;
import com.bloggingapp.dao.UserDAO;
import com.bloggingapp.dto.BlogPostDTO;
import com.bloggingapp.dto.UserDTO;
import com.bloggingapp.services.BlogPostService;
import com.bloggingapp.services.ServiceFactory;
import com.bloggingapp.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login") //handles index.jsp and signup.jsp
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(); //session object
        String emailExpression = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; //email regex
        UserService userService = ServiceFactory.getUserService(); //UserService object for adding and
        // retrieving to database
        BlogPostService postService = ServiceFactory.getBlogPostService(); //BlogPostService for getting user's posts


        //if user has pressed the login button on index.jsp
        if (req.getParameter("loginButton") != null) {
            String password = req.getParameter("password");
            String emailId = req.getParameter("emailId");
            UserDTO crosscheckObject = userService.getUser(emailId);

            //check if email or password are invalid
            if (crosscheckObject.getUserID() == 0 || !password.equals(crosscheckObject.getPassword())) {
                req.setAttribute("message", "Invalid email or password!");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
            //else if email and password are valid
            else {
                String username = crosscheckObject.getFirstName().substring(0, 1).toUpperCase() + crosscheckObject.getFirstName().substring(1).toLowerCase();
                session.setAttribute("username", username);
                session.setAttribute("emailId", emailId);
                //retrieve all the user's posts from the Pense Posts database and store
                // in a session attribute to display on their home page (using JSTL in home.jsp)
                List<BlogPostDTO> posts;
                posts = postService.getPostsByEmail(emailId);
                session.setAttribute("userPosts", posts);
                resp.sendRedirect("home.jsp");
            }

        }
        //if the user has pressed the register button on signup.jsp
        if (req.getParameter("registerButton") != null) {

            String emailId = req.getParameter("emailId");
            String password = req.getParameter("password");
            UserDTO crosscheckObject = userService.getUser(emailId);
            //if email is not valid, display an invalid message

            if(req.getParameter("firstname").length() < 2) {
                req.setAttribute("namemessage", "Name should be more than 1 character long.");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }
            if (!emailId.matches(emailExpression)) {
                req.setAttribute("emailmessage", "Please enter a valid email address.");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }
            if (crosscheckObject.getUserID() != 0) {
                req.setAttribute("emailmessage", "This email is already registered!");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }
            if (password.length() < 6) {
                req.setAttribute("passwordmessage", "Password should be atleast 6 characters long.");
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
                return;
            }

            //if entered details are valid, set session email and redirect to login page
            UserDTO newUser = new UserDTO();
            newUser.setFirstName(req.getParameter("firstname"));
            newUser.setLastName(req.getParameter("lastname"));
            newUser.setEmail(emailId);
            newUser.setPassword(password);
            userService.saveUser(newUser);
            session.setAttribute("emailId", emailId);
            resp.sendRedirect("index.jsp");
        }
    }

}






