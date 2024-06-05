<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div>
	<a href="#"><img src="images/logo.png" alt="Acme Dancer Co., Inc." /></a>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li><a class="fNiv"><spring:message
						code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="curso/administrator/list.do"><spring:message
								code="master.page.administrator.cursos" /></a></li>
					<li><a href="estilo/administrator/listCRUD.do"><spring:message
								code="master.page.administrator.estilos" /></a></li>
					<li><a href="administrator/dashboard.do"><spring:message
								code="master.page.administrator.dashboard" /></a></li>
				</ul></li>
		</security:authorize>

		<security:authorize access="hasRole('ALUMNO')">
			<li><a class="fNiv"><spring:message
						code="master.page.alumno" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="curso/list.do"><spring:message
								code="master.page.alumno.action.1" /></a></li>
								<li><a href="solicitud/list-alumn.do"><spring:message
								code="master.page.alumno.action.2" /></a></li>
				</ul></li>
		</security:authorize>

		<security:authorize access="hasRole('ACADEMIA')">
			<li><a class="fNiv"><spring:message
						code="master.page.academia" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="solicitud/list-academy.do"><spring:message
								code="master.page.academia.action.2" /></a></li>
					<li><a href="curso/academia/listCRUD.do"><spring:message
								code="master.page.academia.cursos" /></a></li>

				</ul></li>
		</security:authorize>

		<security:authorize access="isAnonymous()">
			<li><a class="fNiv" href="security/login.do"><spring:message
						code="master.page.login" /></a></li>
			<li><a class="fNiv" href="security/register.do"><spring:message
						code="master.page.register" /></a></li>
			
			<li><a class="fNiv" href="curso/list.do"><spring:message
						code="master.page.cursos" /></a></li>
			<li><a class="fNiv" href="academia/list.do"><spring:message
						code="master.page.academias" /></a></li>
			<li><a class="fNiv" href="estilo/list.do"><spring:message
						code="master.page.estilos" /></a></li>

		</security:authorize>

		<security:authorize access="isAuthenticated()">
			<li><a class="fNiv"> <spring:message
						code="master.page.profile" /> (<security:authentication
						property="principal.username" />)
			</a>
				<ul>
					<li class="arrow"></li>
					<security:authorize access="hasRole('ACADEMIA')">
								
					</security:authorize>
					<security:authorize access="hasRole('ALUMNO')">
						<li><a href="profile/edit.do"><spring:message
								code="master.page.profile.edit" /></a></li>
					</security:authorize>
					
					<li><a href="j_spring_security_logout"><spring:message
								code="master.page.logout" /> </a></li>
				</ul></li>
				
				<li><a class="fNiv" href="curso/list.do"><spring:message
						code="master.page.cursos" /></a></li>
			<li><a class="fNiv" href="academia/list.do"><spring:message
						code="master.page.academias" /></a></li>
			<li><a class="fNiv" href="estilo/list.do"><spring:message
						code="master.page.estilos" /></a></li>			
		</security:authorize>
	</ul>
</div>

<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>


