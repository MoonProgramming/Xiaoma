package com.MoonLikeCats.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

@WebServlet(urlPatterns = { "/dummy4" })
public class UserSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Client loginedUser;

	public UserSetting() {
		super();
		System.out.println("inside UserSetting constructor");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// (Users can not access directly into JSP pages placed in WEB-INF)
		System.out.println("inside UserSetting doGet");
		
		HttpSession session = request.getSession();
		
		// Check User has logged on
		loginedUser = (Client) SessionUtils.getLoginedUser(session);
		
		 // Not logged in
        if (loginedUser == null) {
            // Redirect to login page.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Store info to the request attribute before forwarding.
        request.setAttribute("user", loginedUser);
 
        // If the user has logged in, then forward to the page
        // /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher 
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user-setting.jsp");
        dispatcher.forward(request, response);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside UserSetting doPost");

		String updateMessage = null;
		
		if (request.getParameter("updateUserEmail") != null) {
		    // Invoke FirstServlet's job here.
			System.out.println("updating user email...");
			
			String email = request.getParameter("user-input-email");
			
			if (email == null || email.length() == 0) {
	             
	             updateMessage = "Update failed, email is empty!";
	 	       } else {
	 	    	   
	 	    	  loginedUser.setEmail(email);
	 	    	  
					DBUtils.updateUser(loginedUser);
					
					HttpSession session = request.getSession();
					SessionUtils.storeLoginedUser(session, loginedUser);
					
					updateMessage = "Update user email successful";
					SessionUtils.storeUserCookie(response, loginedUser);
	 	       }
			
			
		} else if (request.getParameter("updateUserPassword") != null) {
		    // Invoke SecondServlet's job here.
			System.out.println("updating user password...");
			
			String password = request.getParameter("user-input-pwd");
 	        String retypePassword = request.getParameter("user-reinput-pwd");
 	        
 	       if (password == null || retypePassword == null || password.length() == 0 || retypePassword.length() == 0) {
             
             updateMessage = "Update failed, password is required";
 	       } else {
 	    	   
 	    	   if (!password.equals(retypePassword)) {
 	    		  updateMessage = "Update failed, please retype the same new password";
 	    	   } else {
 	    		   
 	    		   loginedUser.setPassword(password);
 	    		   DBUtils.updateUser(loginedUser);
 	    		   
 	    		   HttpSession session = request.getSession();
 	    		   SessionUtils.storeLoginedUser(session, loginedUser);
 	    		   
 	    		   updateMessage = "Update password successful";
 	    		  SessionUtils.storeUserCookie(response, loginedUser);
 	    	   }
 	       }        
		}
		
		else if (request.getParameter("deleteUserAcc") != null) {
			
			System.out.println("deleting user...");
			
			DBUtils.deleteUser(loginedUser);
			loginedUser = null;
			SessionUtils.deleteUserCookie(response);
			
			HttpSession session = request.getSession();
  		    SessionUtils.storeLoginedUser(session, loginedUser);
  		    
  		    updateMessage = "user delete successful";
  		  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/home");
  		dispatcher.forward(request, response);
  		return;
		}
		
		// Store info to the request attribute before forwarding.
		if (updateMessage != null) {
			request.setAttribute("updateMessage", updateMessage);
		}
		request.setAttribute("user", loginedUser);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user-setting.jsp");
		dispatcher.forward(request, response);
		
	}

}
