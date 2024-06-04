<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
    name="cursos" requestURI="${requestURI}" id="row">

    <!-- Edit Button -->
    <display:column title="Edit">
        <a href="<spring:url value='#' />">Edit</a>
    </display:column>

    <!-- Attributes -->
    <spring:message code="curso.titulo" var="tituloHeader" />
    <display:column property="titulo" title="${tituloHeader}" sortable="true" />

    <spring:message code="curso.nivel" var="nivelHeader" />
    <display:column property="nivel" title="${nivelHeader}" sortable="true" />

     <spring:message code="curso.fechaInicio" var="fechaInicioHeader" />
    <display:column property="fechaInicio" title="${fechaInicioHeader}" sortable="true" />
    
	<spring:message code="curso.fechaFinal" var="fechaFinalHeader" />
    <display:column property="fechaFinal" title="${fechaFinalHeader}" sortable="true" />
    
    <spring:message code="curso.diaImpartido" var="diaImpartidoHeader" />
    <display:column property="diaImpartido" title="${diaImpartidoHeader}" sortable="true" />
    
    <spring:message code="curso.horaImpartido" var="horaImpartidoHeader" />
    <display:column property="horaImpartido" title="${horaImpartidoHeader}" sortable="true" />
    
    <spring:message code="curso.horaImpartido" var="horaImpartidoHeader" />
    <display:column property="horaImpartido" title="${horaImpartidoHeader}" sortable="true" />
    
    <spring:message code="curso.academia" var="academiaHeader" />
    <display:column property="academia.nombreComercial" title="${academiaHeader}" sortable="true" />
    

</display:table>