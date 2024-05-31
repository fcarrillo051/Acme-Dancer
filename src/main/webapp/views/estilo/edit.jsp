<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Estilo</title>
</head>
<body>
    <h2><spring:message code="estilo.edit.title" /></h2>

    <form:form modelAttribute="estilo" method="post" action="${requestURI}">
        <table>
            <tr>
                <td><spring:message code="estilo.titulo" /></td>
                <td><form:input path="titulo" /></td>
                <td><form:errors path="titulo" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="estilo.descripcion" /></td>
                <td><form:input path="descripcion" /></td>
                <td><form:errors path="descripcion" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="estilo.videos" /></td>
                <td><form:textarea path="videos" /></td>
                <td><form:errors path="videos" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="estilo.imagenes" /></td>
                <td><form:textarea path="imagenes" /></td>
                <td><form:errors path="imagenes" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="<spring:message code='estilo.save'/>" />
                </td>
            </tr>
        </table>
    </form:form>

    <a href="<spring:url value='/estilo/administrator/listCRUD.do' />"><spring:message code="estilo.back.to.list" /></a>
</body>
</html>
