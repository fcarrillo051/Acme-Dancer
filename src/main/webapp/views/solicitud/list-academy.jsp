<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="solicitudes" requestURI="${requestURI}" id="row">
    <!-- Action links -->

		<display:column>
			<security:authorize access="hasRole('ACADEMIA')">
	            <form action="solicitud/aceptar.do" method="post" style="display:inline;">
	                <input type="hidden" name="solicitudId" value="${row.id}" />
	                <button type="submit">
	                    <spring:message code="solicitud.aceptar" />
	                </button>
	            </form> 
				<br/>
	            <form action="solicitud/rechazar.do" method="post" style="display:inline;">
	                <input type="hidden" name="solicitudId" value="${row.id}" />
	                <button type="submit">
	                    <spring:message code="solicitud.rechazar" />
	                </button>
	            </form> 
        	</security:authorize>
		</display:column>
    <!-- Attributes -->
    
    <spring:message code="solicitud.momentoSolicitud" var="dateRequestHeader" />
    <display:column property="momentoSolicitud" title="${dateRequestHeader}" sortable="true" />

    <spring:message code="solicitud.estadoSolicitud" var="stateHeader" />
    <display:column property="estadoSolicitud" title="${stateHeader}" sortable="true"/>
	
	<spring:message code="solicitud.titulo" var="titleHeader" />
	<display:column property="curso.titulo" title="${titleHeader}" sortable="true" />

	<spring:message code="solicitud.fechaInicio" var="initDateHeader" />
	<display:column property="curso.fechaInicio" title="${initDateHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />

	<spring:message code="solicitud.fechaFinal" var="endDateHeader" />
	<display:column property="curso.fechaFinal" title="${endDateHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}"/>

	<spring:message code="solicitud.diaImpartido" var="dayWeekHeader" />
	<display:column property="curso.diaImpartido" title="${dayWeekHeader}" sortable="true" />
	
	<spring:message code="solicitud.horaImpartido" var="hourHeader" />
	<display:column property="curso.horaImpartido" title="${hourHeader}" sortable="true" />
	
	<spring:message code="solicitud.nivel" var="levelHeader" />
	<display:column property="curso.nivel" title="${levelHeader}" sortable="false" />
	
	
	<spring:message code="solicitud.estilo" var="styleHeader" />
	<display:column property="curso.estilo.titulo" title="${styleHeader}" sortable="false" />
	
	<spring:message code="solicitud.alumno" var="alumnoHeader" />
	<display:column property="dueño.nombre" title="${alumnoHeader}" sortable="false" />

    
</display:table>