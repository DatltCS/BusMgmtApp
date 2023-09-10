<%-- 
    Document   : index.jsp
    Created on : Aug 13, 2023, 8:38:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<section class = "container">
    <h1 class ="text-center text-infor mt-1">Bus List</h1>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div>
            <a href="<c:url value="/buses" />" class="btn btn-success mt-1">Add Bus</a>
        </div>
        <div>
            <a href="<c:url value="/buscompanies" />" class="btn btn-success mt-1">Add Bus Company</a>
        </div>
        <div>
            <a href="<c:url value="/buscompanies/active" />" class="btn btn-success mt-1">Active Bus Company</a>
        </div>
        <div>
            <a href="<c:url value="/buscompanies/register" />" class="btn btn-success mt-1">Company register</a>
        </div>
    </sec:authorize>

    <c:if test="${count > 1}">
        <ul class="pagination mt-2">
            <c:url value="/" var="action"/>
            <li class="page-item"><a class="page-link" href="${action}">All</a></li>
                <c:forEach begin = "1" end = "${count}" var="i">
                    <c:url value="/" var="pageUrl">
                        <c:param name="page" value="${i}"></c:param>
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Bus ID</th>
                <th>Bus Name</th>
                <th>Total Seat</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${bus}" var="b">
                <tr>
                    <td>
                        <img src="${b.image}" alt="${b.busName}" width="120dp"/> 
                    </td>
                    <td>${b.licensePlateId}</td>
                    <td>${b.busName}</td>
                    <td>${b.totalSeat}</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td>
                            <c:url value="/api/buses/${b.licensePlateId}" var="apiDelete"/>
                            <a href="<c:url value="/buses/${b.licensePlateId}"/>" class="btn btn-success">UPDATE</a>
                            <button class="btn btn-danger" onclick="deleteBus('${apiDelete}', ${b.licensePlateId})">DELETE</button>
                        </td>
                    </sec:authorize>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

<script src="<c:url value="/js/main.js"/>"></script>