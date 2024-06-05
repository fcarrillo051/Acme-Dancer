<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="solicitud/alumno/add.do" modelAttribute="solicitud">
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="dueño" value="${alumno.id}" />

	<form:label path="momentoSolicitud">
		<spring:message code="solicitud.momentoSolicitud" />:
    </form:label>
	<form:input path="momentoSolicitud" />
	<form:errors cssClass="error" path="momentoSolicitud" />
	<br />

	<form:label path="estadoSolicitud">
		<spring:message code="solicitud.estadoSolicitud" />:
    </form:label>
	<form:input path="estadoSolicitud" />
	<form:errors cssClass="error" path="estadoSolicitud" />
	<br />

	<div class="form-group" style="width: 55%;">
		<label for="curso"><spring:message code="solicitud.curso" />:</label> <select
			id="curso" name="curso">
			<c:forEach var="s" items="${cursos}">
				<option value="${s.id}">${s.titulo}</option>
			</c:forEach>
		</select>
	</div>


	<input type="submit" name="save"
		value="<spring:message code="solicitud.save" />" />&nbsp; 
    
    <a href="<spring:url value='/solicitud/alumno/listCRUD.do' />"> <input
		type="button" name="cancel"
		value="<spring:message code="solicitud.cancel" />" />
	</a>

	<br />
</form:form>