<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<body>
	<form:form action="alumno/edit.do" modelAttribute="tarjetaCredito" method="post">
		<form:hidden path="id" value="${tarjetaDeCredito.id}"/>
		<form:hidden path="version" value="${tarjetaDeCredito.version}"/>
		<form:hidden path="alumno" value="${alumno.id}" />

		<form:label path="titular">
			<spring:message code="alumno.titular" />
		</form:label>
		<form:input path="titular" />
		<form:errors class="error" path="titular" />
		<br />

		<form:label path="marca">
			<spring:message code="alumno.marca" />
		</form:label>
		<form:input path="marca" />
		<form:errors class="error" path="marca" />
		<br />

		<form:label path="numeroValido">
			<spring:message code="alumno.numeroValido" />
		</form:label>
		<form:input path="numeroValido" />
		<form:errors class="error" path="numeroValido" />
		<br />

		<form:label path="mesCaducidad">
			<spring:message code="alumno.mesCaducidad" />
		</form:label>
		<form:input path="mesCaducidad" />
		<form:errors class="error" path="mesCaducidad" />
		<br />

		<form:label path="anyoCaducidad">
			<spring:message code="alumno.anyoCaducidad" />
		</form:label>
		<form:input path="anyoCaducidad" />
		<form:errors class="error" path="anyoCaducidad" />
		<br />

		<form:label path="cvv">
			<spring:message code="alumno.cvv" />
		</form:label>
		<form:input path="cvv" />
		<form:errors class="error" path="cvv" />
		<br />

		<c:if test="${showError}">
			<div class="error">
				<spring:message code="alumno.commit.error" />
			</div>
		</c:if>

		<c:if test="${tarjetaDeCredito.id == 0}">
			<input type="submit" name="save"
				value="<spring:message code='alumno.save' />" />&nbsp; 
			<input type="button" name="cancel"
				value="<spring:message code='alumno.cancel' />"
				onclick="javascript: window.location.href='/Acme-Dancer/';" />
			<br />
	</c:if>

		<c:if test="${tarjetaDeCredito.id != 0}">
			<input type="submit" name="edit"
				value="<spring:message code='alumno.edit' />" />&nbsp; 
			<input type="button" name="cancel"
				value="<spring:message code='alumno.cancel' />"
				onclick="javascript: window.location.href='/Acme-Dancer/';" />
		<br />
	</c:if>

	</form:form>

</body>
</html>
