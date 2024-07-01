<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="academias" requestURI="${requestURI}" id="row">
    <display:column property="nombreComercial" title="Nombre Comercial"/>
    <display:column title="Cursos">
        <c:forEach var="curso" items="${row.cursos}">
            <c:url var="url" value="/curso/info.do">
                <c:param name="cursoId" value="${curso.id}" />
            </c:url>
            <a href="${url}">${curso.titulo} - ${curso.nivel}</a><br/>
        </c:forEach>
    </display:column>
    
    	<display:column>
		<a href="tutorial/academia/listFromAcademia.do?academiaId=${row.id}"> <spring:message
				code="academia.listTutoriales" />
		</a>
	</display:column>
</display:table>

