<%-- 
    Document   : admin
    Created on : 28 Oct, 2010, 11:43:13 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            if(!request.getSession().getAttribute("logged-group").toString().equals("Admin"))
//                application.getRequestDispatcher("/index.jsp");
//            %>
        <h1>Hello Administrators !!!</h1>
        <a href="/TestSecurityApp/SecureServlet"> Secure Servlet </a>
        <br><br><br><a href="logout.jsp">Log out </a>
   
    </body>
</html>
