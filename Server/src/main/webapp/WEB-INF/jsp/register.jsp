<%-- 
    Document   : register
    Created on : Aug 26, 2023, 7:30:34 PM
    Author     : Admin
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/register" var="action" />
<form:form method="post" action="${action}" modelAttribute="users">
<form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <label for="username">Username</label>
        <form:input type="text" class="form-control" id="username" placeholder="Enter username" path="username" />
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" id="password" placeholder="Enter username" path="password" />
        <label for="pwd">Password</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <form:input type="password" class="form-control" id="confirm-password" placeholder="Enter username" path="confirmPassword" />
        <label for="confirm-pwd">Confirm Password</label>
    </div>

    <div class="form-floating mt-3 mb-3">
        <input type="submit" value="Login" class="btn btn-danger"/>
    </div>

</form:form>
