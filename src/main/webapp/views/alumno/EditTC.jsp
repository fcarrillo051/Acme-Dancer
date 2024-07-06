<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="tarjeta/alumno/edit.do" modelAttribute="tarjetaDeCredito">
	<form:hidden path="id" />
	<form:hidden path="version" />
	<form:hidden path="alumno" />


	<label for="nombreTitular"> <spring:message
			code="alumno.titular" />:
	</label>
	<form:input path="nombreTitular" id="nombreTitular" />
	<form:errors cssClass="error" path="nombreTitular" />
	<br />


	<label for="marca"> <spring:message code="alumno.marca" />:
	</label>
	<form:input path="marca" id="marca" />
	<form:errors cssClass="error" path="marca" />
	<br />

	<label for="numero"> <spring:message code="alumno.numeroValido" />:
	</label>
	<form:input path="numero" id="numero" />
	<form:errors cssClass="error" path="numero" />
	<br />


		<label for="mesCad"> <spring:message code="alumno.mesCaducidad" />:
	</label>
	<form:input path="mesCad" id="mesCad" />
	<form:errors cssClass="error" path="mesCad" />
	<br />

		<label for="anioCad"> <spring:message code="alumno.anyoCaducidad" />:
	</label>
	<form:input path="anioCad" id="anioCad" />
	<form:errors cssClass="error" path="anioCad" />
	<br />
	
		<label for="cvv"> <spring:message code="alumno.cvv" />:
	</label>
	<form:input path="cvv" id="cvv" />
	<form:errors cssClass="error" path="cvv" />
	<br />


	<input type="submit" name="save"
		value="<spring:message code='alumno.edit' />" />&nbsp; 
		
			<input type="button" name="cancel"
		value="<spring:message code='alumno.cancel' />"
		onclick="javascript: window.location.href='/Acme-Dancer/';" />
	<br />

</form:form>