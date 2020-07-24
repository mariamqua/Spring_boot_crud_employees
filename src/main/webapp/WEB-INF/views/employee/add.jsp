
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Ajouter employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">
    <jsp:directive.include file="../layout/header.jsp" />
    <header class="col-lg-12">
        <h1>Ajouter un Employee</h1>
        <form:errors path="employee" cssClass="alert-danger" />
        <form:form method="post" action="${pageContext.request.contextPath}/employees/save" modelAttribute="employee" >
            <form:input path="id"  type="hidden"/>
            <div class="form-group">
                <label class="form-check-label">
                    Département
                </label>

                <form:select path="departement"  class="form-control" id="select">
                    <c:forEach items="${departement}"   var="dep">
                        <option value="${dep.id}"> ${dep.name}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="departement" cssClass="alert-danger" />
            </div>


            <div class="form-group">
                <label for="cin">Cin </label>
                <form:input path="cin" cssClass="form-control"  placeholder="Cin" />
                <form:errors path="cin" cssClass="alert-danger" />

            </div>
            <div class="form-group">
                <label for="nom">Nom Complet</label>
                <form:input path="nom" cssClass="form-control"  placeholder="Nom Complet" />
                <form:errors path="nom" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="tel">Tél</label>
                <form:input path="tel" cssClass="form-control"  placeholder="Tél" />
                <form:errors path="tel" cssClass="alert-danger" />

            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <form:input path="email" cssClass="form-control"  placeholder="Email" />
                <form:errors path="email" cssClass="alert-danger" />

            </div>

            <div class="form-group">
                <label for="grade">Grade</label>
                <form:input path="grade" cssClass="form-control"  placeholder="Grade" />
                <form:errors path="grade" cssClass="alert-danger" />
            </div>
            <div class="form-group">
                <label for="salaire">Salaire</label>
                <form:input path="salaire" cssClass="form-control"  placeholder="Salaire" />
                <form:errors path="salaire" cssClass="alert-danger" />
            </div>

            <div class="form-group">
                <label for="type">Type</label>

                <form:select class="form-check-label" id="show" onchange="change(this)"
                             path="type" cssClass="form-control" multiple="false">
                    <form:option value="Normal" />
                    <form:option value="Manager " />

                </form:select>
                <form:errors path="type" cssClass="alert-danger" />
            </div>

            <div class="form-group">
                <label class="form-check-label">
                    Manager
                </label>

                <form:select path="manager"  class="form-control" id="select">
                    <option value=""> selectionner un manager  </option>
                    <c:forEach items="${employees}"   var="empl">
                        <option value="${empl.id}"> ${empl.nom}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="manager" cssClass="alert-danger" />
            </div>
        <div class="form-group">
            <label class="form-check-label">
                Sous jacents
            </label>
            <c:forEach items="${employees}"   var="emp">
                <c:choose>
                    <c:when test="${emp.used}">
                        <form:checkbox path="sous_jacents" value="${emp.id}" label="${ emp.nom }" checked="checked" />
                        <br/>
                    </c:when>
                    <c:otherwise>
                        <form:checkbox path="sous_jacents" value="${emp.id}" label="${ emp.nom }"/>
                        <br/>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <form:errors path="sous_jacents" cssClass="alert-danger" />

        </div>


            <div>
                <label>Text area</label>
                <textarea id="text_area" class="form-control" type="text" name="text_area" placeholder="Write something" rows="5" cols="50" style="display: none"></textarea>
            </div>
            <div class="form-group">
                <label class="form-check-label">
                    Rémuneration
                </label>

                <form:select path="remuneration"  class="form-control" id="select">
                    <c:forEach items="${remuneration}"   var="rem">
                        <option value="${rem.id}"> ${rem.name} : ${rem.type}  </option>
                    </c:forEach>
                </form:select>
                <form:errors path="remuneration" cssClass="alert-danger" />
            </div>

            <input type = "submit" value = "Submit" class="btn btn-primary"/>
        </form:form>
    </header>
</div>
</body>
<script>
    function change(obj) {


        var selectBox = obj;
        var selected = selectBox.options[selectBox.selectedIndex].value;
        var textarea = document.getElementById("text_area");

        if(selected === '1'){
            textarea.style.display = "block";
        }
        else{
            textarea.style.display = "none";
        }
    }
</script>
</html>
