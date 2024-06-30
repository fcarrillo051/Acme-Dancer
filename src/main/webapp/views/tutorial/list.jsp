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
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="tutoriales" requestURI="${requestURI}" id="row">

	<!-- Edit Button -->
	<spring:message code="tutorial.editar" var="editMessage" />
	<display:column title="${editMessage}">
		<a href="<c:url value='/tutorial/academia/edit.do'>
            <c:param name='tutorialId' value='${row.id}' />
        </c:url>">
            <spring:message code="tutorial.editar"/>
        </a>
    </display:column>

	<!-- Attributes -->

	<spring:message code="tutorial.titulo"
		var="titulo" />
	<display:column property="titulo" title="${titulo}" sortable="true"/>

	<spring:message code="tutorial.descripcion"
		var="descripcion" />
	<display:column property="descripcion" title="${descripcion}" sortable="true"/>
	
	<spring:message code="tutorial.video"
		var="video" />
	<display:column property="video" title="${video}" sortable="true"/>
		


</display:table>
