<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="estilo/administrator/add.do" modelAttribute="estilo">
    <form:hidden path="id" />
    <form:hidden path="version" />

    <form:label path="titulo">
        <spring:message code="estilo.titulo" />:
    </form:label>
    <form:input path="titulo" />
    <form:errors cssClass="error" path="titulo" />
    <br />

    <form:label path="descripcion">
        <spring:message code="estilo.descripcion" />:
    </form:label>
    <form:input path="descripcion" />
    <form:errors cssClass="error" path="descripcion" />
    <br />

    <form:label path="videos">
        <spring:message code="estilo.videos" />:
    </form:label>
    <form:textarea path="videos" rows="3" cols="50" />
    <form:errors cssClass="error" path="videos" />
    <br />

    <form:label path="imagenes">
        <spring:message code="estilo.imagenes" />:
    </form:label>
    <form:textarea path="imagenes" rows="3" cols="50" />
    <form:errors cssClass="error" path="imagenes" />
    <br />

    <input type="submit" name="save" value="<spring:message code="estilo.save" />" />&nbsp; 
    
    <a href="<spring:url value='/estilo/administrator/listCRUD.do' />">
        <input type="button" name="cancel" value="<spring:message code="estilo.cancel" />" />
    </a>
    
    <br />
</form:form>


