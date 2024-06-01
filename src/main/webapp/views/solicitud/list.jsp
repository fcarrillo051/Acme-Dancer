<%--
 * list.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="solicitudes" requestURI="${requestURI}" id="row">
	


	<security:authorize access="hasRole('ALUMNO')">
		<display:column>
			<jstl:choose>
				<jstl:when test="${solicitudesRegistradas.contains(row)}">
					<a href="solicitud/alumno/unregister.do?solicitudId=${row.id}" 
					   onclick="javascript: return confirm('<spring:message code="solicitud.confirm.unregister" />')">
						<spring:message code="solicitud.unregister" />
					</a>					
				</jstl:when>
				<jstl:otherwise>
					<a href="solicitud/alumno/register.do?solicitudId=${row.id}">
						<spring:message code="solicitud.register" />
					</a>
				</jstl:otherwise>
			</jstl:choose>
		</display:column>
	</security:authorize>
	
	<!-- Attributes -->
	
	<spring:message code="solicitud.momentoSolicitud" var="momentoSolicitudHeader" />
	<display:column property="momentoSolicitud" title="${momentoSolicitudHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />

	<spring:message code="solicitud.estadoSolicitud" var="estadoSolicitudHeader" />
	<display:column property="estadoSolicitud" title="${estadoSolicitudHeader}" sortable="false" />

</display:table>
