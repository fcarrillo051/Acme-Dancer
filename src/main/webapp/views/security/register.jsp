<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registro</title>
    <script type="text/javascript">
        function toggleNombreComercial() {
            var tipoUsuario = document.querySelector('input[name="tipoUsuario"]:checked').value;
            var nombreComercialDiv = document.getElementById("nombreComercialDiv");
            if (tipoUsuario === "Academia") {
                nombreComercialDiv.style.display = "block";
            } else {
                nombreComercialDiv.style.display = "none";
            }
        }

        window.onload = function() {
            toggleNombreComercial();
            var radioButtons = document.querySelectorAll('input[name="tipoUsuario"]');
            for (var i = 0; i < radioButtons.length; i++) {
                radioButtons[i].onclick = toggleNombreComercial;
            }
        };
    </script>
</head>
<body>
    <form:form action="security/register.do" modelAttribute="credentials" method="post">
		<!-- Label y radio buttons para tipo de usuario -->
        <form:label path="tipoUsuario"><spring:message code="security.typeRadio" /></form:label>
        <br />
        <form:radiobutton path="tipoUsuario" value="Alumno" /> <spring:message code="security.alumnoText" />
        <form:radiobutton path="tipoUsuario" value="Academia" /><spring:message code="security.academiaText" />
        <br /><br />

        <div id="nombreComercialDiv" style="display:none;">
            <form:label path="nombreComercial"><spring:message code="security.nombreComercial" /></form:label>
            <form:input path="nombreComercial" />
            <form:errors class="error" path="nombreComercial" />
            <br />
        </div>

        <form:label path="username">
            <spring:message code="security.username" />
        </form:label>
        <form:input path="username" />    
        <form:errors class="error" path="username" />
        <br />

        <form:label path="password">
            <spring:message code="security.password" />
        </form:label>
        <form:password path="password" />    
        <form:errors class="error" path="password" />
        <br />

        <!-- Campo para nombre -->
        <form:label path="nombre">
            <spring:message code="security.firstName" />
        </form:label>
        <form:input path="nombre" required="true" />
        <form:errors class="error" path="nombre" />
        <br />

        <!-- Campo para apellidos -->
        <form:label path="apellidos">
            <spring:message code="security.lastName" />
        </form:label>
        <form:input path="apellidos" required="true" />
        <form:errors class="error" path="apellidos" />
        <br />

        <!-- Campo para correo electrónico -->
        <form:label path="correoElectronico">
            <spring:message code="security.email" />
        </form:label>
        <form:input path="correoElectronico" type="email" required="true" />
        <form:errors class="error" path="correoElectronico" />
        <br />

        <!-- Campo para número de teléfono (opcional) -->
        <form:label path="numeroTelefono">
            <spring:message code="security.phoneNumber" />
        </form:label>
        <form:input path="numeroTelefono" />
        <form:errors class="error" path="numeroTelefono" />
        <br />

        <!-- Campo para dirección postal (opcional) -->
        <form:label path="direccionPostal">
            <spring:message code="security.postalAddress" />
        </form:label>
        <form:input path="direccionPostal" />
        <form:errors class="error" path="direccionPostal" />
        <br />

        <jstl:if test="${showError == true}">
            <div class="error">
                <spring:message code="security.login.failed" />
            </div>
        </jstl:if>

        <input type="submit" value="<spring:message code="security.register" />" />

    </form:form>
</body>
</html>
