<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="academia" requestURI="${requestURI}" id="row">
    <display:column property="nombreComercial" title="Nombre Comercial" />
    <display:column title="Cursos">
        <c:forEach var="curso" items="${row.cursos}">
            ${curso.titulo} - ${curso.nivel}<br/>
        </c:forEach>
    </display:column>
</display:table>

<a href="<spring:url value='/curso/list.do' />">Volver a Listado de Cursos</a>

