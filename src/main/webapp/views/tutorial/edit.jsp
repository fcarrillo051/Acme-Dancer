<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="tutorial/academia/edit.do" modelAttribute="tutorial">
    <form:hidden path="id" />
    <form:hidden path="version" />
    <form:hidden path="academia" />

    <label for="titulo">
        <spring:message code="tutorial.titulo" />:
    </label>
    <form:input path="titulo" id="titulo" />
    <form:errors cssClass="error" path="titulo" />
    <br />

    <label for="descripcion">
        <spring:message code="tutorial.descripcion" />:
    </label>
    <form:input path="descripcion" id="descripcion" />
    <form:errors cssClass="error" path="descripcion" />
    <br />

    <label for="video">
        <spring:message code="tutorial.video" />:
    </label>
    <form:input path="video" id="video" />
    <form:errors cssClass="error" path="video" />
    <br />


    <input type="submit" name="save" value="<spring:message code="tutorial.save" />" />&nbsp; 
    
    <c:if test="${tutorial.id != 0}">
        <input type="submit" name="delete" value="<spring:message code="tutorial.delete" />"
            onclick="return confirm('<spring:message code="tutorial.confirm.delete" />')" />&nbsp;
    </c:if>
    
    <a href="<spring:url value='/tutorial/academia/list.do' />">
        <input type="button" name="cancel" value="<spring:message code="tutorial.cancel" />" />
    </a>
    
    <br />
</form:form>


