<%-- 
    Document   : setCompanyByRegister
    Created on : Sep 10, 2023, 4:03:40 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info">Register Company</h1>
<c:url value="/buscompanies" var="action" />
<section class = "container">
    <table class="table">
        <thead>
            <tr>
                <th></th>
                <th scope="col">ID</th>
                <th scope="col">Username</th>
                <th scope="col">User Role</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="u">
                <c:if test="${u.isCompany == true}">
                    <tr class="align-middle">
                        <td>
                            <img src="${u.avatar}" alt="${u.username}" width="120dp"/> 
                        </td>
                        <th scope="row" id="userId">${u.userId}</th>
                        <td>${u.username}</td>
                        <td>${u.userRole}</td>
                        <td>
                            <a href="<c:url value="/buscompanies/register/${u.userId}"/> " class="btn btn-success">Active</a>
                            <c:url value="/buscompanies/lock/${bc.companyId}/" var="apiLock"/>


                            <!--                        <button 
                                                        class="btn ${bc.status == false ? 'btn-secondary' : 'btn-danger' }" ${bc.status == false ? 'disabled' : ''} onclick="lock('${apiLock}', '${authToken}')">${bc.status == false ? "Locked" : "Lock" }</button>-->
                        </td>
                    </tr>
                </c:if>

            </c:forEach>
        </tbody>
    </table>
</section>
