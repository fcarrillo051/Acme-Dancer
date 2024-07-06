<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<p><a href="<spring:url value='/estilo/administrator/add.do' />"><spring:message code="estilo.AddStyles" /></a></p>
<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="estilos" requestURI="${requestURI}" id="row">

    <!-- Edit Button -->
    <display:column title="Edit">
        <a href="<spring:url value='/estilo/administrator/edit.do?estiloId=${row.id}' />">Edit</a>
    </display:column>

    <!-- Attributes -->
    <spring:message code="estilo.titulo" var="tituloHeader" />
    <display:column property="titulo" title="${tituloHeader}" sortable="true" />

    <spring:message code="estilo.descripcion" var="descripcionHeader" />
    <display:column property="descripcion" title="${descripcionHeader}" sortable="true" />

    <spring:message code="estilo.videos" var="videosHeader" />
    <display:column title="${videosHeader}">
        <c:forEach var="video" items="${row.videos}">
            <iframe width="400" height="400" src="${video}"></iframe>
        </c:forEach>
    </display:column>
    
    <spring:message code="estilo.imagenes" var="imagenesHeader" />
>
    <display:column>
    <c:forEach var="imagen" items="${row.imagenes}">
           <img src="${imagen}" style="max-width:100px; max-height:100px;" />
        </c:forEach>
    </display:column>

    <display:column title="Cursos">
        <c:forEach var="curso" items="${row.cursos}">
            <a href="<spring:url value='/curso/info.do?cursoId=${curso.id}' />">${curso.titulo} - ${curso.nivel}</a><br/>
        </c:forEach>
    </display:column>

</display:table>
