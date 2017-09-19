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

@WebServlet(urlPatterns = { "/dummy5" })
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Client loginedUser;

	public UserUpdate() {
		super();
		System.out.println("inside UserUpdate constructor");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// (Users can not access directly into JSP pages placed in WEB-INF)
		System.out.println("inside UserUpdate doGet");
		
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
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user-update.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside UserUpdate doPost");
		
		String updateMessage = null;
		
		if (request.getParameter("updateChildBirthdate") != null) {
		    // Invoke FirstServlet's job here.
			System.out.println("updating ChildBirthdate...");
			
			Date childBirthdate;
			try {
				childBirthdate = Date.valueOf(request.getParameter("user-date-childBirthdate"));
			} catch (IllegalArgumentException e1) {
				System.out.println("inside catch IllegalArgumentException");
				childBirthdate = null;
			}
			if (childBirthdate != null) {
				loginedUser.setChildBirthdate(childBirthdate);
				DBUtils.updateUser(loginedUser);
				
				HttpSession session = request.getSession();
				SessionUtils.storeLoginedUser(session, loginedUser);
				
				updateMessage = "Update ChildBirthdate successful";
			} else {
				updateMessage = "Update failed, Invalid date format";			
			}
			
			
		} else if (request.getParameter("updateUserInfo") != null) {
		    // Invoke SecondServlet's job here.
			System.out.println("updating UserInfo...");
			
			String displayName = request.getParameter("user-input-displayName");
 	        String phone = request.getParameter("user-input-Tel");
 	        
 	       if (displayName == null || phone == null || displayName.length() == 0 || phone.length() == 0) {
             
             updateMessage = "Update failed, Required name and phone!";
 	       } else {
 	    	   
 	    	  loginedUser.setDisplayName(displayName);
 	    	  loginedUser.setPhone(phone);
				DBUtils.updateUser(loginedUser);
				
				HttpSession session = request.getSession();
				SessionUtils.storeLoginedUser(session, loginedUser);
				
				updateMessage = "Update UserInfo successful";
 	       }
 	        
		}
		// Store info to the request attribute before forwarding.
		if (updateMessage != null) {
			request.setAttribute("updateMessage", updateMessage);
		}
		request.setAttribute("user", loginedUser);
		
		SessionUtils.storeUserCookie(response, loginedUser);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/user-update.jsp");
		dispatcher.forward(request, response);
		
	}

}
