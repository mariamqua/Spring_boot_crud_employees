
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blog</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container">

    <jsp:directive.include file="../layout/header.jsp" />

    <div class="col-lg-12">
        <h3>Departement : ${departement.name}</h3>
        <h4>Nom : ${departement.name}</h4>
        <h4>Type : ${departement.type}</h4>
        <h4>Sous-jascent  </h4>
        <table class="table table-bordered">
            <tr>
                <th>Nom complet</th>
                <th>Cin</th>
                <th>Tel</th>
                <th>email</th>
                <th>grade</th>
                <th>salaire</th>
                <th>Ch Affaire</th>


            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/departments/view/${item.id}">${item.nom}</a></td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.type}</td>

                </tr>

            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>