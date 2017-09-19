package com.MoonLikeCats.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MoonLikeCats.config.AppConfig;
import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.model.User;
import com.MoonLikeCats.service.ClientService;
import com.MoonLikeCats.utils.SessionUtils;

@Controller
public class ClientController {

	public ClientController() {
		System.out.println("Inside ClientController constructor");
	}

	@Autowired
	private ClientService clientService;

	@GetMapping("/userRegister")
	public String initForm(ModelMap model) {

		Client client = new Client();
		// Make role "Client" as default value
		client.setRole("Client");

		// command object
		model.addAttribute("client", client);

		// return form view
		return null;
	}

	@PostMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request, Model model) {
		System.out.println("Inside HomeController userRegister");

		Date childBirthdate;
		try {
			childBirthdate = Date.valueOf(request.getParameter("childBirthdate"));
		} catch (IllegalArgumentException e1) {
			System.out.println("IllegalArgumentException: childBirthdate invalid, set to null");
			childBirthdate = null;
		}
		String email = request.getParameter("email");
		String displayName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retype-password");

		Client currentUser = null;
		boolean hasError = false;
		String errorString = null;

		if (email == null || password == null || email.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "建立帳戶失敗： Required email and password!";
		} else {

			if (!password.equals(retypePassword)) {
				hasError = true;
				errorString = "建立帳戶失敗： re-type password must be same with password";
			} else {

				try {
					currentUser = new Client();
					currentUser.setEmail(email);
					currentUser.setDisplayName(displayName);
					currentUser.setPhone(phone);
					currentUser.setAddress(address);
					currentUser.setChildBirthdate(childBirthdate);
					currentUser.setPassword(password);
					currentUser.setRole("Client");
					// java.util.Date date = new java.util.Date();
					// Timestamp dateCreated = new Timestamp(date.getTime());
					// currentUser.setDateCreated(dateCreated);

					clientService.create(currentUser);

				} catch (Exception e) {
					e.printStackTrace();
					hasError = true;
					errorString = e.getMessage();
				}
			}
		}
		// If error, forward to /WEB-INF/views/home.jsp
		if (hasError) {

			ModelAndView mav = new ModelAndView("home");
			// Store information in request attribute, before forward.
			model.addAttribute("updateMessage", errorString);
			model.addAttribute("user", currentUser);

			System.out.println(errorString);
			return mav;
		}
		// If no error
		// Store user information in Session
		// And redirect to userInfo page.
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", currentUser);

			ModelAndView mav = new ModelAndView("user-update");
			return mav;
		}
	}

	// @PostMapping("/saveUser")
	// public String saveUser(@ModelAttribute("user") @Valid User user,
	// BindingResult result, Model model) {
	//
	// if (result.hasErrors()) {
	//
	// model.addAttribute("users", userService.list());
	// return "userForm";
	// }
	//
	// clientService.create(client);
	//
	// return "redirect:/";
	// }
}
