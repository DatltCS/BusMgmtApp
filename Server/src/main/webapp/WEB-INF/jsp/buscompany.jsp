<%-- 
    Document   : buscompany
    Created on : Aug 29, 2023, 11:12:58 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">Bus Company Management</h1>

<c:url value="/buscompanies" var="action" />
<form:form method="post" action="${action}" modelAttribute="buscompany" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="nameCompany" 
                    path="nameCompany" placeholder="Enter Name Company"/>
        <label for="licensePlateId">Name Company</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" id="totalBus" 
                    path="totalBus" placeholder="Enter Total Bus"/>
        <label for="busName">Total Bus</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" 
                    path="file"/>
        <label for="busType">Avatar</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="address" 
                    path="address" placeholder="Enter Address"/>
        <label for="busType">Address</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="phone" 
                    path="phone" placeholder="Enter Phone Number"/>
        <label for="phone">Phone Number</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="email" 
                    path="email" placeholder="Enter Email"/>
        <label for="email">Email</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="allowedDelivery" 
                    path="allowedDelivery" placeholder="Enter Allowed Delivery"/>
        <label for="allowedDelivery">Allowed Delivery</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="users" name="users"
                     path="userId">
            <c:forEach items="${users}" var="u">
                <c:choose>
                    <c:when test="${u.userId == buscompany.userId.userId}">
                        <option value="${u.userId}" selected>${u.username}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${u.userId}">${u.username}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

        </form:select>

        <label for="user" class="form-label">List of Username</label>
    </div>

    <div class="form-floating mb-3 mt-3">
        <button class = "btn btn-info mt-1" type="submit">Add New</button>
    </div>

</form:form>