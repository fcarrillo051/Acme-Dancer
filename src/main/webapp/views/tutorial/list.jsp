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
	<security:authorize access="hasRole('ACADEMIA')">
		<spring:message code="tutorial.editar" var="editMessage" />
		<display:column>
			<a href="tutorial/academia/edit.do?tutorialId=${row.id}"> <spring:message
					code="tutorial.editar" />
			</a>
		</display:column>

	</security:authorize>

	<!-- Attributes -->

	<spring:message code="tutorial.titulo" var="titulo" />
	<display:column property="titulo" title="${titulo}" sortable="true" />

	<spring:message code="tutorial.descripcion" var="descripcion" />
	<display:column property="descripcion" title="${descripcion}"
		sortable="true" />

	<spring:message code="tutorial.video" var="video" />
	<display:column property="video" title="${video}" sortable="true" />
	
		<spring:message code="tutorial.visitas" var="visitas" />
	<display:column property="visitas" title="${visitas}" sortable="true" />



</display:table>

<security:authorize access="hasRole('ACADEMIA')">
	<div>
		<a href="tutorial/academia/create.do"> <spring:message
				code="tutorial.create" />
		</a>
	</div>
</security:authorize>


