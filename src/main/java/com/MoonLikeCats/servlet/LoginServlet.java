package com.MoonLikeCats.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MoonLikeCats.conn.DBConnectionUtils;
import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.model.User;
import com.MoonLikeCats.utils.DBUtils;
import com.MoonLikeCats.utils.SessionUtils;

@WebServlet(urlPatterns = { "/dummy2" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		System.out.println("inside LoginServlet constructor");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// (Users can not access directly into JSP pages placed in WEB-INF)
		System.out.println("inside LoginServlet doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");

		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside LoginServlet doPost");
		
		String userEmail = request.getParameter("email");
        String password = request.getParameter("password");
        //String rememberMeStr = request.getParameter("rememberMe");
        //boolean remember = "Y".equals(rememberMeStr);
        
        User user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (userEmail == null || password == null || userEmail.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required email and password!";
        } else {
            //Connection conn = SessionUtils.getStoredConnection(request);
            try {
            	
                // Find the user in the DB.
                //user = DBUtils.findUser(conn, userEmail, password);
            	user = DBUtils.retrieveUser(userEmail, password);
            	
                if (user == null) {
                    hasError = true;
                    errorString = "User email or password invalid";
                }
            } catch (Exception e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
            user = new User();
            user.setEmail(userEmail);
            user.setPassword(password);
            
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
 
            // Forward to /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            SessionUtils.storeLoginedUser(session, user);
 
            // If user checked "Remember me".
            //if (remember) {
            	SessionUtils.storeUserCookie(response, user);
            //}
            // Else delete cookie.
//            else {
//            	SessionUtils.deleteUserCookie(response);
//            }
 
            // Redirect to userInfo page.
            response.sendRedirect(request.getContextPath() + "/user/userSetting");
        	System.out.println("login success and redirect to user dashboard");
        }
	}

}
