<%-- 
    Document   : bus
    Created on : Aug 22, 2023, 5:01:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-info">Bus Management</h1>

<<<<<<< HEAD
<c:url value="/buses" var="action" />
<form:form method="post" action="${action}" modelAttribute="bus" enctype="multipart/form-data">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <form:hidden path="image"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="licensePlateId" 
                    path="licensePlateId" placeholder="Enter License PlateId"/>
        <label for="licensePlateId">License Plate</label>
    </div>
=======
<form:form method="post" modelAttribute="bus">
    <form:hidden path="image" />
>>>>>>> be3458d405526b82a5d82d467d61aa24bfa672a3
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="busName" 
                    path="busName" placeholder="Enter Bus Name"/>
        <label for="busName">Bus Name</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" class="form-control" id="totalSeat" 
                    path="totalSeat" placeholder="Enter Total Seat"/>
        <label for="totalSeat">Total Seat</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" class="form-control" id="busType" 
                    path="busType" placeholder="Enter Bus Type"/>
        <label for="busType">Bus Type</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file" class="form-control" id="file" 
                    path="file"/>
        <label for="busType">Image Bus</label>
    </div>

    <div class="form-floating">
        <form:select class="form-select" id="buscompanies" name="buscompanies"
                     path="companyId">
            <c:forEach items="${buscompanies}" var="bc">
                <c:choose>
                    <c:when test="${bc.companyId == bus.companyId.companyId}">
                        <option value="${bc.companyId}" selected>${bc.nameCompany}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${bc.companyId}">${bc.nameCompany}</option>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

        </form:select>

        <label for="companies" class="form-label">List of Bus Company</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <button class = "btn btn-info mt-1" type="submit">
            <c:choose>
                <c:when test="${bus.licensePlateId == null}">Add New</c:when>
                <c:otherwise>Update Bus</c:otherwise>
            </c:choose>    

        </button>
    </div>


</form:form>
