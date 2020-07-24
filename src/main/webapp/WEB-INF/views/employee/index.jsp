<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employees </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <style>
        #btn{
            margin-bottom: 2%;
        }
    </style>
    <script>
        $(document).ready(function() {
            $('#example').DataTable();
        } );
    </script>
</head>
<body>
<div class="container" id="global">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Tous les employees</h1>
        <div class="col-lg-12" id="btn">
            <a href="${pageContext.request.contextPath}/employees/add" class="btn btn-primary">
                Ajouter Employee</a>
            <br/>
        </div>
        <table id="example"  class="table table-striped table-bordered">
            <tr>
                <th>Nom complet</th>
                <th>Cin</th>
                <th>Tel</th>
                <th>email</th>
                <th>grade</th>
                <th>salaire</th>
                <th>Action</th>


            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/employees/view/${item.id}">${item.nom}</a></td>
                    <td>${item.cin}</td>
                    <td>${item.tel}</td>
                    <td>${item.email}</td>
                    <td>${item.grade}</td>
                    <td>${item.salaire}</td> 
                    <td>
                        <a href="${pageContext.request.contextPath}/employees/add/${item.id}">Update</a>
                        <a href="${pageContext.request.contextPath}/employees/delete/${item.id}"
                           onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </header>

</div>

</body>
</html>