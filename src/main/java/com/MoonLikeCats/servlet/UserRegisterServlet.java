package com.MoonLikeCats.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.MoonLikeCats.config.AppConfig;
import com.MoonLikeCats.conn.DBConnectionUtils;
import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.service.ClientService;
import com.MoonLikeCats.utils.DBUtils;
import com.MoonLikeCats.utils.SessionUtils;

@WebServlet(urlPatterns = { "/dummy3" })
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserRegisterServlet() {
    	super();
		System.out.println("inside UserRegisterServlet constructor");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside UserRegisterServlet doGet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside UserRegisterServlet doPost");
		
		Date childBirthdate;
		try {
			childBirthdate = Date.valueOf(request.getParameter("childBirthdate"));
		} catch (IllegalArgumentException e1) {
			System.out.println("inside catch IllegalArgumentException");
			childBirthdate = null;
		}
				
		String email = request.getParameter("email");
		String displayName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
        String password = request.getParameter("password");
        String retypePassword = request.getParameter("retype-password");
        //String rememberMeStr = request.getParameter("rememberMe");
        //boolean remember = "Y".equals(rememberMeStr);
 
        Client user = null;
        boolean hasError = false;
        String errorString = null;
 
        if (email == null || password == null || email.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required email and password!";
        } else {
        	
        	if (!password.equals(retypePassword)) {
        		hasError = true;
                errorString = "re-type password must be same with password";
        	} else {
        		
        		//Connection conn = SessionUtils.getStoredConnection(request);
        		try {
        			// create the user in the DB.
        			//user = DBUtils.registerUser(conn, email, userName, phone, address, childBirthdate, password);
        			
        			//user = DBUtils.registerClient(email, displayName, phone, address, childBirthdate, password);
        			AnnotationConfigApplicationContext context = 
        	                new AnnotationConfigApplicationContext(AppConfig.class);
        			ClientService clientService = context.getBean(ClientService.class);
        			
        			user = new Client();
        			user.setEmail(email);
        			user.setDisplayName(displayName);
        			user.setPhone(phone);
        			user.setAddress(address);
        			user.setChildBirthdate(childBirthdate);
        			user.setPassword(password);
                    user.setRole("Client");
                    java.util.Date date =  new java.util.Date();
                    Timestamp dateCreated = new Timestamp(date.getTime());
                    user.setDateCreated(dateCreated);
                    
                    clientService.create(user);
                    
//        			if (user == null) {
//        				hasError = true;
//        				errorString = "no currentUser";
//        			}
        		} catch (Exception e) {
        			e.printStackTrace();
        			hasError = true;
        			errorString = e.getMessage();
        		}
        	}
        }
        // If error, forward to /WEB-INF/views/login.jsp
        if (hasError) {
            user = new Client();
            user.setDisplayName(displayName);
            user.setPassword(password);
 
            // Store information in request attribute, before forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);
            
            System.out.println(errorString);
 
            // Forward to /WEB-INF/views/login.jsp
//            RequestDispatcher dispatcher 
//                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
// 
//            dispatcher.forward(request, response);
        }
        // If no error
        // Store user information in Session
        // And redirect to userInfo page.
        else {
            HttpSession session = request.getSession();
            SessionUtils.storeLoginedUser(session, user);
 
            // If user checked "Remember me".
//            if (remember) {
//            	SessionUtils.storeUserCookie(response, user);
//            }
//            // Else delete cookie.
//            else {
//            	SessionUtils.deleteUserCookie(response);
//            }
 
            // Redirect to userInfo page.
            //response.sendRedirect(request.getContextPath() + "/userInfo");
        }
	}

}
