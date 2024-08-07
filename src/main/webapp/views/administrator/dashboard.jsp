<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="administrator.dashboard.title" /></title>
</head>
<body>

	<h2>
		<spring:message code="administrator.dashboard.cursosPorAcademia" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="administrator.dashboard.min" /></th>
			<th><spring:message code="administrator.dashboard.avg" /></th>
			<th><spring:message code="administrator.dashboard.max" /></th>
			<th><spring:message code="administrator.dashboard.stddev" /></th>
		</tr>
		<tr>
			<td>${statsCursosPorAcademia.min}</td>
			<td>${statsCursosPorAcademia.avg}</td>
			<td>${statsCursosPorAcademia.max}</td>
			<td>${statsCursosPorAcademia.stddev}</td>
		</tr>
	</table>

	<h2>
		<spring:message code="administrator.dashboard.solicitudesPorCurso" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="administrator.dashboard.min" /></th>
			<th><spring:message code="administrator.dashboard.avg" /></th>
			<th><spring:message code="administrator.dashboard.max" /></th>
			<th><spring:message code="administrator.dashboard.stddev" /></th>
		</tr>
		<tr>
			<td>${statsSolicitudesPorCurso.min}</td>
			<td>${statsSolicitudesPorCurso.avg}</td>
			<td>${statsSolicitudesPorCurso.max}</td>
			<td>${statsSolicitudesPorCurso.stddev}</td>
		</tr>
	</table>

	<h2>
		<spring:message code="administrator.dashboard.TutorialesPorAcademia" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="administrator.dashboard.min" /></th>
			<th><spring:message code="administrator.dashboard.avg" /></th>
			<th><spring:message code="administrator.dashboard.max" /></th>
		</tr>
		<tr>
			<td>${statsTutorialesPorAcademia.min}</td>
			<td>${statsTutorialesPorAcademia.avg}</td>
			<td>${statsTutorialesPorAcademia.max}</td>
		</tr>
	</table>


	<h2>
		<spring:message code="administrator.dashboard.VisitasPorTutoriales" />
	</h2>
	<table>
		<tr>
			<th><spring:message code="administrator.dashboard.min" /></th>
			<th><spring:message code="administrator.dashboard.avg" /></th>
			<th><spring:message code="administrator.dashboard.max" /></th>
		</tr>
		<tr>
			<td>${StatsVisitasPorTutoriales.min}</td>
			<td>${StatsVisitasPorTutoriales.avg}</td>
			<td>${StatsVisitasPorTutoriales.max}</td>
		</tr>
	</table>

	<a href="<spring:url value='/tutorial/administrador/list.do' />"> <input
		type="button" name="verTutoriales"
		value="<spring:message code="Administrador.Boton.Tutoriales" />" />
	</a>
</body>
</html>

