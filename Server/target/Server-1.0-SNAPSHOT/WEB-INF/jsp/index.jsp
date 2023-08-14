<%-- 
    Document   : index.jsp
    Created on : Aug 13, 2023, 8:38:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Welcome to our website!!!</h1>
        <ul>
            <c:forEach items="${users}" var="p">
                <li>${p.userId} - ${p.username} - ${p.role}</li>
            </c:forEach>
        </ul>
    </body>
</html>
