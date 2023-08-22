<%-- 
    Document   : index.jsp
    Created on : Aug 13, 2023, 8:38:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<section class = "container">
    <h1 class ="text-center text-infor mt-1">Bus</h1>
    <a href ="#" class="btn btn-info">Add Bus</a>

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
                    <td>
                        <a href="#" class="btn btn-success">UPDATE</a>
                        <button class="btn btn-danger">DELETE</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
