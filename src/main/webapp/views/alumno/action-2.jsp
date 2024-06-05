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

<p><spring:message code="alumno.action.2" /></p>

<form:form modelAttribute="shout">
<form:hidden path="id" />
<form:hidden path="version" />
<form:label path="username"><spring:message code="alumno.username" />:</form:label>
<form:input path="username" readonly="true" />
<form:errors path="username" cssClass="error"/>
<br />

<form:label path="link"> <spring:message code="alumno.link" />: </form:label>
<form:input path="link" />
<form:errors path="link" cssClass="error"/>
<br />

<form:label path="text"> <spring:message code="alumno.text" />: </form:label>
<form:textarea path="text" />
<form:errors path="text" cssClass="error"/>
<br />

<input type="submit" name="save" value="<spring:message code="alumno.save" />" />
<input type="button" name="cancel" value="<spring:message code="alumno.cancel" />"
onclick="javascript: relativeRedir('alumno/action-1.do');" />

</form:form>
