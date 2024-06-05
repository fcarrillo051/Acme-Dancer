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
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="cursos" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<p><a href="<spring:url value='/solicitud/alumno/add.do' />"><spring:message code="alumno.AddSolicitud" /></a></p>
	
	<!-- Attributes -->

	<spring:message code="curso.titulo" var="tituloHeader" />
	<display:column property="titulo" title="${tituloHeader}" sortable="true" />

	<spring:message code="curso.nivel" var="nivelHeader" />
	<display:column property="nivel" title="${nivelHeader}" sortable="true" />

	<spring:message code="curso.fechaInicio" var="fechaInicioHeader" />
	<display:column property="fechaInicio" title="${fechaInicioHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />

	<spring:message code="curso.fechaFinal" var="fechaFinalHeader" />
	<display:column property="fechaFinal" title="${fechaFinalHeader}" sortable="true" format="{0,date,dd/MM/yyyy HH:mm}" />
	
	<spring:message code="curso.diaImpartido" var="diaImpartidoHeader" />
	<display:column property="diaImpartido" title="${diaImpartidoHeader}"	sortable="true" />
	
	<spring:message code="curso.horaImpartido" var="horaImpartidoHeader" />
	<display:column property="horaImpartido" title="${horaImpartidoHeader}"	sortable="true" />
	
	<spring:message code="academia.nombreComercial" var="academiaHeader" />
    <display:column title="${academiaHeader}" sortable="true">
        <c:url var="url" value="/academia/info.do">
            <c:param name="academiaId" value="${row.academia.id}" />
        </c:url>
        <a href="${url}">${row.academia.nombreComercial}</a>
    </display:column>
    
</display:table>


