<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Personas</title>
</head>
<body>
	<h1>Lista Personas</h1>
	<table>
		<tr>
			<td><a href="adminPersona?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> NOMBRE</td>
		 <td> TELEFONO</td>
		 <td> FECHA NAC</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="persona" items="${lista}">
			<tr>
				<td><c:out value="${persona.nombre}"/></td>
				<td><c:out value="${persona.telefono}"/></td>
				<td><c:out value="${persona.fechaNac}"/></td>
				<td><a href="adminPersona?action=showedit&id=<c:out value="${persona.idpersona}" />">Editar</a></td>
				<td><a href="adminPersona?action=eliminar&id=<c:out value="${persona.idpersona}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>