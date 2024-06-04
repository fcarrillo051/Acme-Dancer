<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="curso/academia/add.do" modelAttribute="curso">
	<form:hidden path="id" />
	<form:hidden path="version" />

	<form:label path="titulo">
		<spring:message code="curso.titulo" />:
    </form:label>
	<form:input path="titulo" />
	<form:errors cssClass="error" path="titulo" />
	<br />

	<form:label path="nivel">
		<spring:message code="curso.nivel" />:
    </form:label>
	<form:input path="nivel" />
	<form:errors cssClass="error" path="nivel" />
	<br />

	<form:label path="fechaInicio">
		<spring:message code="curso.fechaInicio" />:
    </form:label>
	<form:input path="fechaInicio" />
	<form:errors cssClass="error" path="fechaInicio" />
	<br />

	<form:label path="fechaFinal">
		<spring:message code="curso.fechaFinal" />:
    </form:label>
	<form:input path="fechaFinal" />
	<form:errors cssClass="error" path="fechaFinal" />
	<br />

	<form:label path="diaImpartido">
		<spring:message code="curso.diaImpartido" />:
    </form:label>
	<form:input path="diaImpartido" />
	<form:errors cssClass="error" path="diaImpartido" />
	<br />

	<form:label path="horaImpartido">
		<spring:message code="curso.horaImpartido" />:
    </form:label>
	<form:input path="horaImpartido" />
	<form:errors cssClass="error" path="horaImpartido" />
	<br />

	<input type="submit" name="save"
		value="<spring:message code="curso.save" />" />&nbsp; 
    
    <a href="<spring:url value='/curso/academia/listCRUD.do' />">
		<input type="button" name="cancel"
		value="<spring:message code="curso.cancel" />" />
	</a>

	<br />
</form:form>