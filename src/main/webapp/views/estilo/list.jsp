<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>


<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="estilos" requestURI="${requestURI}" id="row">
    
    <!-- Attributes -->
    
 
    <spring:message code="estilo.titulo" var="tituloHeader" />
    <display:column property="titulo" title="${tituloHeader}" sortable="true" />

    <spring:message code="estilo.descripcion" var="descripcionHeader" />
    <display:column property="descripcion" title="${descripcionHeader}" sortable="true" />
    
    <spring:message code="estilo.videos" var="videosHeader" />
    <display:column title="${videosHeader}">
        <c:forEach var="video" items="${row.videos}">
            <c:out value="${video}" /><br/>
        </c:forEach>
    </display:column>
    
    <spring:message code="estilo.imagenes" var="imagenesHeader" />
    <display:column title="${imagenesHeader}">
        <c:forEach var="imagen" items="${row.imagenes}">
            <c:out value="${imagen}" /><br/>
        </c:forEach>
    </display:column>

    <display:column title="Cursos">
        <c:forEach var="curso" items="${row.cursos}">
            <a href="<spring:url value='/curso/info.do?cursoId=${curso.id}' />">${curso.titulo} - ${curso.nivel}</a><br/>
        </c:forEach>
    </display:column>
    
</display:table>




