<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">

<h1 class="text-center">Créer un compte</h1><br>
<form:form method="post" action="${pageContext.request.contextPath}/auth/save" modelAttribute="user">
    <form:input path="id" type="hidden"/>
    <div class="form-group">
        <label for="firstname">Nom</label>
        <form:input path="firstname" cssClass="form-control" placeholder="Nom"/>
        <form:errors path="firstname" cssClass="alert-danger"/>
    </div>

    <div class="form-group">
        <label for="lastname">Prénom</label>
        <form:input path="lastname" cssClass="form-control" placeholder="Prénom"/>
        <form:errors path="lastname" cssClass="alert-danger"/>
    </div>



    <div class="form-group">
        <label for="email">Email</label>
        <form:input path="email" cssClass="form-control" placeholder="email"/>
        <form:errors path="email" cssClass="alert-danger"/>
    </div>

    <div class="form-group">
        <label for="username">username</label>
        <form:input path="username" cssClass="form-control" placeholder="username"/>
        <form:errors path="username" cssClass="alert-danger"/>
    </div>

    <div class="form-group">
        <label for="password">Mot de passe</label>
        <form:input type="password" path="password" cssClass="form-control" placeholder="password"/>
        <form:errors path="password" cssClass="alert-danger"/>
    </div>

    <div class="form-group">
        <label for="confPassword">Confirmer le Password</label>
        <form:input type="password" cssClass="form-control" id="confPassword"
                    placeholder="Confirm password" path="confPassword"/>
        <form:errors path="confPassword" cssClass="alert-danger"/>

    </div>
    <input type="submit" class="btn btn-primary" value="Submit"/>
</form:form>
<form:errors path="user" cssClass="alert-danger"/>
</div>
</body>
</html>
