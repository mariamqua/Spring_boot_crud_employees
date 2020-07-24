<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gestion HR </title>
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
        <h1>Toute les Rémunérations</h1>
        <div class="col-lg-12" id="btn">
            <a href="${pageContext.request.contextPath}/remunerations/add" class="btn btn-primary">
                Ajouter Rémunération</a>
            <br/>
        </div>
        <table id="example"  class="table table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Nom </th>
                <th>Type</th>
                <th>Action</th>


            </tr>
            <c:forEach items="${liste}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td><a href="${pageContext.request.contextPath}/remunerations/view/${item.id}">
                            ${item.name}</a></td>

                    <td>${item.type}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/remunerations/add/${item.id}">Update</a>
                        <a href="${pageContext.request.contextPath}/remunerations/delete/${item.id}"
                             onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </header>

</div>

</body>
</html>