<%-- 
    Document   : header
    Created on : Aug 21, 2023, 10:31:02 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Bus Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <c:url value="/" var="action"/>
                    <a class="nav-link" href="${action}">Home Page</a>
                </li>
                <c:forEach items="${buscompanies}" var="bc">
                    <c:url value="/" var="searchUrl">
                        <c:param name="companyId" value="${bc.companyId}"></c:param>
                    </c:url>


                    <li class="nav-item">
                        <a class="nav-link" href="${searchUrl}">${bc.nameCompany}</a>
                    </li>
                </c:forEach>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">

                            <a class="nav-link text-danger" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
                        </li>
                        <li class="nav-item">

                            <a class="nav-link text-danger" href="<c:url value="/logout"/>">Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">

                            <a class="nav-link" href="<c:url value="/login"/>">Login</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <c:url value="/" var="action"/>
            <form class="d-flex" action="${action}">
                <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
