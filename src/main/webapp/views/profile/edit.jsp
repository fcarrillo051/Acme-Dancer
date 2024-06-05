<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar datos</title>
</head>
<body>
    <form:form action="profile/edit.do" modelAttribute="alumno" method="post">
		<form:hidden path="id" value="${alumno.id}" />
		<form:hidden path="version" value="${alumno.version}" />
		<form:hidden path="userAccount" value="${alumno.userAccount.id}" />


        <!-- Campo para nombre -->
        <form:label path="nombre">
            <spring:message code="profile.firstName" />
        </form:label>
        <form:input path="nombre" required="true" />
        <form:errors class="error" path="nombre" />
        <br />

        <!-- Campo para apellidos -->
        <form:label path="apellidos">
            <spring:message code="profile.lastName" />
        </form:label>
        <form:input path="apellidos" required="true" />
        <form:errors class="error" path="apellidos" />
        <br />

        <!-- Campo para correo electrónico -->
        <form:label path="correoElectronico">
            <spring:message code="profile.email" />
        </form:label>
        <form:input path="correoElectronico" type="email" required="true" />
        <form:errors class="error" path="correoElectronico" />
        <br />

        <!-- Campo para número de teléfono (opcional) -->
        <form:label path="numTelefono">
            <spring:message code="profile.phoneNumber" />
        </form:label>
        <form:input path="numTelefono" />
        <form:errors class="error" path="numTelefono" />
        <br />

        <!-- Campo para dirección postal (opcional) -->
        <form:label path="codigoPostal">
            <spring:message code="profile.postalAddress" />
        </form:label>
        <form:input path="codigoPostal" />
        <form:errors class="error" path="codigoPostal" />
        <br />

        <jstl:if test="${showError == true}">
            <div class="error">
                <spring:message code="profile.failed" />
            </div>
        </jstl:if>

        <input type="submit" name="save"
				value="<spring:message code='profile.save' />" />&nbsp; 
		<input type="button" name="cancel"
				value="<spring:message code='profile.cancel' />"
				onclick="javascript: window.location.href='/Acme-Dancer/';" />
			
    </form:form>
</body>
</html>
