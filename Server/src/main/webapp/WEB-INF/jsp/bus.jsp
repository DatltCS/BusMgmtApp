<%-- 
    Document   : bustrip
    Created on : Aug 21, 2023, 10:51:56 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">Bus Management</h1>

<form:form method="post" modelAttribute="bus">
    <form:hidden path="image" />
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="busName" 
                    path="busName" placeholder="Enter Bus Name"/>
        <label for="email">Bus Name</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="totalSeat" 
                    path="totalSeat" placeholder="Enter Total Seat"/>
        <label for="email">Total Seat</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="buscompanies" name="buscompanies"
                     path="companyId">
            <c:forEach items="${buscompanies}" var="bc">
                <option value="${companyId}">${bc.companyName}</option>
            </c:forEach>
            
        </form:select>
                
        <label for="sel1" class="form-label">Select list (select one):</label>
    </div>
        
        <button class = "btn btn-info">Add New</button>
        
</form:form>