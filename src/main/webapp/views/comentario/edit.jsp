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
<title>Crear Tutorial</title>
</head>
<body>
	<form:form action="comentario/edit.do" modelAttribute="comentario" method="post">
		<form:hidden path="id" value="${comentario.id}"/>
		<form:hidden path="version" value="${comentario.version}"/>
		<form:hidden path="actores" value="${actor.id}" />
		<fmt:formatDate value="${comentario.fechaCom}" pattern="dd/MM/yyyy"
			var="myFechaCom" />
		<form:hidden path="fechaCom" value="${myFechaCom}" />
		
		<form:label path="texto">
			<spring:message code="comentario.texto" />
		</form:label>
		<form:input path="texto" />
		<form:errors class="error" path="texto" />
		<br />


		<c:if test="${showError}">
			<div class="error">
				<spring:message code="comentario.commit.error" />
			</div>
		</c:if>

		<c:if test="${comentario.id == 0}">
			<input type="submit" name="save"
				value="<spring:message code='comentario.save' />" />&nbsp; 
			<input type="button" name="cancel"
				value="<spring:message code='comentario.cancel' />"
				onclick="javascript: window.location.href='list-actor.do';" />
			<br />
	</c:if>

		<c:if test="${comentario.id != 0}">
			<input type="submit" name="delete"
				value="<spring:message code='comentario.delete' />"
				onclick="return confirm('<spring:message code='comentario.confirm.delete' />')" />&nbsp;
			<input type="button" name="cancel"
				value="<spring:message code='comentario.cancel' />"
				onclick="javascript: window.location.href='list-actor.do';" />
		<br />
	</c:if>

	</form:form>

</body>
</html>
