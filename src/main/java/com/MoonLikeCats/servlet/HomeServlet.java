package com.MoonLikeCats.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/dummy1" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
		System.out.println("inside HomeServlet constructor");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward to /WEB-INF/views/homeView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		System.out.println("inside HomeServlet doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");

		dispatcher.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside HomeServlet doPost");
		doGet(request, response);
	}

}
