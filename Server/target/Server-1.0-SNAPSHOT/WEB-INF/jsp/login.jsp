<%-- 
    Document   : login
    Created on : Aug 24, 2023, 11:52:42 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-floating mb-3 mt-3">
        <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        <label for="email">Username</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="text" class="form-control" id="password" placeholder="Enter password" name="password">
        <label for="pwd">Password</label>
    </div>
    
    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Login" class="btn btn-danger"/>
    </div>
    
</form>