<%--
 * action-2.jsp
 *
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<display:table name="curso" id="row"
	requestURI="curso/administrator/list.do"
	pagesize="5" class="displaytag" >
	<display:column property="titulo" titleKey="curso.titulo" />
	<display:column property="fechaInicio" titleKey="curso.fechaInicio" />
	<display:column property="fechaFinal" titleKey=“curso.fechaFinal“ />
	<display:column property="diaImpartido" titleKey="curso.diaImpartido" />
	<display:column property="horaImpartido" titleKey="curso.horaImpartido" />
</display:table>