<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="academia" requestURI="${requestURI}" id="row">
    <display:column title="Nombre Comercial">
        ${row.nombreComercial}
    </display:column>
    <display:column title="Cursos">
        <c:forEach var="curso" items="${row.cursos}">
            <a href="<spring:url value='/curso/info.do?cursoId=${curso.id}' />">${curso.titulo} - ${curso.nivel}</a><br/>
        </c:forEach>
    </display:column>
</display:table>
