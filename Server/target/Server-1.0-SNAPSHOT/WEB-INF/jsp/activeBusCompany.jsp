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
<section class = "container">
    <table class="table">
        <thead>
            <tr>
                <th></th>
                <th scope="col">ID</th>
                <th scope="col">Bus Company</th>
                <th scope="col">Status</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${buscompanies}" var="bc">
                <tr class="align-middle">
                    <td>
                        <img src="${bc.avatar}" alt="${bc.nameCompany}" width="120dp"/> 
                    </td>
                    <th scope="row" id="companyId">${bc.companyId}</th>
                    <td>${bc.nameCompany}</td>
                    <td>
                        ${bc.status == true ? 'Active' : 'Locked'}
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${bc.status != true}">
                                <a href="<c:url value="/buscompanies/active/${bc.companyId}"/> " class="btn btn-success">Active</a>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value="/buscompanies/lock/${bc.companyId}"/> " class="btn btn-danger">Lock</a>
                            </c:otherwise>
                        </c:choose>
                        <c:url value="/buscompanies/lock/${bc.companyId}/" var="apiLock"/>
                        
                        
<!--                        <button 
                            class="btn ${bc.status == false ? 'btn-secondary' : 'btn-danger' }" ${bc.status == false ? 'disabled' : ''} onclick="lock('${apiLock}', '${authToken}')">${bc.status == false ? "Locked" : "Lock" }</button>-->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>