<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="curso" requestURI="${requestURI}" id="row">
   
    <display:column property="titulo" title="Título" />
    <display:column property="nivel" title="Nivel" />
    <display:column property="fechaInicio" title="Fecha de Inicio" format="{0,date,dd/MM/yyyy HH:mm}" />
    <display:column property="fechaFinal" title="Fecha Final" format="{0,date,dd/MM/yyyy HH:mm}" />
    <display:column property="diaImpartido" title="Día Impartido" />
    <display:column property="horaImpartido" title="Hora Impartido" />
     <display:column title="Academia">
        <a href="<spring:url value='/academia/info.do?academiaId=${row.academia.id}' />">${row.academia.nombreComercial}</a>
    </display:column>
</display:table>


