package com.tcs.ilp.infinity.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.infinity.model.User;
import com.tcs.ilp.infinity.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        LoginService ls = new LoginService();
        
        User user = ls.validateUserLogin(username, password);
        
        if(user != null){ // username and password match
            
        	//Obtain the session object, create a new session if doesn't exist
            HttpSession session = request.getSession(true);
            session.setAttribute("userID", String.valueOf(user.getUserID()));
            session.setAttribute("username", user.getUserName());
            session.setAttribute("role", user.getRole());
       
//            Cookie cookie1 = new Cookie("userID", String.valueOf(user.getUserID()));
//            Cookie cookie2 = new Cookie("username", user.getUserName());
//            Cookie cookie3 = new Cookie("role", user.getRole());
//            cookie1.setMaxAge(60*60*24); // 24 hours for expiry
//            cookie2.setMaxAge(60*60*24); // 24 hours for expiry
//            cookie3.setMaxAge(60*60*24); // 24 hours for expiry
//            response.addCookie(cookie1);
//            response.addCookie(cookie2);
//            response.addCookie(cookie3);
            
            String role = user.getRole();
            
            if(role.equals("Admin")){
            	//redirect to admin home page
            	RequestDispatcher requestDispatcher; 
            	requestDispatcher = request.getRequestDispatcher("/Admin.jsp");
            	requestDispatcher.forward(request, response);
            } else if(role.equals("Operator")){
            	//redirect to operator home page
            	RequestDispatcher requestDispatcher; 
            	requestDispatcher = request.getRequestDispatcher("/Operator.jsp");
            	requestDispatcher.forward(request, response);
            } else if(role.equals("Customer")){
            	//redriect to customer home page
            	RequestDispatcher requestDispatcher; 
            	requestDispatcher = request.getRequestDispatcher("/Customer.jsp");
            	requestDispatcher.forward(request, response);
            }
        } else { // username or password incorrect
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("/Login.jsp");
			request.setAttribute("error", "true"); //check for this value in the login jsp
			reqDispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("userID", null);
        session.setAttribute("username", null);
        session.setAttribute("role", null);
	}

}
