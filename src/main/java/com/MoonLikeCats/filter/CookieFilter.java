package com.MoonLikeCats.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.MoonLikeCats.model.Client;
import com.MoonLikeCats.model.User;
import com.MoonLikeCats.utils.DBUtils;
import com.MoonLikeCats.utils.SessionUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/cancel" })
public class CookieFilter implements Filter {

    public CookieFilter() {
        
    }

    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("inside CookieFilter init");
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("inside CookieFilter doFilter");

		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
 
        User userInSession = SessionUtils.getLoginedUser(session);
        // 
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
 
        // Connection was created in JDBCFilter.
        //Connection conn = SessionUtils.getStoredConnection(request);
 
        // Flag check cookie
//        String checked = (String) session.getAttribute("COOKIE_CHECKED");
//        if (checked == null && conn != null) {
//            String userName = SessionUtils.getUserEmailInCookie(req);
//            try {
//                UserAccount user = DBUtils.findUser(conn, userName);
//                SessionUtils.storeLoginedUser(session, user);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            // Mark checked Cookies.
//            session.setAttribute("COOKIE_CHECKED", "CHECKED");
//        }
 
        chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("inside CookieFilter destroy");
	}

}
