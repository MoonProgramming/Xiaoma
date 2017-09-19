<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<h1>Hello JSP</h1>
<h2>Now is
<% java.util.Date date = new java.util.Date(); %>
<%=date.toString() %>
<% out.println("<p>Fuck U! the date is "+ date +"<p>"); %>
</h2>

<%
        Random random = new Random();
 
        // Returns a random number (0, 1 or 2)
        int randomInt = random.nextInt(3);
        if (randomInt == 0) {
    %> 
    
    <h1>Random value =<%=randomInt%> haha looser!</h1>
     
    <%
        } else if (randomInt == 1) {
    %>
     
    <h2>Random value =<%=randomInt%> Just 1?</h2>
 
    <%
        } else {
    %>
     <h3>Random value =<%=randomInt%> Fuck You!</h3>
    <%
        }
    %>
 
    <a href="<%= request.getRequestURI() %>">Try Again</a>
    <% out.println(request.getRequestURI()); %>

</body>
</html>