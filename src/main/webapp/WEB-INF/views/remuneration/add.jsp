<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Employees </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter une Rémunération</h1>
        <form:errors path="remuneration" cssClass="alert-danger" />
        <form:form method="post" action="${pageContext.request.contextPath}/remunerations/save"
                   modelAttribute="remuneration" >
            <form:input path="id" type="hidden" />

            <div class="form-group">
                <label for="name">Nom </label>
                <form:input path="name" cssClass="form-control"  placeholder="Nom" />
                <form:errors path="name" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="type">Type</label>

                <form:select class="form-check-label" path="type" cssClass="form-control" multiple="false">
                    <form:option value="Fixe" />
                    <form:option value="Variable" />

                </form:select>
                <form:errors path="type" cssClass="alert-danger" />
            </div>

            <input type = "submit" value = "Submit" class="btn btn-primary"/>
        </form:form>
    </header>
</div>
</body>
</html>
