package com.MoonLikeCats.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.MoonLikeCats.conn.DBConnectionUtils;
import com.MoonLikeCats.utils.SessionUtils;

@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/cancel" })
public class JDBCFilter implements Filter {

    public JDBCFilter() {
        
    }
    public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("inside JDBCFilter init");
    }

    // Check the target of the request is a servlet?
    private boolean needJDBC(HttpServletRequest request) {
        
        // 
        // Servlet Url-pattern: /spath/*
        // 
        // => /spath
        String servletPath = request.getServletPath();
        // => /abc/mnp
        String pathInfo = request.getPathInfo();
 
        String urlPattern = servletPath;
 
        if (pathInfo != null) {
            // => /spath/*
            urlPattern = servletPath + "/*";
        }
 
        // Key: servletName.
        // Value: ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
 
        // Collection of all servlet in your Webapp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
            	System.out.println("inside JDBCFilter needJDBC? True");
                return true;
            }
        }
        System.out.println("inside JDBCFilter needJDBC? False");
        return false;
    }
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("inside JDBCFilter doFilter");

		HttpServletRequest req = (HttpServletRequest) request;
		 
        // Only open connections for the special requests.
        // (For example, the path to the servlet, JSP, ..)
        // 
        // Avoid open connection for commons request.
        // (For example: image, css, javascript,... )
        // 
        if (this.needJDBC(req)) {
 
            System.out.println("Open Connection for: " + req.getServletPath());
 
            Connection conn = null;
            try {
                // Create a Connection.
                conn = DBConnectionUtils.getDBConnection();
                // Set auto commit to false.
                conn.setAutoCommit(false);
 
                // Store Connection object in attribute of request.
                SessionUtils.storeConnection(request, conn);
 
                // Allow request to go forward
                // (Go to the next filter or target)
                chain.doFilter(request, response);
 
                // Invoke the commit() method to complete the transaction with the DB.
                conn.commit();
            } catch (Exception e) {
                e.printStackTrace();
                DBConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
            	DBConnectionUtils.closeQuietly(conn);
            }
        }
        // With commons requests (images, css, html, ..)
        // No need to open the connection.
        else {
            // Allow request to go forward
            // (Go to the next filter or target)
            chain.doFilter(request, response);
        }
	}


	public void destroy() {
		System.out.println("inside JDBCFilter destroy");
	}
}
