<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<!DOCTYPE html>
<html>
<head>
    <title>Resgister</title>
</head>
<body>
    <h2><spring:message code="register.add.title" /></h2>

    <form:form modelAttribute="alumno" method="post" action="${requestURI}">
        <table>
            <tr>
                <td><spring:message code="Alumno.Nombre" /></td>
                <td><form:input path="nombre" /></td>
                <td><form:errors path="nombre" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="Alumno.Apellido" /></td>
                <td><form:input path="apellidos" /></td>
                <td><form:errors path="apellidos" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="Alumno.correoElec" /></td>
                <td><form:textarea path="correoElectronico" /></td>
                <td><form:errors path="correoElectronico" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="Alumno.Numtelef" /></td>
                <td><form:textarea path="numTelefono" /></td>
                <td><form:errors path="numTelefono" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="Alumno.Codpostal" /></td>
                <td><form:textarea path="codigoPostal" /></td>
                <td><form:errors path="codigoPostal" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="<spring:message code='alumno.save'/>" />
                </td>
            </tr>
        </table>
    </form:form>
    

    <a href="<spring:url value='/actor/save' />"><spring:message code="estilo.back.to.list" /></a>
</body>
</html>