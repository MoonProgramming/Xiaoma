package com.MoonLikeCats.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MoonLikeCats.model.User;
import com.MoonLikeCats.service.UserService;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("Inside HomeController constructor");
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public ModelAndView showHome(HttpSession session) {
		System.out.println("Inside HomeController showHome");
		ModelAndView mav = new ModelAndView("home");
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        System.out.println("currentUser is: " + loggedInUser);
        
        if (loggedInUser != null && loggedInUser.getRole().equals("Client")) {
        	// currentUser logged-in as Client
        } 
        else if (loggedInUser != null && loggedInUser.getRole().equals("Service Provider")) {
        	// currentUser logged-in as Service Provider
        }
        
        return mav; 
    }
	
	@GetMapping("/login")
	public String showLogin(HttpServletRequest request) {
		System.out.println("Inside HomeController showLogin");

        return "login";
    }
	
	@PostMapping("/login")
	public String doLogin(HttpServletRequest request, HttpSession session) {
		System.out.println("Inside HomeController doLogin");
		
		String userEmail = request.getParameter("email");
        String password = request.getParameter("password");
        
        User currentUser = null;
        boolean hasError = false;
        String updateMessage = null;
        
        if (userEmail == null || password == null || userEmail.length() == 0 || password.length() == 0) {
            hasError = true;
            updateMessage = "Required email and password!";
        } else {
        	try {
        		currentUser = userService.retrieve(userEmail, password);
        		if (currentUser == null) {
                    hasError = true;
                    updateMessage = "User email or password invalid";
                }
        	}
        	catch (Exception e) {
        		e.printStackTrace();
                hasError = true;
                updateMessage = e.getMessage();
        	}
        	
        	if (hasError) {
        		currentUser = new User();
        		currentUser.setEmail(userEmail);
        		currentUser.setPassword(password);
                
                // Store information in request attribute, before forward.
                request.setAttribute("updateMessage", updateMessage);
                request.setAttribute("user", currentUser);
                return "login";
        	}
        	else {
        		session.setAttribute("user", null);
        		session.setAttribute("loggedInUser", currentUser);
        		updateMessage = "Logged in successful";
        		request.setAttribute("updateMessage", updateMessage);
        		return "home";
        	}
        }
        request.setAttribute("updateMessage", updateMessage);
		return null;
	}
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpSession session) {
		System.out.println("Inside HomeController showDashboard");
		
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        System.out.println("loggedInUser is: " + loggedInUser);
        
        if (loggedInUser != null && loggedInUser.getRole().equals("Client")) {
        	// currentUser logged-in as Client
        	return "user-update";
        } 
        else if (loggedInUser != null && loggedInUser.getRole().equals("Service Provider")) {
        	// currentUser logged-in as Service Provider
        	return "sp-update";
        }
        
        return "login"; 
    }
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpSession session) {
		System.out.println("Inside HomeController logout");
		
		session.invalidate();
		String updateMessage = "Logged out successful";
		request.setAttribute("updateMessage", updateMessage);
		return "home";
	}
}
