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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Bus Management</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#">Home Page</a>
                            </li>
                            <c:forEach items="${buscompanies}" var="bc">
                                <c:url value="/" var="searchUrl">
                                    <c:param name="companyId" value="${bc.companyId}"></c:param>
                                </c:url>
                                <li class="nav-item">
                                    <a class="nav-link" href="${searchUrl}">${bc.nameCompany}</a>
                                </li>
                            </c:forEach>
                        </ul>
                        <c:url value="/" var="action"/>
                        <form class="d-flex" action="${action}">
                            <input class="form-control me-2" type="text" name="kw" placeholder="Search">
                            <button class="btn btn-primary" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </nav>
        <section class = "container">
            <table class="table table-hover">
                <a href ="#" class="btn btn-info">Add BusTrip</a>
                <thead>
                    <tr>
                        <th></th>
                        <th>Trip ID</th>
                        <th>Trip Name</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${bustrips}" var="bt">
                        <tr>
                            <td>
                                <img src="${bt.tripName}" alt="${bt.tripName}" width="120dp"/> 
                            </td>
                            <td>${bt.tripId}</td>
                            <td>${bt.tripName}</td>
                            <td>${bt.price}</td>
                            <td>
                                <a href="#" class="btn btn-success">UPDATE</a>
                                <button class="btn btn-danger">DELETE</button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </body>
</html>
